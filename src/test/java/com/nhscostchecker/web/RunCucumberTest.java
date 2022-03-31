package com.nhscostchecker.web;

import com.nhscostchecker.web.helper.DriverProvider;
import com.nhscostchecker.web.helper.PropertiesProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.io.IOException;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/nhscostchecker/web")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {
    private DriverProvider driverProvider;
    private PropertiesProvider propertiesProvider;
    @Before
    public void before(Scenario scenario) throws IOException {
        propertiesProvider = new PropertiesProvider();
        propertiesProvider.loadProperties();

        driverProvider = new DriverProvider();
        driverProvider.initDriver();
    }


    @After
    public void after(Scenario scenario) {
        driverProvider.getDriver().quit();
    }


}


