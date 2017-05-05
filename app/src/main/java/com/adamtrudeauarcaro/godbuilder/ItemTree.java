package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-04-10.
 */

import java.util.ArrayList;

public class ItemTree {

    private int image;
    private String name;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public ItemTree(int image, String name, ArrayList<Item> itemList) {
        this.image = image;
        this.name = name;
        this.itemList = itemList;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
