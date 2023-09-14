package vtiger.practice;

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

import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingUtilityAndPomClass 
{

	public static void main(String[] args) throws Throwable 
	
	{
		
		JavaUtility jutil= new JavaUtility();
		PropertyFileUtility putil= new PropertyFileUtility();
		ExcelFileUtility eutil= new ExcelFileUtility();
		WebDriverUtility wutil= new WebDriverUtility();
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
		
		//String BROWSER = propert.getProperty("browser");
		//String URL = propert.getProperty("url");
		//String USERNAME = propert.getProperty("username");
		//String PASSWORD = propert.getProperty("password");		
		
		//Read data drom excel file
		//FileInputStream fise= new FileInputStream(".\\src\\test\\resources\\Vtiger.xlsx");
		//Workbook wb = WorkbookFactory.create(fise);
		//Sheet sheet = wb.getSheet("Organization");
		//String ORGANIZATION = sheet.getRow(4).getCell(2).getStringCellValue()+random;
		//String INDUSTRY = sheet.getRow(4).getCell(3).getStringCellValue();
		
		String organizationName = eutil.readDataFromExcelFile("Organization", 4, 2)+jutil.randomNumber();
		String IndustryType = eutil.readDataFromExcelFile("Organization", 4, 3);
		
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
		
		/*login using getters from pomclass
		LoginPage lp= new LoginPage(driver);
		lp.getUserNameedt().sendKeys(USERNAME);
		lp.getPasswordedt().sendKeys(PASSWORD);
		lp.getLoginbtn().click();*/
		
		
				
		//Login to application with valid credentials 
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations link 
		HomePage hp= new HomePage(driver);
		hp.getOrganizationLink().click();
		//driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Create Organization look Up Image 
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrganizationLookupIcon().click();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.getOrganiztionNameEdt().sendKeys(organizationName);
		//driver.findElement(By.name("accountname")).sendKeys(organizationName);
		
		//Select "Chemicals" in the industry drop down
		WebElement indusryDropDown=cnop.getIndustryDropdown();
		//WebElement indusryDropDown = driver.findElement(By.name("industry"));
		//Select industry= new Select(indusryDropDown);
		//industry.selectByValue(INDUSTRY);
		wutil.handleDropdown(indusryDropDown, IndustryType);
		
		//save
		cnop.getSaveBtn().click();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		//verify
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String headerText=oip.getHeaderText().getText();
		//String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(headerText);
		
		if (headerText.contains(organizationName))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("Failed");
		}
		
		//logout of Application
		//Thread.sleep(8000);
		WebElement logout =hp.getAdministratoricon();
		//WebElement logout = driver.findElement(By.xpath("//span[text()=' Administrator']/following::*[1]"));
		//Actions act= new Actions(driver);
		//act.moveToElement(logout).perform();
		wutil.mouseHoverAction(driver, logout);
		hp.getSignoutBtn().click();
		//driver.findElement(By.linkText("Sign Out")).click();


	}

}
