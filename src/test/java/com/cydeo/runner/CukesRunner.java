package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html", //can write whatever instead of cucumber-report
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features" , //FEATURES PATH copy CONTENT ROOT
        glue = "com/cydeo/step_definitions",//glue - STEP DEFINITIONS PATH copy SOURCE ROOT --> runs hooks first
        //dryRun = true,//- returns snippets,
        tags = "@smoke" //if no tags - runs everything
)

public class CukesRunner {
    //run here
}
