package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement UserNameTextfield;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextfield;

}
