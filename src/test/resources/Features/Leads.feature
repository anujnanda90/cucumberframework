@regression
Feature: Lead functionality

Background:
Given user should be on login page
When user enters valid crdentials and click login button

Scenario: create lead with mandatory fields
When user click on new lead link then create lead page will open
And user enters lastname and company and click on save button
Then lead should be created successfully
And user can search same lead successfully
