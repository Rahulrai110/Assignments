package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class HelperUtil {
	public Properties prop;
	private WebDriver driver;

	public HelperUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void navigatePage(String url) {
		driver.get(url);
	}

	public Properties loadprop() {
		prop = new Properties();

		try {
			// System.getProperty("user.dir")
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
