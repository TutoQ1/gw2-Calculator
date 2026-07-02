package org.example.demo.services.Implements;

import org.example.demo.entity.Valuables;

public class GoldSub extends GoldSum {
    long value1 = 0;
    long value2 = 0;
    public void getValue1(int gold, int silver, int copper){
        gold *= 10000;
        silver *= 100;

        value1 = gold + silver + copper;

    }
    public void getValue2(int gold, int silver, int copper){
        gold *= 10000;
        silver *= 100;

        value2 = gold + silver + copper;

    }

    public Valuables getSubGold(){
        return valuables.conversion(value1 - value2);
    }

    public void reset1(){
        value1 = 0;
        value2 = 0;
    }


}
