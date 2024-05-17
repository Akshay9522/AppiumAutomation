package com.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="resources",
		glue="stepdefinations",
		monochrome=true,
		//dryRun=true,
		tags="@Testt",
		plugin= {"pretty","json:target/cucumber.json"}
		)
public class TestRunner {

}
