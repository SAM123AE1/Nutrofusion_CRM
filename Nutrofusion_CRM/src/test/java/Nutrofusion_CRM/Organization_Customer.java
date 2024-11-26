package Nutrofusion_CRM;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Nutro_CRM_generic.Baseutility.BaseTestforRealProject;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_objectRepositoryutility.ContactLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.CreateNewContactPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.CreatingNewOrganizationPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.OrganizationInformationVERIFICATIONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.OrganizationsLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.plusinCustomerPageforselectingORG;
@Listeners(Nutro_CRM_listenerUtility.ListenerImplementationclass.class)

public class Organization_Customer extends BaseTestforRealProject {
	@Test(groups="System")
	public void ORG_CustomerTest() throws Throwable {
		UtilityclassObject.getTest().log(Status.INFO, "Read data from Excel");

		String ORGNAME = elib.getDataFromExcel("Createorg", 1, 2) + jlib.getRandomNumber();

		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, " Create Organization");

		hp.getOrgLink().click();

		OrganizationsLinkPLUSICONPage_for_Nutro plusoforglink = new OrganizationsLinkPLUSICONPage_for_Nutro(driver);
		plusoforglink.getCreateNeworgbtn().click();
		CreatingNewOrganizationPage_for_Nutro neworg = new CreatingNewOrganizationPage_for_Nutro(driver);
		neworg.createorg(ORGNAME);

		OrganizationInformationVERIFICATIONPage_for_Nutro orginfo = new OrganizationInformationVERIFICATIONPage_for_Nutro(
				driver);
		String actorg = orginfo.getHeadermsg().getText();
		softobj.softAssertusingboolean(actorg, ORGNAME);
		softobj.assertALL();
		// navigate back to link to check list
		UtilityclassObject.getTest().log(Status.INFO, " select organization ");

		hp.getOrgLink().click();
		plusoforglink.selectbyln(ORGNAME);

		plusoforglink.selfirstcheckbox();
		wlib.switchToAlertAndAccept(driver);
		hp.Conatctlink().click();
		ContactLinkPLUSICONPage_for_Nutro pluscon = new ContactLinkPLUSICONPage_for_Nutro(driver);
		pluscon.clickonplus().click();
		CreateNewContactPage_for_Nutro createcontact = new CreateNewContactPage_for_Nutro(driver);
		createcontact.getorgPLusIcon().click();
		wlib.switchToTabOnurl(driver, "Accounts&action");

		plusinCustomerPageforselectingORG orgplusincustpage = new plusinCustomerPageforselectingORG(driver);
		orgplusincustpage.selectreqorganization(ORGNAME);
		String errmsg = orgplusincustpage.getErrmsg().getText();
		if(!ORGNAME.equals(errmsg)) 
		{
			driver.close();
		}
		wlib.switchToTabOnurl(driver, "Accounts&action");
		
		 UtilityclassObject.getTest().log(Status.INFO,errmsg);

	}

}
