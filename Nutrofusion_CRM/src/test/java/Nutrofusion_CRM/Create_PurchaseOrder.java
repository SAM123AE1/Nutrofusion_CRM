package Nutrofusion_CRM;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Nutro_CRM_generic.Baseutility.BaseTestforRealProject;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_objectRepositoryutility.CreatingNewPurchaseOrderPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.PurcahseOrderLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.SalesOredrInformationPage;
import Nutro_CRM_objectRepositoryutility.plusinPurcahseOrderPageforselectingProduct;
import Nutro_CRM_objectRepositoryutility.selectSupplierbyPLUSinProductPage;
@Listeners(Nutro_CRM_listenerUtility.ListenerImplementationclass.class)
public class Create_PurchaseOrder extends BaseTestforRealProject {
	@Test(groups = "Integration")
	public void Create_PurcahseOrderTest() throws Throwable {
		UtilityclassObject.getTest().log(Status.INFO, "Read data from Excel");
		String ProductName = elib.getDataFromExcel("Products", 3, 2);
		String SupplierName2 = elib.getDataFromExcel("Supplier", 2, 0);
		// String ORGNAME = elib.getDataFromExcel("Createorg", 1, 6);
		String Qnty = elib.getDataFromExcel("Products", 1, 1);
		String PurchaseSubject = elib.getDataFromExcel("Purchase", 1, 0) + jlib.getRandomNumber();
		String Billingaddress = elib.getDataFromExcel("Purchase", 1, 1) + jlib.getRandomNumber();

		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, " Create Purchase Order");

		hp.PurchaseOrder();
		PurcahseOrderLinkPLUSICONPage_for_Nutro newPurchases = new PurcahseOrderLinkPLUSICONPage_for_Nutro(driver);
		newPurchases.getcreateNewPurchasebtn().click();
		CreatingNewPurchaseOrderPage_for_Nutro newPur = new CreatingNewPurchaseOrderPage_for_Nutro(driver);
		newPur.entersalename(PurchaseSubject);
		UtilityclassObject.getTest().log(Status.INFO, " select supplier");

		newPur.getsupplusicon().click();

		wlib.switchToTabOnurl(driver, "Vendors&action");
		selectSupplierbyPLUSinProductPage selectsup = new selectSupplierbyPLUSinProductPage(driver);
		selectsup.selectSupplier(SupplierName2);

		wlib.switchToTabOnurl(driver, "PurchaseOrder&action");
		newPur.address(Billingaddress);
		UtilityclassObject.getTest().log(Status.INFO, " select Product");

		newPur.getproductplus().click();
		wlib.switchToTabOnurl(driver, "Product&action");
		plusinPurcahseOrderPageforselectingProduct propage = new plusinPurcahseOrderPageforselectingProduct(driver);
		propage.selectreqProduct(ProductName);
		driver.findElement(By.xpath("//a[.='" + ProductName + "']")).click();
		wlib.switchToTabOnurl(driver, "PurchaseOrder&action");
		newPur.qntysave(Qnty);
		UtilityclassObject.getTest().log(Status.INFO, " verify Purcahse information");

		SalesOredrInformationPage salesinfo = new SalesOredrInformationPage(driver);
		String acttext = salesinfo.getSalesSubjectinfo().getText();
		softobj.softAssertusingboolean(PurchaseSubject, acttext);
		// UtilityclassObject.getTest().log(Status.INFO,"salesSubjectverifed
		// sucessfullly");

	}
}
