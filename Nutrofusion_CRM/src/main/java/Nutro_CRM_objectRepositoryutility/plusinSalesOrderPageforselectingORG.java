package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class plusinSalesOrderPageforselectingORG {
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public WebElement getErrmsg() {
		return errmsg;
	}

	WebDriver driver;
	public plusinSalesOrderPageforselectingORG(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchfield;
	public WebElement getplusiconoforgwithincontactsearchfield()
	{
		return searchfield;
	}

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbutton;
	public WebElement sendorgnametotext()
	{
		return searchbutton;
	}
	public void selectreqorganization(String orgname)
	{
		searchfield.sendKeys(orgname);
		searchbutton.click();
		
	}
	@FindBy(xpath = "//span[text()='No Organizations Found !']")
	private WebElement errmsg;
}
