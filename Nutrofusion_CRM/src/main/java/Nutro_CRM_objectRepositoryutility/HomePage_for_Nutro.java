package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author kmyas Home page object Repository
 */
public class HomePage_for_Nutro {
	WebDriver driver;

	// constructor
	public HomePage_for_Nutro(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	@FindBy(linkText = "Products")
	private WebElement productslink;

	// getters
	public WebElement Conatctlink() {
		return contactlink;
	}

	@FindBy(xpath = "//a[contains(text(),'Documents')]")
	private WebElement Documentslink;

	// getters
	public WebElement getDocumentslink() {
		return Documentslink;
	}

	@FindBy(xpath = "//a[contains(text(),'Email')]")
	private WebElement EmailLink;

	// getters
	public WebElement getEmailLink() {
		return EmailLink;
	}

	@FindBy(linkText = "Leads")
	private WebElement Leadslink;

	public WebElement getLeadslink() {
		return Leadslink;
	}

	@FindBy(xpath = "//a[text()='More']")
	private WebElement MOre;

	public WebElement getMOre() {
		return MOre;
	}

	@FindBy(xpath = "//a[@name='Reports']")
	private WebElement clickonReport;

	public WebElement getclickonReport() {
		return clickonReport;
	}

	/**
	 * 
	 * @param driver
	 */

	public void MouseoveronMore(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(MOre).perform();

	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	/**
	 * Logout from the application
	 */
	public void logout() throws InterruptedException {

		Actions acct = new Actions(driver);
		Thread.sleep(3000);
		acct.moveToElement(adminimg).perform();
		Thread.sleep(3000);
		SignoutLink.click();
		
	}
	
	@FindBy(xpath = "//a[text()='Sales Order']")
	private WebElement Saleslink;

	public WebElement getSaleslink() {
		return Saleslink;
	}
	public void salesOrder()
	{
		Actions acct = new Actions(driver);
		
		acct.moveToElement(moreLink).perform();
		Saleslink.click();
		
	}

	
	
	@FindBy(xpath = "//a[text()='Purchase Order']")
	private WebElement Purchaselink;

	public WebElement getPurchaselink() {
		return Purchaselink;
	}
	public void PurchaseOrder()
	{
		Actions acct = new Actions(driver);
		
		acct.moveToElement(moreLink).perform();
		Purchaselink.click();
		
	}

}
