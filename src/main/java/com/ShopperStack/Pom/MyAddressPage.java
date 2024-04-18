package com.ShopperStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {

	public MyAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAdressBtn;

	public WebElement getAddAdressBtn() {
		return addAdressBtn;
	}
	
	@FindBy(xpath="(//button[contains(@class,'MuiButton')])[4]")
	private WebElement deleteAdress;
	
	@FindBy(xpath="(//button[text()='Yes'])[1]")
	private WebElement yesBtn;

	public WebElement getDeleteAdress() {
		return deleteAdress;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}
}
