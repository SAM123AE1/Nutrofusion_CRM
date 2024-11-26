package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectSupplierbyPLUSinProductPage {
	WebDriver driver;
	public selectSupplierbyPLUSinProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchbox;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement searchedtext;
	public WebElement getsearchedtext() {
		return searchedtext;
	}
	
	
	public void selectSupplier(String SupplierName) throws InterruptedException
	{
		searchbox.sendKeys(SupplierName);
		searchbtn.click();
		Thread.sleep(3000);
		searchedtext.click();
	}
}
