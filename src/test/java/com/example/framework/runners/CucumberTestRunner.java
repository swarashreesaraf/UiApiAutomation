package com.example.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.framework.steps", "com.example.framework.hooks"},
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
        monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
