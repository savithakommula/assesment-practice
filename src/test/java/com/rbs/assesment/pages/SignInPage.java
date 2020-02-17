package com.rbs.assesment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.assesment.BaseClass;

public class SignInPage {
	public static final String SIGNIN_XPATH= "//*[@class = 'login']";
	public static final String EMAIL_ID = "email";
	public static final String PASSWORD_ID = "passwd";
	public static final String SIGNIN_SUBMIT_ID = "SubmitLogin";
	
	public SignInPage(WebDriver webDriver)	
	{
	    PageFactory.initElements(webDriver, this);
	}

	@FindBy(xpath = SIGNIN_XPATH)
	WebElement signIn;
	
	@FindBy(id = EMAIL_ID)
	WebElement email;
	
	@FindBy(id = PASSWORD_ID)
	WebElement password;
	
	@FindBy(id = SIGNIN_SUBMIT_ID)
	WebElement siginSubmit;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSiginSubmit() {
		return siginSubmit;
	}
	

}
