package org.example.demo.services.Implements;

import org.example.demo.entity.Valuables;

public class GoldMulti extends GoldSum{

    Valuables valuables = new Valuables();
    long value = 0;

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
