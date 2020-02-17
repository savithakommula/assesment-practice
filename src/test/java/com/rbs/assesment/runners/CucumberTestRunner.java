package com.rbs.assesment.runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/rbs/assesment/features",
        glue={"com.rbs.assesment.stepdefs"},
        tags= {"@tag1"}
        )

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
	
}

