package com.testvagrant.stepdefs.finder;

import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.commons.parser.ConfigParser;
import com.testvagrant.commons.utils.JsonUtil;
import com.testvagrant.stepdefs.identifier.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        return getElement(locator);
    }

    public By findBy(String appConsumer, String screenName, String fieldName) throws OptimusException, IOException {
        Element appElement = getAppElement(appConsumer, screenName, fieldName);
        return getLocatorType(appElement);
    }

    public Element getAppElement(String appConsumer, String screenName, String fieldName) throws OptimusException, IOException {
        String testFeed = System.getProperty("testFeed") + ".json";
        System.out.println("TestFEED==" + testFeed);
        String appJson = new JsonUtil().getAppJson(testFeed);
        String appName = new ConfigParser(appJson).getAppBelongingTo(appConsumer);
        return elementStore(appName).read(screenName).find(fieldName);
    }

    private By getLocatorType(Element appElement) {
        return identifierMap.get(appElement.getIdentifier()).getLocator(appElement.getValue());
    }


    private WebElement getElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (WebDriverException e) {
            Thread.currentThread().interrupt();
            return driver.findElement(locator);
        }
    }


}
