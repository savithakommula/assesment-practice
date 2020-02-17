package com.rbs.assesment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	protected static WebDriver webDriver;
	public static void initializeBrowser()
	{
		try {
			String path = new File("src/test/resources/chromedriver").getAbsolutePath();
			System.setProperty("webdriver.chrome.driver",  path);
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			 webDriver = new ChromeDriver(options);
			 webDriver.get("http://automationpractice.com");
			// webDriver.get("https://www.americanexpress.com/uk/"); 
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
			webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
