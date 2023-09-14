package vtiger.practice;

import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;

public class GenericUtilitiesPractice {

	public static void main(String[] args) throws Throwable
	{
		//read data from property utility
		PropertyFileUtility pfu= new PropertyFileUtility();
		String browsser = pfu.readDataFromPropertyFile("browser");
		System.out.println(browsser);
		
		String un = pfu.readDataFromPropertyFile("username");
		System.out.println(un);

		//Read data from excel utility
		ExcelFileUtility efu= new ExcelFileUtility();
		String data = efu.readDataFromExcelFile("Organization", 1, 2);
		System.out.println(data);
		
		//write data into excel
		efu.writeDataIntoExcel("Import", 9, 1, "Salt");
		System.out.println("Data is added");
		
		//get rqandom date
		JavaUtility ju= new JavaUtility();
		int number = ju.randomNumber();
		System.out.println(number);
		
		//get system date
		String date = ju.getSystemDate();
		System.out.println(date);
		
		
	}

}
