package TestNGPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMClasses.HomePage;
import POMClasses.SignUpLinkPage;


public class InstagramTestNGPack1 {
	WebDriver driver;

	
	@BeforeClass
	public void openBrowser() {
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver","R:\\Software Testing\\Selenium Tool\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","R:\\Software Testing\\Selenium Tool\\chromedriver_win32\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void homePage() {
		System.out.println("Before Method");
		driver.get("https://www.instagram.com/");	
		
		HomePage homePage=new HomePage(driver);
		
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
		
		String expectedURL="https://www.instagram.com/";
		String expectedTitle="Instagram";
		
		if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
		
		//logInButton.isEnabled()==true
		if(homePage.logInButton()==true)
		{
			System.out.println("True");
		}
		else
		{
			homePage.enterUserName();
			homePage.enterPassword();
			homePage.clickOnLogInButton();
			homePage.getErrorMessage();
		}
		homePage.clickOnSignUpLink();
				
	}
		
			
			@Test(enabled=false)
			public void signUpLink() throws InterruptedException {
				Thread.sleep(3000);
				String actualURL1=driver.getCurrentUrl();
				String actualTitle1=driver.getTitle();
				
				String expectedURL1="https://www.instagram.com/accounts/emailsignup/";
				//String expectedTitle1="Instagram";
				String expectedTitle1="Sign up • Instagram";
				
				if(actualURL1.equals(expectedURL1) && actualTitle1.equals(expectedTitle1))
				{
					System.out.println("PASSED");
				}
				else
				{
					System.out.println("FAILED");
					System.out.println(actualURL1);
					System.out.println(actualTitle1);
				}
				
				SignUpLinkPage signUpLinkPage=new SignUpLinkPage(driver);
				
				//SignUP.isEnabled()==true
				if(signUpLinkPage.SignUpButton()==true)
				{
					System.out.println("True");
				}
				else
				{
					signUpLinkPage.enterMobileOREmail();
					signUpLinkPage.enterFullname();
					signUpLinkPage.enterUserName();
					signUpLinkPage.enterPassword();
					signUpLinkPage.clickOnSignUpButton();
					signUpLinkPage.getErrorMessage();
				}		
				
			}
			
			@Test(enabled=false)
			public void getItFromMicrosoft() throws InterruptedException 
			{
				Thread.sleep(3000);
				SignUpLinkPage signUpLinkPage=new SignUpLinkPage(driver);
				signUpLinkPage.clickOnGetItFromMicrosoft();
				Thread.sleep(3000);
				// driver.switchTo().alert().accept();
				 Thread.sleep(3000);				
			}
				
			
			@AfterMethod
			public void closeCurrentTab() {
				System.out.println("After Method");
					//driver.close();
					ArrayList<String>addressf1=new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(addressf1.get(0));
			}
			
			
			@AfterClass
			public void afterClass() {
			System.out.println("After Class");
			//driver.quit();

			}
		
	
	}


