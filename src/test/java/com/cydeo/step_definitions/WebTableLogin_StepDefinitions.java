package com.cydeo.step_definitions;

import com.cydeo.pages.WebTable_LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class WebTableLogin_StepDefinitions {

WebTable_LoginPage webTable_page = new WebTable_LoginPage();

    @Given("User is on homepage")
    public void user_is_on_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("webtables_url"));
    }

    @When("User enters valid credentials and clicks login button")
    public void user_enters_valid_credentials_and_clicks_login_button(Map<String, String> credentials) {
        webTable_page.login(credentials.get("username"), credentials.get("password"));
    }

    @Then("Expected URL should end with {string}")
    public void expected_url_should_end_with(String expectedUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertTrue("Url verification failed", actualUrl.endsWith(expectedUrl));
    }

}
