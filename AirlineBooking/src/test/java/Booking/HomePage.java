package Booking;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import resources.initialiseDriver;

public class HomePage extends initialiseDriver{
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = intializedDriver();
		
	}
	
	public void NavigateToHomePage()
	{
	
		driver.get(prop.getProperty("url"));
		
		
	}

}
