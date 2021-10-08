package pageObject;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public Properties prop;
	public WebDriver Driver;
	public LandingPage(WebDriver driver) throws IOException
	{	
		this.Driver = driver;
	}
	
	By searchbox = By.xpath("//input[@id='search']");
	By searchbutton = By.cssSelector("input[id='searchButton']");
	
	By itemname = By.xpath("//a[@class='clip-prd-dtl']");
	
	public WebElement searchboxfield()
	{
		return Driver.findElement(searchbox);
	}
	
	public WebElement searchbuttonclick()
	{
		return Driver.findElement(searchbutton);
	}
	
	public List<WebElement> itemnamelist()
	{
		return (List<WebElement>) Driver.findElements(itemname);
	}

}

