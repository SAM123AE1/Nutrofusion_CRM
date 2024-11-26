package Nutro_CRM_generic.webdriverutility;
//instead of declaring static we can make use of this class

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityclassObject {
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static ExtentTest getTest()

	{
		return test.get();

	}

	public static void setTest(ExtentTest actTest)

	{
		test.set(actTest);

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}

}
