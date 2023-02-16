package POMClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLinkPage {
	
	private WebDriver driver;
	
	//(//button[@class='_acan _acap _acas _aj1-'])[1]
	@FindBy (xpath = "//button[@type='button']")
	private WebElement logInWithFacebook;
	
	@FindBy (xpath = "//input[@name='emailOrPhone']")
	private WebElement mobileNoOrEmail;
	
	@FindBy (xpath="//input[@aria-label='Full Name']")
	private WebElement fullName;
	
	@FindBy (xpath="//input[@aria-label='Username']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@aria-label='Password']")
	private WebElement password;
	
	@FindBy (xpath="(//span/a[1])[1] ")
	private WebElement learnMore;
	
	@FindBy (xpath="//a[text() = 'Terms']")
	private WebElement terms;
	
	@FindBy (xpath="/a[text() = 'Privacy Policy' ")
	private WebElement privacyPolicy;
	
	
	@FindBy (xpath="//a[text()='Cookies Policy']")
	private WebElement cookiesPolicy;
	
	
	@FindBy (xpath="(//button[@class='_acan _acap _acas _aj1-'])[2]")
	private WebElement signUpButton;
	
	@FindBy (xpath="/a[text()='Log in'")
	private WebElement logInLink;
	
	
	@FindBy (xpath="//a[@aria-label='Get it from Microsoft']")
	private WebElement getItFromMicrosoft;
	
	@FindBy (xpath="//p[@id='ssfErrorAlert']")
	private WebElement errorMessage;
	
	public SignUpLinkPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void clinkOnLoginWithfacebookButton()
	{
		logInWithFacebook.click();

	}
	
	public void enterMobileOREmail()
	{
		mobileNoOrEmail.sendKeys("8234554567");
	}
	
	public void  enterFullname()
	{
		fullName.sendKeys("Ganpat patil");
	}
	public void  enterUserName()
	{
		userName.sendKeys("Ganpat");
	}
	
	public void enterPassword()
	{
		password.sendKeys("Ganpat123$");
	}

	public void clickOnLearnMore()
	{
		learnMore.click();
	}
	
	public void clickOnTerms()
	{
		terms.click();
	}
	public void clickOnPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	public void clickOnCookiesPolicy()
	{
		cookiesPolicy.click();
	}
	
	public void clickOnSignUpButton()
	{
		signUpButton.click();
	}
	
	public boolean SignUpButton()
	{
		boolean signup=signUpButton.isEnabled();
		return signup;		
	}
	
	
	
	public void clickOnLogInLink()
	{
		logInLink.click();
	}
	public void clickOnGetItFromMicrosoft()
	{
		
		getItFromMicrosoft.click();
		
	}
	
	public void getErrorMessage()
	{
		System.out.println(errorMessage.getText());
	}
	
}
