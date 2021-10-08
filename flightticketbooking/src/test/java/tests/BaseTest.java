package tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utilities.HelperUtil;

public class BaseTest {

	public static WebDriver driver;
	public Properties prop;

	@BeforeSuite
	public Properties loadprop() {
		return prop = new HelperUtil(driver).loadprop();
	}

	@BeforeClass
	public void launchBrowser() {
		String browsername = prop.getProperty("browser");

		if (browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver_v94.exe");
			ChromeOptions options = new ChromeOptions();
			if (browsername.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@AfterClass
//	public void tearDownBrowser() {
//		driver.quit();
//	}
}
