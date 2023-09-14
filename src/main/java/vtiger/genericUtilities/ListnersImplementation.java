package vtiger.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Thi class will give implementation to iTestlistners interface
 * @author Keerthi
 *
 */
public class ListnersImplementation implements ITestListener
{
	//Right click ----------------------> source---> override/implement methods. Sekect all Itstlistners and click ok
	// load all methods. U can give implementation to oly which is needed. Let other be blank
	//we will declare it globally because we will be using it in many methods
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
		//Getmethod and getmethodname is method of itestresult class. it will give methodname wghich got started to execute
	String methodname = result.getMethod().getMethodName();
		//u can delete this suggestion from superclass in all methods
		//ITestListener.super.onTestStart(result);
		System.out.println(methodname+ "Test execution started");
		
		//This will make extent report to get to know test is starting
		test=report.createTest(methodname);
	}

	
	public void onTestSuccess(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+ "pass");
	}


	public void onTestFailure(ITestResult result) 
	{
		//to get screenshot
		WebDriverUtility wutil= new WebDriverUtility();
		//need to get date
		JavaUtility jutil= new JavaUtility();
		//It shows the exceptions why it is failed or skipped
		// we are writing it in test.log so no need to write sop statement
		//System.out.println(result.getThrowable());
		String methodname = result.getMethod().getMethodName();
		String screenshotName = methodname+jutil.getSystemDate();
		//Status is enum. after typing that we will get fail, pass etc. we can write message in taht only so no need to write extra sop statement
		test.log(Status.FAIL, methodname+ "Fail");
		//System.out.println(methodname+ "Fail");
		test.log(Status.INFO, result.getThrowable());
		//as we have given static for sdriver we can access through classname without creating object
		try {
			wutil.captureScreenshot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result)
	{
		//System.out.println(result.getThrowable());
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+ "Skip");
		test.log(Status.SKIP, methodname+ "Skip");
		test.log(Status.INFO, result.getThrowable());
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}


	public void onStart(ITestContext context)
	{
		System.out.println("suite execution started");
		
		//Configure the extent report. First add dependeny from maven repository
		//Create folder as extent report. Rightclick on project-> new-> folder. Give name as extentreport
		//\\report is name, create object of java utility to call getsystemdate. extension should be html
		ExtentSparkReporter htmlreport= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlreport.config().setDocumentTitle("vtiger execution report");
		htmlreport.config().setReportName("Automation Execution Report");
		//Theme is enmum. After typing it we will get dark, standard etc
		htmlreport.config().setTheme(Theme.DARK);
		
		//Assigning to report
		report= new ExtentReports();
		// will attach  html report whicj is configured
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base browser", "Firefox");
		report.setSystemInfo("Base url", "https://localhost:888");
		report.setSystemInfo("Base environment", "testing");
		report.setSystemInfo("Reporter name", "Keerthana");
		
	
	}


	public void onFinish(ITestContext context)
	{
		System.out.println("suite execution finished");
		
		//Generate the report after execution. This line of code will generate report
		report.flush();
	}

	
}
