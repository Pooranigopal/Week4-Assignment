package Week4Day2Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pepperfry {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Go to https://www.pepperfry.com/
		driver.get("https://www.pepperfry.com/");
		System.out.println("Pepperfry Launched Sucessfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("notification-frame-~55866c41"));

		// driver.switchTo().frame("notification-frame-~55866c41");
		WebElement close = driver
				.findElement(By.xpath("//div[@id='webklipper-publisher-widget-container-notification-close-div']"));
		wait.until(ExpectedConditions.visibilityOf(close));
		close.click();
		driver.switchTo().defaultContent();
		System.out.println("Popup closed");

		WebElement regpopup = driver.findElement(By.xpath("//div[@id='reg_login_box']/div[@id='regPopUp']/a"));
		wait.until(ExpectedConditions.visibilityOf(regpopup));
		regpopup.click();
		System.out.println("Registration Closed");

		// Mouseover on Furniture and click Office Chairs under Chairs

		Actions builder = new Actions(driver);
		WebElement furniture = driver.findElement(By.xpath("//div[@id='menu_wrapper']//a[@rel='meta-furniture']"));
		builder.moveToElement(furniture).perform();
		System.out.println("Moved to Furniture");

		WebElement officechair = driver.findElement(By.linkText("Office Chairs"));
		builder.moveToElement(officechair).click().perform();
		System.out.println("Clicked on Office Chairs");

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("notification-frame-~251447426"));
		WebElement closepop = driver
				.findElement(By.xpath("//div[@id='webklipper-publisher-widget-container-notification-close-div']"));
		wait.until(ExpectedConditions.visibilityOf(closepop));
		closepop.click();
		driver.switchTo().defaultContent();
		System.out.println("second Popup closed");
		Thread.sleep(3000);

		// click Executive Chairs
		driver.findElement(By.xpath("//h5[text()='Executive Chairs']/preceding::div[1]")).click();
		System.out.println("Executive Chairs clicked");
		Thread.sleep(3000);

		// Change the minimum Height to 50 in under Dimensions
		WebElement height = driver.findElement(By.xpath("//h2[text()='DIMENSION              ']/following::input[1]"));
		height.clear();
		Thread.sleep(3000);
		height.sendKeys("50", Keys.TAB);
		System.out.println("Dimention 50 added in height");
		Thread.sleep(3000);

		// Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist

		driver.findElement(By.xpath("//a[@data-productname='Galician High Back Executive Chair in Black Colour']"))
				.click();
		Thread.sleep(3000);

		// Mouseover on Bedroom and Click Study tables
		WebElement bedroom = driver.findElement(By.xpath("//div[@id='menu_wrapper']//a[@rel='meta-bedroom']"));
		builder.moveToElement(bedroom).perform();
		Thread.sleep(3000);

		WebElement studytables = driver.findElement(By.linkText("Study Tables"));
		builder.moveToElement(studytables).click().perform();
		System.out.println("moved to bedroom and Clicked on study tables");
		Thread.sleep(3000);

		// Select Spacewood as Brand
		driver.findElement(By.xpath("//input[@data-value='Spacewood']/following-sibling::label[1]")).click();
		System.out.println("SpaceWood Brand Selected");

		// Select Price as 7000 to 8000
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='price7000-8000']/following-sibling::label[1]")).click();
		Thread.sleep(3000);

		System.out.println("Price Range selected");

		// Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish" to
		// Wishlist

		driver.findElement(
				By.xpath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']"))
				.click();
		System.out.println("SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish product is added");

		// Verify the number of items in the Wishlist
		String numberofitems = driver.findElement(By.id("wishlist_mini_cart")).getText();
		System.out.println("The Number of items dispalyed in the wishlist is: " + numberofitems);
		Thread.sleep(3000);

		// Navigate to Wishlist
		driver.findElement(By.className("wishlist_bar")).click();
		System.out.println("Navigated to wishlist");
		Thread.sleep(3000);

		// Move Table only to Cart from Wishlist
		driver.findElement(By.xpath("//div[@data-brand='Spacewood']//a[1]")).click();
		System.out.println("Table only moved to card");
		Thread.sleep(3000);

		// Click Proceed to Pay Securely
		driver.findElement(By.xpath("//div[@id='minicart_footer']//a")).click();
		Thread.sleep(3000);

		// Enter Pincode as 600028 in Delivery & Assembly Details and click Go
		driver.findElement(By.id("pin_code")).sendKeys("600028");
		Thread.sleep(3000);
		driver.findElement(By.id("pin_check")).click();
		Thread.sleep(3000);
		System.out.println("Entered the pin 600028 and clicked on GO");

		// Click Place Order"
		driver.findElement(By.linkText("PLACE ORDER")).click();
		System.out.println("Place Order button clicked");
		Thread.sleep(3000);

		// Capture a screenshot by Clicking on Order Summary
		driver.findElement(By.id("ordersummary_accrodian")).click();
		Thread.sleep(3000);
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshot/OrderSummary.jpeg"));
		System.out.println("Ordersummary screenshot taken and it is saved in screenshot folder");
		Thread.sleep(2000);

		// Close the browser
		driver.quit();
		System.out.println("Browser Closed sucessfully");

	}

}
