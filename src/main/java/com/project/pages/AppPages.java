package com.project.pages;

import org.openqa.selenium.WebDriver;

import com.project.constant.FindLocator;
import com.project.helper.CommonUtility;

public class AppPages {

	
public static void abc(FindLocator loc,WebDriver driver)
{
	
	CommonUtility.clickElement(driver, loc.getlocator("clickonoption"));
	
}
	
	
}
