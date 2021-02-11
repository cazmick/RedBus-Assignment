package in.RedBus.Base;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject extends Driver {
	public static WebDriver driver;

	public PageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public static void selectDateByJS(WebElement element, String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateval + "');", element);
	}

	public static void scroll() {								//scroll action to perform scroll to the bottom of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,5000)");
	}

	public static void exWait(WebElement waited_element) {		//method defined to wait for the element for 30 seconds or until it got visible to driver
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(waited_element));

	}

	public static void DMY(String date, String my) {				//method is choose the date
		while (true) {
			String myCheck = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			if (myCheck.equals(my)) {
				break;
			} else {
				driver.findElement(By.xpath("//td[@class='next']")).click();
			}

		}
		List<WebElement> allDAtes = driver.findElements(By.xpath("//tbody/tr/td"));
		for (WebElement ele : allDAtes) {
			String date_txt = ele.getText();
			if (date_txt.equals(date)) {
				ele.click();
				break;
			}
		}

	}

	public static void scrollElement(WebElement element) {				//method defined to scroll by means of any element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void checkClickableExplicitly(WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.elementToBeClickable(locator));
		//locator.click();
		}

	public static void switchIFrame(WebElement index) {					//method defines d to handle the frame
		driver.switchTo().frame(index);
	}

	public static void switchWindow() {			
		String mainHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,250)");
		for (String windowHandle : allHandles) {
			if (mainHandle.equals(windowHandle)) {
				System.out.println(driver.getTitle());

			} else {

				driver.switchTo().window(windowHandle);
			}

		}

	}

}
