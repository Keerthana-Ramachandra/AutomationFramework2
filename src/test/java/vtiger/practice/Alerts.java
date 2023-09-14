package vtiger.practice;





import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts 
{
	
WebDriver driver= new ChromeDriver();

	
	void launching_url()
	{
		
		driver.get("https://www.jquery-az.com/javascript/demo.php?ex=151.1_1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}

	void confirmAlert()
	{
		//click on alert
		driver.findElement(By.xpath("//button[@onclick='confirmalert()']")).click();
		
		//get the text displayed on alert
		
		
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        
        //accept the alert
        driver.switchTo().alert().accept();
        
      //get the text displayed on alert
        String alert1 = driver.switchTo().alert().getText();
        
        System.out.println(alert1);
        
      //accept the alert
        driver.switchTo().alert().accept();
		
	}
	
	void close()
	{
		//close browser
		driver.close();
	}
	
	
	public static void main(String[] args)
	{
		Alerts a= new Alerts();
		a.launching_url();
		a.confirmAlert();
		a.close();
		

	}

}
