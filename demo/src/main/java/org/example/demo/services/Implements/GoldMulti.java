package org.example.demo.services.Implements;

import org.example.demo.entity.Valuables;

public class GoldMulti{

    Valuables valuables = new Valuables();
    long value = 0;


    public void validation(double gold, double silver, double copper, int value)throws IllegalArgumentException{
        if(gold<0||silver<0||copper<0||value<0){
            throw  new IllegalArgumentException("INVALID INPUT");
        }
    }

    public void multiGold(double gold,double silver, double copper, int Multi) {
            gold *= 10000;
            silver *= 100;
            value += (long) (gold + silver + copper) * Multi;
    }
    public Valuables getResult (){
        return valuables.conversion(value);
    }

    public void reset(){
        value = 0;
    }
}
