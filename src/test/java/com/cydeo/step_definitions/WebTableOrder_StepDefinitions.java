package com.cydeo.step_definitions;

import com.cydeo.pages.WebTable_LoginPage;
import com.cydeo.pages.WebTable_OrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableOrder_StepDefinitions {

    WebTable_OrderPage webTable_orderPage = new WebTable_OrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigReader.getProperty("webtables_url"));
        new WebTable_LoginPage().login(ConfigReader.getProperty("webtables_username"), ConfigReader.getProperty("webtables_password"));
        webTable_orderPage.orderSideBar.click();
    }

    @When("user selects productType {string}")
    public void user_selects_product_type(String productType) {
        webTable_orderPage.selectProduct(productType);
    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer quantity) {
        webTable_orderPage.quantity.sendKeys(String.valueOf(quantity));
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
        webTable_orderPage.customerName.sendKeys(customerName);
    }

    @When("user enters street {string}")
    public void user_enters_street(String street) {
        webTable_orderPage.street.sendKeys(street);
    }

    @When("user enters city {string}")
    public void user_enters_city(String city) {
        webTable_orderPage.city.sendKeys(city);

    }

    @When("user enters state {string}")
    public void user_enters_state(String state) {
        webTable_orderPage.state.sendKeys(state);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String zipcode) {
        webTable_orderPage.zipcode.sendKeys(zipcode);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String creditCardType) {
        webTable_orderPage.selectCreditCardType(creditCardType);
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String creditCardNumber) {
        webTable_orderPage.creditCardNumber.sendKeys(creditCardNumber);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String expiratioDate) {
        webTable_orderPage.expirationDate.sendKeys(expiratioDate);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webTable_orderPage.processOrderBtn.click();
        BrowserUtils.sleep(5);
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        webTable_orderPage.allOrdersSideBar.click();
        WebElement tdElement = Driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(tdElement));
        String tdElementText = tdElement.getText();
        Assert.assertEquals(expectedName, tdElementText);

    }
}
