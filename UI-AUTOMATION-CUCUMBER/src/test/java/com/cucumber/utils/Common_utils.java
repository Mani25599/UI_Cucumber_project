package com.cucumber.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.Drivermanager.DriverManager;
import com.cucumber.constant.Constant_values;
import com.cucumber.pageObject.DirectoryPage;
import com.cucumber.pageObject.HomePage;
import com.cucumber.pageObject.LoginPage;
import com.cucumber.step_def.Common_Step_def;

public class Common_utils {
	private static final Logger LOGGER = LogManager.getLogger(Common_utils.class);

	private static Common_utils utilsinstance;

	private Common_utils() {

	}

	public static Common_utils getinstance() {
		if (utilsinstance == null) {
			utilsinstance = new Common_utils();
		}
		return utilsinstance;
	}

	public void loadproperties() {
		/*
		 * This block is used to get the location of config file when in normal place so
		 * that it should need why we not use this anymore means the config properties
		 * file should be placed under resource folder which create for store the
		 * resources needed for project FileReader reader=null; try { reader=new
		 * FileReader("config.properties"); }catch(Exception e) { e.printStackTrace(); }
		 */
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		Constant_values.BROWSER = properties.getProperty("BROWSER");
		Constant_values.APP_USERNAME = properties.getProperty("APP_USERNAME");
		Constant_values.APP_PASS = properties.getProperty("APP_PASSWORD");
		Constant_values.CHROME_DRIVER_LOCATION = properties.getProperty("DRIVER_LOCATION");
		Constant_values.APP_URL = properties.getProperty("APP_URL");
	}

	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getinstance());

	}

	public void takescreenshot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_def.getScenarioName() + "Screenshot.png"));
		} catch (IOException e) {

		}
	}

//	public void highlighter(WebElement element) {
//	JavascriptExecutor	executer=(JavascriptExecutor) DriverManager.getDriver();
//	 executer.executeScript("arguments[0].style.border='3px solid red'", element);
//	 }
//	public void highlighter(List<WebElement> element) {
//		JavascriptExecutor	executer1=(JavascriptExecutor) DriverManager.getDriver();
//		 executer1.executeScript("arguments[0].style.border='3px solid red'", element);
//		 }
	/*
	 * public void dropDownValues(WebElement dropdown,String htw,String value) {
	 * Select select=new Select(dropdown); switch (htw) { case "index":
	 * select.selectByIndex(Integer.parseInt(value)); break; case "value":
	 * select.selectByValue(value); break; case "Text":
	 * select.selectByVisibleText(value); break;
	 * 
	 * default:LOGGER.
	 * info("please enter the correct value from : text or index or value ");
	 * 
	 * } }
	 */

	public void listArraymethod(List<WebElement> list_instance, String from_feat) {
		for (WebElement locate : list_instance) {
			String job = locate.getText();
			LOGGER.info("the list options are displayed" + job);
			if (job.equalsIgnoreCase(from_feat)) {
				locate.click();

			}
		}

	}

}
