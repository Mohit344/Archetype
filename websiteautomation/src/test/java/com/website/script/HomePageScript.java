package com.website.script;

import org.testng.annotations.Test;

import com.website.constant.FindLocator;
import com.website.dataprovider.DataProviderData;
import com.website.driver.DriverClass;
import com.website.helper.CommonUtility;

import com.website.pages.HomePage;

public class HomePageScript extends DriverClass {
FindLocator loc = new FindLocator();
	
@Test(priority = 1,  dataProvider = "productdetail", dataProviderClass = DataProviderData.class)
	public void click(String productType,String productName,String productPrice,String itemName,String message)
	{
	  CommonUtility.mouseHover(loc.getlocator("device"));
	HomePage.productSearch(productType, productName, loc, driver);
   HomePage.validateProductName(loc, driver, productName);	
   HomePage.validateProductPrice(loc, driver, productPrice);
   HomePage.SearchMoreItem(productType, itemName, loc, driver);
   HomePage.validateMessage(loc, driver, message);
 
	
	
	}
	
	
	
}
