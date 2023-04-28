package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonActions;

public class HeaderPage {
	public WebDriver driver;
	public ExtentTest logger;
	public commonActions ca;
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		ca = new commonActions(driver,logger);
	}
	
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	@FindBy(linkText="New Lead")
	WebElement lnkNewLead;
	
	@FindBy(linkText="Leads")
	WebElement lnkLeads;
	
	
	public void clickNewLead()
	{
		ca.ClickElement(lnkNewLead, "New Lead link clicked");
	}
	
	public void clickLeads()
	{
		ca.ClickElement(lnkLeads, "Leads link clicked");
	}
	public void clickLogout()
	{
		ca.ClickElement(lnkLogout, "Logout link clicked");
	}
	
	public void validateLogout()
	{
		ca.ExistElement(lnkLogout, "Logout link is available");
	}

}
