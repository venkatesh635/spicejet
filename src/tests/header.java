package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import testutils.Helper;

public class header extends Helper
{
 
	
	       Helper h= new Helper();
     
           @BeforeMethod
           public void beforemethod(){
	       browserType();
	       loadPage();
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           }
           
		   @Test
		   public void test() {
		   List<WebElement> li=driver.findElement(By.className(or.getProperty("headerclassname"))).findElements(By.tagName("li"));
		   System.out.println("header total size::"+li.size());
		   
		   if(li.size()==0){
		   Assert.fail("header id not found");
		   }else{
		   System.out.println("header id  present");
		   }
		   
		   List<String> list = new ArrayList<String>();
		   
		   for(int i=0;i<li.size();i++){
		   System.out.println(li.get(i).getText());
		   if(i==83){
		   System.out.println("getting " +(i+1) + ":" +"http://www.spicejet.com/#");
		   }
		   else if(li.get(i).findElement(By.tagName("a")).getAttribute("href")!=null){
		   list.add(li.get(i).findElement(By.tagName("a")).getAttribute("href"));
		   System.out.println("getting " +(i+1) +":" +li.get(i).findElement(By.tagName("a")).getAttribute("href"));
		   }  
		   System.out.println("======================================");
		   }
		   
		   for(int j=3;j<7;j++){
		   driver.get(list.get(j));
		   sleep(5);
		   }
		  
		}
}
