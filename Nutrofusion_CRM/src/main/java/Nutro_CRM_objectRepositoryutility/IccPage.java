package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nutro_CRM_generic.webdriverutility.WebDriverUtility;
//create seperate java class
//object creation
public class IccPage extends WebDriverUtility{
	WebDriver driver;
	public IccPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath = "//button[text()='Accept All Cookies']")
	private WebElement acceptcookies;
	
	
	//object encapsulation
	public WebElement getacceptcookies() {
		return acceptcookies;
	}
	
	
	
	

}
