@smartbear
Feature: Smartbear app order page feature

  Scenario Outline: User should see name on the list
    Given User is logged into SmartBear Tester account
    When User goes to "Order" page
    * User selects "<productType>" from product dropdown
    * User enters "<quantity>" to quantity
    * User enters "<customerName>" to customer name
    * User enters "<street>" to street
    * User enters "<city>" to city
    * User enters "<state>" to state
    * User enters "<zip>" to zip
    * User selects "<cardType>" as card type
    * User enters "<cardNumber>" to card number
    * User enters "<expirationDate>" to expiration date
    * User clicks process button
    Then User should see "<expectedName>" in the list
    Examples:
      | productType | quantity | customerName   | street      | city        | state | zip    | cardType        | cardNumber       | expirationDate | expectedName   |
      | FamilyAlbum | 1        | Donald Trump   | Kinzie Ave  | Chicago     | IL    | 60056  | Visa            | 1111222233334444 | 12/22          | Donald Trump   |
      | MyMoney     | 4        | Kim Kardashian | State St    | Los Angeles | IL    | 123005 | MasterCard      | 1111222233336666 | 03/24          | Kim Kardashian |
      | ScreenSaver | 5        | Mariah Carey   | Michigan St | New York    | IL    | 450333 | American Express | 1111222233335555 | 12/26          | Mariah Carey   |

