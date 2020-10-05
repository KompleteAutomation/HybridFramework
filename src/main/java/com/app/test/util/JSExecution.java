/**
 * 
 */
package com.app.test.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.test.base.TestBase;


public class JSExecution extends TestBase {

	public void clickElement(WebElement element,WebDriver driver){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void selectDateByJS(WebDriver driver,WebElement element,String dateval){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');", element);
	}
	
}
