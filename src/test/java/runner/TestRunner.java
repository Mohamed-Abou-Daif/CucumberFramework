package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/parallel"},
        glue = { "org.MG.parallel"},
        plugin = {"pretty"
        },
        monochrome = true,
        publish = true)
public class TestRunner{

}
