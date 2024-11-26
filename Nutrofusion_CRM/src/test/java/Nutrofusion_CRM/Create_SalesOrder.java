package Nutrofusion_CRM;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Nutro_CRM_generic.Baseutility.BaseTestforRealProject;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_objectRepositoryutility.CreatingNewSalesOrderPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.SalesOrderLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.SalesOredrInformationPage;
import Nutro_CRM_objectRepositoryutility.plusinSalesOrderPageforselectingORG;
import Nutro_CRM_objectRepositoryutility.plusinSalesOrderPageforselectingProduct;
@Listeners(Nutro_CRM_listenerUtility.ListenerImplementationclass.class)
public class Create_SalesOrder extends BaseTestforRealProject {
	@Test(groups = "System")
	public void Create_SalesOrderTest() throws Throwable {
		UtilityclassObject.getTest().log(Status.INFO, "Read data from Excel");

		String ProductName = elib.getDataFromExcel("Products", 2, 2);
		//String SupplierName2 = elib.getDataFromExcel("Supplier", 2, 0);
		String ORGNAME = elib.getDataFromExcel("Createorg", 1, 6);
		String Qnty = elib.getDataFromExcel("Products", 1, 1);
		String salesSubject = elib.getDataFromExcel("Sales", 1, 0) + jlib.getRandomNumber();
		String Billingaddress = elib.getDataFromExcel("Sales", 1, 1) + jlib.getRandomNumber();

		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, " Create Sales Order");

		hp.salesOrder();
		SalesOrderLinkPLUSICONPage_for_Nutro newsales = new SalesOrderLinkPLUSICONPage_for_Nutro(driver);
		newsales.getcreateNewsalesbtn().click();
		CreatingNewSalesOrderPage_for_Nutro newsale = new CreatingNewSalesOrderPage_for_Nutro(driver);
		newsale.entersalename(salesSubject);

		newsale.getorgplusicon().click();
		wlib.switchToTabOnurl(driver, "Accounts&action");
		plusinSalesOrderPageforselectingORG plusorg = new plusinSalesOrderPageforselectingORG(driver);
		UtilityclassObject.getTest().log(Status.INFO, " select Organization");

		plusorg.selectreqorganization(ORGNAME);
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		wlib.switchToAlertAndAccept(driver);
		wlib.switchToTabOnurl(driver, "SalesOrder&action");
		newsale.address(Billingaddress);
		newsale.getproductplus().click();
		wlib.switchToTabOnurl(driver, "Product&action");
		plusinSalesOrderPageforselectingProduct propage = new plusinSalesOrderPageforselectingProduct(driver);
		propage.selectreqProduct(ProductName);
		driver.findElement(By.xpath("//a[.='" + ProductName + "']")).click();
		wlib.switchToTabOnurl(driver, "SalesOrder&action");
		newsale.qntysave(Qnty);
		UtilityclassObject.getTest().log(Status.INFO, " verify sales information");

		SalesOredrInformationPage salesinfo = new SalesOredrInformationPage(driver);
		String acttext = salesinfo.getSalesSubjectinfo().getText();
		softobj.softAssertusingboolean(salesSubject, acttext);
		// UtilityclassObject.getTest().log(Status.INFO,"salesSubjectverifed
		// sucessfullly");

	}
}
