package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.BasePage;

public class AddToCartPage extends BasePage
{

	public AddToCartPage(WebDriver driver)
	{
		super(driver);	
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	public WebElement searchbox()
	{
		return searchbox;
	}
	
	@FindBy(xpath = "//span[text()='Samsung Galaxy M31 (Ocean Blue, 6GB RAM, 128GB Storage)']")
	private WebElement mobile;
	public WebElement mobile()
	{
		return mobile;
	}
	
	@FindBy(name="submit.add-to-cart")
	private WebElement addtocart;
	public WebElement addtocart()
	{
		return addtocart;
	}

}
