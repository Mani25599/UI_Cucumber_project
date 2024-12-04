package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@Failedtest/failed_scenario.txt",glue = "com.cucumber.step_def",dryRun = false,monochrome = true)
public class ReRunnerStepDef {

}
