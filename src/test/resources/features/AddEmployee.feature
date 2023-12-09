Feature:Add Employee scenario

  Background:
    Given when user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM Option
    And user clicks on add employee option

  @addEmp @test
  Scenario: Adding one employee in the hrms system.
    #Given when user is navigated to HRMS application
   # When user enters admin username and password
   # And user clicks on login button
    #Then user is successfully logged in
   # When user clicks on PIM Option
   # And user clicks on add employee option
    When user enters firstName middleName and lastName
    And user clicks on save button
    Then employee added successfully
    #Then user closes the browser

  @cucumber
  Scenario: Adding one employee using feature file
     #Given when user is navigated to HRMS application
      #When user enters admin username and password
   # And user clicks on login button
   # Then user is successfully logged in
    #When user clicks on PIM Option
   # And user clicks on add employee option
    When user enters "miraj" and "fali" and "moralejo"
    And user clicks on save button
    Then employee added successfully


  @ddt
  Scenario Outline:adding multiple employees from feature file.
    When user enters "<firstName>" and "<middleName>" and enters "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | Hello     | my         | duck     |
      | mickey    | ms         | mouse    |
      | Donny     | ms         | trump    |


  @excel
  Scenario: Adding multiple employees from excel file
    When user adds Multiple employees from excel using "Sheet1" and verify it


  @datatable
  Scenario: adding multiple employees from data table
    When user adds multiple employees from data table
      |firstName   | middleName | lastName |
      |donal12      |ms          |duck      |
      |tamoha12     |ms          |jimo      |
      |joe12        |ms          |trump     |


