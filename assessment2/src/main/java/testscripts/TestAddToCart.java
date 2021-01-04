package testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pageobject.AddToCartPage;

public class TestAddToCart extends BaseTest
{
	@Test
	public void addtocartmethod()
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
			Reporter.log("product added into cart successfully....",true);
		}
		catch (Exception e) 
		{
			
		}
	}
}
