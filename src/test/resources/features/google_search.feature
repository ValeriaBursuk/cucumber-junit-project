@smoke
Feature: Google search functionality title verification
  User story: As a user, I should be able to search anything in Google and see results

Scenario: User should be able to see searched word in Google title
  Given User is on Google search page
  When User types apple in google search box and hits Enter
  Then User should see apple – Google Search in google title

  Scenario: Search with parameterization
    Given User is on Google search page
    When User types "word" in google search box and hits Enter
    Then User should see "word - Google Search" in google title



