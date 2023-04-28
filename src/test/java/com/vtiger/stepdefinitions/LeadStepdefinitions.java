package com.vtiger.stepdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadStepdefinitions extends BaseTest {
	
	
	
	@When("user click on new lead link then create lead page will open")
	public void click_new_lead() {
		HomePage hp = new HomePage(driver,logger);
		hp.clickNewLead();
	    
	}
	
	@And("user enters lastname and company and click on save button")
	public void user_enters_lastname_and_company_and_click_on_save_button() {
		LeadPage ldp = new LeadPage(driver,logger);
	    ldp.CreateLeadwithMandatoryFields(td.get(TCName).get("LastName"), td.get(TCName).get("Company"));
	}
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
		LeadPage ldp = new LeadPage(driver,logger);
	    ldp.verifyLeadCreation(td.get(TCName).get("LastName"), td.get(TCName).get("Company"));
	    ldp.clickLeads();
	    
	}
	@Then("user can search same lead successfully")
	public void user_can_search_same_lead_successfully() {
		LeadPage ldp = new LeadPage(driver,logger);
	    ldp.searchLead(td.get(TCName).get("LastName"), td.get(TCName).get("Company"));
	    ldp.clickLogout();
	}

}
