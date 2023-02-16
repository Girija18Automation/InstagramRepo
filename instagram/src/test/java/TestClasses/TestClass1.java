package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMClasses.HomePage;

public class TestClass1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","R:\\Software Testing\\Selenium Tool\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		
		HomePage homePage=new HomePage(driver);
		homePage.enterUserName();
		homePage.enterPassword();
		homePage.clickOnLogInButton();
		homePage.getErrorMessage();
		
		
	}
}
