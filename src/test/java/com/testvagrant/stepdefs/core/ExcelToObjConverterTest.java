package com.testvagrant.stepdefs.core;

import com.testvagrant.stepdefs.exceptions.SheetNotFoundException;
import com.testvagrant.stepdefs.finder.App;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.testvagrant.stepdefs.utils.ExcelToObjectConverter.converter;


public class ExcelToObjConverterTest {

    @Test
    public void excelToObjTest() throws IOException, SheetNotFoundException {
        App convert = converter("Scripbox").withExtension(".xls").convert("home");
        Assert.assertEquals(99,convert.getElements().size());
    }
}
