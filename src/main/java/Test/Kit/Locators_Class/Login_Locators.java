package Test.Kit.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Locators {
	
	public WebDriver driver;

	public Login_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtUsername;

	public WebElement getemailAddress() {
		return txtUsername;
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;

	public WebElement getpassword() {
		return txtPassword;
	}

	@FindBy(xpath = "//button[@id='loginform']")
	private WebElement btnLogin;

	public WebElement getLoginBtn() {
		return btnLogin;
	}
	
	
	
}
