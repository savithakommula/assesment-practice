package com.rbs.assesment;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil extends BaseClass{

	public static void click(WebElement element) {
		try {
			 @SuppressWarnings("deprecation")
				Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
					       .withTimeout(10, TimeUnit.SECONDS)
					       .pollingEvery(2, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
			//WebDriverWait driverWait = new WebDriverWait(webDriver, 10);
			 wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		}catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	public static void waitForElement(WebElement element) throws Exception {
		try {
			 @SuppressWarnings("deprecation")
			Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
				       .withTimeout(10, TimeUnit.SECONDS)
				       .pollingEvery(2, TimeUnit.SECONDS)
				       .ignoring(NoSuchElementException.class);
			//WebDriverWait driverWait = new WebDriverWait(webDriver, 10);
			 wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e) {
			Assert.fail();
			throw new Exception();
		}
		
	}
	
	
}
