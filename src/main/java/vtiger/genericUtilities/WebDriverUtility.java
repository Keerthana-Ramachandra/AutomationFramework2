package vtiger.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of reusable methods relate to webdriver
 * @author Keerthi
 *
 */
public class WebDriverUtility 
{
	
/**
 * This method will maximize the window	
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

/**
 * This method will minimize the window	
 * @param driver
 */
	public void minimiseWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

/**
 * This method will open the window in full screen mode	
 * @param driver
 */
	public void fullscreenwindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	
/**
 * This method will wait 10 sec for all webelement to load	
 * @param driver
 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	/**
	 * This method will wait for 10sec for perticular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForeElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
/**
 * 	This method will wait for 10sec for perticular element to be Clickable
 * @param driver
 * @param element
 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

/**
 * This method will handle dropdown using index	
 * @param element
 * @param index
 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}

/**
 * This method will handle dropdown using value	
 * @param element
 * @param index
 */
		public void handleDropdown(WebElement element, String value)
		{
			Select s= new Select(element);
			s.selectByValue(value);
		}	
/**
* This method will handle dropdown using visibleText	
* @param element
* @param visibleText
*/
		public void handleDropdown(String visibleText, WebElement element)
		{
		  Select s= new Select(element);
		  s.selectByVisibleText(visibleText);
		}
		
/**
 * This method will handle mouse hover action on webelement		
 * @param driver
 * @param Element
 */
		public void mouseHoverAction(WebDriver driver, WebElement element)
		{
			Actions a= new Actions(driver);
			a.moveToElement(element).perform();
			
		}
		
/**
 * This method will handle drag and drop
 * @param driver
 * @param source
 * @param target
 */
		public void dragAndDrop(WebDriver driver, WebElement source,WebElement target )
		{
			Actions a= new Actions(driver);
			a.dragAndDrop(source, target).build().perform();
			
		}
		
/**
 * This method will rightclick anywhere on webpage	
 * @param driver
 */
		public void rightclick(WebDriver driver)
		{
			Actions a= new Actions(driver);
			a.contextClick().perform();
		}
/**
 *This method will rightclick on perticular webelement	 		
 * @param driver
 * @param element
 */
		public void rightclick(WebDriver driver, WebElement element)
		{
			Actions a= new Actions(driver);
			a.contextClick(element).perform();
		}
/**
 * This method will doubleclick anywhere on webpage			
 * @param driver
 */
		public void doubleClick(WebDriver driver)
		{
			Actions a= new Actions(driver);
			a.doubleClick().perform();
		}
/**
 * This method will doubleclick on perticular webelement		
 * @param driver
 * @param element
 */
		public void doubleclick(WebDriver driver, WebElement element)
		{
			Actions a= new Actions(driver);
			a.doubleClick(element).perform();
		}
/**
 * This method will move the cursor by offset and click		
 * @param driver
 * @param x
 * @param y
 */
		public void moveTheCursorAndClick(WebDriver driver, int x, int y)
		{
			Actions a= new Actions(driver);
			a.moveByOffset(x, y).click().perform();
		}
/**
 * This method will accept webalert		
 * @param driver
 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
/**
 * This method will dismiss webalert		
 * @param driver
 */
		public void declineAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
/**
 * This method will get the alert text and return it to caller		
 * @param driver
 * @return 
 */
		public String getAlertText(WebDriver driver)
		{
			return driver.switchTo().alert().getText();
		}
/**
 * This method will scrolldown for 500 units		
 * @param driver
 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("window.scrollby(0,500);", "");
		}
/**
 *This method will scrolldown untill a perticular webelement 		
 * @param driver
 * @param element
 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js= (JavascriptExecutor) driver;
			// if we have multiple scrollbars; index stat from 0, if u want to consider 2 give 1 inside argument
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
		
/**
 * This method will handle frame using index		
 * @param driver
 * @param index
 */
		public void handleFrames(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}

/**
 * This method will handle frame using namr or ID				
 * @param driver
 * @param nameorId
 */
		public void handleFrames(WebDriver driver, String nameorId)
		{
			driver.switchTo().frame(nameorId);
		}
/**
 * This method will handle frame using Frame Element			
 * @param driver
 * @param frameElement
 */
		public void handleFrames(WebDriver driver, WebElement frameElement)
		{
			driver.switchTo().frame(frameElement);
		}
/**
 * This method will switch to immediate parent frame		
 * @param driver
 */
		public void switchToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
/**
 * This method will switch to default page			
 * @param driver
 */
		public void switchToDefaultContent(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
/**
 * Thois method will help to switch control from one window to another		
 * @param driver
 * @param partialWindowTitle
 */
		public void switchToWindows(WebDriver driver, String partialWindowTitle)
		{
			//capture all window Ids
			Set<String> allwinid = driver.getWindowHandles();
			//Navigate through each window
			for(String childwinid: allwinid )
			{
				//switch to each and capture the title
				String actTitle = driver.switchTo().window(childwinid).getTitle();
				//compare the title with required
				if(actTitle.contains(partialWindowTitle))
				{
					break;
				}
			}
		}
	
		/**
		 * This method will capture screenshot and return to caller
		 * @param driver
		 * @param screenShotName
		 * @return
		 * @throws IOException
		 */
		public String captureScreenshot(WebDriver driver, String screenShotName) throws IOException
		{
			//first in google go to maven repository. find common io. select apache common io.
			//copy dependency and paste in pom.xml. it will help to do any file related actions
			//cast takescreenshot interface
			TakesScreenshot ts= (TakesScreenshot) driver;
			//it will be stored in src by default which is temporary.
			//if we capture another screenshot this screenshot will be replaced by that. so we need to copy in in another location.
			File src = ts.getScreenshotAs(OutputType.FILE);
			// Right click on project----> new---> folder. create folder named Screenshots. give that location in ()
			File destination=new File (".\\Screenshots\\"+screenShotName+".png");
			Files.copy(src, destination);
			//This will give complete path of screenshot saved. It is used for extent reporting
			return destination.getAbsolutePath();
		}
	
}
