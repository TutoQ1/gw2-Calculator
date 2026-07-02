package org.example.demo.entity;

/*
 * Here is the MAIN class entity where the objects are created and used later
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


    //this function is used to convert the manageable number in a convenient syntax
    public Valuables conversion(long value){
        double gold = (double) value/10000;
        double silver = ((double) value%10000)/100;
        double copper = (double) value % 100;

        return new Valuables(gold,silver,copper);

    }
    //this function is used to convert the manageable number of GoldTp class to convenient syntax
    public Valuables conversionDouble(double value){
        long total = (long) value;

        double gold =   total/10000;
        double silver = (total%10000) / 100.0;
        double copper = total % 100;

        return new Valuables(gold,silver,copper);

    }
}
