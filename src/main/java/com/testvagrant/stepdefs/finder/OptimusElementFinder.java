package com.testvagrant.stepdefs.finder;

import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.optimus.identifier.*;
import com.testvagrant.optimus.parser.OptimusConfigParser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.testvagrant.optimus.utils.JsonUtil.getAppJson;
import static com.testvagrant.stepdefs.finder.ElementStore.elementStore;

public class OptimusElementFinder {
    private AppiumDriver driver;
    private Map<String, ElementIdentifier> identifierMap = new HashMap<>();

    private OptimusElementFinder(AppiumDriver driver) {
        this.driver = driver;
        identifierMap.put("id", new IdIdentifier());
        identifierMap.put("xpath", new XpathIdentifier());
        identifierMap.put("className", new ClassNameIdentifier());
        identifierMap.put("css", new CssIdentifier());
        identifierMap.put("linkText", new LinkIdentifier());
        identifierMap.put("partialLinkText", new PartialLinkIdentifier());
    }

    public static OptimusElementFinder optimusElementFinder(AppiumDriver driver) {
        return new OptimusElementFinder(driver);
    }


    public WebElement findWebElement(String appConsumer, String screenName, String fieldName) throws OptimusException, IOException {
        Element appElement = getAppElement(appConsumer, screenName, fieldName);
        By locator = getLocatorType(appElement);
        new WaitControl(driver).waitFor(appElement.getWaitFor(), locator);
        return driver.findElement(locator);
    }

    public By findBy(String appConsumer, String screenName, String fieldName) throws OptimusException, IOException {
        Element appElement = getAppElement(appConsumer, screenName, fieldName);
        return getLocatorType(appElement);
    }

    public Element getAppElement(String appConsumer, String screenName, String fieldName) throws OptimusException, IOException {
        String testFeed = System.getProperty("testFeed") + ".json";
        System.out.println("TestFEED==" + testFeed);
        String appJson = getAppJson(testFeed);
        String appName = new OptimusConfigParser(appJson).getAppBelongingTo(appConsumer);
        return elementStore(appName).read(screenName).find(fieldName);
    }

    private By getLocatorType(Element appElement) {
        return identifierMap.get(appElement.getIdentifier()).getLocator(appElement.getValue());
    }


}
