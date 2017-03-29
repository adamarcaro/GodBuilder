package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-02-11.
 */

//Class to define one God entry

public class God {

    private String name;
    private int image;
    private String pantheon;
    private int pantheonIcon;
    private String type;
    private int typeIcon;

    public God(String name, int image, String pantheon, int pantheonIcon, String type, int typeIcon) {
        this.name = name;
        this.image = image;
        this.pantheon = pantheon;
        this.pantheonIcon = pantheonIcon;
        this.type = type;
        this.typeIcon = typeIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPantheon() {
        return pantheon;
    }

    public void setPantheon(String pantheon) {
        this.pantheon = pantheon;
    }

    public int getPantheonIcon() {
        return pantheonIcon;
    }

    public void setPantheonIcon(int pantheonIcon) {
        this.pantheonIcon = pantheonIcon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(int typeIcon) {
        this.typeIcon = typeIcon;
    }
}