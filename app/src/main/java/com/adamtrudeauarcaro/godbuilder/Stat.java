package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-03-08.
 */

public class Stat {

    private String statLabel, statValue;
    private Boolean capped;

    public Stat(String statLabel, String statValue, Boolean capped) {
        this.statLabel = statLabel;
        this.statValue = statValue;
        this.capped = capped;
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

    public Boolean getCapped() {
        return capped;
    }

    public void setCapped(Boolean capped) {
        this.capped = capped;
    }
}