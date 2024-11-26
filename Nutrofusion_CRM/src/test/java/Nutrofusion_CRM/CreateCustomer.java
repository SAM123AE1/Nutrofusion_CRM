package Nutrofusion_CRM;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Nutro_CRM_generic.Baseutility.BaseTestforRealProject;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_objectRepositoryutility.ContactLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.CreateNewContactPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.contactverifyinformationPage_for_Nutro;
@Listeners(Nutro_CRM_listenerUtility.ListenerImplementationclass.class)
public class CreateCustomer extends BaseTestforRealProject {

	@Test(groups="smoke")
	public void CreateCustomerTest() throws Throwable {
		UtilityclassObject.getTest().log(Status.INFO, "Read data from Excel");

		String LastName = elib.getDataFromExcel("Contact", 7, 3) + jlib.getRandomNumber();

		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, "Create customer");

		hp.Conatctlink().click();
		ContactLinkPLUSICONPage_for_Nutro pluscon=new ContactLinkPLUSICONPage_for_Nutro(driver);
		pluscon.clickonplus().click();
		CreateNewContactPage_for_Nutro createcontact=new CreateNewContactPage_for_Nutro(driver);
		createcontact.createcustomerwithmandatoryfield(LastName);
		contactverifyinformationPage_for_Nutro converfy=new contactverifyinformationPage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, " verify customer information");

		String acttext = converfy.getln().getText();
		hardobj.hardAssertforboolean(LastName, acttext);
		
		
	}

}
