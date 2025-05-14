package RohanQATask;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest extends BaseClass {

	@Test
	public void appleWatch() {

		driver.get("https://rohanqa.deposyt.store/");
		driver.findElement(By.xpath("//a[text()='SHOP NOW']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		DriverWait.waitDriver(By.xpath("//a[@href='/products/apple-watch']"), driver);
		driver.findElement(By.xpath("//a[@href='/products/apple-watch']")).click();

		DriverWait.waitDriver(By.xpath("//span[text()='$240.00']"), driver);
		String ExpectedPrice = "$240.00";
		String ActualPrice = driver.findElement(By.xpath("//span[text()='$240.00']")).getText();
		System.out.println("Actual Price: " + ActualPrice);
		Assert.assertEquals(ActualPrice, ExpectedPrice, "both are not same price");

		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		DriverWait.waitDriver(By.xpath("//a[text()='Cart (1)']"), driver);
		driver.findElement(By.xpath("//a[text()='Cart (1)']")).click();

		driver.findElement(By.xpath("//select")).click();
		Select select = new Select(driver.findElement(By.xpath("//select/following-sibling::span")));
		select.selectByIndex(1);

		DriverWait.waitDriver(By.xpath("//span[text()='$480.00']"), driver);
		String ActualTotalPrice = driver.findElement(By.xpath("//span[text()='$480.00']")).getText();
		String ExpectedTotlePrice = "$480.00";
		Assert.assertEquals(ActualTotalPrice, ExpectedTotlePrice, "both are not same price");

		driver.findElement(By.xpath("//button[text()='Go to checkout']")).click();
		DriverWait.waitDriver(By.xpath("//span[text()='Shipping']/parent::div/following-sibling::div/span"), driver);
		String ExpectedShipping = "$0.00";
		String ActualShipping = driver
				.findElement(By.xpath("//span[text()='Shipping']/parent::div/following-sibling::div/span")).getText();
		Assert.assertEquals(ActualShipping, ExpectedShipping, " both are not same");
		String ExpectedTotal = "$518.40";
		String ActualTotal = driver
				.findElement(By.xpath("//span[text()='Total']/parent::div/following-sibling::div/span")).getText();
		System.out.println("Total: " + ActualTotal);

	}

}
