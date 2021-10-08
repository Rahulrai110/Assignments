package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.HelperUtil;

public class ReserveDetailsPage extends BasePage {
	public Properties prop;
	public HelperUtil helperUtil;

	public ReserveDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		helperUtil = new HelperUtil(driver);
		loadProperties();
	}

	public void loadProperties() {
		prop = helperUtil.loadprop();
	}

	@FindBy(xpath = "//descendant::h2")
	WebElement purchasePageTitle;

	@FindBy(name = "inputName")
	WebElement name;

	@FindBy(name = "address")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "zipCode")
	WebElement zipCode;

	@FindBy(name = "cardType")
	WebElement cardType;

	@FindBy(name = "creditCardNumber")
	WebElement cardNumber;

	@FindBy(name = "creditCardMonth")
	WebElement month;

	@FindBy(name = "creditCardYear")
	WebElement year;

	@FindBy(name = "nameOnCard")
	WebElement cardName;

	@FindBy(name = "rememberMe")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement purchaseFlight;

	public void verifyPurchasePageDisplayed() {
		purchasePageTitle.isDisplayed();
	}

	public void setMonth() {
		String mt = prop.getProperty("month");
		month.sendKeys(mt);
	}

	public void setYear() {
		String yr = prop.getProperty("year");
		year.sendKeys(yr);
	}

	public void setNameOnCard() {
		String noc = prop.getProperty("nameoncard");
		cardName.sendKeys(noc);
	}

	public void setCardNo() {
		String cn = prop.getProperty("cardno");
		cardNumber.sendKeys(cn);
	}

	public void setZipcode() {
		String zc = prop.getProperty("zipcode");
		zipCode.sendKeys(zc);
	}

	public void selectCardTypeOption() {
		String cType = prop.getProperty("cardType");
		Select s = new Select(cardType);
		s.selectByVisibleText(cType);
	}

	public void setState() {
		String st = prop.getProperty("state");
		state.sendKeys(st);
	}

	public void setCity() {
		String ci = prop.getProperty("city");
		city.clear();
		city.sendKeys(ci);
	}

	public void setAddress() {
		String ad = prop.getProperty("address");
		address.clear();
		address.sendKeys(ad);
	}

	public void setName() throws InterruptedException {
		String na = prop.getProperty("name");
		name.clear();
		name.sendKeys(na);
	}

	public void clickpurchaseButtonoption() {
		purchaseFlight.click();
	}

	public void enableRememberMeCheckBox() {
		if (!rememberMeCheckBox.isSelected())
			rememberMeCheckBox.click();
	}

	public void disableRememberMeCheckBox() {
		if (rememberMeCheckBox.isSelected())
			rememberMeCheckBox.click();
	}
}
