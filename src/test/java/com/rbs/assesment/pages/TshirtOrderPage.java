package com.rbs.assesment.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.assesment.BaseClass;

public class TshirtOrderPage extends BaseClass {

	
//private static final String TSHIRT_LIST_XPATH= "//*[@class = 'product_list grid row']/li[2]";
private static final String ADD_TO_CART_XPATH = "//*[@class = 'button ajax_add_to_cart_button btn btn-default']";
private static final String TSHIRT_XPATH = "//*[@class = 'ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']";
private static final String PROCEED_TO_CHECOUT_XPATH = "//*[@class = 'button-container']/a";
private static final String PROCEED_TO_CHECOUT2_XPATH = "//*[@class = 'button btn btn-default standard-checkout button-medium']";
private static final String PROCEED_TO_CHECOUT3_NAME = "processAddress";
private static final String TERMS_CHECKBOX_ID = "cgv";
private static final String PAY_BY_BANK_XPATH = "//*[@class = 'payment_module']";
private static final String CONFIRM_ORDER_XPATH = "//*[@class = 'button btn btn-default button-medium']";
private static final String BACK_TO_ORDERS_XPATH = "//*[@class = 'button-exclusive btn btn-default']";
private static final String TABLE_ORDER_HISTORY_XPATH = "//*[@id = 'order-list']/tbody";
private static final String ORDER_NUMBER_XPATH = "//*[@class = 'box']";
private static final String ORDER_MESSAGE_XPATH = "//*[@id = 'center_column']/h1";
private static final String SHIPPING_MESSAGE_XPATH = "//*[@class = 'page-heading']";
private static final String SHOPPING_CART_SUMMARY_ID = "cart_title";
private static final String PRODUCT_ADDED_SUCCESSFUL_MESSAGE_XPATH = "//*[@class = 'layer_cart_product col-xs-12 col-md-6']/h2";

public TshirtOrderPage(WebDriver webDriver )	
{
    PageFactory.initElements(webDriver, this);
}

	
	
	@FindBy(xpath = TSHIRT_XPATH)
	public WebElement tshirt;
	
	@FindBy(xpath = ADD_TO_CART_XPATH )
	public WebElement addToCart;
	
	@FindBy(xpath = PROCEED_TO_CHECOUT_XPATH )
	public WebElement proceedToCheckOut;
	
	@FindBy(xpath = PROCEED_TO_CHECOUT2_XPATH )
	public WebElement proceedToCheckOut2;
	
	@FindBy(id = TERMS_CHECKBOX_ID )
	public WebElement termsCheckBox;
	
	@FindBy(xpath = PAY_BY_BANK_XPATH )
	public WebElement payByBank;
	
	@FindBy(xpath = CONFIRM_ORDER_XPATH )
	public WebElement confirmOrder;
	
	@FindBy(name = PROCEED_TO_CHECOUT3_NAME )
	public WebElement proceedToCheckout3;
	
	@FindBy(xpath = BACK_TO_ORDERS_XPATH )
	public WebElement backToOrders;
	
	@FindBy(xpath = TABLE_ORDER_HISTORY_XPATH )
	public WebElement tableOrderHistory;
	
	@FindBy(xpath = ORDER_NUMBER_XPATH )
	public WebElement orderNumber;
	
	@FindBy(xpath = ORDER_MESSAGE_XPATH )
	public WebElement ordermessage;

	@FindBy(xpath = SHIPPING_MESSAGE_XPATH )
	public WebElement shippingMessage;

	@FindBy(xpath = PRODUCT_ADDED_SUCCESSFUL_MESSAGE_XPATH )
	public WebElement productAddedSuccessMessage;
	
	@FindBy(id = SHOPPING_CART_SUMMARY_ID )
	public WebElement shoppingCartSummary;
	
	public WebElement getAddToCart() {
		return addToCart;
	}

	
	
	public WebElement getTshirt() {
		return tshirt;
	}
	
	public WebElement getProceedToCheckOut() {
		return proceedToCheckOut;
	}
	
	public WebElement getProceedToCheckOut2() {
		return proceedToCheckOut2;
	}
	
	public WebElement getProceedToCheckOut3() {
		return proceedToCheckout3;
	}
	
	public WebElement getPayByBank() {
		return payByBank;
	}
	
	public WebElement getTermsCheckBox() {
		return termsCheckBox;
	}
	
	public WebElement getConfirmOrder() {
		return confirmOrder;
	}
	
	public WebElement getBackToOrders() {
		return backToOrders;
	}
	
	public WebElement getTableOrderHistory() {
		return tableOrderHistory;
	}
	
	public WebElement getOrderNumber() {
		return orderNumber;
	}

	public WebElement getOrdermessage() {
		return ordermessage;
	}
	
	public WebElement getShippingMessage() {
		return shippingMessage;
	}
	
	public WebElement getProductAddedSuccessMessage() {
		return productAddedSuccessMessage;
	}
	
	public WebElement getShoppingCartSummary() {
		return shoppingCartSummary;
	}
	
	
	public String fetchOrderNumber() {
		String orderText = getOrderNumber().getText(); 
		String[] ordersTexts= orderText.split("order reference ");
		String[] number = ordersTexts[1].split(" ",2);
		
		return number[0];
		}
	public boolean isOrderNumberMatched(String orderNumber)
	{
		List<WebElement> orderRows = getTableOrderHistory().findElements(By.tagName("tr"));
		for(WebElement orderRow : orderRows)
		{
			String orderReference = orderRow.findElements(By.tagName("td")).get(0).getText();
			if(orderReference.equals(orderNumber))
			{
				return true;
			}
		}
		
		
		return false;
		
	}
	
}

