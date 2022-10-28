@etsy
Feature: Etsy Title Verification
  Background:
    Given user is on Etsy homepage

  Scenario: Etsy title verification
    Then the title should be "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone"


  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    When user types Wooden Spoon in search box
    And user clicks search button
    Then user should see Wooden Spoon in the title

  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    When user types "wooden spoon" in search box
    And user clicks search button
    Then user should see "Wooden spoon" in the title






