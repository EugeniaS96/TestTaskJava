package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Statistic.*;
import static org.example.Utils.sort;
import static org.example.Utils.writeListToFile;

public class StringHandler {

    static void processStrings(List<String> fileContents, WorkMode workMode) {
        List<String> integers = new ArrayList<>();
        List<String> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        sort(fileContents, integers, floats, strings);

        collectAndPrintStatistic(workMode, integers, floats, strings);

        writeListToFile(integers, workMode.getOutputPath(), workMode.getPrefix(),
                OutputFileTypes.INTEGER.getFileName(), workMode.isAppendMode());
        writeListToFile(floats, workMode.getOutputPath(), workMode.getPrefix(),
                OutputFileTypes.FLOAT.getFileName(), workMode.isAppendMode());
        writeListToFile(strings, workMode.getOutputPath(), workMode.getPrefix(),
                OutputFileTypes.STRING.getFileName(), workMode.isAppendMode());


    }
}
