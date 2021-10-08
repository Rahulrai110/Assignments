package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseFlight extends BasePage {
	
	@FindBy(xpath = "//h3")
	WebElement reservePageTitle;

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> rows;

	@FindBy(xpath = "//tbody/tr[1]/td")
	List<WebElement> cols;

	@FindBy(xpath = "/descendant::input[@type='submit'][3]")
	WebElement lowestPrice;

	public ChooseFlight(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyReservePageDisplayed() {
		reservePageTitle.isDisplayed();
	}

	public void selectLowestPriceFlight() {
		int rowCount = rows.size();
		String min = "", currVal = "";
		int minRowNum = 0;
		min = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText();
		for (int rows = 1; rows <= rowCount; rows++) {
			currVal = driver.findElement(By.xpath("//tbody/tr[" + rows + "]/td[6]")).getText();

			if (min.compareTo(currVal) > 0) {
				min = currVal;
				minRowNum = rows;
			}
		}

		System.out.println("Lowest Price -" + min);
		driver.findElement(By.xpath("//tbody/tr[" + minRowNum + "]/td[1]")).click();
	}
}
