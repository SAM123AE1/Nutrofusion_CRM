package Nutrofusion_CRM;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Nutro_CRM_generic.Baseutility.BaseTestforRealProject;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_objectRepositoryutility.CreatingNewOrganizationPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.CreatingNewSalesOrderPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.OrganizationInformationVERIFICATIONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.OrganizationsLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.ProductInformationPage;
import Nutro_CRM_objectRepositoryutility.Productlink_PLUSICONpage;
import Nutro_CRM_objectRepositoryutility.SalesOrderLinkPLUSICONPage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.SalesOredrInformationPage;
import Nutro_CRM_objectRepositoryutility.createProductpage;
import Nutro_CRM_objectRepositoryutility.plusinSalesOrderPageforselectingORG;
import Nutro_CRM_objectRepositoryutility.plusinSalesOrderPageforselectingProduct;
import Nutro_CRM_objectRepositoryutility.selectSupplierbyPLUSinProductPage;
@Listeners(Nutro_CRM_listenerUtility.ListenerImplementationclass.class)
public class Product_sales_org extends BaseTestforRealProject {
	@Test(groups="System")
	public void Product_sales_orgTest() throws Throwable {
		UtilityclassObject.getTest().log(Status.INFO, "Read data from Excel");


		/** create product **/
		String ProductName = elib.getDataFromExcel("Products", 1, 0) + jlib.getRandomNumber();
		String SupplierName2 = elib.getDataFromExcel("Supplier", 2, 0);
		String ORGNAME = elib.getDataFromExcel("Createorg", 1, 2) + jlib.getRandomNumber();
		String Qnty = elib.getDataFromExcel("Products", 1, 1);
		String salesSubject = elib.getDataFromExcel("Sales", 1, 0) + jlib.getRandomNumber();
		String Billingaddress = elib.getDataFromExcel("Sales", 1, 1) + jlib.getRandomNumber();
		
		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		UtilityclassObject.getTest().log(Status.INFO, " Create Products");

		hp.getProductslink().click();
		Productlink_PLUSICONpage productplus = new Productlink_PLUSICONpage(driver);
		productplus.getplusofproduct().click();
		createProductpage createproduct = new createProductpage(driver);
		createproduct.selSupplier(ProductName);
		wlib.switchToTabOnurl(driver, "Vendors&action=P");
		UtilityclassObject.getTest().log(Status.INFO, " select supplier");

		selectSupplierbyPLUSinProductPage selectsup = new selectSupplierbyPLUSinProductPage(driver);
		selectsup.selectSupplier(SupplierName2);

		wlib.switchToTabOnurl(driver, "Products&action=EditV");
		createproduct.getSavebtn().click();
		UtilityclassObject.getTest().log(Status.INFO, " verify product information");

		ProductInformationPage productverfy = new ProductInformationPage(driver);
		String actinfo = productverfy.getproductinfo().getText();
		softobj.softAssertusingboolean(ProductName, actinfo);
		/* create org */
		UtilityclassObject.getTest().log(Status.INFO, "create organization");

		hp.getOrgLink().click();

		OrganizationsLinkPLUSICONPage_for_Nutro plusoforglink = new OrganizationsLinkPLUSICONPage_for_Nutro(driver);
		plusoforglink.getCreateNeworgbtn().click();
		CreatingNewOrganizationPage_for_Nutro neworg = new CreatingNewOrganizationPage_for_Nutro(driver);
		neworg.createorg(ORGNAME);
		UtilityclassObject.getTest().log(Status.INFO, " verify organization information");

		OrganizationInformationVERIFICATIONPage_for_Nutro orginfo = new OrganizationInformationVERIFICATIONPage_for_Nutro(
				driver);
		String actorg = orginfo.getHeadermsg().getText();
		softobj.softAssertusingboolean(actorg, ORGNAME);
		softobj.assertALL();
		
		UtilityclassObject.getTest().log(Status.INFO, "create sales Order");

		/** sales order */
	    hp.salesOrder();
		SalesOrderLinkPLUSICONPage_for_Nutro newsales = new SalesOrderLinkPLUSICONPage_for_Nutro(driver);
		newsales.getcreateNewsalesbtn().click();
		CreatingNewSalesOrderPage_for_Nutro newsale = new CreatingNewSalesOrderPage_for_Nutro(driver);
		newsale.entersalename(salesSubject);
		UtilityclassObject.getTest().log(Status.INFO, " select organization");

		newsale.getorgplusicon().click();
		wlib.switchToTabOnurl(driver, "Accounts&action");
		plusinSalesOrderPageforselectingORG plusorg = new plusinSalesOrderPageforselectingORG(driver);
		plusorg.selectreqorganization(ORGNAME);
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		wlib.switchToAlertAndAccept(driver);
		wlib.switchToTabOnurl(driver, "SalesOrder&action");
		newsale.address(Billingaddress);
		UtilityclassObject.getTest().log(Status.INFO, " select product");

		newsale.getproductplus().click();
		wlib.switchToTabOnurl(driver, "Product&action");
		plusinSalesOrderPageforselectingProduct propage = new plusinSalesOrderPageforselectingProduct(driver);
		propage.selectreqProduct(ProductName);
		driver.findElement(By.xpath("//a[.='" + ProductName + "']")).click();
		wlib.switchToTabOnurl(driver, "SalesOrder&action");
		newsale.qntysave(Qnty);
		UtilityclassObject.getTest().log(Status.INFO, " verify sales information");

		SalesOredrInformationPage salesinfo=new SalesOredrInformationPage(driver);
		String acttext = salesinfo.getSalesSubjectinfo().getText();
		softobj.softAssertusingboolean(salesSubject, acttext);
		//UtilityclassObject.getTest().log(Status.INFO,"salesSubjectverifed sucessfullly");
		
		
	}
}
