package runner;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.ConfigReader;


//@ExtendWith(ReportPortalExtension.class)
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepdefinitions"},
        plugin = {"pretty","junit:target/junitreport.xml","json:target/jsonreport.json","html:target/cucumber-reports",
        		 "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "rerun:target/rerun.txt"  },
        tags="@UI"
        		// Save Failed test scenarios in rerun.txt file}
        
)
public class TestRunner {

	  @AfterClass
      public static void generateEnvironmentProperties() throws IOException {
              FileOutputStream fos = new FileOutputStream("target/results/allure-results/environment.properties");
              Properties properties = new Properties();
              properties.put("Browser", ConfigReader.getProperty("browser"));
//              properties.put("Browser.version", "12");
              properties.put("Stand", "Test");
              properties.store(fos, "Allure Environment Properties");
              fos.flush();
              fos.close();
      }
	 
}

