package library;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements Constants,ITestListener
{
	public WebDriver driver;
	private static ExtentReports extent=ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@BeforeMethod
	public void lanchAndStartApplication()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
	}
	
	public void onTestStart(ITestResult result) 
	{
		ExtentTest test=extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		String logtext= "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}
	
	public void onTestFailure(ITestResult result) 
	{
		String methodName=result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color-red>Exception Occured, click to see details: "+ 
				"</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		
		String path= takeScreenshot(driver,result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}catch(IOException e) {
			extentTest.get().fail("Test Failed, Cannot attach Screenshot");
		}
		String logtext= "<b>Test Method " + methodName + " Failed</b>";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		String logtext= "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);
	}
	
	public void onFinish(ITestContext context)
	{
		if(extent!=null)
		{
			extent.flush();
		}
	}
	
	public String takeScreenshot(WebDriver driver,String methodName) {
		String fileName=getScreenshotName(methodName);
		String file="./ExtentReport/";
		String path=file + fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType. FILE); 
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*************");
			System.out.println("Screenshot stored at :" +path);
			System.out.println("*************");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
		
	}
	
	public static String getScreenshotName(String methodName) {
		Date d=new Date();
		String fileName=methodName + "-" + d.toString().replace(":", "").replace(" ", "")+ ".png";
		return fileName;
	}
	
	@AfterMethod
	public void closeApplication()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}

		
	
	
	
	
	
	
	
	
	


}
