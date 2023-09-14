package other;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTripCalenderPopup 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		//Close login popup
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		driver.findElement(By.xpath("//p[text()='Round-trip']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//This is normal expression. This we have to generalize by saving all numbers as seperate variable and giving that variable name in xpath
		//driver.findElement(By.xpath("//div[text()='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='20']")).click();
		String month = "September 2023";
		String date = "20";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		driver.findElement(By.xpath("//p[text()='Round-trip']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//p[text()='Click to add a return flight for better discounts']")).click();
		String month2 = "October 2023";
		String date2 = "23";
		driver.findElement(By.xpath("//div[text()='"+month2+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date2+"']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='Travellers & Class']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='4']")).click();
		
		
	}

}

