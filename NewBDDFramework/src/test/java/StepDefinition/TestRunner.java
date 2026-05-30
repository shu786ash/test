package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

features = "src/test/resources/features",

glue = "StepDefinition",

plugin = {

"pretty",

"html:target/cucumber-report.html",

"json:target/cucumber.json",

"junit:target/cucumber.xml"
},

//monochrome = true,

publish = true
)

public class TestRunner {

}