package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile 
{

	public static void main(String[] args) throws IOException
	{
		//open the file in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//create object of properties class
		Properties pro= new Properties();
		
		
		//load the documant tnto properties class
		pro.load(fis);
		
		//provide the key and read the value
		String browser1 = pro.getProperty("browser");
		System.out.println(browser1);
		String url1 = pro.getProperty("url");
		System.out.println(url1);
		String un = pro.getProperty("username");
		System.out.println(un);
		String pass = pro.getProperty("password");
		System.out.println(pass);

	}

}
