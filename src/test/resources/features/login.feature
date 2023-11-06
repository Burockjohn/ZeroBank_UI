Feature: Login functionality

  Scenario: User should be able to log in with valid credentials
    Given user is on the login page
    When user enters valid credentials
    And user clicks sign in button
    Then user should be logged in


  Scenario Outline: User should see error message in case of invalid entries
    Given user is on the login page
    When user enters "<userName>" as username and "<password>" as password
    And user clicks sign in button
    Then user should see error message "Login and/or password are wrong."
    Examples:
      | userName      | password      |
      | usernameWrong | password      |
      | username      | passwordWrong |
      | usernameWrong | passwordWrong |
      |               | password      |
      | userName      |               |
      |               |               |