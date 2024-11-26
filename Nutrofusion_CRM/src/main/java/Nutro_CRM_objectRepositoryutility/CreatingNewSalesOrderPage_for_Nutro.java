package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewSalesOrderPage_for_Nutro {

	public CreatingNewSalesOrderPage_for_Nutro(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//input[@class='detailedViewTextBox']"), @FindBy(xpath = "//input[@name='subject']") })
	private WebElement subjectsales;
	@FindBy(xpath = "(//input[@value='  Save  '])[1]")
	private WebElement clickonsavebtn;

	public WebElement getsubjectsales() {
		return subjectsales;
	}

	public WebElement getClickonsavebtn() {
		return clickonsavebtn;
	}

	public void entersalename(String salesName) {
		subjectsales.sendKeys(salesName);

	}

	@FindBy(xpath = "//td[text()='Organization Name 			']/following-sibling::td[1]/img")
	private WebElement orgplusicon;

	public WebElement getorgplusicon() {
		return orgplusicon;
	}

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billadd;

	public WebElement getbilladd() {
		return billadd;
	}

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shipadd;

	public WebElement getshipadd() {
		return shipadd;
	}

	@FindBy(xpath = "//img[@id='searchIcon1']")
	private WebElement productplus;

	public WebElement getproductplus() {
		return productplus;
	}

	public void address(String address) {
		billadd.sendKeys(address);
		shipadd.sendKeys(address);
		
	}
	@FindBy(xpath = "//input[@id='qty1']")
	private WebElement Qnty;

	public WebElement getQnty() {
		return Qnty;
	}
	public void qntysave(String qnty)
	{
		Qnty.sendKeys(qnty);
		clickonsavebtn.click();
	}
	
}
