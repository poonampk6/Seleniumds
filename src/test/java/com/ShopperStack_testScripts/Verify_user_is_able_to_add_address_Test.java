package com.ShopperStack_testScripts;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.ShopperStack.Pom.AddressFormPage;
import com.ShopperStack.Pom.HomePage;
import com.ShopperStack.Pom.LoginPage;
import com.ShopperStack.Pom.MyAddressPage;
import com.ShopperStack.Pom.MyProfilePage;
import com.ShopperStack.Pom.WelcomePage;
import com.ShopperStack.genericUtility.BaseTest;

public class Verify_user_is_able_to_add_address_Test extends BaseTest {

	@Test
	public void addAddress() throws IOException {
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.getLoginButton().click();
	
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmailTf().sendKeys(file.readPropertyData("un"));
		loginPage.getPwdTf().sendKeys(file.readPropertyData("pwd"));
		loginPage.getLoginButton().click();
		
		HomePage homePage=new HomePage(driver);
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfilePage myProfilePage=new MyProfilePage(driver);
		myProfilePage.getMyAddressBtn().click();
		
		MyAddressPage myAddressPage=new MyAddressPage(driver);
		myAddressPage.getAddAdressBtn().click();
		
		AddressFormPage addressFormPage=new AddressFormPage(driver);
		addressFormPage.getNameTf().sendKeys(file.readExcelData("Sheet2",1,0));
		addressFormPage.getHouseTf().sendKeys(file.readExcelData("Sheet2",1,1));
		addressFormPage.getStreetTf().sendKeys(file.readExcelData("Sheet2",1,2));
		addressFormPage.getLandmarkTf().sendKeys(file.readExcelData("Sheet2",1,3));
		
		webDriverUtil.selectByValue(addressFormPage.getCountryDD(),file.readPropertyData("country"));
		webDriverUtil.selectByValue(addressFormPage.getStateDD(), file.readPropertyData("state"));
		webDriverUtil.selectByValue(addressFormPage.getCityDD(), file.readPropertyData("city"));
		
		addressFormPage.getPincodeTf().sendKeys(file.readExcelData("Sheet2",1,4));
		addressFormPage.getPhoneNumberTf().sendKeys(file.readExcelData("Sheet2",1,5));
		addressFormPage.getAddAdressBtn().click();
		
		homePage.getAccountBtn().click();
		homePage.getLogOutBtn().click();
		
	}
}
