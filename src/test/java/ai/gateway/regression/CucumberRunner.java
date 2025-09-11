package ai.gateway.regression;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", plugin = {"pretty", "html:target/cucumber-reports.html"},
        glue = {"ai.gateway.regression.glue"})
public class CucumberRunner {
}