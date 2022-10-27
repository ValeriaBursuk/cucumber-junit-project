package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EatingCucumber_StepDefinitions {

    @Given("{word} is hungry")
    public void somebody_is_hungry(String name) {
        System.out.println("This is from @GIVEN " + name + " is hungry");
    }
    @When("he eats {int} cucumbers")
    public void he_eats_cucumbers(Integer quantity) {
        System.out.println("This is from @WHEN he eats  " + quantity + " cucumbers");
    }
    @Then("he will be full")
    public void he_will_be_full() {
        System.out.println("This is from @THEN he will be full");
    }

    @Then("he will be too full")
    public void he_will_be_too_full() {
        System.out.println("he will be too full steps");
    }

}
