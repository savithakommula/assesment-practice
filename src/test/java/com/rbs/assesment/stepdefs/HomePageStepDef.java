package com.rbs.assesment.stepdefs;

import static org.junit.Assert.assertEquals;

import com.cucumber.listener.Reporter;
import com.rbs.assesment.AssesmentConstants;
import com.rbs.assesment.BaseClass;
import com.rbs.assesment.ElementUtil;
import com.rbs.assesment.pages.HomePage;
import com.rbs.assesment.pages.SignInPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDef extends BaseClass{
	
	
	public HomePageStepDef() {
		super();
	}

	
	SignInPage signinpage = new SignInPage(webDriver);
	HomePage home =  new HomePage(webDriver);
	
	//Navigating to Automation Practice website
		@Given ("^I am on Automation Practice website$")
		public void I_am_on_Automation_Practice_website()
		{
			String automationUrl = props.getProperty(AssesmentConstants.APP_URL);
			String currentUrl = webDriver.getCurrentUrl();
			if(!currentUrl.contains(automationUrl))
			{
				webDriver.get(automationUrl);
				Reporter.addStepLog("I navigate to Automation Practice website: "+automationUrl);
			}
			
		}
		
		   //Signing into automation Practice website
		   @When ("^I Signed in to Automation Practice website$")
		   public void I_Signed_in_to_Automation_Practice_website() throws Exception
		   {
			   ElementUtil.waitForElement(home.getHeader());
			   String text = home.getHeader().getAttribute("title");
			   String signInTitle = "Log in to your customer account";
			   if(text.equalsIgnoreCase(signInTitle))
			   {
			   ElementUtil.click(signinpage.getSignIn());
		    	Reporter.addStepLog("Clicked on SignIn button");
		    	signinpage.getEmail().clear();
		    	signinpage.getEmail().sendKeys(props.getProperty(AssesmentConstants.USER_ID));
		    	signinpage.getPassword().clear();
		    	signinpage.getPassword().sendKeys(props.getProperty(AssesmentConstants.PASSWORD));
		    	ElementUtil.click(signinpage.getSiginSubmit());  
		    	
			   }
			   else {
				  Reporter.addStepLog("You already signedin to Automation Practice website"); 
			   }
			   
		   }
		
	    //Verifying whether it is displayed with My Account page or not
	    @Then ("^It should display Automation Practice my account page$")
	    public void It_should_display_Automation_Practice_my_account_page()
	    {
	    	String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
	    	String actualURL = webDriver.getCurrentUrl();
	    	assertEquals(expectedURL, actualURL);
	    	Reporter.addStepLog("Signedin to Automation Practice website"); 
	    }

}
