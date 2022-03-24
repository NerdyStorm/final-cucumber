package com.techfios.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Features/",
glue = "com.techfios.steps",
 tags = {"@Regression"},
monochrome = true,
dryRun = false,
plugin = {
    "pretty",
    "html:target/cucumber",
    "json:target/cucumber.json"
})


public class TestRunner {



}
