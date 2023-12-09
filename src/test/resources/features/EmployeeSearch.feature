Feature: Employee Search

  Background:
    #Given when user is navigated to HRMS application
   * user enters admin username and password
    * user clicks on login button
   * user is successfully logged in
    * user clicks on PIM Option
   * User Clicks on employee list option

  @sprint2 @ahmed @regression @emp @test
  Scenario: Search an Employee by ID
   # Given when user is navigated to HRMS application
   # When user enters admin username and password
    # And user clicks on login button
   #Then user is successfully logged in
    #When user clicks on PIM Option
   # And User Clicks on employee list option
    * user enters employee id
    * user clicks on search button
    * user should be able to see employee details
   # Then user closes the browser
    @sprint4 @ali @regression @emp @test
    Scenario: Search an employee By name
    #  Given when user is navigated to HRMS application
     # When user enters admin username and password
      #And user clicks on login button
     # Then user is successfully logged in
     # When user clicks on PIM Option
     # And User Clicks on employee list option
   * user enters valid employee name
      * user clicks on search button
      * user should be able to see employee details
      #Then user closes the browser