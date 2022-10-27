package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

        if(scenario.isFailed()){
            byte[]screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

    }
}
