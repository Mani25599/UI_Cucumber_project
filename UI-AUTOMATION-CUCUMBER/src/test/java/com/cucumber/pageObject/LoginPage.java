package com.cucumber.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.utils.Common_utils;

public class LoginPage {

	private static LoginPage LoginInstance;

	private LoginPage() {

	}

	public static LoginPage getinstance() {
		if (LoginInstance == null) {
			LoginInstance = new LoginPage();
		}
		return LoginInstance;
	}

	@FindBy(xpath="//input[contains(@name,'username')]")
	private WebElement UserName;
	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement PassWord;
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement LoginButton;

	public void enterUserName(String uname) {
		// Common_utils.getinstance().highlighter(UserName);
		UserName.sendKeys(uname);
	}

	public void enterPassWord(String password) {
		// Common_utils.getinstance().highlighter(PassWord);
		PassWord.sendKeys(password);
	}

	public void clickLoginButton() {
		// Common_utils.getinstance().highlighter(LoginButton);
		LoginButton.click();
	}

}
