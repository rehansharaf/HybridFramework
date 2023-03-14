package com.medflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.medflow.base.TestBase;

public class SearchFilePage extends TestBase {

	@FindBy(how = How.XPATH, using = "//td[text()='Search File']")
	WebElement searchFilePageHeading;

	
	public SearchFilePage() {

		PageFactory.initElements(getDriver(), this);
	}

	
	public String verifySearchFilePage() {
		
		return searchFilePageHeading.getText();
	}
	
	
	
}
