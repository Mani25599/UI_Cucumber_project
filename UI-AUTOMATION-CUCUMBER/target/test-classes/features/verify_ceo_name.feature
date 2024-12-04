
@CEOname
Feature: This is to get CEO name from orangeHRM application
  Scenario Outline: To verify the CEO name in hrm app
    Given user successfully logged in and is on home page
    When user clicks the directory option under the menu section
    And user select as "Chief Executive Officer" option from the job title dropdown 
    And click the search button 
    Then user verify the CEO name "<CEO_NAME>"

    Examples: 
     |CEO_NAME|
     |John Smith|
