package vtiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationUsingGenericUtilities
{

	public static void main(String[] args) throws Throwable
	{
		//launch browser
		JavaUtility jutil= new JavaUtility();
		PropertyFileUtility putil= new PropertyFileUtility();
		ExcelFileUtility eutil= new ExcelFileUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		
				WebDriver driver= null;
				// read data from property file
				String BROWSER = putil.readDataFromPropertyFile("browser");
				String USERNAME = putil.readDataFromPropertyFile("username");
				String PASSWORD = putil.readDataFromPropertyFile("password");
				String URL = putil.readDataFromPropertyFile("url");
				
				// Read data from excel
				String contactname = eutil.readDataFromExcelFile("Contact", 4, 2)+jutil.randomNumber();
				String organizationName = eutil.readDataFromExcelFile("Contact", 4, 3);
				
				if (BROWSER.equalsIgnoreCase("chrome"))
				{
					driver= new ChromeDriver();
				}
				else if (BROWSER.equalsIgnoreCase("firefox"))
				{
					driver= new FirefoxDriver();
				}
				else if (BROWSER.equalsIgnoreCase("edge"))
				{
					driver= new EdgeDriver();
				}
				else 
				{
					System.out.println("invalid browser");
				}
			
				
				
				wutil.maximizeWindow(driver);
				wutil.implicitlyWait(driver);
				driver.get("http://localhost:8888/");
				
				//Login to application with valid credentials 
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Navigate to Contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Click on Create contact look Up Image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//Create Contact with Mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(contactname);
				
				//Select the Organization from organization look up image
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				wutil.switchToWindows(driver, "Organizations");
				
				
				
				
				driver.findElement(By.linkText(organizationName)).click();
				
				wutil.switchToWindows(driver, "Creating New Contact");
				
				
				
				//save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify
				String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				System.out.println(headerText);
				
				if (headerText.contains(contactname))
				{
					System.out.println("passed");
				}
				else
				{
					System.out.println("Failed");
				}
				
				//logout of Application
				//Thread.sleep(8000);
				
				WebElement logout = driver.findElement(By.xpath("//span[text()=' Administrator']/following::*[1]"));
				wutil.mouseHoverAction(driver, logout);
				driver.findElement(By.linkText("Sign Out")).click();
				

	}

}
