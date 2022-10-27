@wiki
Feature: Wikipedia Search Functionality Title Verification
    As a user, I should be able to type anything in search box and see the word in wiki title

  Scenario: User should see searched word in the title
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" in wiki title




#  TC#2: Wikipedia Search Functionality Title Verification
#1. User is on Wikipedia home page
#2. User types Steve Jobs in the wiki search box
#3. User clicks wiki search button
#4. User sees Steve Jobs is in the wiki title