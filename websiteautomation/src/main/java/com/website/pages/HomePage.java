package com.website.pages;

import org.openqa.selenium.WebDriver;

import com.website.constant.FindLocator;
import com.website.helper.CommonUtility;
import com.website.validation.ValidationMethod;

public class HomePage {

	
	public static void productSearch(String productType , String productName,FindLocator loc,WebDriver driver)
	{
		
		
		
		CommonUtility.selectDropdown(driver, loc.getlocator("selectoption"), 2, productType);
		CommonUtility.clickAndSendText(driver, loc.getlocator("search"), 2, productName);
		CommonUtility.clickElement(driver, loc.getlocator("searchbutton"));
	}
	
	public static void SearchMoreItem(String productType,String itemName,FindLocator loc,WebDriver driver )
	{
		
		CommonUtility.selectDropdown(driver, loc.getlocator("selectoption"), 2, productType);
	    CommonUtility.clickAndSendText(driver, loc.getlocator("search"), 2, itemName);
	    CommonUtility.clickElement(driver, loc.getlocator("searchbutton"));
		
		
	}
	
	
public static void validateProductName(FindLocator loc,WebDriver driver,String productName)
{
	String actual_productName=CommonUtility.getText(driver, loc.getlocator("productname"));
	ValidationMethod.verify(actual_productName, productName, "not matched");
	
}
public static void   validateProductPrice(FindLocator loc,WebDriver driver,String productPrice ) {
     String actual_productPrice=CommonUtility.getText(driver, loc.getlocator("productprice"));
     System.out.println(actual_productPrice);
     ValidationMethod.verify(actual_productPrice, productPrice, "not matched");

	
}
public static void validateMessage(FindLocator loc,WebDriver driver,String message )
{
	
	String  actual_message=CommonUtility.getText(driver,loc.getlocator("errormessage"));
	ValidationMethod.verify(actual_message, message, "not matched");
}




}
