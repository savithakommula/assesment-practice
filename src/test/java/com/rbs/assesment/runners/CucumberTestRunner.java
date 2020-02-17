package com.rbs.assesment.runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/rbs/assesment/features"},
        glue="com.rbs.assesment.stepdefs",
        tags= {"@tag1, @tag2"},
        format = {"pretty", "html:test-output/Destination", "json:test-output/Destination/cucmber.json"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:test-output/cucumber-reports/report.html"}
       
        )

public class CucumberTestRunner{
	
	@AfterClass
	public static void setUp() {
		String path = new File("src/test/resources/extent-config.xml").getAbsolutePath();
		Reporter.loadXMLConfig(path);
	}
}

