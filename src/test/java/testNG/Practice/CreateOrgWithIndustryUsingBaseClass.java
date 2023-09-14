package testNG.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.math3.optim.nonlinear.vector.jacobian.AbstractLeastSquaresOptimizer;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtilities.BaseClass;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingBaseClass extends BaseClass
{

	@Test
public void createOrganization() throws Throwable
	
	{
	
		String organizationName = eutil.readDataFromExcelFile("Organization", 4, 2)+jutil.randomNumber();
		String IndustryType = eutil.readDataFromExcelFile("Organization", 4, 3);
		
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

}
