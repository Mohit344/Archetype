package com.website.script;

import org.testng.annotations.Test;

import com.website.constant.FindLocator;
import com.website.driver.DriverClass;
import com.website.helper.CommonUtility;

public class Practice extends DriverClass {

	FindLocator loc = new FindLocator();
	@Test
	public void practice()
	{
		  CommonUtility.mouseHover(loc.getlocator("device"));
		
		
	}
}
