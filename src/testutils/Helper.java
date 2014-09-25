package testutils;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import testbase.TestBase;

public class Helper extends TestBase  
{
	//Selecting Browser Type and Opening browser
	public void browserType() {
    if(config.getProperty("browserType").equalsIgnoreCase("Firefox")) {
    driver= new FirefoxDriver();
	}
	else if(config.getProperty("browserType").equalsIgnoreCase("Chrome")) {
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\config\\chromedriver.exe");
    driver = new ChromeDriver();
	}
	else {
	if(config.getProperty("browserType").equalsIgnoreCase("IE"))
    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\config\\IEDriverServer.exe");
    driver=new InternetExplorerDriver();
    }	  
	}
	
	//Opening the required URL
	public void loadPage() {
	driver.manage().window().maximize();
	driver.get(config.getProperty("testUrl"));
	}
	
	
	public void loadPage1() {
	driver.manage().window().maximize();
	driver.get(config.getProperty("testUrl1"));
	}
	
	//Quitting the browser
	public void closingBrowser() {
	driver.close();
	//driver.quit();
	}
	
	
	//Wait Method
	public void sleep(int seconds) {
	try {
	Thread.sleep(seconds * 1000);
	} catch (Exception e) {
			
	}
	}
	
	
	
	
	
	
	
	
	
}
