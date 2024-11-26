package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsLinkPLUSICONPage_for_Nutro {
	WebDriver driver;

	public OrganizationsLinkPLUSICONPage_for_Nutro(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']"),
			@FindBy(xpath = "//img[@alt='Create Organization...']") })
	private WebElement createNeworgbtn;

	public WebElement clickonplus() {
		return createNeworgbtn;
	}
	
	
	
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchbox;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchbtn;
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement org_searchDD;
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement massdeletebtn;
	@FindBy(xpath = "//input[@value='Mass Edit']")
	private WebElement masseditbtn;
	@FindBy(xpath = "//a[text()='edit']")
	private WebElement editbtn;
	@FindBy(xpath = "//a[text()='del']")
	private WebElement deletebtn;
	@FindBy(xpath = "//input[@type='checkbox'][1]")
	private WebElement selectallcheckbox;

@FindBy(xpath = "//input[@name='selected_id']")
private WebElement firstcheckbox;
	

	public WebElement getFirstcheckbox() {
	return firstcheckbox;
}
	public WebElement getCreateNeworgbtn() {
		return createNeworgbtn;
	}
	public WebElement getSaerchEdt() {
		return saerchEdt;
	}
	public WebElement getSaerchDD() {
		return saerchDD;
	}

	@FindBy(name = "search_text")
	private WebElement saerchEdt;
	@FindBy(name = "search_field")
	private WebElement saerchDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	public WebElement getsearchBtn() {
		return searchBtn;
	}
	public WebElement getSelectallcheckbox() {
		return selectallcheckbox;
	}

	public WebElement getProduct_searchDD() {
		return org_searchDD;
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

	public void SelectORGFromOrgDDand_delete(String value, String searchfor) {
		Select sel = new Select(org_searchDD);
		sel.deselectByVisibleText(value);
		searchbox.sendKeys(searchfor);
		searchbtn.click();

	}
	public void deleteallorgs()
	{
		selectallcheckbox.click();
		massdeletebtn.click();
	}
	public void selectbyln(String ln) throws InterruptedException
	{
		Select sel=new Select(saerchDD);
		sel.selectByVisibleText("Organization Name");
		saerchEdt.sendKeys(ln);
		searchBtn.click();
		Thread.sleep(5000);
		
		}
	public void selfirstcheckbox()
	{
		firstcheckbox.click();
		deletebtn.click();
	}
	

}
