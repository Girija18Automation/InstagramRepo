package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClasses.ForgotPasswordPage;
import PomClasses.LoginOrSignUpPage;

public class FacebookTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","R:\\Software Testing\\Selenium Tool\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	
		LoginOrSignUpPage loginOrSignUpPage =new LoginOrSignUpPage(driver);
		loginOrSignUpPage .sendUserName();
		loginOrSignUpPage.sendPassword();
		//loginOrSignUpPage.clickOnLoginButton();
		loginOrSignUpPage.clickOnForgotPasswordLink();
		//loginOrSignUpPage.openSignUpForm();
		
		ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver);
		forgotPasswordPage.getTextMessage();
		forgotPasswordPage.sendEmailOrPhoneNumber();
		forgotPasswordPage.clickOnSearchButton();
		
	}

}
