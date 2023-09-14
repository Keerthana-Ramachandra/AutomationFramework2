package testNG.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.CreatenewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationUsingBusinessLibrary 
{

	@Test
	public void createContactWithOrganization() throws Throwable
	{
		JavaUtility jutil= new JavaUtility();
		ExcelFileUtility eutil= new ExcelFileUtility();
		PropertyFileUtility putil= new PropertyFileUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		
		WebDriver driver= null;
		
		String Browser = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String URL = putil.readDataFromPropertyFile("url");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		if(Browser.equalsIgnoreCase("chrome")) 
		{
			driver= new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) 
		{
			driver= new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) 
		{
			driver= new EdgeDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		String ORGNAME = eutil.readDataFromExcelFile("Contact", 4, 3)+jutil.randomNumber();
		String LASTNAME = eutil.readDataFromExcelFile("Contact", 4, 2)+jutil.randomNumber();
		
		wutil.maximizeWindow(driver);
		wutil.implicitlyWait(driver);
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		HomePage hp= new HomePage(driver);
		hp.clickonorganizationLink();
		
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOncreateOrganizationLookupIcon();
		
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String organizationHeaderText = oip.orgnameText();
				
		if(organizationHeaderText.contains(ORGNAME))
		{
			System.out.println("organization is created");
			System.out.println(ORGNAME);
		}
		else
		{
			System.out.println("Fail");
		}
		
		hp.clickonContatsLink();
		ContactsPage cp= new ContactsPage(driver);
		cp.clickoncreateContactlookupIcon();
		
		CreatenewContactPage cncp= new CreatenewContactPage (driver);
		cncp.createContact(LASTNAME, driver, ORGNAME);
		
		ContactInformationPage cip= new ContactInformationPage(driver);
		String conHeaderText = cip.contactHeaderText();
		
		if(conHeaderText.contains(LASTNAME))
		{
			System.out.println("Pass");
			System.out.println(LASTNAME);
		}
		else
		{
			System.out.println("Fail");
		}
		
		hp.logout(driver);

	}
	
	

}
