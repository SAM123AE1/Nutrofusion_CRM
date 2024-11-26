package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalesOrderLinkPLUSICONPage_for_Nutro  {
	WebDriver driver;

	public SalesOrderLinkPLUSICONPage_for_Nutro(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']"),
			@FindBy(xpath = "//img[@alt='Create Sales Order...']") })
	private WebElement createNewsalesbtn;

	

	
	public WebElement getcreateNewsalesbtn() {
		return createNewsalesbtn;
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

public void selectbyln(String org)
{
	Select sel=new Select(saerchDD);
	sel.selectByVisibleText("Organization Name");
	saerchEdt.sendKeys(org);
	searchBtn.click();
	}

}
