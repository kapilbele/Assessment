package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.BasePage;

public class AmazonSearchPage extends BasePage
{

	public AmazonSearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='Online Shopping site in India: Shop Online for Mobiles, Books ...']")
	private WebElement searchlink;
	public WebElement searchlink()
	{
		return searchlink;
	}
}
