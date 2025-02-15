package org.example;

import java.util.List;

import static org.example.StringHandler.processStrings;
import static org.example.Utils.*;

public class Main {
    public static void main(String[] args) {
        WorkMode workMode = readFlags(args);//читаем флаги
        List<String> inputFiles = getInputFilesList(args);//получаем файлы in1 in2
        List<String> fileContents = readFromInput(inputFiles);//получаем содержимое файлов in1 in2
        processStrings(fileContents, workMode);//обрабатываем содержимое полученных файлов
    }
}