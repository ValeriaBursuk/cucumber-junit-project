package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("User is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigReader.getProperty("google.url"));
    }

    @When("User types apple in google search box and hits Enter")
    public void user_types_in_google_search_box() {
      googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }


    @Then("User should see apple – Google Search in google title")
    public void userShouldSeeWordGoogleSearchInGoogleTitle() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple - Google Search";
        Assert.assertEquals("Title verification is failed", expectedTitle, actualTitle);
    }

    @When("User types {string} in google search box and hits Enter")
    public void userTypesInGoogleSearchBoxAndHitsEnter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }

    @Then("User should see {string} in google title")
    public void userShouldSeeInGoogleTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title Verification Failed", actualTitle.contains(expectedTitle));

    }
}
