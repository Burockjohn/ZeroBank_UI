Feature: Add new payee under pay bills

  Background:
    Given user is on the login page
    When user enters valid credentials
    And user clicks sign in button
    And user clicks Pay Bills link under Online Banking module


  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed
