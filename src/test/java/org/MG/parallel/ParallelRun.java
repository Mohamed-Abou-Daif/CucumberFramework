package org.MG.parallel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty",
                "timeline:test-output-thread/",
                "rerun:target/failedrun.txt",
                "html:target/CumcumberReport/CumcumberReport.html"
        },
        tags = "not @Skip",
        monochrome = true,
        glue = { "org.MG.parallel" },
        features = { "src/test/resources/parallel" }
)

public class ParallelRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
