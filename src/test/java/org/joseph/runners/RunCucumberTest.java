package org.joseph.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/reports.html",
        features = "src/resources/features",
        glue = "org/joseph/stepDefinitions",
        tags = ""
)
public class RunCucumberTest {
}
