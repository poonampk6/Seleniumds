package com.ShopperStack.genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	Select sel;
	File temp;
	File dest;
	
	public void selectByValue(WebElement ele,String value) {
		sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void selectByIndex(WebElement ele,int index) {
		sel=new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement ele,String value) {
		sel=new Select(ele);
		sel.selectByVisibleText(value);
	}
	
	public void deselectByIndex(WebElement ele,int index) {
		sel.deselectByIndex(index);
	}
	
	public void deselectByVisibleText(WebElement ele,String value) {
		sel.deselectByVisibleText(value);
	}
	
	public void deselectByValue(WebElement ele,String value) {
		sel.deselectByValue(value);
	}
	
	public void deselectAll(WebElement ele) {
		sel.deselectAll();
	}
	
	public void ScreenshotWebPage(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		temp=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("./screenshot");
		FileHandler.copy(temp, dest);
	}
	
	public void ScreenshotWebElement(WebElement element) throws IOException {
		temp=element.getScreenshotAs(OutputType.FILE);
		dest=new File("./screenshot");
		FileHandler.copy(temp, dest);
	}
}
