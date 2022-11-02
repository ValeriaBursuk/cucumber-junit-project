Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin


  Background:
    Given User is on the homepage


@librarian @employee
  Scenario: Login as a librarian
    When Librarian enters valid username and valid password
    And User clicks Login button
    Then Dashboard should be displayed

    @student
  Scenario: Login as a student
      When Student enters valid username and valid password
      And User clicks Login button
      Then Dashboard should be displayed

  @admin @employee
  Scenario: Login as an admin
      When Admin enters valid username and valid password
      And User clicks Login button
      Then Dashboard should be displayed


