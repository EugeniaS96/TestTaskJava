package org.example;
public enum OutputFileTypes {
    INTEGER("integers.txt"),
    FLOAT("floats.txt"),
    STRING("strings.txt");

    private final String fileName;

    OutputFileTypes(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}