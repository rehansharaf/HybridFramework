package com.medflow.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.medflow.base.TestBase;
import com.medflow.pages.HomePage;
import com.medflow.pages.LoginPage;
import com.medflow.pages.SearchFilePage;
import com.medflow.utils.Log;

public class VerifySearchFilePage extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	SearchFilePage sp;
	
	@BeforeMethod
	public void beforeTest() {
		
		browserIntialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		sp = hp.gotoSearchFile();
		
	}
	
	
	@Test
	public void verifySearchFilePage_Test1() {
		
		Log.startTestCase("Verify SearchFile Page");
		Assert.assertEquals(sp.verifySearchFilePage(), "Search File");
		Log.endTestCase("Verify SearchFile Page");

		
	}
	
	@AfterMethod
	public void afterTest() {
		
		getDriver().get("https://khi.medicallienmgt.com/logout.aspx");
		removeDriver();
	}
	
	

}
