package testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import library.BaseTest;
import pageobject.AddToCartPage;

public class TestDeleteProduct extends BaseTest
{
	@Test()
	public void delete()
	{
		try
		{
			AddToCartPage acp = new AddToCartPage(driver);
			acp.searchbox().clear();
			acp.searchbox().sendKeys(searchinput);
			acp.searchbox().sendKeys(Keys.ENTER);
			acp.mobile().click();
			Thread.sleep(5000);
			
			ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tab2.get(1));
		    driver.navigate();
			
		    WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		    addtocart.click();
		    Thread.sleep(5000);
		    
		    WebElement cartclose = driver.findElement(By.id("attach-close_sideSheet-link"));
		    cartclose.click();
		    Thread.sleep(5000);
		    
		   WebElement cartbox = driver.findElement(By.id("nav-cart-count"));
		   cartbox.click();
		   Thread.sleep(5000);
		   
		   WebElement deletebutton = driver.findElement(By.className("a-color-link"));
		   deletebutton.click();
		   Thread.sleep(5000);
		   Reporter.log("product deleted successfully....",true);
			extentTest.get().log(Status.PASS, "Test Method Successful");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getStackTrace());
			//extenttest.log(Status.FAIL, "Test Method failed");
		}
	}
}
