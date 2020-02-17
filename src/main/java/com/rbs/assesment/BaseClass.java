package com.rbs.assesment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public BaseClass(){
		initializeProperties();
		initializeBrowser();
		
	}
	protected static WebDriver webDriver;
	protected static Properties props ;
	
	public void initializeBrowser()
	{
		try {
			if(webDriver == null) {
				String path = new File("src/test/resources/chromedriver").getAbsolutePath();
				System.setProperty("webdriver.chrome.driver",  path);
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				 webDriver = new ChromeDriver(options);
				 webDriver.get(props.getProperty(AssesmentConstants.APP_URL));
				// webDriver.get("https://www.americanexpress.com/uk/"); 
				webDriver.manage().window().maximize();
				webDriver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
				webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			}


		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void initializeProperties() {
		try {
			if(props == null) {
				props = new Properties();
				InputStream stream =  BaseClass.class.getClassLoader().getResourceAsStream("assesment.properties");
				props.load(stream);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void waitForElement(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(webDriver, 2000);
			driverWait.until(ExpectedConditions.elementToBeClickable(element));
			
		}catch (Exception e) {
			Assert.fail();
		}
		
	}
}
