package com.rbs.assesment.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.rbs.assesment.BaseClass;
import com.rbs.assesment.pages.PersonalInformationPage;
import com.rbs.assesment.pages.SignInPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdatePersonalInformationStepDef extends BaseClass {

	//PersonalInformationPage personalInfo = new PersonalInformationPage();
	PersonalInformationPage personalInfo= null;
	
	@When("^I click on account button$")
	public void I_click_on_account_button() {
		personalInfo = PageFactory.initElements(webDriver, PersonalInformationPage.class);
		personalInfo.getAccount();
	}

	@And("^I click on my personal information$")
	public void I_click_on_my_personal_information() throws InterruptedException {
     Thread.sleep(5000);
		personalInfo.getmyPersonalInformation().click();
		Thread.sleep(5000);
		
	}

	@Then("I update my first name$")
	public void I_update_my_first_name() throws InterruptedException {
		
		personalInfo.getFirstName().clear();
		personalInfo.getFirstName().sendKeys("XYZ");
		personalInfo.getOldPassword().clear();
		personalInfo.getOldPassword().sendKeys("Selenium123");
		personalInfo.getSave().click();
		Thread.sleep(5000);
		String name = webDriver.findElement(By.xpath("//*[@class = 'account']/span")).getText();
		System.out.println(name);
		String firstName[] = name.split(" ");
		boolean flag = firstName[0].equalsIgnoreCase("XYZ");
		assertTrue(flag);
		
		

	}

}
