package tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ChooseFlight;
import pages.ConfirmationPage;
import pages.LandingPage;
import pages.ReserveDetailsPage;
import utilities.HelperUtil;

public class BookAFlightTest extends BaseTest {
	public LandingPage landingPage;
	public ChooseFlight chooseFlight;
	public ReserveDetailsPage reservePage;
	public ConfirmationPage confirmationPage;
	public HelperUtil helperUtil;
	private String baseUrl = super.loadprop().getProperty("url");

	@BeforeClass
	public void setup() throws IOException {
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		chooseFlight = PageFactory.initElements(driver, ChooseFlight.class);
		reservePage = PageFactory.initElements(driver, ReserveDetailsPage.class);
		confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
		helperUtil = new HelperUtil(driver);
	}

	@Test(priority=0)
	public void searchForFlights() {
		helperUtil.navigatePage(baseUrl);
		landingPage.selectDepartureCity();
		landingPage.selectDestinationCity();
		landingPage.submitbuttonOption();
	}

	@Test(priority=1)
	public void chooseFlight() {
		chooseFlight.verifyReservePageDisplayed();
		chooseFlight.selectLowestPriceFlight();
	}

	@Test(priority=2)
	public void purchaseTicket() throws InterruptedException {
		reservePage.verifyPurchasePageDisplayed();
		reservePage.setName();
		reservePage.setAddress();
		reservePage.setCity();
		reservePage.setState();
		reservePage.setZipcode();
		reservePage.selectCardTypeOption();
		reservePage.setCardNo();
		reservePage.setMonth();
		reservePage.setYear();
		reservePage.setNameOnCard();
		reservePage.clickpurchaseButtonoption();
	}

	@Test(priority=3)
	public void bookingConfirmed() {
		 confirmationPage.verifyConfirmationPageDisplayed();
		 System.out.println("Booking Id:"+confirmationPage.getReservationNumber());
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
