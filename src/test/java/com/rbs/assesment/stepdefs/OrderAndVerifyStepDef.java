package com.rbs.assesment.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.listener.Reporter;
import com.rbs.assesment.BaseClass;
import com.rbs.assesment.ElementUtil;
import com.rbs.assesment.pages.HomePage;
import com.rbs.assesment.pages.TshirtOrderPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class OrderAndVerifyStepDef extends BaseClass{

	
	TshirtOrderPage tshirt =  new TshirtOrderPage(webDriver);
	HomePage home =  new HomePage(webDriver);
	 String orderNumber;
	 SoftAssertions soft = new SoftAssertions();
	 

    
    //Clicking on Tshirts tab from my account page
    @And ("^I clicked on \"([^\"]*)\" tab$")
    public void I_clicked_on_Tshirt_tab(String tshirt) throws Exception
    {
    	ElementUtil.waitForElement(home.getTshirtTab());
    	String text = home.getTshirtTab().getAttribute("title");
    	if(text.equalsIgnoreCase(tshirt)) {
    	ElementUtil.click(home.getTshirtTab());
    	Reporter.addStepLog("I clicked on Tshirts tab");
    		}
    }
    	
    	
    
    //Adding tshirt to cart and checkout the order
    @Then ("^I ordered Tshirt$")
    public void I_ordered_Tshirt() throws Exception
    {
    	
    	 Actions actions = new Actions(webDriver);
    	 ElementUtil.waitForElement(tshirt.getTshirt());
    	//WebElement addtShirtElement = tshirt.getTshirt();
    	//Actions actions = new Actions(webDriver);
        actions.moveToElement(tshirt.getTshirt()).build().perform();
        //webDriver.switchTo().defaultContent();
        ElementUtil.click(tshirt.getAddToCart());
        Reporter.addStepLog("I added Tshirt to Cart");
        Thread.sleep(2000);
        webDriver.switchTo().activeElement();
        String expectedProductAddedMessage = "Product successfully added to your shopping cart";
        ElementUtil.waitForElement(tshirt.getProductAddedSuccessMessage());
        String actualProductAddedMessage = tshirt.getProductAddedSuccessMessage().getText();
        //assertEquals(expectedProductAddedMessage, actualProductAddedMessage);
        soft.assertThat(actualProductAddedMessage).isEqualTo(expectedProductAddedMessage);
        String expectedProceedToCheckoutTitle = "Proceed to checkout";
        String proceedToCheckoutTitle = tshirt.getProceedToCheckOut().getAttribute("title");
        //assertEquals(expectedProceedToCheckoutTitle, proceedToCheckoutTitle);
        soft.assertThat(proceedToCheckoutTitle).isEqualTo(expectedProceedToCheckoutTitle);
        ElementUtil.click(tshirt.getProceedToCheckOut());
        //webDriver.switchTo().activeElement();
        
        String expectedShippingCartMessage = "SHOPPING-CART SUMMARY\n"
        		+"Your shopping cart contains: 1 Product";
        ElementUtil.waitForElement(tshirt.getShoppingCartSummary());
        String actualShippingCartMessage = tshirt.getShoppingCartSummary().getText();
        //assertEquals(expectedShippingCartMessage, actualShippingCartMessage);
        soft.assertThat(actualShippingCartMessage).isEqualTo(expectedShippingCartMessage);
        Reporter.addStepLog("Shopping Cart summary page got displayed");
        ElementUtil.click(tshirt.getProceedToCheckOut2());
        
        
        String expectedAddressmessage = "ADDRESSES";
        ElementUtil.waitForElement(tshirt.getOrdermessage());
        String actualAddressmessage = tshirt.getOrdermessage().getText();
        //assertEquals(expectedAddressmessage, actualAddressmessage); 
        soft.assertThat(actualAddressmessage).isEqualTo(expectedAddressmessage);
        Reporter.addStepLog("Address page got displayed");
        ElementUtil.click(tshirt.getProceedToCheckOut3());
        
        String expectedShippingmessage = "SHIPPING";
        ElementUtil.waitForElement(tshirt.getShippingMessage());
        String actualShippingMessage = tshirt.getShippingMessage().getText();
        //assertEquals(expectedShippingmessage, actualShippingMessage);
        soft.assertThat(actualShippingMessage).isEqualTo(expectedShippingmessage);
        Reporter.addStepLog("Shipping page got displayed");
        tshirt.getTermsCheckBox().click();
        ElementUtil.click(tshirt.getProceedToCheckOut2());
        
        
        String expectedpaymentMethodMessage = "PLEASE CHOOSE YOUR PAYMENT METHOD";
        ElementUtil.waitForElement(tshirt.getOrdermessage());
        String actualpaymentMethodMessage = tshirt.getOrdermessage().getText();
       // assertEquals(expectedpaymentMethodMessage, actualpaymentMethodMessage);
        soft.assertThat(actualpaymentMethodMessage).isEqualTo(expectedpaymentMethodMessage);
        Reporter.addStepLog("Payment page got displayed");
        ElementUtil.click(tshirt.getPayByBank());
        
        String expectedOrderSummaryMessage = "ORDER SUMMARY";
        ElementUtil.waitForElement(tshirt.getOrdermessage());
        String actualOrderSummaryMessage= tshirt.getOrdermessage().getText();
        //assertEquals(expectedOrderSummaryMessage, actualOrderSummaryMessage); 
        soft.assertThat(actualOrderSummaryMessage).isEqualTo(expectedOrderSummaryMessage);
        Reporter.addStepLog("Order summary page got displayed");
         ElementUtil.click(tshirt.getConfirmOrder());
         
         
        String expectedConfirmationMessage = "ORDER CONFIRMATION";
        ElementUtil.waitForElement(tshirt.getOrdermessage());
        String actualConfirmationMessage= tshirt.getOrdermessage().getText();
        //assertEquals(expectedConfirmationMessage, actualConfirmationMessage); 
        soft.assertThat(actualConfirmationMessage).isEqualTo(expectedConfirmationMessage);
        Reporter.addStepLog("Order confirmation page got displayed");
        
        orderNumber = tshirt.fetchOrderNumber();
        Reporter.addStepLog("I have ordered Tshirt successfully, my Order number is: " +orderNumber);
        ElementUtil.click(tshirt.getBackToOrders());
     
    }
    
    //Verifying the Order History
    @And ("^I verified in Orders History$")
    public void I_verified_in_Orders_History()
    { 
    	String expectedOrderHistory = "ORDER HISTORY";
    	String actualOrderHistory= tshirt.getOrdermessage().getText();
        //assertEquals(expectedOrderHistory, actualOrderHistory);
    	soft.assertThat(actualOrderHistory).isEqualTo(expectedOrderHistory);
        Reporter.addStepLog("Order confirmation page got displayed");
        boolean flag = tshirt.isOrderNumberMatched(orderNumber);
        assertTrue(flag);
        Reporter.addStepLog("I found my Order number in my Order history");
        soft.assertAll();
    }
    

}
