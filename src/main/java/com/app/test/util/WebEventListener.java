package com.app.test.util;


import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.app.test.log4j.MyLogger;

import com.app.test.base.TestBase;;

 public class WebEventListener extends TestBase implements WebDriverEventListener {
	 static Logger mainLogger = LogManager.getLogger("- - - - - - Logger for test- - - - - - ");
	public WebEventListener() {
		BasicConfigurator.configure();
		 
		 //Create a console appender and attach it to our mainLogger
		 ConsoleAppender appender = new ConsoleAppender();
		 appender.activateOptions();
		 PatternLayout layoutHelper = new PatternLayout();
		 FileAppender fileAppender = new FileAppender();
		 try {
			fileAppender.setFile("logfile.txt", false, false, 0);
		} catch (IOException e) {

			e.printStackTrace();
		}
//	      fileAppender.setFile("logfile.txt");
	      fileAppender.setLayout(new SimpleLayout());
		 layoutHelper.setConversionPattern("%-5p [%t]: %m%n");
		 layoutHelper.activateOptions();
	
		 appender.setLayout(layoutHelper);
		 
		 mainLogger.addAppender(fileAppender);

		 fileAppender.activateOptions();
		 mainLogger.info("Logging events"); 
	} 
	 
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		mainLogger.info("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
		mainLogger.info("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
		mainLogger.info("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		mainLogger.info("Trying to click on: " + element.toString());
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		mainLogger.info("Clicked on: " + element.toString());
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		mainLogger.info("Navigating back to previous page");
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		mainLogger.info("Navigated back to previous page");
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		mainLogger.info("Navigating forward to next page");
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		mainLogger.info("Navigated forward to next page");
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		mainLogger.info("Exception occured :: " + error);
		System.out.println("Exception occured :: " + error);
//		screenshot.getScreenshot();
		WebElement test = driver.findElement(By.id("errormessage-dialog"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		if(test.isDisplayed()){
			System.out.println("<--------> Alert or Warning message :: "+test.getText());
		}
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		mainLogger.info("Trying to find Element By : " + by.toString());
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		mainLogger.info("Found Element By : " + by.toString());
		System.out.println("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
		
	}
	public void afterScript(String script, WebDriver driver) {
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	}	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		mainLogger.info("CHnaged value of "+element+" by "+keysToSend);
		System.out.println("CHnaged value of "+element+" by "+keysToSend);
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

} 