package vtiger.practice;

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

public class WriteDataToExcelWithExistingSheetWithExistingRowAndNewCell 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//open the file in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Vtiger.xlsx");
		
		//Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to sheet
		Sheet sh = wb.getSheet("Contact");
		
		//Navigate to row
		Row row = sh.getRow(4);
		
		//Create a cell
		Cell c = row.createCell(8);
		
		//provide data to be written
		c.setCellValue("it");
		
		//open the document in java writable format
		FileOutputStream fos= new FileOutputStream (".\\\\src\\\\test\\\\resources\\\\Vtiger.xlsx");
		
		//write the data
		wb.write(fos);
		System.out.println("Data added Successfully");
		
		//close
		wb.close();
		
		

	}

}
