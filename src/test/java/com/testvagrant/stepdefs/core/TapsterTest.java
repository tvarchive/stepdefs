package com.testvagrant.stepdefs.core;


import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;

import static com.testvagrant.stepdefs.core.Tapster.tapster;

public class TapsterTest {

    @Test
    public void test() {
        Integer integer = Integer.valueOf("1000", 2);
        System.out.println(integer);
    }
}
