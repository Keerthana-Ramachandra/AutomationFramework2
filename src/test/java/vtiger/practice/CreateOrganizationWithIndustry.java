package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry
{

	public static void main(String[] args) 
	{
		//launch browser
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
		//Login to application with valid credentials 
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Honda");
		
		//Select "Chemicals" in the industry drop down
		WebElement indusryDropDown = driver.findElement(By.name("industry"));
		Select industry= new Select(indusryDropDown);
		industry.selectByValue("Chemicals");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify
		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(headerText);
		
		if (headerText.contains("Honda"))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("Failed");
		}
		
		//logout of Application
		//Thread.sleep(8000);
		WebElement logout = driver.findElement(By.xpath("//span[text()=' Administrator']/following::*[1]"));
		Actions act= new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
