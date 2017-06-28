package com.testvagrant.stepdefs.core.feature;


import com.testvagrant.stepdefs.entities.Step;
import com.testvagrant.stepdefs.utils.FileExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.testvagrant.stepdefs.utils.FileFinder.fileFinder;

public class ScenarioSearcher {

    private String scenarioId;
    private ScenarioSearcher(String scenarioId) {
        this.scenarioId  = scenarioId;
    }

    public static ScenarioSearcher scenario(String scenarioId) {
        return new ScenarioSearcher(scenarioId);
    }

    public List<Step> readSteps() {
        List<File> features = getFeatures();
        features.forEach(feature -> {
            try {
                List<String> content = getFileContent(feature);
                List<String> collect = content.stream().filter(line -> line.trim().equalsIgnoreCase(scenarioId)).collect(Collectors.toList());
                System.out.println(collect);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return new ArrayList<>();
    }


    private List<File> getFeatures() {
       return fileFinder(System.getProperty("user.dir")+"/src/test/resources").find(FileExtension.FEATURE);
    }

    private List<String> getFileContent(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
