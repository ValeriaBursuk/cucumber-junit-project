package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        System.out.println("User is on the homepage");
    }

    @When("Librarian enters valid username and valid password")
    public void librarianEntersValidUsernameAndValidPassword() {
        System.out.println("Librarian enters valid username and valid password");
    }

    @When("Admin enters valid username and valid password")
    public void adminEntersValidUsernameAndValidPassword() {
        System.out.println("Admin enters valid username and valid password");
    }


    @Then("Dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        System.out.println("Dashboard should be displayed");
    }

    @When("Student enters valid username and valid password")
    public void studentEntersValidUsernameAndValidPassword() {
        System.out.println("Student enters valid username and valid password");
    }

    @And("User clicks Login button")
    public void userClicksLoginButton() {
        System.out.println("User clicks Login button");
    }
}
