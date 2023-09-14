package testNG.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class CreateOrganizationWithOrganizationWithIndustryMultipleDataFromDataProvider2AndBaseClass extends BaseClass
{

		@Test (dataProvider="getdata",groups = "RegressionSuite")
		public void createOrganizationwithIndustry(String orgName, String IndustryType) throws Throwable
	
		{
			
		String organizationName= orgName+jutil.randomNumber();
			
			//Navigate to Organizations link 
			HomePage hp= new HomePage(driver);
			hp.clickonorganizationLink();
			
			
			//Click on Create Organization look Up Image 
			OrganizationsPage op= new OrganizationsPage(driver);
		     op.clickOncreateOrganizationLookupIcon();
			
			//using business Library
			CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
			cnop.createOrganization(organizationName, IndustryType);
			
			//verify
			OrganizationInformationPage oip= new OrganizationInformationPage(driver);
			String headerText = oip.orgnameText();
			 //String headerText = oip.getHeaderText().getText();
			//System.out.println(headerText);
			
			Assert.assertTrue(headerText.contains(organizationName));
	
		}

	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.readMultipledataFromExcel("MultipleData");
		return data;
	}

}
