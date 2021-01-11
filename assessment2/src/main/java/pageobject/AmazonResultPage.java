package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import library.BasePage;

public class AmazonResultPage extends BasePage
{

	public AmazonResultPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath = "(//span[@class='nav-action-inner'])[2]")
	private WebElement login;
	public WebElement login()
	{
		return login;
	}
	
	
	@FindBy(id = "ap_email")
	private WebElement username;
	public WebElement username()
	{
		return username;
	}

	@FindBy(id = "continue")
	private WebElement continuebutton;
	public WebElement continuebotton()
	{
		return continuebutton;
	}
	
	@FindBy(id = "ap_password")
	private WebElement password;
	public WebElement password()
	{
		return password;
	}
	
	@FindBy(id = "signInSubmit")
	private WebElement loginbutton;
	public WebElement loginbutton()
	{
		return loginbutton;
	}
	
	
}
