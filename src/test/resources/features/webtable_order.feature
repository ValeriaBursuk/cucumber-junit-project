@smoke
Feature: WebTable Order
  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects productType "Familybea"
    And user enters quantity 2
    And user enters customer name "Kim Kardashian"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "Visa"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Kim Kardashian" in first row of the web table




