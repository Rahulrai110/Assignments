package pepperFry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.LandingPage;

public class HomePage {
	
	public WebDriver driver;

	public WebDriver intializedDriver() throws IOException
	{
		String browsername = "chrome";
		if(browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\main\\java\\resources\\chromedriver.exe");
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--incognito");
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    if(browsername.contains("headless"))
		    {
		    options.addArguments("headless");
		    }
			driver=new ChromeDriver(options);
	    }
		else
		{
			System.out.println("Browser is not Chrome browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	@Parameters({"url","iteamname"})
	public void HomePageNavigation(String urlname,String itemname) throws IOException
	{
		driver = intializedDriver();
		driver.get(urlname);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LandingPage lp = new LandingPage(driver);
		
		//To send the item name in the Search box
		lp.searchboxfield().sendKeys(itemname);
		
		//To click on Search button/Icon
		lp.searchbuttonclick().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> itemcount = lp.itemnamelist();
		int count = itemcount.size();
		ArrayList<String> list =new ArrayList<String>();
		System.out.println(count);
		
		for(int i=0;i<count;i++)
		{
			list.add(itemcount.get(i).getText());		  
		}
		//To get the list of item names in Ascending order
		Collections.sort(list);
		System.out.println("Ascending Order \n" + list);
		
		System.out.println("-----------------------------------------------");
		
		//To get the list of item names in Descending order
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("Descending Order \n" + list);
    }
	
	
	@AfterTest
	public void teatdown()
	{
		driver.close();
	}
	
}
	