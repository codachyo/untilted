package chill.gachi_game;

import javax.swing.*;

public class Persons {

    protected String name;
    protected String sm;
    protected int age;
    protected boolean waffle;
    protected String color;

    public Persons(String name, String sm, int age, boolean waffle, String color) {
        this.name = name;
        this.sm = sm;
        this.age = age;
        this.waffle = waffle;
        this.color = color;
    }

    protected void name() {
        if (this.name.equals("Josifs")) {
            System.out.println("My name is " + this.name + ", and i'm a gey");
        } else {
            System.out.println("My name is " + name);
        }
    }

    protected void sm() {
        if (this.sm.equals("5")) {
            System.out.println("My name is " + this.name + ", and i'm a pipidastr");
        } else {
            System.out.println("My name is " + this.name + ", and i'm a genius");
        }
    }

    protected void age() {
        System.out.println("My age is " + age);
    }

    protected void waffle() {
        if (this.waffle) {
            System.out.println("I'm a waffle");
        } else {
            System.out.println("I'm not a waffle");
        }
    }

    protected void color() {
        if (color == "black") {
            System.out.println("I'm a Josifs and i'm a gey");
        } else {
            System.out.println("tututuuttu");
        }
    }
    protected void geyOrNot() {
        System.out.println("I'm a gey");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWaffle() {
        return waffle;
    }

    public void setWaffle(boolean waffle) {
        this.waffle = waffle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}





