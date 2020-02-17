package com.rbs.assesment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {
	
	
	private static final String ACCOUNT_XPATH= "//*[@class='account']";
	//private static final String ACCOUNT_NAME = ("//*[@class = 'account']/span"));
	private static final String My_PERSONAL_INFORMATION_XPATH = "//*[@class = 'myaccount-link-list']/li[4]/a";
	private static final String FIRST_NAME_ID = "firstname";
	private static final String OLD_PASSWORD_ID = "old_passwd";
	private static final String SAVE_NAME = "submitIdentity";
	private static final String UPDATE_SUCCESSFUL_MESSAGE_XPATH = "//*[@class ='box']/p";
	
	public PersonalInformationPage(WebDriver driver)	
	{
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ACCOUNT_XPATH)    
	public WebElement account;
	
	@FindBy(xpath = My_PERSONAL_INFORMATION_XPATH)    
	public WebElement myPersonalInformation;
	
	@FindBy(id = FIRST_NAME_ID)    
	public WebElement firstName;
	
	@FindBy(id = OLD_PASSWORD_ID)    
	public WebElement oldPassword;
	
	@FindBy(name = SAVE_NAME)    
	public WebElement save;
	
	@FindBy(xpath = UPDATE_SUCCESSFUL_MESSAGE_XPATH)    
	public WebElement updateSuccessfulMessage;
	
	
	public WebElement getAccount() {
		return account;
	}
	
	public WebElement getmyPersonalInformation() {
		return myPersonalInformation;
	}
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getOldPassword() {
		return oldPassword;
	}
	
	public WebElement getSave() {
		return save;
	}
	
	public WebElement getUpdateSuccessfulMessage() {
		return updateSuccessfulMessage;
	}


}
