Feature: ContactUs
  
  Scenario: Complete ContactUs Form
    
    Given user navigates to google website
    And user searches for SecurePay
		And navigates to SecurePay website
		When user clicks on Contact Us link
		Then contact Us Page is loaded
		Then populate Contact Us form with random data 
		And validate checkbox is present 
		And submit button is present