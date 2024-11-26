package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductpage {
	WebDriver driver;

	public createProductpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productname;
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement productpageSupplierplusicon;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;
	public WebElement getSavebtn() {
	return savebtn;
}
	public WebElement getProductname() {
		return productname;
	}
	public WebElement getProductpageSupplierplusicon() {
		return productpageSupplierplusicon;
	}
	public void CreateProductwithonlymadatory(String product)
	{
		productname.sendKeys(product);
		savebtn.click();
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement clickonplusofsupplier;
	

	public WebElement getClickonplusofsupplier() {
		return clickonplusofsupplier;
	}
	public void  selSupplier(String product)
	{
		productname.sendKeys(product);
		clickonplusofsupplier.click();
		
		
		
	}
	public void  selagainSupplier()
	{
		
		clickonplusofsupplier.click();
		
		
		
	}
}
