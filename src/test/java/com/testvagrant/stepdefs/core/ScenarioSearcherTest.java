package com.testvagrant.stepdefs.core;

import org.junit.Test;

import static com.testvagrant.stepdefs.core.feature.ScenarioSearcher.scenario;

public class ScenarioSearcherTest {

    @Test
    public void scenarioFinderTest() {
        scenario("i login as mr x").readSteps();
    }
}
