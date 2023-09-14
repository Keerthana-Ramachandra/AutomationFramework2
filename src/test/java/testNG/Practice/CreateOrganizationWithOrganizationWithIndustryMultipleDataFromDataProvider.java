package testNG.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateOrganizationWithOrganizationWithIndustryMultipleDataFromDataProvider 
{

	
		JavaUtility jutil= new JavaUtility();
		PropertyFileUtility putil= new PropertyFileUtility();
		ExcelFileUtility eutil= new ExcelFileUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		
		@Test (dataProvider="getdata")
		public void createOrganizationwithIndustry(String orgName, String IndustryType) throws Throwable
		
		
		{
			
		
			/*random class to avoid duplicate. we will add this for org name. it will take the within number mentioned in
			  nextint() method. if textfield  is accepting alphanumeric then we can use this*/
			//Random r= new Random();
			//int random = r.nextInt(7);
			
			//we are declaring null to avoild compile time exceptopn. we will reinitialize later
			WebDriver driver= null;
			
			//read the data from property file
			//FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			//Properties propert=new Properties();
			//propert.load(fisp);
			String BROWSER = putil.readDataFromPropertyFile("browser");
			String URL = putil.readDataFromPropertyFile("url");
			String USERNAME = putil.readDataFromPropertyFile("username");
			String PASSWORD = putil.readDataFromPropertyFile("password");
			
			String organizationName= orgName+jutil.randomNumber();
			
			//launch the browser- runtime polymorphism- driver
			//equalsIgnoreCase will ignore the cases (capital or small letter)
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver= new ChromeDriver();
			}
			
			else if(BROWSER.equalsIgnoreCase("Edge"))
			{
				driver= new EdgeDriver();
			}
			
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				driver= new FirefoxDriver();
			}
			
			else
			{
				System.out.println("invalid browser");
			}	
				
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			wutil.implicitlyWait(driver);
			//driver.manage().window().maximize();
			wutil.maximizeWindow(driver);
			driver.get(URL);
			
			
			//login using business library
			LoginPage lp= new LoginPage(driver);
			lp.loginToApplication(USERNAME, PASSWORD);
			
			
			
			
					
			
			
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
			
			if (headerText.contains(organizationName))
			{
				System.out.println("passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
			//logout of Application
			hp.logout(driver);
			//Thread.sleep(8000);
			//WebElement logout = driver.findElement(By.xpath("//span[text()=' Administrator']/following::*[1]"));
			//Actions act= new Actions(driver);
			//act.moveToElement(logout).perform();
			//wutil.mouseHoverAction(driver, logout);
			//driver.findElement(By.linkText("Sign Out")).click();


		}

	
	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.readMultipledataFromExcel("MultipleData");
		return data;
	}

}
