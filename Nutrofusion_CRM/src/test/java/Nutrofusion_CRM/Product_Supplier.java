package Nutrofusion_CRM;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Nutro_CRM_generic.Baseutility.BaseTestforRealProject;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.ProductInformationPage;
import Nutro_CRM_objectRepositoryutility.Productlink_PLUSICONpage;
import Nutro_CRM_objectRepositoryutility.createProductpage;
import Nutro_CRM_objectRepositoryutility.selectSupplierbyPLUSinProductPage;
@Listeners(Nutro_CRM_listenerUtility.ListenerImplementationclass.class)
public class Product_Supplier extends BaseTestforRealProject {
	@Test(groups = "Integration")
	public void Product_SupplierTest() throws Throwable {
		UtilityclassObject.getTest().log(Status.INFO, "Read data from Excel");


		String ProductName = elib.getDataFromExcel("Products", 1, 0) + jlib.getRandomNumber();
		String SupplierName1 = elib.getDataFromExcel("Supplier", 1, 0);
		String SupplierName2 = elib.getDataFromExcel("Supplier", 2, 0);
		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, " Create Products");

		hp.getProductslink().click();
		Productlink_PLUSICONpage productplus = new Productlink_PLUSICONpage(driver);
		productplus.getplusofproduct().click();
		createProductpage createproduct = new createProductpage(driver);
		createproduct.selSupplier(ProductName);
		
		// System.out.println("1"+driver.getCurrentUrl());
		wlib.switchToTabOnurl(driver, "Vendors&action=P");
		UtilityclassObject.getTest().log(Status.INFO, " select supplier1");

		selectSupplierbyPLUSinProductPage selectsup = new selectSupplierbyPLUSinProductPage(driver);
		selectsup.selectSupplier(SupplierName1);
		
		wlib.switchToTabOnurl(driver, "Products&action=EditV");
		createproduct.selagainSupplier();
		wlib.switchToTabOnurl(driver, "Vendors&action=P");
		UtilityclassObject.getTest().log(Status.INFO, " select supplier2");

		
		selectsup.selectSupplier(SupplierName2);
		wlib.switchToTabOnurl(driver, "Products&action=EditV");

		createproduct.getSavebtn().click();
		ProductInformationPage productverfy=new ProductInformationPage(driver);
		UtilityclassObject.getTest().log(Status.INFO, " verify product and supplier");

		String actinfo = productverfy.getsupplierinfo().getText();
		System.out.println(actinfo);
		hardobj.hardAssertforboolean(SupplierName2, actinfo);
		
		
	}

}
