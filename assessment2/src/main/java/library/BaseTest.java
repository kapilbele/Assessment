package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements Constants
{
	public WebDriver driver;
	
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
	
	@AfterMethod
	public void closeApplication()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
