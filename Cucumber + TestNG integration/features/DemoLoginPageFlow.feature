Feature: Demo UI Login Page

Background:
Given Chrome browser should be open 
And Load the application URL as "http://leaftaps.com/opentaps/control/login"
And Maximize and set the timeouts

Scenario: TC001-Login with valid data  
Given Enter the valid username as "demosalesmanager"
And Enter the valid password as "crmsfa"
When Login Button should be clicked
Then Home page verification

Scenario: TC002-Login with valid username and invalid password  
Given Enter the valid username as "demosalesmanager"
And Enter the valid password as "crmsf"
When Login Button should be clicked
But Home page verification

Scenario: TC003-Login with invalid username and valid password  
Given Enter the valid username as "demosalesmanage"
And Enter the valid password as "crmsfa"
When Login Button should be clicked
But Home page verification


Scenario: TC004-Login with invalid username and invalid password  
Given Enter the valid username as "dmosalesmanage"
And Enter the valid password as "crmfa"
When Login Button should be clicked
But Home page verification

Scenario Outline: TC005-Login with multiple users  
Given Enter the valid username as <Username>
And Enter the valid password as <Password>
When Login Button should be clicked
But Home page verification

Examples:
|Username|Password|
|'demosalesmanager'|'crmsf'|
|'demoCSR'|'crmsfa'|








