
package vtiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateContactWithOrg
{

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch The Browser
	
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// Step 2: Login To Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click on contacts LInk
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: click on create conatct look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 5: create contact using manadatory fields
		driver.findElement(By.name("lastname")).sendKeys("spiderMan");
		
		//Step 6: click on Organizations look Up image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//Step 7: Switch the control to child window
		String mainWinID = driver.getWindowHandle();
		
		Set<String> allWinIds = driver.getWindowHandles();
		
		for(String ID:allWinIds)
		{
			if(!ID.equals(mainWinID))
			{
				driver.switchTo().window(ID);
				System.out.println("window swicthed to child");
			}
		}
		
		//Step 8: search for Organization
		driver.findElement(By.name("search_text")).sendKeys("fanta");
		driver.findElement(By.name("search")).click();		
		driver.findElement(By.xpath("//a[.='fanta']")).click();
		
		//Step 9: Swicth the control back to main window
		driver.switchTo().window(mainWinID);
		
		//Step 10 : save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 11: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("spiderMan"))
		{
			System.out.println("PASS");
			System.out.println(contactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//step 12: logout
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successfull");
		
		
		//Step 13: Close the browser
		driver.quit();
	}
}