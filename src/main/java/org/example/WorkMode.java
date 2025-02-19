package org.example;

public class WorkMode {
    private String outputPath;
    private String prefix;
    private boolean appendMode;
    private boolean statistic;
    private boolean fullStatistic;

    public WorkMode(String outputPath, String prefix, boolean appendMode, boolean statistic, boolean fullStatistic) {
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.appendMode = appendMode;
        this.statistic = statistic;
        this.fullStatistic = fullStatistic;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public boolean isStatistic() {
        return statistic;
    }

    public boolean isFullStatistic() {
        return fullStatistic;
    }
}
