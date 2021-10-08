package pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.HelperUtil;

public class LandingPage extends BasePage {
	public Properties prop;
	public HelperUtil helperUtil;
	
	@FindBy(xpath = "//div[@class='jumbotron']//h1[contains(text(),'Welcome')]")
	WebElement welcomeTitle;
	
	@FindBy(name = "fromPort")
	WebElement departureDropDown;

	@FindBy(name = "toPort")
	WebElement destinationDropDown;

	@FindBy(xpath = "//input[@value='Find Flights']")
	WebElement findFlightsButton;

	public LandingPage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
		helperUtil = new HelperUtil(driver);
		loadProperties();
	}

	public void loadProperties() {
		prop = helperUtil.loadprop();
	}

	public void validateText() {
		welcomeTitle.isDisplayed();
	}

	public void submitbuttonOption() {
		findFlightsButton.click();
	}

	public void selectDepartureCity() {
		String dCity = prop.getProperty("From");
		Select select = new Select(departureDropDown);
		select.selectByValue(dCity);
	}

	public void selectDestinationCity() {
		String aCity = prop.getProperty("To");
		Select select = new Select(destinationDropDown);
		select.selectByValue(aCity);
	}
}
