package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationVERIFICATIONPage_for_Nutro {

	public OrganizationInformationVERIFICATIONPage_for_Nutro(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

@FindBy(xpath ="//span[@class ='dvHeaderText']") 
	private WebElement headermsg;

	public WebElement getHeadermsg() {
		return headermsg;
	}

}
