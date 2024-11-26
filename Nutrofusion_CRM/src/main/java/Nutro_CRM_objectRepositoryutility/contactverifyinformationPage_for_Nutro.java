package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactverifyinformationPage_for_Nutro {
	public contactverifyinformationPage_for_Nutro(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgName;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDate;

	@FindBy(xpath = "//span[@id='dtlview_Support End Date']")
	private WebElement endDate;

	public WebElement getendDate() {
		return endDate;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement ln;

	public WebElement getln() {
		return ln;
	}

	@FindBy(xpath = "//span[@id='dtlview_Email']")
	private WebElement email;

	public WebElement getemail() {
		return email;
	}

}
