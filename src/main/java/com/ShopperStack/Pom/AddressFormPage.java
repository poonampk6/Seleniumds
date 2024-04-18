package com.ShopperStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage {

	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Office")
	private WebElement officeRb;
	
	@FindBy(id="Name")
	private WebElement nameTf;
	
	@FindBy(id="House/Office Info")
	private WebElement houseTf;
	
	@FindBy(id="Street Info")
	private WebElement streetTf;
	
	@FindBy(id="Landmark")
	private WebElement landmarkTf;
	
	@FindBy(id="Country")
	private WebElement countryDD;
	
	@FindBy(id="State")
	private WebElement stateDD;
	
	@FindBy(id="City")
	private WebElement cityDD;
	
	@FindBy(id="Pincode")
	private WebElement pincodeTf;
	
	public WebElement getOfficeRb() {
		return officeRb;
	}

	public WebElement getNameTf() {
		return nameTf;
	}

	public WebElement getHouseTf() {
		return houseTf;
	}

	public WebElement getStreetTf() {
		return streetTf;
	}

	public WebElement getLandmarkTf() {
		return landmarkTf;
	}

	public WebElement getCountryDD() {
		return countryDD;
	}

	public WebElement getStateDD() {
		return stateDD;
	}

	public WebElement getCityDD() {
		return cityDD;
	}

	public WebElement getPincodeTf() {
		return pincodeTf;
	}

	public WebElement getPhoneNumberTf() {
		return phoneNumberTf;
	}

	public WebElement getAddAdressBtn() {
		return addAdressBtn;
	}

	@FindBy(id="Phone Number")
	private WebElement phoneNumberTf;
	
	@FindBy(id="addAddress")
	private WebElement addAdressBtn;
	
	
}
