package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonActions;

public class LoginPage {
	
	private WebDriver driver;
	public commonActions ca;
	public ExtentTest logger;
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		ca = new commonActions(driver,logger);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	WebElement userid;
	
	@FindBy(name="user_password")
	WebElement pwd;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement errorMsg;
	
	public void login(String uid, String pass)
	{
		ca.TypeText(userid, uid, uid+" has been entered into username field");
		ca.TypeText(pwd, pass, pass+" has been entered into password field");		
		ca.ClickElement(login, "Login button clicked");
	}
	
	public void verifyErrorMsg()
	{
		ca.ExistElement(errorMsg, "Error message validated");
	}
	
	
	
	/*
	By userid = By.name("user_name");
	By pwd = By.name("user_password");
	By login = By.name("Login");
	
	public void validlogin()
	{
		driver.findElement(userid).clear();
		driver.findElement(userid).sendKeys("admin");
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys("admin");
		driver.findElement(login).click();
	}
	
	public void Invalidlogin()
	{
		driver.findElement(userid).sendKeys("admin12");
		driver.findElement(pwd).sendKeys("admin124");
		driver.findElement(login).click();
	}
	*/
	
	

}
