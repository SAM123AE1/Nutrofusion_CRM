package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Productlink_PLUSICONpage {
	WebDriver driver;

	public Productlink_PLUSICONpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement plusofproduct;

	public WebElement getplusofproduct() {
		return plusofproduct;
	}

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchbox;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchbtn;
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement product_searchDD;
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement massdeletebtn;
	@FindBy(xpath = "//input[@value='Mass Edit']")
	private WebElement masseditbtn;
	@FindBy(xpath = "//a[text()='edit']")
	private WebElement editbtn;
	@FindBy(xpath = "//a[text()='delete']")
	private WebElement deletebtn;
	@FindBy(xpath = "//input[@type='checkbox'][1]")
	private WebElement selectallcheckbox;

	public WebElement getSelectallcheckbox() {
		return selectallcheckbox;
	}

	public WebElement getProduct_searchDD() {
		return product_searchDD;
	}

	public WebDriver getDriver() {
		return driver;
	}

	
	public WebElement getMassdeletebtn() {
		return massdeletebtn;
	}

	public WebElement getMasseditbtn() {
		return masseditbtn;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public void SelectProductFromProductDDand_delete(String value, String searchfor) {
		Select sel = new Select(product_searchDD);
		sel.deselectByVisibleText(value);
		searchbox.sendKeys(searchfor);
		searchbtn.click();

	}
	public void deleteallproducts()
	{
		selectallcheckbox.click();
		massdeletebtn.click();
	}
	

}
