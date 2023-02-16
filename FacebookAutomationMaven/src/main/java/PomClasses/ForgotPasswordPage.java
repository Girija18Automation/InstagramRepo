package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	@FindBy (xpath = "//table//tr[1]//td[2]//div")
	private WebElement forgotMessage;
	
	@FindBy (xpath = "(//input[@name='email'])[2]")
	private WebElement emailOrPhoneNumber;
	
	@FindBy (xpath="//a[text()='cancel']")
	private WebElement cancelButton;
	
	@FindBy (xpath="//button[text()='Search'] ")
	private WebElement searchButton;
	

	@FindBy (xpath="(//a[@role='link'])[2] ")
	private WebElement signUpLink;
	
	
	
	public ForgotPasswordPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods-public-WebElement action
	
	public void getTextMessage()
	{
		String text=forgotMessage.getText();
		System.out.println(text);

	}
	
	public void sendEmailOrPhoneNumber()
	{
		emailOrPhoneNumber.sendKeys("123455");
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public void clickOnForgotPasswordLink()
	{
		cancelButton.click();
	}

}
