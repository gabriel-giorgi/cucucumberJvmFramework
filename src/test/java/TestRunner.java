import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ggiorgi on 5/9/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/features",
        tags = "@runOnly",
        glue= "steps",
        plugin = {"html:target/cucumber-html-report","json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml"})

public class TestRunner {

}
