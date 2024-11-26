package Nutro_CRM_objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
	WebDriver driver;
	public SalesOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

}
