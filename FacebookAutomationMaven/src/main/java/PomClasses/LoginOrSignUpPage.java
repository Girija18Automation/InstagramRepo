package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	//variable- private-webElements
	@FindBy (xpath = "//input[@id='email']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()='Log in']")
	private WebElement loginButton;
	
	@FindBy (xpath="//a[text()='Forgotten password?']")
	private WebElement forgotPasswordLink;
	
	@FindBy (xpath="//a[text()='Create new account']")
	private WebElement createNewAcc;
	
	@FindBy (xpath="//a[text()='Create a Page']")
	private WebElement createPage;
	
	//Constructor-Public-webElement Initialization (Find)
	
	public LoginOrSignUpPage ( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods-public-WebElement action
	
	public void sendUserName()
	{
		userName.sendKeys("velocity");
	}
	
	public void sendPassword()
	{
		password.sendKeys("123455");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public void clickOnForgotPasswordLink()
	{
		forgotPasswordLink.click();
	}
	 //clickOnCreateNewAccount
	
	public void openSignUpForm()
	{
		createPage.click();
	}
}
