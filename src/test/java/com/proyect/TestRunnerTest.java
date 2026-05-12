package com.proyect;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "com.proyect")
@ConfigurationParameter(
    key = io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class TestRunnerTest {

}