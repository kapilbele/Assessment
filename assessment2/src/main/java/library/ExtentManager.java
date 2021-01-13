package library;


import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	private static ExtentReports extent;
	public static ExtentReports createInstance()
	{
		String fileName=getReportName(); 
		String directory="./ExtentReport/";
		String path=directory+fileName;
	    ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(path);

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("Test Result");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.setSystemInfo("System","Localhost");
		extent.setSystemInfo("Browser","Chrome");
		extent.attachReporter(htmlReporter);
		return extent;
	}
	
	public static String getReportName() {
		Date d = new Date();
		String fileName="AutomationReport" + "-" + d.toString().replace(":", "").replace(" ", "")+ ".html";
		return fileName;
	}
	
}
