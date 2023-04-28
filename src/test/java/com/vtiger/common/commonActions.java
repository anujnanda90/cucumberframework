package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class commonActions {
	private WebDriver driver;
	public WebDriverWait wait;
	public ExtentTest logger;
	public commonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	
	public void TypeText(WebElement elm, String val,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		logger.pass(msg+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("text did not enter due to error "+e.getMessage()+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	
	public void VerifyText(WebElement elm, String val,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		if(elm.getText().equals(val))
		{
		logger.pass(msg+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		else
		{
			logger.fail("text did not match"+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");	
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("text did not enter due to error "+e.getMessage()+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void ClickElement(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));		
		elm.click();
		logger.pass(msg+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("unable to click element due to error "+e.getMessage()+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void ExistElement(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));		
		elm.isDisplayed();
		logger.pass(msg+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("unable to click element due to error "+e.getMessage()+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void SelectText(WebElement elm,String val,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));		
		Select sel = new Select(elm);
		sel.selectByVisibleText(val);
		logger.pass(msg+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("unable to select value from dropdown due to error "+e.getMessage()+"       "+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public String getScreenshot() 
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
