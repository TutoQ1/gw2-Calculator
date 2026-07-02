package org.example.demo.services.Implements;

import org.example.demo.entity.Valuables;

public class GoldTp{
    Valuables valuables = new Valuables();
    public void validation(double gold,double silver, double copper, double value,double tp) throws IllegalArgumentException{
        if(gold<0||silver<0||copper<0||value<0||tp<0){
            throw new IllegalArgumentException("INVALID INPUT");
        }
    }
    long value = 0;
    double price = 0;
    double finalPrice = 0;
    public void goldTp(double gold,double silver, double copper, double x,double tp){
        gold *= 10000;
        silver *= 100;

        value = (long) (gold + silver + copper);
        price = (double) value * tp/100;
        finalPrice = price * (x*250);
    }
    public Valuables getResult(){
        return valuables.conversionDouble(finalPrice);
    }
    public void reset1(){
        value = 0;
        price = 0;
        finalPrice = 0;
    }

}
