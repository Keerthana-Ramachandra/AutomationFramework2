package testNG.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
// RetryAnalyser works at @test level so we will give retryAlalyser after @test. Give fully qulalified name of RetryAnalyserImplementation class name.
	//Right click on class name and click on fully qualified class name. Give .class after that
	@Test (retryAnalyzer = vtiger.genericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		//Purposefully failing it to analyse
		Assert.fail();
		System.out.println("Hello");
	}
}
