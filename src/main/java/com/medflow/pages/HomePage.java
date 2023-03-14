package com.medflow.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.medflow.actiondriver.Action;
import com.medflow.base.TestBase;

public class HomePage extends TestBase {
	
	Action action = new Action();
	
	@FindBy(how = How.XPATH, using = "//td[@class='dft_page_header']")
	WebElement dashboardText;
	
	@FindBy(how = How.ID, using = "services")
	WebElement navPatientSection;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Search File']")
	WebElement searchFileLink;
	
	
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(), this);
	}

	
	
	public String verifyHomePageHeading() {
		
		action.explicitWait(getDriver(), dashboardText, Duration.ofSeconds(10));
		//utils.explicitWait(driver, dashboardText, Duration.ofSeconds(10));
		return dashboardText.getText();
	}
	
	public SearchFilePage gotoSearchFile() {
		
		action.explicitWait(getDriver(), dashboardText, Duration.ofSeconds(10));
		action.mouseOverElement(getDriver(), navPatientSection);
		//utils.mouseOverElement(driver, navPatientSection);
		searchFileLink.click();
		return new SearchFilePage();
	}
}
