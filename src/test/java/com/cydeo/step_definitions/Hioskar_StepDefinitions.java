package com.cydeo.step_definitions;

import com.cydeo.pages.HioskarPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class Hioskar_StepDefinitions {

    HioskarPage hioskarPage = new HioskarPage();

    @Given("user is on homepage and user clicks {string}")
    public void user_is_on_homepage_and_user_clicks(String category) {
        Driver.getDriver().get("https://www.hioscar.com/care-options");
        hioskarPage.clickCategory(category);
    }

    @When("and Selects {string} year for Coverage year")
    public void and_selects_year_for_coverage_year(String year) {
        hioskarPage.dropdowns.get(0).click();
        BrowserUtils.sleep(1);
        hioskarPage.selectAnything(year);
    }

    @When("From Coverage access dropdown Selects {string} option")
    public void from_coverage_access_dropdown_selects_option(String coverage) {
        hioskarPage.dropdowns.get(1).click();
        BrowserUtils.sleep(1);
        hioskarPage.selectAnything(coverage);
    }
    @When("From Network partner dropdown Select {string} option")
    public void from_network_partner_dropdown_select_option(String network) {
        hioskarPage.dropdowns.get(2).click();
        BrowserUtils.sleep(1);
        hioskarPage.selectAnything(network);

    }
    @When("From Coverage area dropdown Select {string}")
    public void from_coverage_area_dropdown_select(String city) {
        hioskarPage.dropdowns.get(3).click();
        BrowserUtils.sleep(1);
        hioskarPage.selectAnything(city);
    }

    @When("Clicks Continue button")
    public void clicks_continue_button() {
        hioskarPage.continueBtn.click();
    }

    @Then("Verify title contains {string}")
    public void verify_title_contains(String expectedTitle) {
        BrowserUtils.verifyTitleContains(expectedTitle);


    }
}
