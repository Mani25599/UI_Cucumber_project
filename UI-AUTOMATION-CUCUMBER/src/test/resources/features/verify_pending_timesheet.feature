@Timesheet
Feature: to check the timesheet
  Scenario Outline: To verify the pending timesheet in hrm app
    Given the user successfully logged in and is on home page
    When the user clicks the Time option under the menu section
    And the user enter the "John Smith" in employee name text field
    And click the view button 
    Then the user verify the message "<message>"

    Examples: 
     |message|
     |No Timesheet Found|