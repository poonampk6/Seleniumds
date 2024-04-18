package com.ShopperStack.genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShopperStack.Pom.HomePage;
import com.ShopperStack.Pom.LoginPage;
import com.ShopperStack.Pom.WelcomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static WebDriver listenerDrivers;
	public WebDriver driver;
	public FileUtility file=new FileUtility();
	public WebDriverUtility webDriverUtil=new WebDriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public JavaUtility java=new JavaUtility();
	public HomePage homePage;
	
	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite");
		spark=new ExtentSparkReporter("./reports"+java.LocalDateTime()+".html");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("Before Test");
		report=new ExtentReports();
		report.attachReporter(spark);
		test=report.createTest("demo");
	}
	
	@BeforeClass
	public void bc() throws IOException {
		String url=file.readPropertyData("url");
		String browser=file.readPropertyData("browser");
		System.out.println("Before Class");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Enter Valid Browser Name");
		}
		listenerDrivers=driver;
		homePage=new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}
	
	@BeforeMethod
	public void bm() throws InterruptedException, IOException {
		System.out.println("Before Method");
		test.log(Status.INFO, "navigated");
		
		WelcomePage welcomePage=new WelcomePage(driver);
		Thread.sleep(10000);
		welcomePage.getLoginButton().click();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmailTf().sendKeys(file.readPropertyData("un"));
		loginPage.getPwdTf().sendKeys(file.readPropertyData("pwd"));
		loginPage.getLoginButton().click();
	}
	
	@AfterMethod
	public void am() {
		System.out.println("After Method");
		homePage.getAccountBtn().click();
		homePage.getLogOutBtn().click();
	}
	
	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("After Class");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void at() {
		System.out.println("After Test");
		report.flush();
	}
	
	@AfterSuite
	public void as() {
		System.out.println("After Suite");
	}
}
