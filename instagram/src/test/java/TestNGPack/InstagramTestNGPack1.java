package TestNGPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMClasses.HomePage;
import POMClasses.SignUpLinkPage;
import browser.Browser;


public class InstagramTestNGPack1 extends Browser {
	WebDriver driver;
	private SoftAssert softAssert;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@BeforeClass
	public void openBrowser1() {
		System.out.println("Before Class");
//		System.setProperty("webdriver.chrome.driver","R:\\Software Testing\\Selenium Tool\\chromedriver_win32\\chromedriver.exe");
//			
//		driver=new ChromeDriver();
		
	}
	@BeforeMethod
	
	public void homePage() {
		softAssert=new SoftAssert();
		System.out.println("Before Method");
		driver.get("https://www.instagram.com/");	
		
		HomePage homePage=new HomePage(driver);
		
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
		
		String expectedURL="https://www.instagram.com/";
		String expectedTitle="Instagram";
		
		Assert.assertEquals(actualURL, expectedURL, "HomePage URL is Wrong");
		softAssert.assertEquals(actualTitle, expectedTitle, "Title is Wrong");
		
//		if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
		
		//logInButton.isEnabled()==true
//		if(homePage.logInButtonIsEnabled()==true)
//		{
//			System.out.println("True");
//		}
//		else
//		{
			homePage.enterUserName();
			homePage.enterPassword();
			
			Assert.assertEquals(true, homePage.logInButtonIsEnabled());
			//Verifies that the textbox elementis enabled
			System.out.println("Element is enabled – Assert passed");
			 
			homePage.clickOnLogInButton();
			//homePage.getErrorMessage();
			
			String e="Sorry, your password was incorrect. Please double-check your password.";
			softAssert.assertEquals(homePage.getErrorMessage(),e,"Error Message is Wrong");
//		}
		homePage.clickOnSignUpLink();
		
			
		softAssert.assertAll();
	}
		
			
			@Test(enabled=true)
			public void signUpLink() throws InterruptedException {
				Thread.sleep(3000);
				String actualURL1=driver.getCurrentUrl();
				String actualTitle1=driver.getTitle();
				
				String expectedURL1="https://www.instagram.com/accounts/emailsignup/";
				
				String expectedTitle1="Sign up • Instagram";
				
				Assert.assertEquals(actualURL1, expectedURL1, "SignUp URL is Wrong");
				softAssert.assertEquals(actualTitle1, expectedTitle1, "Title is Wrong");
				
//				if(actualURL1.equals(expectedURL1) && actualTitle1.equals(expectedTitle1))
//				{
//					System.out.println("PASSED");
//				}
//				else
//				{
//					System.out.println("FAILED");
//					System.out.println(actualURL1);
//					System.out.println(actualTitle1);
//				}
				
				SignUpLinkPage signUpLinkPage=new SignUpLinkPage(driver);
				
				//SignUP.isEnabled()==true
//				if(signUpLinkPage.SignUpButton()==true)
//				{
//					System.out.println("True");
//				}
//				else
//				{
					signUpLinkPage.enterMobileOREmail();
					signUpLinkPage.enterFullname();
					signUpLinkPage.enterUserName();
					signUpLinkPage.enterPassword();
					
					Assert.assertEquals(true, signUpLinkPage.SignUpButtonIsEnabled());
					//Verifies that the textbox elementis enabled
					System.out.println("Element is enabled – Assert passed");
					
					
					signUpLinkPage.clickOnSignUpButton();
					//signUpLinkPage.getErrorMessage();
					
				
					
					String e="This username isn't available. Please try another.";
					softAssert.assertEquals(signUpLinkPage.getErrorMessage(),e,"Error Message is Wrong");
					
					
//				}		
					softAssert.assertAll();
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
				 softAssert.assertAll();
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
			
			@AfterTest
			public void afterTest() {
				System.out.println("After Test");
				
				}
		
	
}


