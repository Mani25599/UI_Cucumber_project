package com.cucumber.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.cucumber.utils.Common_utils;

public class DirectoryPage {
	private static DirectoryPage directorypageinstance;

	private DirectoryPage() {

	}

	public static DirectoryPage getinstance() {
		if (directorypageinstance == null) {
			directorypageinstance = new DirectoryPage();
		}
		return directorypageinstance;
	}

	@FindBy(xpath = "(//div[text()='-- Select --'])[]")
	private WebElement Job_Title;
	@FindBys({
		@FindBy(xpath = "(//div[text()='-- Select --'])[1]/following::div[2]/div")
	})
	public List<WebElement> Job_Title_List;
	 // "(//label[contains(text(),'Job
																			// Title')]/following::div/child::div[2])[2]/div")
	
	@FindBy(xpath = "//button[text()=' Search']")
	private WebElement Search_Button;
	@FindBy(xpath = "//span[text()='No Records Found']")
	private WebElement Status;

	

	public void clickJob_Title() {
		// Common_utils.getinstance().highlighter(Job_Title);
		Job_Title.click();
	}

	public void select_Dropdown() {
		// Common_utils.getinstance().highlighter(Job_Title_List);
		//Job_Dropdown.click();
	}

	public void clickSearch_Button() {
		// Common_utils.getinstance().highlighter(Search_Button);
		Search_Button.click();
	}

	public String displayStatus() {
		// Common_utils.getinstance().highlighter(Status);
		return Status.getText();
	}
	

}
