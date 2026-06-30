package org.example.demo.entity;

import java.util.ArrayList;

/*
 * Here is the MAIN class entitie where the objects are created and used later
 */
public class Valuables {
    private double gold;
    private double silver;
    private double copper;

    public Valuables(){ }

    public Valuables(double gold, double silver, double copper) {
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
    }

    public double getGold() {
        return gold;
    }

    public double getSilver() {
        return silver;
    }

    public double getCopper() {
        return copper;
    }



    public Valuables conversion(long value){
        double gold = (double) value/10000;
        double silver = ((double) value%10000)/100;
        double copper = (double) value % 100;

        return new Valuables(gold,silver,copper);

    }
}
