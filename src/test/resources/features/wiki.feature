@wiki
Feature: Wikipedia Search Functionality Title Verification, Header verification, Image Header Verification
    As a user, I should be able to type anything in search box and see the word in wiki title

  Background:
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button

  Scenario: User should see searched word in the title
    Then User should see "Steve Jobs" in wiki title

  Scenario: User should see searched word in the header
  Then User should see "Steve Jobs" in the main header

  Scenario: User should see searched word in the image header
  Then User should see "Steve Jobs" in image header

#  TC#4: Wikipedia Search Functionality Image Header Verification
#  1. User is on Wikipedia home page
#  2. User types Steve Jobs in the wiki search box
#  3. User clicks wiki search button
#  4. User sees Steve Jobs is in the image header
#  Note: Follow POM

