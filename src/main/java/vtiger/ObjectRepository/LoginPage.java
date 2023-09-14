package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule 1 create seperate pom class for every webpage
public class LoginPage 
{
	
// Rule 2 identify the webelements using @FindBy, @FindAll and @FindBys
	//Declaration
@FindBy(name = "user_name")
private WebElement userNameedt; //edtmeans textfield

@FindBy(name = "user_password")
private WebElement passwordedt;

@FindBy(id="submitButton")
private WebElement loginbtn; //btn means button

//Rule 3 create constructor to initialize the webelements
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Rule 4 provide getters foe accessing the webelements
public WebElement getUserNameedt()
{
	return userNameedt;
}

public WebElement getPasswordedt() 
{
	return passwordedt;
}

public WebElement getLoginbtn() 
{
	return loginbtn;
}

//Rule 5 provide business library
//Is a generic method created using webelements present only in current page
/**
 * This methos conststs of login business library
 * @param username
 * @param password
 */
public void loginToApplication(String username, String password )
{
	userNameedt.sendKeys(username);
	passwordedt.sendKeys(password);
	loginbtn.click();
}

}
