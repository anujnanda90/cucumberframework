package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage {
	
	public LeadPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="company")
	WebElement company;
	
	
	
	@FindBy(name="button")
	WebElement save;
	
	@FindBy(xpath="//td[text()='Last Name:']/following::td[1]")
	WebElement lbl_lastname;
	
	@FindBy(xpath="//td[text()='Company:']/following::td[1]")
	WebElement lbl_Company;
	
	@FindBy(name="firstname")
	List<WebElement> ls_fname;
	
	@FindBy(name="lastname")
	List<WebElement> ls_lname;
	
	@FindBy(name="company")
	List<WebElement> ls_comp;
	
	@FindBy(name="button")
	List<WebElement> ls_search;
	
	@FindBy(xpath="//table[@class='FormBorder']/descendant::tr[6]/td[4]")
	WebElement colName;
	
	@FindBy(xpath="//table[@class='FormBorder']/descendant::tr[6]/td[6]")
	WebElement colCompany;
	
	
	public void CreateLeadwithMandatoryFields(String lname,String comp)
	{
		ca.TypeText(lastname, lname, lname+" has been entered into lastname field");
		ca.TypeText(company, comp, comp+" has been entered into company field");
		ca.ClickElement(save, "Save button clicked");
		
	}
	
	public void verifyLeadCreation(String lname,String comp)
	{
		ca.VerifyText(lbl_lastname, lname,"Text "+lname+ "matched against label LastName:");
		ca.VerifyText(lbl_Company, comp,"Text "+comp+ "matched against label Company:");
	}
	
	public void searchLead(String lname,String comp)
	{
		WebElement secondLastname = ls_lname.get(1);
		WebElement secondCompany = ls_comp.get(1);
		WebElement search = ls_search.get(1);
		ca.TypeText(secondLastname, lname, lname+" has been entered into lastname field");
		ca.TypeText(secondCompany, comp, comp+" has been entered into company field");
		ca.ClickElement(search, "Search button clicked");		
	}
	
	public void verifySingleRecordSearch(String lname,String comp)
	{
		ca.VerifyText(colName, lname,"Text "+lname+ "matched against column Name");
		ca.VerifyText(colCompany, comp,"Text "+comp+ "matched against Column Company:");
	}

}
