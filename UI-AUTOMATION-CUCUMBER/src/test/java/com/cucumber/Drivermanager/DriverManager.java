package com.cucumber.Drivermanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.constant.Constant_values;
import com.cucumber.step_def.Common_Step_def;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverManager {
	public static WebDriver driver=null;
	

	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	
	public static void lanchbrowser() {
		// TODO Auto-generated method stub
		switch(Constant_values.BROWSER) {
		case "chrome":WebDriverManager.chromedriver().setup();;
		LOGGER.info("start "+Constant_values.BROWSER);
		              driver=new ChromeDriver();
		              break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
		LOGGER.info(" start "+Constant_values.BROWSER);
		               driver=new FirefoxDriver();
		               break;
		case "Edge":WebDriverManager.edgedriver().setup();
		LOGGER.info("start "+Constant_values.BROWSER);
		               driver=new FirefoxDriver();
		               break;
		case "ie":WebDriverManager.iedriver().setup();
		LOGGER.info("start "+Constant_values.BROWSER);
		               driver=new FirefoxDriver();
		               break;
		default :    System.setProperty(Constant_values.CHROME_DRIVER,Constant_values.CHROME_DRIVER_LOCATION);
		LOGGER.info("default is start"+Constant_values.BROWSER);
        driver=new ChromeDriver();
        break;           
		
		} 
	}
		public static WebDriver getDriver() {
			return driver;
		}
	}


