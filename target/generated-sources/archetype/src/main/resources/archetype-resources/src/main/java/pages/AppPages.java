#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import org.openqa.selenium.WebDriver;

import ${package}.constant.FindLocator;
import ${package}.helper.CommonUtility;

public class AppPages {

	
public static void abc(FindLocator loc,WebDriver driver)
{
	
	CommonUtility.clickElement(driver, loc.getlocator("clickonoption"));
	
}
	
	
}
