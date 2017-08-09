package com.testvagrant.stepdefs.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SelectHelper extends ActionHelper {

    private WebDriver driver;
    private WebElement element;
    private String words[] = {"Select", "select", "select from below", "Select From Below"};

    private SelectHelper(WebDriver driver) {
        super(driver);
    }

    public static SelectHelper selectHelper(WebDriver driver) {
        return new SelectHelper(driver);
    }

    public SelectHelper onElement(WebElement element) {
        this.element = element;
        return this;
    }

    public void selectText(String value) {
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        element.click();

        int flag = 0;
        Select dropdown = new Select(element);
        for (String s : words) {
            if (s.contains(dropdown.getOptions().get(0).getText())) {
                await().atMost(20, SECONDS).until(() -> dropdown.getOptions().size() > 1);
                flag = 1;
            }
        }
        if (flag == 0)
            await().atMost(20, SECONDS).until(() -> dropdown.getOptions().size() >= 1);
        selectBasedOnCategory(dropdown, value);
    }

    private void selectBasedOnCategory(Select selectElement, String value) {
        int flag = 0;
        List<WebElement> allOptions = selectElement.getOptions();
        for (WebElement w : allOptions) {
            if (w.getText().equals(value)) {
                selectElement.selectByVisibleText(value);
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
                selectElement.selectByIndex(Integer.parseInt(value));
        }
    }
}
