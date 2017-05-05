package com.adamtrudeauarcaro.godbuilder;

import java.io.Serializable;

/**
 * Created by adama on 2017-02-11.
 */

//Class to define one God entry

public class God {

    private String name;
    private String title;

    private String nameString;
    private int image;
    private String pantheon;
    private int pantheonIcon;
    private String className;
    private int classIcon;
    private char type;

    private int health, mana, damage, protMag, protPhys;
    private double hp5, mp5, attackSpeed, speed;
    private Boolean fav;

    public God(String name, String title, String nameString, int image, String pantheon, int pantheonIcon, String className, int classIcon, char type,
               int health, int mana, int damage, int protPhys, int protMag, double speed,
               double hp5, double mp5, double attackSpeed) {
        this.name = name;
        this.title = title;

        this.nameString = nameString;
        this.image = image;
        this.pantheon = pantheon;
        this.pantheonIcon = pantheonIcon;
        this.className = className;
        this.classIcon = classIcon;


        this.health = health;
        this.mana = mana;
        this.damage = damage;
        this.protPhys = protPhys;
        this.protMag = protMag;
        this.speed = speed;
        this.type = type;

        this.hp5 = hp5;
        this.mp5 = mp5;
        this.attackSpeed = attackSpeed;

        this.fav = false;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getProtMag() {
        return protMag;
    }

    public void setProtMag(int protMag) {
        this.protMag = protMag;
    }

    public int getProtPhys() {
        return protPhys;
    }

    public void setProtPhys(int protPhys) {
        this.protPhys = protPhys;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHp5() {
        return hp5;
    }

    public void setHp5(double hp5) {
        this.hp5 = hp5;
    }

    public double getMp5() {
        return mp5;
    }

    public void setMp5(double mp5) {
        this.mp5 = mp5;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassIcon() {
        return classIcon;
    }

    public void setClassIcon(int classIcon) {
        this.classIcon = classIcon;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }
}