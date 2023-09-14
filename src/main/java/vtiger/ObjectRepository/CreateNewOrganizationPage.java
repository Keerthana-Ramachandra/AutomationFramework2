package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
@FindBy(name="accountname")
private WebElement organiztionNameEdt;

@FindBy(name="industry")
private WebElement industryDropdown;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public CreateNewOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrganiztionNameEdt() 
{
	return organiztionNameEdt;
}

public WebElement getIndustryDropdown()
{
	return industryDropdown;
}

public WebElement getSaveBtn()
{
	return saveBtn;
}

/**
 * This method will create organization. 
 * @param orgname
 */
//Create organization is example for method overloading
public void createOrganization(String orgname)
{
	organiztionNameEdt.sendKeys(orgname);
	
	
	saveBtn.click();
}
public void createOrganization(String orgname, String industrytype )
{
	organiztionNameEdt.sendKeys(orgname);
	
	handleDropdown(industryDropdown, industrytype);
	saveBtn.click();
	
}

}
