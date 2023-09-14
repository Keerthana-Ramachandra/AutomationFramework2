package testNG.Practice;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.CreatenewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtilities.BaseClass;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;
@Listeners(vtiger.genericUtilities.ListnersImplementation.class)
public class CreateContactWithOrganizationUsingBaseClass2SExtentReports extends BaseClass 
{
//name which is in include in group suite file that should be given
	@Test 
	public void createContactWithOrganization() throws Throwable
	{
	
		String ORGNAME = eutil.readDataFromExcelFile("Contact", 4, 3)+jutil.randomNumber();
		String LASTNAME = eutil.readDataFromExcelFile("Contact", 4, 2)+jutil.randomNumber();
		
		HomePage hp= new HomePage(driver);
		hp.clickonorganizationLink();
		
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOncreateOrganizationLookupIcon();
		
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		System.out.println(ORGNAME);
		//Purposefully failing script to tale screenshot
		Assert.fail();
		
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String organizationHeaderText = oip.orgnameText();
		
		Assert.assertTrue(organizationHeaderText.contains(ORGNAME));
		
		hp.clickonContatsLink();
		ContactsPage cp= new ContactsPage(driver);
		cp.clickoncreateContactlookupIcon();
		
		CreatenewContactPage cncp= new CreatenewContactPage (driver);
		cncp.createContact(LASTNAME, driver, ORGNAME);
		System.out.println(LASTNAME);
		
		ContactInformationPage cip= new ContactInformationPage(driver);
		String conHeaderText = cip.contactHeaderText();
		
		Assert.assertTrue(conHeaderText.contains(LASTNAME));
		

	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}
