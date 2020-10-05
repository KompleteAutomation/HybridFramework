package com.app.test.keyword;

import com.app.test.utility.Constants;
import com.app.test.util.WebEventListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ActionKeywords {
	public static WebDriver driver;
	
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public void openBrowser(String browsername) {


//Confirm the Chrome version 
		if (browsername.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\chromedriver.exe");

			driver = new ChromeDriver();
			

		}else
			if (browsername.equals("FIREFOX")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\chromedriver.exe"); 
				driver = new FirefoxDriver();
			}
		e_driver = new EventFiringWebDriver(driver);
		// Object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}

	public void navigate(String URL) {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}

//	Open Module People
	public void clickPeople(String tData) {
		driver.findElement(By.xpath(Objects.people)).click();

	}


	//	public void verifyTitle() {
	//		driver.findElement(By.xpath("//h1[@class='top-card-layout__title']")).getText()
	//		
	//	}

//Search for People 
	public void clickSearchPeople(String tData) {
		driver.findElement(By.xpath(Objects.searchPeople)).click();
	}

//	Enter Last Name 
	public void enterLastName(String tData) {
		driver.findElement(By.xpath(Objects.lastName)).sendKeys(Constants.lastname);

	}

	public void enterFirstName(String tData) {
		driver.findElement(By.xpath(Objects.firstName)).sendKeys(Constants.fistname);
	}

	

	//	public void enterEmail() {
	//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(Constants.username);
	//	}
	//
	//	public void enterPassword() {
	//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Constants.password);
	//	}

	//	public void clickSignIn() {
	//		driver.findElement(By.xpath("//button[text() = 'Sign in']")).click();
	//	}
	//
	//	public void profileImage() {
	//		driver.findElement(By.xpath("//img[@id = 'ember26']")).click();
	//	}
	//
	//	public void logout() {
	//		driver.findElement(By.xpath("//a[text() = 'Sign out']")).click();
	//	}

	
	public void closeBrowser(String tData) {
		driver.quit();
	}

	
//		Generalized code designed specific for this app to handle all fields dynamically
	public void clearAllFields(String tData) {
		Utils utils = new Utils();
		
		String[] LocValue = {"//input[@id='cyearsv']","//input[@id='ccontributeamountv']","//input[@id='cinterestratev']","//input[@id='cstartingprinciplev']","//input[@id='ctargetamountv']"};
		for (String loc : LocValue) {
			if (utils.checkIfExists(driver, "", loc)) {
//				System.out.println(loc);
				driver.findElement(By.xpath(loc)).clear();
			}

		}
		
//		driver.findElement(By.xpath("//input[@id='cyearsv']")).clear();
//		driver.findElement(By.xpath("//input[@id='ccontributeamountv']")).clear();
//		driver.findElement(By.xpath("//input[@id='cinterestratev']")).clear();
//		driver.findElement(By.xpath("//input[@id='cstartingprinciplev']")).clear();
		
		
	}

	
//To be removed  - added a general method to Open Tab
	
	public void clickFV(String tData) {
		driver.findElement(By.xpath("//a[text() = 'FV']")).click();
		
	}

	//To be removed  - added a general method to Open Tab
	public void clickIY(String tData) {
		driver.findElement(By.xpath("//a[text() = 'I/Y']")).click();
	}
	
	//To be removed  - added a general method to Open Tab
	public void clickTab(String tData) {
		driver.findElement(By.xpath("//a[text() = '"+tData+"']")).click();
	}
	
	//To be removed  - added a general method to Open Tab
	public void clickN(String tData) {
		driver.findElement(By.xpath("//a[text() = 'N']")).click();
	}
	
	//To be removed  - added a general method to Open Tab
	public void clickStartPrincipal(String tData) {
		driver.findElement(By.xpath("//a[text() = 'Start Principal']")).click();
	}
	
	
	public void enterPeriods(String tData) {
		driver.findElement(By.xpath(Objects.periods)).sendKeys(tData);

	}

	public void clickCalculate(String tData) {
		driver.findElement(By.xpath("//input[@alt='Calculate']")).click();

	}

//	Select the Radio Button value 
	public void selectPMTmade(String tData) {
		if (tData.equalsIgnoreCase("beginning")) {
			driver.findElement(By.xpath("//label[text()='beginning']/input")).click();

		}
		else if (tData.equalsIgnoreCase("end")) {
			driver.findElement(By.xpath("//label[text()='end']/input")).click();
		}
	}

	public void enterPMT(String tData) {
		driver.findElement(By.xpath(Objects.PMT)).sendKeys(tData);

	}

	public void enterFV(String tData) {
		driver.findElement(By.xpath(Objects.FV)).sendKeys(tData);

	}
	public void enterInterest(String tData) {
		driver.findElement(By.xpath(Objects.Interest)).sendKeys(tData);

	}

	public void enterStartPrinciple(String tData) {
		driver.findElement(By.xpath(Objects.StartPrinciple)).sendKeys(tData);

	}
	
	
//	ToDo
	public void verifyValue() {
		
	}
}
