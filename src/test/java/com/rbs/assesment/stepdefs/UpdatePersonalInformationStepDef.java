package com.rbs.assesment.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.SoftAssertions;

import com.cucumber.listener.Reporter;
import com.rbs.assesment.BaseClass;
import com.rbs.assesment.ElementUtil;
import com.rbs.assesment.pages.PersonalInformationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdatePersonalInformationStepDef extends BaseClass {
	

	PersonalInformationPage personalInfo= new PersonalInformationPage(webDriver);
	SoftAssertions soft = new SoftAssertions();
	static final String FIRST_NAME = "XYZ";
	
	@When("^I click on account button$")
	public void I_click_on_account_button() {
		ElementUtil.click(personalInfo.getAccount());
		Reporter.addStepLog("Clicked on My account");
	}

	@And("^I click on my personal information$")
	public void I_click_on_my_personal_information() throws InterruptedException {
		ElementUtil.click(personalInfo.getmyPersonalInformation());
		Reporter.addStepLog("Clicked on My Personal information tab");
		
	}

	@Then("I update my first name$")
	public void I_update_my_first_name() throws Exception {
		ElementUtil.waitForElement(personalInfo.getFirstName());
		personalInfo.getFirstName().clear();
		personalInfo.getFirstName().sendKeys(FIRST_NAME);
		personalInfo.getOldPassword().clear();
		personalInfo.getOldPassword().sendKeys(decryptPassword());
		ElementUtil.click(personalInfo.getSave());
	}
	
	 @And ("^I verified the changes for first name$")
	 public void I_verified_the_changes_for_first_name() throws Exception
	 {
		 ElementUtil.waitForElement(personalInfo.getUpdateSuccessfulMessage());
		 String expectedSuccessMessage = "Your personal information has been successfully updated.";
		 String actualSuccessMessage = personalInfo.getUpdateSuccessfulMessage().getText();
		 //assertEquals(expectedSuccessMessage, actualSuccessMessage);
		  	soft.assertThat(actualSuccessMessage).isEqualTo(expectedSuccessMessage);
		 Reporter.addStepLog("Update successful message got displayed as: " +actualSuccessMessage);
		 ElementUtil.waitForElement(personalInfo.getAccount());
		    String name = personalInfo.getAccount().getText();
			String firstName[] = name.split(" ");
			boolean flag = firstName[0].equalsIgnoreCase(FIRST_NAME);
			assertTrue(flag);
			Reporter.addStepLog("I have changed my first name suuccessfully");
	 }
	 
	 @And("^I close my browser$")
	 public void I_close_my_browser() {
		 tearDown();
		 
	 }

}
