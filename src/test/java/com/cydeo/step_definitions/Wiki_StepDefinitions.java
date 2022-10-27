package com.cydeo.step_definitions;

import com.cydeo.pages.WikiPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Wiki_StepDefinitions {

    WikiPage wikiPage = new WikiPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchKeyword) {
        wikiPage.getSearchbox().sendKeys(searchKeyword);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.getSearchBtn().click();
    }

    @Then("User should see {string} in wiki title")
    public void user_should_see_is_in_the_wiki_title(String searchKeyword) {
        BrowserUtils.verifyTitleContains(searchKeyword);
    }
}
