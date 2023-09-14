package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage
{
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeaderText() 
	{
		return headerText;
	}
	
	public String orgnameText()
	{
		 return headerText.getText();
	}

}
