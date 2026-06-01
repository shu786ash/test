package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
features = "classpath/features",
glue ="StepDefinition",
tags = "@Smoke",
plugin = {

"pretty",

"html:target/cucumber-report.html",

"json:target/cucumber.json",

"junit:target/cucumber.xml"
},
//monochrome = true,
//
publish = false
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
