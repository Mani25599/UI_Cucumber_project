package com.cucumber.step_def;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.Drivermanager.DriverManager;
import com.cucumber.constant.Constant_values;
import com.cucumber.pageObject.LoginPage;
import com.cucumber.utils.Common_utils;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_def {
	private static final Logger LOGGER = LogManager.getLogger(Common_Step_def.class);
	private static String ScenarioName = null;
	public byte[] screenshotTaken;

	@Before
	public void beforeSceanrio(Scenario scenario) {

		LOGGER.info("logger is start");
		try {
			ScenarioName = scenario.getName();
			LOGGER.info("instantiate comman_utils file object");

			LOGGER.info("the loadproperty file is load");
			Common_utils.getinstance().loadproperties();
			LOGGER.info("loaded propoerty and check driver is null or not");
			if (DriverManager.getDriver() == null)// for every before execution seperate browser is lauched instantly
													// ,so to do complete task on a single browser this logic is used
				LOGGER.info("inside the if loop so driver is now not null");
			DriverManager.lanchbrowser();
			Common_utils.getinstance().initWebElements();
			login();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void login() {
		DriverManager.getDriver().get(Constant_values.APP_URL);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		LoginPage.getinstance().enterUserName(Constant_values.APP_USERNAME);

		LoginPage.getinstance().enterPassWord(Constant_values.APP_PASS);
		LoginPage.getinstance().clickLoginButton();

	}

	public static String getScenarioName() {
		return ScenarioName;
	}

	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshotTaken, "image/png", "error screen");
		}

	}
}
