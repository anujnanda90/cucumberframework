package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonActions;

public class HomePage extends HeaderPage {

	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name="pipeline")
	WebElement pipeline;
	
	
	public void checkPipelinedisplay()
	{
		ca.ExistElement(pipeline, "Pipeline dashboard exist on Home Page");
	}
	

	

}
