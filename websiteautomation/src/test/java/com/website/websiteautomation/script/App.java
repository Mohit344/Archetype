package com.website.websiteautomation.script;

import org.testng.annotations.Test;

import com.website.websiteautomation.constant.FindLocator;
import com.website.websiteautomation.driver.DriverClass;
import com.website.websiteautomation.helper.CommonUtility;

public class App extends DriverClass {
FindLocator loc = new FindLocator();
	
	@Test
	public void click()
	{
		
		CommonUtility.clickElement(driver,loc.getlocator("device"));
		CommonUtility.getText(driver, loc.getlocator("device"));
		CommonUtility.scrollToElement(driver, loc.getlocator("device"));
		//CommonUtility.clickAndSendText(driver, loc.getlocator(""), timeOutInSeconds, text);
		CommonUtility.clickAndSendText(driver, loc.getlocator("search"), 2, "call of duty");
	
	}
	
	
	
}
