package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import tests.socialsites;


public class TestBase 
{
        public static String dir1;
        public static Properties config=null;
        public static Properties or=null;
        public static WebDriver driver;
        FileInputStream fp, fp1;
        //initializing log4j
        public static Logger log = Logger.getLogger("devpinoyLogger");
        @BeforeSuite	
	    public void intialize() throws IOException   {
		log.debug("Starting the test suite......");
		log.debug("Loading the config files.....");
		fp= new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\config.properties");
		config = new Properties();
		config.load(fp);
		log.debug("Loading the Object repository files.....");
		fp1= new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\or.properties");
		or = new Properties();
	    or.load(fp1);
	    System.out.println("=======================================");
		System.out.println("Choosing the browser: "+ config.getProperty("browserType"));
		System.out.println("=======================================");
		}
     
		
}
