package testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pageobject.AddToCartPage;

public class DeleteProduct extends BaseTest
{
	@Test
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
		   
		    WebElement cartclose = driver.findElement(By.xpath("(//a[@href='#'])[8]"));
		    cartclose.click();
		    Thread.sleep(5000);
		    
		    WebElement cart = driver.findElement(By.id("nav-cart-count"));
		    cart.click();
		    Thread.sleep(5000);
		    
		   WebElement delete = driver.findElement(By.className("a-color-link"));
		   delete.click();
		   Reporter.log("product deleted successfully....",true);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getStackTrace());
		}
	
}
}
