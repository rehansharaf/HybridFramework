package com.medflow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.medflow.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(how = How.ID, using = "txtLogin")
	WebElement username;
	
	@FindBy(how = How.ID, using = "txtPassword")
	WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	WebElement btnLogin;
	
	
	
	public LoginPage() {
		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	
	public HomePage login(String user, String pass) {
		
		username.sendKeys(user);
		password.sendKeys(pass);
		btnLogin.click();
		return new HomePage();
		
	}
	
	
	

	
}
