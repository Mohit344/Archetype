#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dataprovider;

import java.io.IOException;
import java.util.Properties;

import ${package}.constant.FileConstant;
import ${package}.util.ReadPropertiesFile;

public class ValidatingData {
	
	static Properties Property;
	
	/**
	 * In this constructor, reading of property file is being done
	 */
	public ValidatingData() {
		try {
			// calling loadProperty method by giving file path to get property
			Property = ReadPropertiesFile.loadProperty(FileConstant.VALIDATION_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * In this method, validation data from the property file is taken
	 * 
	 * @param key
	 */
	public static String getValidatingData(String key) {
		String value = Property.getProperty(key);
		return value;
	}

}
