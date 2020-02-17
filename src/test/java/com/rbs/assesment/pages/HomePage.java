package com.rbs.assesment.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.assesment.BaseClass;

public class HomePage extends BaseClass {
	
	//private static final String CATEGORY_LIST_XPATH= "//*[@id=\"block_top_menu\"]/ul/li[3]/a";
	
/*	@FindAll({
		@FindBy(xpath = CATEGORY_LIST_XPATH)
	})                
	public ArrayList<WebElement> categoryList;

	
	public ArrayList<WebElement> getCategoryList() {
		return categoryList;
	} */
	
	private static final String T_SHIRT_XPATH= "//*[@id=\"block_top_menu\"]/ul/li[3]/a";
	@FindBy(xpath = T_SHIRT_XPATH)    
	public WebElement categoryList;

	
	public WebElement getCategory() {
		return categoryList;
	}
	
	//public HomePage(WebDriver webDriver)	
	//{
		//HomePage.webDriver = webDriver;
	      // PageFactory.initElements(webDriver, this);
	//}
	
	

	public void selectTshirtsTab(ArrayList<WebElement> categories)
	{
		for(WebElement category: categories)
		{
			String categoryName = category.getAttribute("title");
			if(categoryName.equalsIgnoreCase("T-shirts"))
			{
				category.click();
				break;
			}
		}
		
		
	}

	



}
