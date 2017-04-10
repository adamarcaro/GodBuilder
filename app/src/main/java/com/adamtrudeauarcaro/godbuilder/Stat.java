package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-03-08.
 */

public class Stat {

    private String statLabel, statValue;

    public Stat(String statLabel, String statValue) {
        this.statLabel = statLabel;
        this.statValue = statValue;
    }

    public String getStatLabel() {
        return statLabel;
    }

    public void setStatLabel(String statLabel) {
        this.statLabel = statLabel;
    }

    public String getStatValue() {
        return statValue;
    }

    public void setStatValue(String statValue) {
        this.statValue = statValue;
    }
}