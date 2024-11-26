package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	WebDriver driver;

	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productheaderinfo;
	public WebElement getproductheaderinfo() {
		return productheaderinfo;
	}
	@FindBy(xpath = "//td[@id='mouseArea_Vendor Name']/a")
	private WebElement supplierinfo;
	public WebElement getsupplierinfo() {
		return supplierinfo;
	}
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement productinfo;
	public WebElement getproductinfo() {
		return productinfo;
	}
}
