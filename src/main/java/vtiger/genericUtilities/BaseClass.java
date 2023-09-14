package vtiger.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This is a generic class consisting of all basic configuration
 * @author Keerthi
 *
 */
public class BaseClass 
{
public JavaUtility jutil= new JavaUtility();
public ExcelFileUtility eutil= new ExcelFileUtility();
public PropertyFileUtility putil= new PropertyFileUtility();
public WebDriverUtility wutil= new WebDriverUtility();
public WebDriver driver= null;
//This is inorder to get updated driver in listners without creating object or extending
public static WebDriver sdriver;

//if we are doing group execution then it will search for incllude name in base class. inordewr to load multiple group name in base claqss we will always give alwaysrun=true


@BeforeSuite (alwaysRun = true)
public void beforeSuiteConfiguration()
{
	System.out.println("Database connection successfull");
}

//We will change to before test only when we are doing parallel execution. after execution again chnage back to class
// need to add parameters when doing cross browser testing add name given in parameter tag in suite xml file
//@Parameters("Browser")
//@BeforeTest
@BeforeClass (alwaysRun = true)
//String browser should be parameterized only when doing cross browser testing as we are not reading it from property file
public void bcConfiguration(/*String BROWSER*/) throws Throwable
{
	String BROWSER = putil.readDataFromPropertyFile("browser");
	String URL = putil.readDataFromPropertyFile("url");
	

	if(BROWSER.equalsIgnoreCase("chrome")) 
	{
		driver= new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) 
	{
		driver= new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge")) 
	{
		driver= new EdgeDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
	
	wutil.maximizeWindow(driver);
	wutil.implicitlyWait(driver);
	driver.get(URL);
	// this will reinitialize sdriver
	sdriver=driver;
	System.out.println(BROWSER+"browser is launched");
	
	
}


@BeforeMethod (alwaysRun = true)
public void bmConfiguration() throws Throwable
{
	String USSERNAME = putil.readDataFromPropertyFile("username");
	String PASSWORD = putil.readDataFromPropertyFile("password");
	LoginPage lp= new LoginPage(driver);
	lp.loginToApplication(USSERNAME, PASSWORD);
	System.out.println("successfully loggedin");
}


@AfterMethod (alwaysRun = true)
public void amConfiguration()
{
	HomePage hp= new HomePage(driver);
	hp.logout(driver);
	System.out.println("successfully loggedout");
}

//@AfterTest
@AfterClass (alwaysRun = true)
public void acConfiguration()
{
	driver.quit();
	System.out.println("Browser closed");
}


@AfterSuite (alwaysRun = true)
public void AfterSuiteConfiguration()
{
	System.out.println("Database connection closed");
}

}
