package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlusOFSelectingorgPageformcontact_for_Nutro {
String ORGNAME="";
	WebDriver driver;
	public PlusOFSelectingorgPageformcontact_for_Nutro(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement plusiconoforgwithincontactsearchfield;
	public WebElement getplusiconoforgwithincontactsearchfield()
	{
		return plusiconoforgwithincontactsearchfield;
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbutton;
	public WebElement sendorgnametotext()
	{
		return searchbutton;
	}
	
	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
	private WebElement clickonsearchedtext;
	public WebElement getclickonsearchedtext()
	{
		return clickonsearchedtext;
	}
	public void searchfororgfrompopupoforgPage(String orgname) throws InterruptedException
	{
		plusiconoforgwithincontactsearchfield.sendKeys(orgname);
		searchbutton.click();
		Thread.sleep(2000);
		clickonsearchedtext.click();
	}
	
	
	
}
