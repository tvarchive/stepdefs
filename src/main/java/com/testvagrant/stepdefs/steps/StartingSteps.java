package com.testvagrant.stepdefs.steps;

import com.testvagrant.commons.entities.SmartBOT;
import com.testvagrant.optimus.device.OptimusController;
import com.testvagrant.optimus.utils.JsonUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.util.List;


public class StartingSteps extends BaseSteps {


    @Before
    public void setUp(Scenario scenario) throws Exception {
        String testFeed = System.getProperty("testFeed") + ".json";
        System.out.println("file name -- " + testFeed);
        controller = new OptimusController(new JsonUtil().getAppJson(testFeed), scenario);
        smartBOTs = controller.registerSmartBOTs();
        optimus = new OptimusImpl(having(smartBOTs));
//        pageBank = new PageBank();
    }


    private List<SmartBOT> having(List<SmartBOT> smartBOTs) {
        return smartBOTs;
    }


    @After
    public void e2eTearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] failedScreens = optimus.getScreenCapture();
            scenario.embed(failedScreens, "image/png");
        }
        controller.deRegisterSmartBOTs(smartBOTs);
    }


}
