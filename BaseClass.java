package RohanQATask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public WebDriver setUp() {
		return driver;
	}

	@AfterMethod
	public void dearDown() {
		driver.quit();
	}

}
