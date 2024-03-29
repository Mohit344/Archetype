package com.website.helper;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.website.constant.FileConstant;
import com.website.driver.DriverClass;

public class CommonUtility extends DriverClass{

	

	static WebElement element;

	public static WebElement locatorsType(String locator) {
		String arraylocator[] = locator.split(":", 2);
		
		System.out.println(arraylocator[0]);

		switch (arraylocator[0]) {
		// Find by xpath
		case "ID":
			System.out.println(arraylocator[1]);
			element = driver.findElement(By.id(arraylocator[1]));
			// element.click();

			break;
		case "XPATH":
			System.out.println(arraylocator[1]);
			element = driver.findElement(By.xpath(arraylocator[1]));

			break;
		// Find by css
		case "CSS":
			element = driver.findElement(By.cssSelector(arraylocator[1]));
			break;
		// find by class
		case "CLASSNAME":
			element = driver.findElement(By.className(arraylocator[1]));
			break;

		// find by name
		case "NAME":
			element = driver.findElement(By.name(arraylocator[1]));
			break;

		// find by link
		case "LINK":
			element = driver.findElement(By.linkText(arraylocator[1]));
			break;

		// find by partial link
		case "PARTIALLINK":
			element = driver.findElement(By.partialLinkText(arraylocator[1]));
			break;
			// find by tagName
		case "TAGNAME":
			element = driver.findElement(By.tagName(arraylocator[1]));
			break;

		default:
			element = driver.findElement(By.xpath(arraylocator[1]));
		}
		return element;
	}

	/**
	 * method click the Element using the fluent wait concepts ignoring the
	 * ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */

	public static void clickElement(WebDriver driver, final String locator) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = locatorsType(locator);
				element.isDisplayed();
				element.click();
				return true;
			}

		});

	}
	
	
	
	
	

	/**
	 * method takes parameter as
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOut
	 * @param text    and select the items from the drop down.
	 */

	public static void selectDropdown(WebDriver driver, final String locator, int timeOut, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {	
				locatorsType(locator);
				element.isDisplayed();
				Select select = new Select(element);
               
				select.selectByVisibleText(text);
				return true;
			}

		});
	}

	/**
	 * method click the blank fields and send the text to be entered
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 */
	public static void clickAndSendText(WebDriver driver, final String locator, int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				locatorsType(locator);
				element.sendKeys(text);
				element.isDisplayed();
				element.click();
				return true;
			}
		});
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text             and get the text of the web element
	 */
	public static String getText(WebDriver driver, final String locator) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		return fluentWait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {
			
				locatorsType(locator);
				element.isDisplayed();
				String text = element.getText();
				
				return text;
			}

		});
	}

	/**
	 * method takes parameter as
	 * 
	 * @param driver
	 * @param xpath
	 * @param text
	 * @return WebElement
	 */
	public static WebElement getElement(WebDriver driver, String locator, String text) {

		//WebElement element = driver.findElement(By.xpath(xpath));
		locatorsType(locator);
		element.sendKeys(text);
		return element;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param XPathIsDisplayed
	 * @return a boolean value for the displayed element on the web page
	 */
	public static boolean isDisplayed(WebDriver driver, String XPathIsDisplayed) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public static void clearElement(WebDriver driver, final String locator) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				locatorsType(locator);
				element.isDisplayed();
				element.clear();
				return true;
			}
		});
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath  and uses the explicit wait concept
	 * @return a boolean value after checking the visibility of the.
	 */
	public static boolean isElementVisible(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, FileConstant.Expicit_Wait);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath
	 * @return the list of elements
	 */

	public static List<WebElement> getElementsList(WebDriver driver, final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}

	/**
	 * method scroll down the window on the web page
	 * 
	 * @param driver
	 */

	/**
	 * the method takes parameter as
	 * 
	 * @param driver
	 * @param byResolution and scroll down the window.
	 */
	public static void scrollDownPage(WebDriver driver, int byResolution) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(0," + byResolution + ")";
		js.executeScript(scroll);

	}

	public static void scrollToElement(WebDriver driver, String locator) {
		//WebElement element = driver.findElement(By.xpath(xpath));
locatorsType(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public static void wait(int timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebElement getElement(String locator) {

		locatorsType(locator);
		return element;
	}

	public static void mouseHover(String locator)
	{Actions action = new Actions(driver);
	locatorsType(locator);
	action.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param actual
	 * @param expected // * @param message //
	 */


}