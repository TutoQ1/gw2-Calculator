package org.example.demo.entity;
/*
 * Here is the MAIN class entitie where the objects are created and used later
 */
public class Currency {
    private double gold;
    private double silver;
    private double copper;

    public Currency(){ }

    public Currency(double gold, double silver, double copper) {
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getSilver() {
        return silver;
    }

    public void setSilver(double silver) {
        this.silver = silver;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    //method used to convert incoming values in another more controllable
    public Currency convertor(long value){
        double _gold = (double) value / 10000;
        double _silver = ((double) value%10000) / 100;
        double _copper = (double) value % 100;

        return new Currency(_gold,_silver,_copper);
    }
}
