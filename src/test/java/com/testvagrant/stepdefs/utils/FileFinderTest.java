package com.testvagrant.stepdefs.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static com.testvagrant.stepdefs.utils.FileFinder.fileFinder;

public class FileFinderTest {

    @Test
    public void fileFinderTestWithPath() {
        List<File> files = fileFinder("src/test/resources").find(FileExtension.FEATURE);
        Assert.assertEquals(4, files.size());
    }

    @Test
    public void fileFinderTestWithName() {
        File file = fileFinder().find("A", FileExtension.FEATURE);
        Assert.assertEquals("A.feature", file.getName());
    }

    @Test
    public void fileFinderTestWithPath1() {
        List<File> files = fileFinder().find(FileExtension.FEATURE);
        Assert.assertEquals(9, files.size());
    }
}
