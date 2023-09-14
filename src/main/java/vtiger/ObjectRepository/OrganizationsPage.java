package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createOrganizationLookupIcon;




public OrganizationsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateOrganizationLookupIcon() 
{
	return createOrganizationLookupIcon;
}




public void clickOncreateOrganizationLookupIcon()
{
	createOrganizationLookupIcon.click();
}



}
