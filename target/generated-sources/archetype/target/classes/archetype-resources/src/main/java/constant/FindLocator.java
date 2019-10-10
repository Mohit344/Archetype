#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constant;

import java.io.IOException;
import java.util.Properties;

import ${package}.util.ReadPropertiesFile;


/**
 * Find locator class
 * @author Mohit.Jaiswal
 *
 */
public class FindLocator {


	static Properties Assignsprop;

	public FindLocator() {
		try {
			Assignsprop = ReadPropertiesFile.loadProperty(FileConstant.findlocator);// all the xpath to locate element .
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public  String getlocator(String key)
	{
		String value=Assignsprop.getProperty(key);
		return value;

	}

}
