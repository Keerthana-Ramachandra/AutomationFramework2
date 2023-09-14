package vtiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganization
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
				
				//Navigate to Contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Click on Create contact look Up Image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//Create Contact with Mandatory fields
				driver.findElement(By.name("lastname")).sendKeys("Eshwari");
				
				//Select the Organization from organization look up image
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				Set<String> windows = driver.getWindowHandles();
				for(String w:windows)
				{
					driver.switchTo().window(w);
				}
				
				
				
				driver.findElement(By.linkText("Goodday")).click();
				
				
				
				Set<String> windows1 = driver.getWindowHandles();
				for(String w1:windows1)
				{
					driver.switchTo().window(w1);
				}
				
				
				//save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify
				String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				System.out.println(headerText);
				
				if (headerText.contains("Eshwari"))
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
