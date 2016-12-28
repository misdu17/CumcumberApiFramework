package runner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/token/", 
		dryRun = false, 
		glue = "step.definations", 
		tags = "@regression, @sanity", 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter"})
// use tags for custom test run only, Example: `tags = "@regression, @sanity"`
public class TestRunner {
	@BeforeClass
    public static void setup() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();

        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }


}
