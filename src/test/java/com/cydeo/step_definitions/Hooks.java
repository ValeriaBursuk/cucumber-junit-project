package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
//for all step definitions before everything

    @Before
    public void setupScenario(Scenario scenario) {
        System.out.println("----@Before each scenario----setting up browser------");
        System.out.println("Scenario name: " + scenario.getName());
    }


    @After
    public void tearDownScenario(Scenario scenario){
        System.out.println("---@After each scenario----closing browser------");
        Driver.closeDriver();
        System.out.println("Scenario failed? " + scenario.isFailed());
        //taking a screenshot after each scenario
    }




   // @BeforeStep
//    @Before(value = "@login")
//    public void setupLogin() {
//        System.out.println("value = @login - to run before any specific feature/scenario");
//    }
    //@Before (value = "@db", order = 3)
    //public void setupDataBaseScenario(){
//}


}
