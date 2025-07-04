package org.example;

import java.util.List;

import static org.example.StringHandler.processStrings;
import static org.example.Utils.*;

public class Main {
    public static void main(String[] args) {
        WorkMode workMode = readFlags(args);
        List<String> inputFiles = getInputFilesList(args);
        List<String> fileContents = readFromInput(inputFiles);
        processStrings(fileContents, workMode);
    }
}