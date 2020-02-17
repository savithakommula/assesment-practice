package com.rbs.assesment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	
	private static final String HEADER_XPATH = "//*[@class = 'header_user_info']/a";
	private static final String T_SHIRT_XPATH = "//*[@id=\"block_top_menu\"]/ul/li[3]/a";
	

	public HomePage(WebDriver webDriver)	
	{
	    PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath = T_SHIRT_XPATH)    
	public WebElement tshirtTab;
	

	@FindBy(xpath = HEADER_XPATH)    
	public WebElement header;

	
       public WebElement getTshirtTab() {
		return tshirtTab;
	}
	
	public WebElement getHeader() {
		return header;
	}
	
}
