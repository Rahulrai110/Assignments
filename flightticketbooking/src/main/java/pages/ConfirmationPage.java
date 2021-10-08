package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//descendant::h1")
	WebElement confirmationPageTitle;

	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	WebElement reservationNumber;

	public void verifyConfirmationPageDisplayed() {
		confirmationPageTitle.isDisplayed();
	}

	public String getReservationNumber() {
		return reservationNumber.getText();
	}
}
