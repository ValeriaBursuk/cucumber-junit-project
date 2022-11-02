package com.cydeo.step_definitions;

import com.cydeo.pages.SmartBear_OrderPage;
import com.cydeo.pages.SmartBear_CommonPage;
import com.cydeo.pages.Smartbear_ListOfAllOrdersPage;
import com.cydeo.pages.Smartbear_LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class SmartBear_StepDefinitions {

    Smartbear_LoginPage smartbear_loginPage = new Smartbear_LoginPage();
    SmartBear_CommonPage smartBear_commonPage = new SmartBear_CommonPage();
    SmartBear_OrderPage smartBear_orderPage = new SmartBear_OrderPage();
    Smartbear_ListOfAllOrdersPage smartbear_listOfAllOrdersPage = new Smartbear_ListOfAllOrdersPage();

    @Given("User is logged into SmartBear Tester account")
    public void user_is_logged_into_smart_bear_tester_account() {
        smartbear_loginPage.goTo();
        //   Assert.assertTrue(smartbear_loginPage.isAtLoginPage());
        smartbear_loginPage.login(ConfigReader.getProperty("smartbear_login"), ConfigReader.getProperty("smartbear_password"));
    }

    @When("User goes to {string} page")
    public void user_goes_to_page(String tabName) {
        //  Assert.assertTrue(smartBear_commonPage.isUserNameDisplayed());
        smartBear_commonPage.orderTab.click();
    }

    @When("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String productType) {
        Select select = new Select(smartBear_orderPage.product);
        select.selectByValue(productType);
    }


    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String quantity) {
        smartBear_orderPage.quantity.clear();
        //
        smartBear_orderPage.quantity.sendKeys(quantity);
    }

    @When("User enters {string} to customer name")
    public void user_enters_to_customer_name(String customerName) {
        smartBear_orderPage.name.sendKeys(customerName);
    }

    @When("User enters {string} to street")
    public void user_enters_to_street(String street) {
        smartBear_orderPage.street.sendKeys(street);
    }

    @When("User enters {string} to city")
    public void user_enters_to_city(String city) {
        smartBear_orderPage.city.sendKeys(city);
    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String state) {
        smartBear_orderPage.state.sendKeys(state);
    }

    @When("User enters {string} to zip")
    public void user_enters_to_zip(String zip) {
        smartBear_orderPage.zip.sendKeys(zip);
    }

    @When("User selects {string} as card type")
    public void user_selects_as_card_type(String cardType) {
        smartBear_orderPage.selectCardType(cardType);
    }

    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) {
        smartBear_orderPage.cardNumber.sendKeys(cardNumber);
    }

    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String expirationDate) {
        smartBear_orderPage.expiration.sendKeys(expirationDate);
    }

    @When("User clicks process button")
    public void user_clicks_process_button() {
        smartBear_orderPage.processButton.click();
        BrowserUtils.sleep(5);
//       BrowserUtils.waitForVisibilityOf(smartBear_orderPage.successNotification);
    }

    @Then("User should see {string} in the list")
    public void user_should_see_in_the_list(String expectedName) {
        smartBear_commonPage.viewAllOrdersTab.click();
        BrowserUtils.sleep(5);
        BrowserUtils.waitForVisibilityOf(smartbear_listOfAllOrdersPage.actualNameInTable);
        String actualName = smartbear_listOfAllOrdersPage.actualNameInTable.getText();
        Assert.assertEquals("Name is not on the list", expectedName, actualName);
    }
}
