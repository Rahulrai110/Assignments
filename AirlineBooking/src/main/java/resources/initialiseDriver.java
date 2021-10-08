package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class initialiseDriver {

	public WebDriver driver;
	public Properties prop;
	public WebDriver intializedDriver() throws IOException
	{
	    prop =new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\hi\\eclipse-workspace\\AirlineBooking\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "D:\\Software\\Selenium\\chromedriverwin32\\chromedriver.exe");
		    driver=new ChromeDriver();
			
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Software\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:\\Software\\Selenium\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
		
	}

}
