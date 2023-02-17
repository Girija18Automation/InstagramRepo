package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userNameTab;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement passwordTab;
	
	@FindBy (xpath="//button[@class='_acan _acap _acas _aj1-']")
	private WebElement logInButton;
	
	@FindBy (xpath="//button[@class='_acan _acao _acas _aj1-']")
	private WebElement logInWithFacebookLink;
	
	@FindBy (xpath="//a[contains(text(),'Forgot')] ")
	private WebElement forgotPasswordLink;
	

	@FindBy (xpath="(//a[@role='link'])[2] ")
	private WebElement signUpLink;
	
	@FindBy (xpath="//div[@class='_ab2z']/p ")
	private WebElement errorMessage;
	
	
	
	public HomePage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void enterUserName()
	{
		userNameTab.sendKeys("Welcome@gmail.com");

	}
	
	public void enterPassword()
	{
		passwordTab.sendKeys("8234554567");
	}
	
	public void clickOnLogInButton()
	{
		logInButton.click();
	}
	
	public boolean logInButtonIsEnabled()
	{
		boolean b=logInButton.isEnabled();
		return b;
	
	}
	public void clickOnlogInWithFacebookLink()
	{
		logInWithFacebookLink.click();
	}
	
	public void clickOnforgotPasswordLink()
	{
		forgotPasswordLink.click();
	}

	public void clickOnSignUpLink()
	{
		signUpLink.click();
	}

	
	public String getErrorMessage()
	{
		String e=errorMessage.getText();
		//System.out.println(errorMessage.getText());
		return e;
		
	}
}
