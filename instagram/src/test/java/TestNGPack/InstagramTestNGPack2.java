package TestNGPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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

public class InstagramTestNGPack2 extends Browser{
	WebDriver driver;
	private SoftAssert softAssert;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browsername)
	{

		if(browsername.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		
		if(browsername.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class");
		
		}
			
	@BeforeMethod
			
	public void openHomePage() 
	{
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
		public void verifyTerms() throws InterruptedException 
		{
			System.out.println("Test");
			Thread.sleep(3000);
			SignUpLinkPage signUpLinkPage=new SignUpLinkPage(driver);
			signUpLinkPage.clickOnTerms();
			Thread.sleep(3000);
			ArrayList<String>addressf1=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addressf1.get(1));
			Thread.sleep(3000);
			String actualURL2=driver.getCurrentUrl();
			Thread.sleep(3000);
			String actualTitle2=driver.getTitle();
				
			String expectedURL2="https://help.instagram.com/581066165581870/?locale=en_US";
				
			String expectedTitle2="Terms of Use | Instagram Help Center";
				
			Thread.sleep(6000);
			
			Assert.assertEquals(actualURL2, expectedURL2, "clickOnTerms URL is Wrong");
			softAssert.assertEquals(actualTitle2, expectedTitle2, "Title is Wrong");
				
//			if(actualURL2.equals(expectedURL2) && actualTitle2.equals(expectedTitle2))
//			{
//				System.out.println("PASSED");
//			}
//			else
//			{
//				System.out.println("FAILED");
//					System.out.println(actualURL2);
//					System.out.println(actualTitle2);					
//			}	
			
			softAssert.assertAll();
		}
			
			@Test(enabled=true,priority=2)
			public void verifyCookiesPolicy() throws InterruptedException 
			{
				SignUpLinkPage signUpLinkPage=new SignUpLinkPage(driver);
				signUpLinkPage.clickOnCookiesPolicy();
				
				ArrayList<String>addressf1=new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(addressf1.get(2));
			
				Thread.sleep(3000);
				String actualURL3=driver.getCurrentUrl();
				Thread.sleep(3000);
				String actualTitle3=driver.getTitle();
				
				String expectedURL3="https://help.instagram.com/1896641480634370/";
				String expectedTitle3="Cookies Policy | Instagram Help Center";
				Thread.sleep(3000);
				
				Assert.assertEquals(actualURL3, expectedURL3, "verifyCookiesPolicy URL is Wrong");
				softAssert.assertEquals(actualTitle3, expectedTitle3, "Title is Wrong");
				
//				if(actualURL3.equals(expectedURL3) && actualTitle3.equals(expectedTitle3))
//				{
//					System.out.println("PASSED");
//				}
//				else
//				{
//					System.out.println("FAILED");
//					System.out.println(expectedURL3);
//					System.out.println(expectedTitle3);
//				}
				
				softAssert.assertAll();
			}
		
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("After Method");
		}
		
		@AfterClass
		public void afterClass() {
			System.out.println("After Class");
			
			}
		
		
		@AfterTest
		public void afterTest()
		{
			System.out.println("After Test");			
		}
			
}
