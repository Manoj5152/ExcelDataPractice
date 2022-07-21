package runnerfile;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "Featurefile/Contactus.feature",
				glue = "stepdefinition",
				dryRun = false,
				monochrome = true,
				plugin = {"pretty:target/cucumber-pretty.txt",
						"html:output/test-output.html",
						"json:target/cucumber-reports/Cucumber.json",
						"junit:target/cucumber-reports/Cucumber.xml",
						"timeline:test-output-thread/"
						})


public class Testrunnerfile extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
