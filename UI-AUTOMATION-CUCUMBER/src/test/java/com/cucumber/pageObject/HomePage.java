package com.cucumber.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.utils.Common_utils;

public class HomePage {

	private static HomePage homepageinstance;

	private HomePage() {

	}

	public static HomePage getinstance() {
		if (homepageinstance == null) {
			homepageinstance = new HomePage();
		}
		return homepageinstance;
	}

	@FindBy(linkText = "Directory")
	private WebElement Directory_Menu;

	public void clickDirectory_Menu() {
		// Common_utils.getinstance().highlighter(Directory_Menu);
		Directory_Menu.click();
	}

}
