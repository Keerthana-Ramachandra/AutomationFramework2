package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of generic or reusable methods related to property file
 * @author Keerthi
 *
 */

public class PropertyFileUtility 
{

/**
 * This method will read data from property file and return he value to the caller
 * @param propertyfilekey
 * @return
 * @throws Throwable
 */
	public String readDataFromPropertyFile(String propertyfilekey) throws Throwable
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(propertyfilekey);
		return value;
		
	}
}
