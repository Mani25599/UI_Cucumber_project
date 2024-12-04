package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "com.cucumber.step_def",dryRun = false,monochrome = true,
plugin= {"rerun:Failedtest/failed_scenario.txt","json:Reports/cucumber-report/report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunnerStepDef {

}
