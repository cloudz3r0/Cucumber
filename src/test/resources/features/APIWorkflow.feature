Feature: Syntax API workflow feature
  Background:
    Given a JWT is generated
@api
  Scenario: create an employee via API
    #Given a JWT is generated
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for this request is 201
Then the employee id "Employee.employee_id" is stored as global variable for other request

  @api
  Scenario: get the created employee
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    And the global employee id must match with "employee.employee_id" key
    And the retrieved data at "employee" object matches the data used to create employee
    |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
    |Adrian       | Gerardo    |G              |Male         |2002-11-29  |here      |Hi           |

@json @api
    Scenario: Creating the employee using json payload
      Given a request is prepared for creating an employee via json payload
      When a POST call is made to create an employee
      Then the status code for this request is 201
  And the employee id "Employee.employee_id" is stored as global variable for other request
      And the response body contains "Message" key and value "Employee Created"
@jsondynamic @api
  Scenario: Creating the employee using json payload
    Given a request is prepared for creating an employee with dynamic data "Adrian", "Gerardo","G","M","2002-11-29","here","hi"
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request
    And the response body contains "Message" key and value "Employee Created"


  @GetAllJob @api
  Scenario: get all job titles
    Given a request is made to retrieve all jobtitles
    Then the status code for this employee is 200


  @GetAll @api
    Scenario: get all employees
      Given a request is prepared to retrieve all employees
      Then the status code for this employee is 200

@update @api
Scenario: Updating the employee
  Given a request is prepared to update an employee in HRMS system
  When a PUT call is made to update the employee
  Then the status code for updating the employee is 200


