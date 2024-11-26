package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOredrInformationPage {
	WebDriver driver;

	public SalesOredrInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//span[@id='dtlview_Subject']")
	private WebElement SalesSubjectinfo;
	public WebElement getSalesSubjectinfo() {
		return SalesSubjectinfo;
	}
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement productinfo;
	public WebElement getproductinfo() {
		return productinfo;
	}
}
