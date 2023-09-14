package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic or reusable methods related to Excel file
 * @author Keerthi
 *
 */

public class ExcelFileUtility 
{
	

/**
 * This method will read data drom excel sheet and return the value to caller
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @return data
 * @throws Throwable
 */
	public String readDataFromExcelFile(String sheetname, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//Sheet sheet = wb.getSheet(sheetname);
		 String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		 wb.close();
		 return data;
	}
	
	
/**
 * 	This method will write data into excel sheet 
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @param value
 * @return
 * @throws Throwable
 */
	public void writeDataIntoExcel(String sheetname, int rownum, int cellnum, String value) throws Throwable
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 wb.createSheet(sheetname).createRow(rownum).createCell(cellnum).setCellValue(value);
		 
		 FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Vtiger.xlsx");
		 wb.write(fos);
		 wb.close();
	
		
	}


public Object[][] readMultipledataFromExcel(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetname);
	//To read the last row till where data is written
	int lastRowNumber = sheet.getLastRowNum();
	//To read the last cell till where data is written
	int lastCellNumber = sheet.getRow(0).getLastCellNum();
	//Indicating array boundary
	Object[][] data= new Object[lastRowNumber][lastCellNumber];
	//it is only< because if it is equal it will read empty row too as indexing starts from 0
	for (int i=0; i<lastRowNumber; i++)
	{
		for (int j=0; j<lastCellNumber; j++)
		{
			//u can either give i=1 in for loop or give getrow(i+1) inside loop. Beause always 0th row is having header so need to read that
			data[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}
}

