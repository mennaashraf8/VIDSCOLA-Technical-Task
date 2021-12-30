Feature: Google Search Functionality

  // Testing Google search using Cucumber , Selenium and JUnit
  Scenario: Successful Search
    Given I am in google search page
    When I search for a word in google
    Then I should be in the search page