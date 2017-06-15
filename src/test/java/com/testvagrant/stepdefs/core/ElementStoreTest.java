package com.testvagrant.stepdefs.core;


import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.stepdefs.finder.Element;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import static com.testvagrant.stepdefs.finder.ElementStore.elementStore;

public class ElementStoreTest {

    @Test
    public void eleStoreTest() throws OptimusException {
        Element element = elementStore("scripbox.apk").read("Test1").find("letsGetStarted");
        Element element1 = elementStore("scripbox.apk").read("test1").find("savingSlider");
        Assert.assertEquals("letsGetStarted",element.getName());
        Assert.assertEquals("seekBar",element1.getName());
    }


    @Test
    public void screenNameTest() {
        String screenName = "menu";
        System.out.println(StringUtils.swapCase(screenName));
        Assert.assertEquals("Menu",StringUtils.capitalize(screenName));
    }
}
