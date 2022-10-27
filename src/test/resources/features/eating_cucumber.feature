@eating-cucumber
Feature: Eating too many cucumbers may not be good for you

  Eating too much of anything may not be good for you

  Scenario: 1 Eating a few is no problem
    Given John is hungry
    When he eats 6 cucumbers
    Then he will be full

  Scenario: 2 Eating a few is no problem Second scenario
    Given Adam is hungry
    When he eats 4 cucumbers
    Then he will be too full

