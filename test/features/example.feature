@domain @ui
Feature: Calculator

  Scenario: Adding numbers
    Given I have number 5
    When I add to this number 44
    Then the result should be 49

  Scenario: Adding positive number to negative number
    Given I have number -5
    When I add to this number 5
    Then the result should be 0
