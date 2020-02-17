package com.rbs.assesment.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rbs.assesment.BaseClass;
import com.rbs.assesment.pages.HomePage;
import com.rbs.assesment.pages.SignInPage;
import com.rbs.assesment.pages.TshirtOrderPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderAndVerifyStepDef extends BaseClass{

	static {
		initializeBrowser();
	}
	
	SignInPage signinpage = null;
	HomePage home =  null;
	TshirtOrderPage tshirt =  null;
	
	@Given ("^I am on Automation Practice website$")
	public void I_am_on_Automation_Practice_website()
	{
		//webDriver.get("http://automationpractice.com");
		
	}
	
    @And ("^I click on Signin button$")
    public void I_click_on_Signin_button() throws InterruptedException
    {
    	signinpage = PageFactory.initElements(webDriver, SignInPage.class);
    	signinpage.getSignIn().click();
    } 
    
    @When ("^I enter my credentials$")
    public void I_enter_my_credentials() throws InterruptedException
    {
    	Thread.sleep(5000);
    	signinpage.getEmail().clear();
    	signinpage.getEmail().sendKeys("SeleniumTesting@gmail.com");
    	signinpage.getPassword().clear();
    	signinpage.getPassword().sendKeys("Selenium123");
    	signinpage.getSiginSubmit().click();
    }
    
    @Then ("^It should display Automation Practice home page$")
    public void It_should_display_Automation_Practice_home_page()
    {
    	String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
    	String actualURL = webDriver.getCurrentUrl();
    	assertEquals(expectedURL, actualURL);
    }
    
    @And ("^I ordered Tshirt$")
    public void I_ordered_Tshirt() throws InterruptedException
    {
    	home = PageFactory.initElements(webDriver, HomePage.class);
    	tshirt = PageFactory.initElements(webDriver, TshirtOrderPage.class);
   /* 	ArrayList<WebElement> categoryList = home.getCategoryList();
    	int size = categoryList.size();
    	if(size != 0)
    	{
    		home.selectTshirtsTab(categoryList);
    		
    		//ArrayList<WebElement> tShirtList= tshirt.getTshirtList();
    		//WebElement tShirtElement =  tShirtList!= null ? tShirtList.get(0): null;
    		
    		//if(tShirtElement != null ) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(tshirt.getTshirtList());
            tshirt.getAddToCart().click();
    		}
    	}
    	*/
    	
    	WebDriverWait wait = new WebDriverWait(webDriver, 10);
       
    	
    	
    	WebElement tShirtElemnt = home.getCategory();
    	tShirtElemnt.click();
    	Thread.sleep(4000);
    	WebElement addtShirtElement = tshirt.getTshirt();
    	Actions actions = new Actions(webDriver);
        actions.moveToElement(addtShirtElement).build().perform();
        webDriver.switchTo().defaultContent();
        Thread.sleep(2000);
        tshirt.getAddToCart().click();
        Thread.sleep(2000);
        webDriver.switchTo().activeElement();
        String expectedProceedToCheckoutTitle = "Proceed to checkout";
        String proceedToCheckoutTitle = tshirt.getProceedToCheckOut().getAttribute("title");
        assertEquals(expectedProceedToCheckoutTitle, proceedToCheckoutTitle);
        tshirt.getProceedToCheckOut().click();
       
        //webDriver.switchTo().activeElement();
        Thread.sleep(5000);
       // wait.until(
            	//ExpectedConditions.elementToBeClickable(tshirt.getProceedToCheckOut()));
        
        tshirt.getProceedToCheckOut2().click();
        Thread.sleep(5000);
        tshirt.getProceedToCheckOut3().click();
        Thread.sleep(5000);
        tshirt.getTermsCheckBox().click();
        Thread.sleep(5000);
        tshirt.getProceedToCheckOut2().click();
        Thread.sleep(5000);
        tshirt.getPayByBank().click();
        Thread.sleep(5000);
        tshirt.getConfirmOrder().click();
        Thread.sleep(5000);
        String orderNumber = tshirt.fetchOrderNumber();
        tshirt.getBackToOrders().click();
        Thread.sleep(5000);
        boolean flag = tshirt.isOrderNumberMatched(orderNumber);
        assertTrue(flag);
        
    }

}
