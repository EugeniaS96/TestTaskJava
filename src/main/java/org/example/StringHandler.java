package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Statistic.*;
import static org.example.Utils.*;

public class StringHandler {

    static void processStrings(List<String> fileContents, WorkMode workMode) {
        List<String> integers = new ArrayList<>();
        List<String> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        sortIntoFiles(fileContents, integers, floats, strings);

        collectAndPrintStatistic(workMode, integers, floats, strings);

        writeListToFile(integers, workMode, OutputFileTypes.INTEGER.getFileName());
        writeListToFile(floats, workMode, OutputFileTypes.FLOAT.getFileName());
        writeListToFile(strings, workMode, OutputFileTypes.STRING.getFileName());
    }
}
