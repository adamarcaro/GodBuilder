package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-03-08.
 */

public class Item {

    private String name, passive;
    private int image, cost;
    private char itemType, itemGroup;
    private int health, mana, damage, protPhys, protMag, critChance, penetration, lifesteal, cdr, ccr;
    private double hp5, mp5, attackSpeed, speed;
    private int maxStacks;

    public Item()
    {
        this.name = "";
        this.image = R.drawable.no_item;
        this.cost = 0;
        this.itemType = 'P';
        this.itemGroup = 'I';

        this.health = 0;
        this.mana = 0;
        this.hp5 = 0.0;
        this.mp5 = 0.0;

        this.damage = 0;
        this.lifesteal = 0;
        this.penetration = 0;

        this.protPhys = 0;
        this.protMag = 0;

        this.attackSpeed = 0.0;
        this.speed = 0;

        this.critChance = 0;
        this.cdr = 0;
        this.ccr = 0;

        this.passive = "";

        this.maxStacks = 0;
    }

    public Item(String header, String note)
    {
        this.name = header;
        this.image = R.drawable.no_item;
        this.cost = 0;
        this.itemType = 'P';
        this.itemGroup = 'I';

        this.health = 0;
        this.mana = 0;
        this.hp5 = 0.0;
        this.mp5 = 0.0;

        this.damage = 0;
        this.lifesteal = 0;
        this.penetration = 0;

        this.protPhys = 0;
        this.protMag = 0;

        this.attackSpeed = 0.0;
        this.speed = 0;

        this.critChance = 0;
        this.cdr = 0;
        this.ccr = 0;

        this.passive = note;

        this.maxStacks = 0;
    }

    public Item(String name, int image, int cost, char itemType, char itemGroup,
                int health, int mana, double hp5, double mp5,
                int damage, int lifesteal, int penetration,
                int protPhys, int protMag,
                double attackSpeed, double speed,
                int critChance, int cdr, int ccr,
                String passive) {
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.itemType = itemType;
        this.itemGroup = itemGroup;

        this.health = health;
        this.mana = mana;
        this.hp5 = hp5;
        this.mp5 = mp5;

        this.damage = damage;
        this.lifesteal = lifesteal;
        this.penetration = penetration;

        this.protPhys = protPhys;
        this.protMag = protMag;

        this.attackSpeed = attackSpeed;
        this.speed = speed;

        this.critChance = critChance;
        this.cdr = cdr;
        this.ccr = ccr;

        this.passive = passive;

        this.maxStacks = 0;
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

    public char getItemType() {
        return itemType;
    }

    public void setItemType(char itemType) {
        this.itemType = itemType;
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

    public int getProtPhys() {
        return protPhys;
    }

    public void setProtPhys(int protPhys) {
        this.protPhys = protPhys;
    }

    public int getProtMag() {
        return protMag;
    }

    public void setProtMag(int protMag) {
        this.protMag = protMag;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    public int getLifesteal() {
        return lifesteal;
    }

    public void setLifesteal(int lifesteal) {
        this.lifesteal = lifesteal;
    }

    public int getCdr() {
        return cdr;
    }

    public void setCdr(int cdr) {
        this.cdr = cdr;
    }

    public int getCcr() {
        return ccr;
    }

    public void setCcr(int ccr) {
        this.ccr = ccr;
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

    public char getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(char itemGroup) {
        this.itemGroup = itemGroup;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString() {
        return name;
    }

    public int getMaxStacks() {
        return maxStacks;
    }

    public void setMaxStacks(int maxStacks) {
        this.maxStacks = maxStacks;
    }

}