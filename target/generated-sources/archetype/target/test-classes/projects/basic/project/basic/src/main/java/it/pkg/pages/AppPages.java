package it.pkg.pages;

import org.openqa.selenium.WebDriver;

import it.pkg.constant.FindLocator;
import it.pkg.helper.CommonUtility;

public class AppPages {

	
public static void abc(FindLocator loc,WebDriver driver)
{
	
	CommonUtility.clickElement(driver, loc.getlocator("clickonoption"));
	
}
	
	
}
