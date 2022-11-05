Feature: User should be able to login to WebTables application
  Scenario: Login with valid credentials MAP
    Given User is on homepage
    When User enters valid credentials and clicks login button
      |username  | Test|
      |password  |Tester|
    Then Expected URL should end with "orders"






#  when map -  SCENARIO



#TC #: Login scenario
#1- Open a chrome browser 2- Go to:
#https://web-table-2.cydeo.com/login
#3- Enter  username:  Test
#4- Enter password: Tester
#5- Verify URL:
#Expected: URL should end with “orders”