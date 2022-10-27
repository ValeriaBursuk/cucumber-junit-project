package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features = "src/test/resources/features" , //FEATURES PATH copy CONTENT ROOT
        glue = "com/cydeo/step_definitions", //glue - STEP DEFINITIONS PATH copy SOURCE ROOT --> runs hooks first
        //dryRun = false, - default value is false - redundant
        //dryRun = true - returns snippets,
        //if no tags - runs everything
        tags = "@google" //"@eating-cucumber"
)

public class CukesRunner {
    //run from CukesRunner
}
