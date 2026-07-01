package org.example.demo.services.Implements;

public class GoldStack extends GoldMulti{

    long value = 0;
    double decimals = 0;
    double result = 0;

    public void stackGold(double gold, double silver, double copper,double stack){


        gold *= 10000;
        silver *= 100;
        stack *= 10000;

        value += (long) (gold + silver + copper) * 250;
        result = stack / value;
        decimals = (stack%value) / value * 250;
    }
    public double showValueResult(){
        return result;
    }
    public double showDecimal(){
        return decimals;
    }
    public void reset1(){
        value = 0;
        decimals = 0;
        result = 0;
    }
}
