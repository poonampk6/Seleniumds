package com.ShopperStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTf;
	
	@FindBy(id="Password")
	private WebElement pwdTf;
	
	@FindBy(id="Login")
	private WebElement loginButton;
	
	public WebElement getEmailTf() {
		return emailTf;
	}

	public WebElement getPwdTf() {
		return pwdTf;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	
}
