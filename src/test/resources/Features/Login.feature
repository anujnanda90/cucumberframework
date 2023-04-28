@regression
Feature: Login

Background:
Given user should be on login page


Scenario: Test invalid login
When user enters invalid crdentials and click login button
Then user should can see error message on login page
 

@test @sanity
Scenario: Test valid login
When user enters valid crdentials and click login button
Then user should be navigated to home page
And user can see logout link apear on home page

@smoke
Scenario Outline: Test invalid login with multiple iteration
When user enters userid as "<userid>" and password "<password>" click login button
Then user should can see error message on login page
Examples:
|userid | password|
|admin1 |pass1    |
|admin2 |pass2    |
|admin3 |[ass3    |



