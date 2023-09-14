package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//open the file in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Vtiger.xlsx");
		
		//Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to required sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Navigate to required row
		Row row = sh.getRow(4);
		
		//Navigate to required cell
		Cell cell = row.getCell(3);
		
		//read the data inside the cell
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		//close the workbook
		wb.close();

	}

}
