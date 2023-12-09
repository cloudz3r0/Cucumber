Feature: Login Scenarios
  @sprint1 @nafiseh @regression @test123 @test
  Scenario: Valid admin login
   # Given when user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    #Then user closes the browser