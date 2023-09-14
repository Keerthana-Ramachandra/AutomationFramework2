package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtilities.WebDriverUtility;

public class CreatenewContactPage extends WebDriverUtility
{
@FindBy (name="lastname")
private WebElement lastnameedt;

@FindBy (xpath="(//img[@title='Select'])[1]")
private WebElement organizationNameLookupIcon;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy (name= "search_text")
private WebElement orgsearchbar;

@FindBy(name="search")
private WebElement orgsearchbtn;

public CreatenewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getLastnameedt() 
{
	return lastnameedt;
}

public WebElement getOrganizationNameLookupIcon() 
{
	return organizationNameLookupIcon;
}

public WebElement getSaveBtn() 
{
	return saveBtn;
}

public WebElement getSearchbar()
{
	return orgsearchbar;
}

public WebElement getSearchbtn() 
{
	return orgsearchbtn;
}

/**
 * This method will create contact with Mandatory fields
 * @param lastname
 */
public void createContact(String lastname)
{
	lastnameedt.sendKeys(lastname);
	saveBtn.click();	
}

/**
 *  This method will create Contact using Organization
 * @param lastname
 * @param driver
 * @param orgname
 */
public void createContact(String lastname, WebDriver driver, String orgname)
{
	lastnameedt.sendKeys(lastname);
	organizationNameLookupIcon.click();
	switchToWindows(driver, "Accounts&action");
	orgsearchbar.sendKeys(orgname);
	orgsearchbtn.click();
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click(); //dynamic xpath
	//a[text()='ch399'] - regular xpath for reference
	//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
	switchToWindows(driver, "Contacts&parenttab");
	saveBtn.click();	
}

}
