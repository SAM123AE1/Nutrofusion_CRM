package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class plusinPurchaseOrderPageforselectingProduct {
	

	WebDriver driver;
	public plusinPurchaseOrderPageforselectingProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getClickonsearchedtext() {
		return clickonsearchedtext;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public WebElement getErrmsg() {
		return errmsg;
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
	public void selectreqProduct(String product)
	{
		searchfield.sendKeys(product);
		searchbutton.click();
		
	}
	@FindBy(xpath = "//span[text()='No Organizations Found !']")
	private WebElement errmsg;
	
	
	
	
	
	
	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
	private WebElement clickonsearchedtext;
	public WebElement getclickonsearchedtext()
	{
		return clickonsearchedtext;
	}
//	public void searchforProduct_frompopupoforgPage(String proname) throws InterruptedException
//	{
//		.sendKeys(orgname);
//		searchbutton.click();
//		Thread.sleep(2000);
//		clickonsearchedtext.click();
//	}
//	
}


