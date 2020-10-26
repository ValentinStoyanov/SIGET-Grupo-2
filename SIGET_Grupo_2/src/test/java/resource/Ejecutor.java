package resource;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.*;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/features/escenario.feature" 
		,glue="pasos"
		, plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
		)

	public class Ejecutor extends AbstractTestNGCucumberTests{
		
	}
