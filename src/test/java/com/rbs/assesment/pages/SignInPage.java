package com.rbs.assesment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.assesment.BaseClass;

public class SignInPage extends BaseClass {
	public static final String SIGNIN_XPATH= "//*[@id='header']/div[2]/div/div/nav/div[1]/a";
	public static final String EMAIL_ID = "email";
	public static final String PASSWORD_ID = "passwd";
	public static final String SIGNIN_SUBMIT_ID = "SubmitLogin";
	

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
	
	
	//public SignInPage(WebDriver webDriver)	
	//{
	//	SignInPage.webDriver = webDriver;
	//       PageFactory.initElements(webDriver, this);
	//}
	

}
