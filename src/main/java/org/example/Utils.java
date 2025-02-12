package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static WorkMode readFlags(String[] args) {
        String outputPath = "";
        String prefix = "";
        boolean appendMode = false;
        boolean statistic = false;
        boolean fullStatistic = false;

        List<String> arguments = Arrays.asList(args);

        for (int i = 0; i < arguments.size(); i++) {
            String arg = arguments.get(i);

            switch (arg) {
                case "-a":
                    appendMode = true;
                    break;
                case "-s":
                    statistic = true;
                    break;
                case "-f":
                    fullStatistic = true;
                    break;
                case "-p":

                    if (i + 1 < arguments.size()) {
                        prefix = arguments.get(i + 1);
                        i++;
                    }
                    break;
                case "-o":
                    if (i + 1 < arguments.size()) {
                        outputPath = arguments.get(i + 1);
                        i++;
                    }
                    break;
                default:

                    if (arg.startsWith("-")) {
                        System.out.println("Неизвестный флаг: " + arg);
                    }
                    break;
            }
        }

        return new WorkMode(outputPath, prefix, appendMode, statistic, fullStatistic);
    }


    public static List<String> getInputFilesList(String[] args) {
        List<String> inputFiles = new ArrayList<>();

        int fileStartIndex = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (args[i].equals("-o") || args[i].equals("-p")) {
                    i++;
                }
            } else {

                fileStartIndex = i;
                break;
            }
        }
        for (int i = fileStartIndex; i < args.length; i++) {
            inputFiles.add(args[i]);
        }
        return inputFiles;
    }

    static List<String> readFromInput(List<String> inputFiles) {
        List<String> fileContents = new ArrayList<>();
        for (String arg : inputFiles) {
            try {

                List<String> lines = Files.readAllLines(Paths.get(arg));
                fileContents.addAll(lines);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileContents;
    }

    public static void writeListToFile(List<String> list, String outputDir, String prefix, String fileName,
                                       boolean isAppendMode) {
        if (list.isEmpty()) {
            return;
        }

        boolean useCurrentDir = outputDir == null || outputDir.trim().isEmpty();
        String fullFileName;
        if (!useCurrentDir) {

            File directory = new File(outputDir);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Директория создана: " + outputDir);
                } else {
                    System.err.println("Ошибка при создании директории: " + outputDir);
                    return;
                }
            }

            fullFileName = Paths.get(outputDir, prefix + fileName).toString();
        } else {

            fullFileName = prefix + fileName;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullFileName, isAppendMode))) {
            for (String line : list) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Файл сохранен: " + fullFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + fullFileName);
            e.printStackTrace();
        }
    }

    static boolean isFloat(String currentString) {
        try {
            Double.parseDouble(currentString);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    static boolean isInteger(String currentString) {
        if (currentString.isEmpty()) {
            return false;
        }
        for (char c : currentString.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static void sort(List<String> fileContents, List<String> integers, List<String> floats, List<String> strings) {
        for (String line : fileContents) {
            if (isInteger(line)) {
                integers.add(line);
            } else if (isFloat(line)) {
                floats.add(line);
            } else {
                strings.add(line);
            }
        }
    }

}
