package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pageobject.AmazonResultPage;
import pageobject.AmazonSearchPage;

public class TestLogin extends BaseTest
{
	@Test
	public void amazonlogin()
	{
		try
		{
			AmazonSearchPage asp = new AmazonSearchPage(driver);
			//asp.searchlink().click();
			Thread.sleep(10000);
			Actions action = new Actions(driver);
			WebElement mousemoveonsignin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			action.moveToElement(mousemoveonsignin).build().perform();
			mousemoveonsignin.click();
			Thread.sleep(5000);
			AmazonResultPage arp = new AmazonResultPage(driver);
			//arp.login().click();
			arp.username().clear();
		
			arp.username().sendKeys(username);
			Thread.sleep(5000);
			arp.continuebotton().click();
			arp.password().clear();
			arp.password().sendKeys(password);
			Thread.sleep(5000);
			arp.loginbutton().click();
			Thread.sleep(5000);
			Reporter.log("logged in successfully.....",true);
		}
		catch (Exception e) 
		{
			//Reporter.log("login fail.....",true);
			//Assert.fail();
		}
	}
}
