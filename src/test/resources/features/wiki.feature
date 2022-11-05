Feature: Wikipedia Search Functionality Title Verification, Header verification, Image Header Verification
  As a user, I should be able to type anything in search box and see the word in wiki title

  Background:
    Given User is on Wikipedia home page

  Scenario: User should see searched word in the title
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" in wiki title

#  Scenario: User should see searched word in the header
#    And User clicks wiki search button
#    Then User should see "Steve Jobs" in the main header
#
#  Scenario: User should see searched word in the image header
#    And User clicks wiki search button
#    Then User should see "Steve Jobs" in image header

  @wiki
  Scenario Outline:
    Given User is on Wikipedia home page
    When User types "<word>" in the wiki search box
    And User clicks wiki search button
    Then User should see "<expectedTitle>" in wiki title
    Examples:
      | word           | expectedTitle  |
      | Donald Trump   | Donald Trump    |
      | Bill Gates     | Bill Gates     |
      | Elon Musk      | Elon Musk      |
      | Kim Kardashian | Kim Kardashian |



