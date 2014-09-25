package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutils.Helper;

public class socialsites  extends Helper
{
	        Helper h= new Helper();
	        
	        @BeforeMethod
	        public void beforemethod(){
		    browserType();
		    loadPage();
	        }
	        
	        @Test
		    public void test() {
			List<WebElement> list=driver.findElement(By.className(or.getProperty("classname"))).findElements(By.tagName("a"));
			
			if(list.size()==0){
		    Assert.fail("class name not found");
			}else{
			System.out.println("========================================");
			System.out.println("elements found by class name successfully");
			System.out.println("total elements::"+list.size());
			System.out.println("=========================================");
			}
			
			for(int i=0;i<list.size();i++){   
			String url1=list.get(i).getAttribute("href");
			list.get(i).click();
			sleep(5);
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); 
			String url= driver.getCurrentUrl();
			
			if(url.contains("facebook")&&url1.contains("facebook")){
			System.out.println("facebook url:"+url);
		    System.out.println("navigated to facebook succesfully");
		    System.out.println("========================================");
			}
			
			if(url.contains("twitter")&&url1.contains("twitter")){
			System.out.println("twitterurl:"+url);
			System.out.println("navigated to twitter succesfully");
			System.out.println("========================================");
			}
			
			driver.close();
			driver.switchTo().window(tabs.get(0));
			} 
		    }
	        
	        @AfterMethod
	        public void aftermethod(){
	        closingBrowser();
	        }
}
