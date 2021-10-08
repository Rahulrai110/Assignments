import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class googleMap {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Parameterized source and Destination , Input will be passed from command line when user try to run the Jar file
		String source = args[0];
		String destination = args[1];
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"");
		ChromeOptions option=new ChromeOptions();
		
		//browser is run in Headless mode
		option.setHeadless(true);
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.google.co.in/maps");
		driver.manage().window().maximize();
		
		//Click on the Direction Button on the GoogleMp HomePage
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@class='searchbox-directions-icon']")).click();
		
		//Send Source location which the user will Send from Command Line
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='sb_ifc51']/input")).sendKeys(source);
		
		//Send Destination Location which the user will Send from Command Line
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='sb_ifc52']/input")).sendKeys(destination);
		
		//Click on the Search button to get all the possible Distance from Source to Destination
		driver.findElement(By.xpath("//*[@id='directions-searchbox-1']/button[1]")).click();
		
		//Find all the Distance from Source to Destination
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> distance = driver.findElements(By.xpath("//div[contains(text(), 'km')]"));
		int count = distance.size();
		System.out.println(count);
		
		for(int i=0; i<count; i++) 
		{
			String distancediff = distance.get(i).getText();
			//Print all the possible distance from Source to destination
			System.out.println(distancediff);
		}
	}

}
