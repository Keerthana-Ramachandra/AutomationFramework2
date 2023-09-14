package vtiger.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This method will give implementation to IRetryAnalyser interface of TestNG
 * @author Keerthi
 *
 */
//IRetryAnalyser is an interface so we need to implement it
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	//Default count
	int count=0;
	//Retry count
	int retryCount=2;
//Right click--> Soursce-----------------> Override/implement methods
	public boolean retry(ITestResult result)
	{
		//U can give count<= if u gave int count=1
		while(count<retryCount)
		{
			count++;
			return true;
			
		}
		return false;
	}

}
