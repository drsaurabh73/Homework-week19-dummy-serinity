Feature: Testing different products on the Best Api Application

  Scenario: Check if the GoRest application is accessed by the users
    Given I am on Homepage of application DummyApi
    When User send a GET Request to list endpoint employees
    Then User can get back a valid status code 200 of employees

  Scenario: Check if User can add  employees in the application
    Given I am on Homepage of application DummyApi
    When User can create new employee using POST method in products application
    Then User can get back a valid status code 201 of employees

  Scenario: Check if User can update  employees in the application
    Given I am on Homepage of application DummyApi
    When User can create new employee using PUT method in employees application
    Then User can get back a valid status code 200 of employees

  Scenario: Check if User can Delete  employees in the application
    Given I am on Homepage of application DummyApi
    When User can Delete new employee using DELETE method in employees application
    Then User can get back a valid status code 200 of employees
    And User verify that the employee is deleted successfully from employees