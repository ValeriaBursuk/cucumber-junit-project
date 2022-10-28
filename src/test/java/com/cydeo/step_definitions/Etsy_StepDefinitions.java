package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Etsy_StepDefinitions {

    EtsyPage etsyPage = new EtsyPage();

    @Given("user is on Etsy homepage")
    public void user_is_on_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
//        BrowserUtils.verifyTitle("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
        BrowserUtils.verifyTitleContains("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
    }

    @When("user types Wooden Spoon in search box")
    public void user_types_wooden_spoon_in_search_box() {
        etsyPage.getSearchBox().sendKeys("Wooden Spoon");
    }

    @When("user clicks search button")
    public void user_clicks_search_button() {
        etsyPage.getSearchButton().click();
    }

    @Then("user should see Wooden Spoon in the title")
    public void user_should_see_wooden_spoon_in_the_title() {
        BrowserUtils.verifyTitleContains("Wooden spoon");
    }

    @When("user types {string} in search box")
    public void user_types_in_search_box(String keyword) {
        etsyPage.getSearchBox().sendKeys(keyword);
    }

    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String keyword) {
        BrowserUtils.verifyTitleContains(keyword);
    }
}


