package com.GenericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtilties {
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void ScrollToParticularElement(WebDriver driver , WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
	}
	/**
	 * *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void wait(WebDriver driver , String partialPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains(partialPageURL));
	}

	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @return
	 */
	public String screenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
}
