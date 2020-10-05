package com.app.test.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {
	
	WebDriver driver;
	public boolean checkIfExists(WebDriver driver, String loctype, String LocValue) {
//		To Do Swtich for Locator types, code for xPath only
		this.driver = driver;
		if (driver.findElements(By.xpath(LocValue)).size() > 0) {
			
//			System.out.println(driver.findElement(By.xpath(LocValue)).findElement(By.xpath(".//ancestor::table[1]")).getAttribute("style"));
			if (!driver.findElement(By.xpath(LocValue)).findElement(By.xpath(".//ancestor::table[1]")).getAttribute("style").contains("none")) {
				return true;
			}
			
		}
		
		return false;
	}
}
