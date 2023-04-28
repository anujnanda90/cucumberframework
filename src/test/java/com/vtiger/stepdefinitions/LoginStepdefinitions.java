package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdefinitions extends BaseTest {
	
	@Before
	public void getScenario(Scenario scenario)
	{
		initiation();
		TCName = scenario.getName();
		logger = extent.createTest(TCName);
	}
	
	@After
	public void savereport()
	{
		extent.flush();
	}
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		launchApp();
	}
	@When("user enters valid crdentials and click login button")
	public void user_enters_valid_crdentials_and_click_login_button() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(td.get(TCName).get("Userid"), td.get(TCName).get("Password"));
	}
	
	@When("user enters invalid crdentials and click login button")
	public void user_enters_invalid_crdentials_and_click_login_button() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(td.get(TCName).get("Userid"), td.get(TCName).get("Password"));
	}
	
	@Then("user should can see error message on login page")
	public void validate_error_message() {
		LoginPage lp = new LoginPage(driver,logger);
		lp.verifyErrorMsg();
	}
	
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	    HomePage hp = new HomePage(driver,logger);
	    hp.checkPipelinedisplay();
	}
	@Then("user can see logout link apear on home page")
	public void user_can_see_logout_link_apear_on_home_page() {
		 HomePage hp = new HomePage(driver,logger);
		    hp.validateLogout();
		    hp.clickLogout();
		
	}
	
	@When("user enters userid as {string} and password {string} click login button")
	public void user_enters_userid_as_and_password_click_login_button(String uid, String pwd) {
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(uid, pwd);
	}

}
