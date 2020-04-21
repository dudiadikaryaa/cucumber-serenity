@contactus
Feature: Contact Us Scenarios
  As a user
  I want to access contact us page
  So that I'm able to see contact us page

  @case1
  Scenario: Successfully redirects to Contact Us Page
    Given the user opens Web
    When the user clicks Contact Us Page button
    Then user redirects to Contact Us Page