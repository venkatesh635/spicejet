package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutils.Helper;

public class footer  extends Helper
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
		   List<WebElement> li=driver.findElement(By.className(or.getProperty("footerclass"))).findElements(By.tagName("li"));
		   System.out.println("=================================");
		   System.out.println("footer total size::"+li.size());
		   System.out.println("=================================");
		   
		   if(li.size()==0){
		   Assert.fail("footer id not present");
		   }else{
		   System.out.println("footer class id found");
		   System.out.println("=============================");
		   }
		   
		   HashMap<String,String> hm = new HashMap<String,String>();
		   for(int i=0;i<li.size();i++) {
		   System.out.println(i+1 +"::"+li.get(i).getText());
		   System.out.println(li.get(i).findElement(By.tagName("a")).getAttribute("href"));
		   System.out.println("===========================================================================");
		   hm.put(li.get(i).getText(), li.get(i).findElement(By.tagName("a")).getAttribute("href"));
		   }
		   Set<String> keys=hm.keySet();
		   for(String key:keys){
		   driver.get(hm.get(key));
		   }
		   
		   driver.close();
			
		   }

		

		
}
