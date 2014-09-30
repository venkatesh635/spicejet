package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutils.Helper;

public class cargotest  extends Helper
{
	         //Helper h= new Helper();
     // asdashdkaskjdhjkashd
             @BeforeMethod
             public void beforemethod(){
	         browserType();
	         loadPage1();
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             }
             
		     @Test
		     public void test() {
		     WebElement element=driver.findElement(By.className(or.getProperty("cargotableid")));
		     System.out.println(element.getSize());
		     List<WebElement> rowCollection=element.findElements(By.tagName("tr"));
		     
		     if(rowCollection.size()==0){
		     Assert.fail("row element id not found");
		     }else{
		     System.out.println("row element id found");
		     }
		     
			 System.out.println("Numer of rows in this table: "+rowCollection.size());
			 List<String> array = new ArrayList<String>();
			 
             for(WebElement rowElement:rowCollection){
			 List<WebElement> colCollection=rowElement.findElements(By.tagName("td"));
			 
			 for(WebElement colElement:colCollection){
			 System.out.print(colElement.getText() + "\t") ;
			 //System.out.println();
			 }
			 System.out.println();
			 }
			 System.out.println("\n");
			 driver.close();
		     }
}
