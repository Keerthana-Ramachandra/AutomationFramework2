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

import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatenewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationUsingGenericUtilitiespomClasses
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
				LoginPage lp= new LoginPage(driver);
				lp.getUserNameedt().sendKeys(USERNAME);
				lp.getPasswordedt().sendKeys(PASSWORD);
				lp.getLoginbtn().click();
				
				//Navigate to Contacts link
				HomePage hp= new HomePage(driver);
				hp.getContactsLink().click();
						
				
				//Click on Create contact look Up Image
				ContactsPage cp= new ContactsPage(driver);
				cp.getCreateContactlookupIcon().click();
				
				//Create Contact with Mandatory fields
				CreatenewContactPage cncp= new CreatenewContactPage(driver);
				cncp.getLastnameedt().sendKeys(contactname);
				
				
				//Select the Organization from organization look up image
				cncp.getOrganizationNameLookupIcon().click();
				wutil.switchToWindows(driver, "Organizations");
				
				
				
				
				
				cncp.getSearchbar().sendKeys(organizationName);
				Thread.sleep(1000);
				cncp.getSearchbtn().click();
				
				driver.findElement(By.linkText(organizationName)).click();
				
				wutil.switchToWindows(driver, "Creating New Contact");
				
				
				
				//save
				cncp.getSaveBtn().click();
				
				//verify
				ContactInformationPage cip= new ContactInformationPage(driver);
				String headerText = cip.getHeaderText().getText();
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
				
				WebElement logout = hp.getAdministratoricon();
				wutil.mouseHoverAction(driver, logout);
				hp.getSignoutBtn().click();
				

	}

}
