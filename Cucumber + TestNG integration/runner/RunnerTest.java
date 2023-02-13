package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/DemoLoginPageFlow.feature",glue="steps")
public class RunnerTest extends AbstractTestNGCucumberTests 
{
   
}
