package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"org.MG.stepdefs", "appHooks"},
        plugin = {"pretty",
                "rerun:target/rerun.txt"
        },
        monochrome = true,
        publish = true)
public class TestRunner {

//    @Override
//    @DataProvider(parallel = true)
//    public Object [][] scenarios(){
//        return super.scenarios();
//    }
}
