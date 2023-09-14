package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtilities.WebDriverUtility;

//it is an example for Hierarchical Inheritance as webdriver utility can be extended in all pom classes
public class HomePage extends WebDriverUtility
{
@FindBy(linkText = "Organizations")
private WebElement organizationLink;

@FindBy(linkText = "Contacts")
private WebElement contactsLink;

@FindBy(linkText = "Products")
private WebElement productsLink;


@FindBy (xpath="//span[text()=' Administrator']/following::*[1]")
private WebElement administratoricon;

@FindBy(linkText = "Sign Out")
private WebElement signoutBtn;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getOrganizationLink()
{
	return organizationLink;
}

public WebElement getContactsLink()
{
	return contactsLink;
}
public WebElement getProductsLink() 
{
	return productsLink;
}
public WebElement getAdministratoricon()
{
	return administratoricon;
}

public WebElement getSignoutBtn()
{
	return signoutBtn;
}

public void clickonorganizationLink()
{
	organizationLink.click();
}

/**
 * This method will click on contact link
 */
public void clickonContatsLink()
{
	contactsLink.click();
}
/**
 * This method will logout from the application
 * @param driver
 */
public void logout(WebDriver driver)
{
	mouseHoverAction(driver, administratoricon);
	signoutBtn.click();
}

}
