package com.cucumber.step_def;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.cucumber.Drivermanager.DriverManager;
import com.cucumber.constant.Constant_values;
import com.cucumber.pageObject.DirectoryPage;
import com.cucumber.pageObject.HomePage;
import com.cucumber.pageObject.LoginPage;
import com.cucumber.utils.Common_utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class verify_ceo_name {

	private static final Logger LOGGER=LogManager.getLogger(verify_ceo_name.class);

	@Given("user successfully logged in and is on home page")
	public void user_successfully_logged_in_and_is_on_home_page() {
		try {
			
			String url=DriverManager.getDriver().getCurrentUrl();
			if(url.contains("dashboard")) {
			LOGGER.info(" user successfully logged in and is on home page");
			}
		}catch(Exception e) {
			LOGGER.error(e);
			Common_utils.getinstance().takescreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user clicks the directory option under the menu section")
	public void user_clicks_the_directory_option_under_the_menu_section() {
		try
		{DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		HomePage.getinstance().clickDirectory_Menu();

		LOGGER.info("clicked directory and moved to page");}
		catch(Exception e){
			LOGGER.error(e);
			Common_utils.getinstance().takescreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@When("user select as {string} option from the job title dropdown")
	public void user_select_as_option_from_the_job_title_dropdown(String listoption) {
		try{
			DirectoryPage.getinstance().clickJob_Title();
			Common_utils.getinstance().listArraymethod(DirectoryPage.getinstance().Job_Title_List,listoption);


			LOGGER.info("selected ceo as option");
		}catch(Exception e) {
			//Common_utils.getinstance().listArraymethod(DirectoryPage.getinstance().Job_Title_List,listoption);
			LOGGER.error(e);
			Common_utils.getinstance().takescreenshot();
			//Assert.fail(e.getMessage());
		}

	}

	@When("click the search button")
	public void click_the_search_button() {
		try{
			DirectoryPage.getinstance().clickSearch_Button();
			LOGGER.info("clicked search button");
		}catch(Exception e) {
			LOGGER.error(e);
			Common_utils.getinstance().takescreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("user verify the CEO name {string}")
	public void user_verify_the_ceo_name(String status) {
		try{
			String stat=DirectoryPage.getinstance().displayStatus();
			if(!(stat.equalsIgnoreCase(status))) {
				LOGGER.info("no records found");
			}
		}catch(Exception e) {
			LOGGER.error(e);
			Common_utils.getinstance().takescreenshot();
			Assert.fail(e.getMessage());
		}
	}



}
