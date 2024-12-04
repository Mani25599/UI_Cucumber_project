package com.cucumber.step_def;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class verify_pending_timesheet {
	@Given("the user successfully logged in and is on home page")
	public void the_user_successfully_logged_in_and_is_on_home_page() {
		System.out.println("logged in success");
	}

	@When("the user clicks the Time option under the menu section")
	public void the_user_clicks_the_time_option_under_the_menu_section() {
	   System.out.println("click timeoption under menu");
	}

	@When("the user enter the {string} in employee name text field")
	public void the_user_enter_the_in_employee_name_text_field(String string) {
		System.out.println("entered name");
	}

	@When("click the view button")
	public void click_the_view_button() {
		System.out.println("clicked view button");
	}

	@Then("the user verify the message {string}")
	public void the_user_verify_the_message(String string) {
		System.out.println("verified the time sheet");
	}


}
