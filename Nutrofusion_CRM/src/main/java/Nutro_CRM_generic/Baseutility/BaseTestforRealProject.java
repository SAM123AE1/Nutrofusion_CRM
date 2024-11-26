package Nutro_CRM_generic.Baseutility;

/**
 * @author YASHAWANTH K M
 */
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Nutro_CRM_AssertUtility.HardAssertCalling;
import Nutro_CRM_AssertUtility.SoftAssertCalling;
import Nutro_CRM_generic.databaseutility.DatabaseUtility;
import Nutro_CRM_generic.fileutility.ExcelUtility;
import Nutro_CRM_generic.fileutility.FileUtility;
import Nutro_CRM_generic.webdriverutility.JavaUtility;
import Nutro_CRM_generic.webdriverutility.UtilityclassObject;
import Nutro_CRM_generic.webdriverutility.WebDriverUtility;
import Nutro_CRM_objectRepositoryutility.HomePage_for_Nutro;
import Nutro_CRM_objectRepositoryutility.LoginPage_for_Nutro;

public class BaseTestforRealProject {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public SoftAssertCalling softobj = new SoftAssertCalling();
	public HardAssertCalling hardobj = new HardAssertCalling();

	public DatabaseUtility dlib = new DatabaseUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();

	@BeforeSuite(groups = { "Smoke Test", "Regression Test" })
	public void BeforeSuite() throws Throwable {

		dlib.getDbconnection();
		System.out.println("executed BeforeSuite++=========connect to db and report config");

	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "Smoke Test", "Regression Test" })
	public void BeforeClass(@Optional("chrome") String browser) throws Throwable {
		//String BROWSER = browser;
		//to enter browser from cmd first browser
		String BROWSER =System.getProperty("browser", browser);
System.out.println(BROWSER);
		// flib.getDataFromPropertiesFile("browser");
		driver = wlib.browserselect(BROWSER);
		sdriver = driver;
		UtilityclassObject.setDriver(driver);

		System.out.println("executed BeforeClass====Launch the brow");
	}

//	@BeforeClass(groups = {"Smoke Test","Regression Test"})
//	public void BeforeClass() throws Throwable {
//		String BROWSER =flib.getDataFromPropertiesFile("browser");
//		 driver = wlib.browserselect(BROWSER);
//		 sdriver=driver;
//		System.out.println("executed BeforeClass====Launch the brow");
//	}

	@BeforeMethod(groups = { "Smoke Test", "Regression Test" })
	public void executeBefore() throws Throwable {
//		String URL = flib.getDataFromPropertiesFile("url");
//		String UN = flib.getDataFromPropertiesFile("un");
//
//		String PWD = flib.getDataFromPropertiesFile("pwd");
		//to enter url from cmd first browser
		//to enter pwd from cmd first browser
		
		//to enter un from cmd first browser
		String  URL=System.getProperty("url",flib.getDataFromPropertiesFile("url"));
		String PWD=System.getProperty("pwd",flib.getDataFromPropertiesFile("pwd"));
		String UN=System.getProperty("un",flib.getDataFromPropertiesFile("un"));

		LoginPage_for_Nutro lp = new LoginPage_for_Nutro(driver);
		lp.logintoApp(URL, UN, PWD);
		System.out.println("executed beforemethod=======login");
	}

	@AfterMethod(groups = { "Smoke Test", "Regression Test" })
	public void executeAfter() throws Throwable {

		HomePage_for_Nutro hp = new HomePage_for_Nutro(driver);
		hp.logout();

		System.out.println("executed Aftermethod=====logout");
	}

	@AfterClass(groups = { "Smoke Test", "Regression Test" })
	public void Afterclass() {
		wlib.quitwindow(driver);

		System.out.println("executed Afterclass===close the brow");
	}

	@AfterSuite(groups = { "Smoke Test", "Regression Test" })
	public void AfterSuite() throws Throwable {
		dlib.closeDbconnection();
		System.out.println("executed AfterSuite=====connect to db, report backup");

	}

}
