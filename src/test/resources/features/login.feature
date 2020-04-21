@login
Feature: Login Scenarios
  As a user
  I want to log in into the system
  So that I'm authorized to make transactions

  @positive_1
  Scenario: Login failed using incorrect username & password
    Given the user opens Web
    When the user clicks Login Portal button
    And the user input username asdf
    And the user input password asdf
    And the user clicks Login button
    Then show warning message