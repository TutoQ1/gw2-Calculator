package org.example.demo.services.Implements;


import org.example.demo.entity.Valuables;
import org.example.demo.services.InterValidations.Interface;

import java.util.ArrayList;

public class GoldSum implements Interface {

    Valuables valuables = new Valuables();

    @Override
    public void validation(Valuables valuables) throws Exception {
        if(valuables.getCopper()<0&& valuables.getGold()<0&& valuables.getSilver()<0){
            throw new Exception("Valor invalido");
        }
    }
    long value = 0;

    public void sumGold(double gold,double silver, double copper){
        gold *= 10000;
        silver *=100;

        value += (long) (gold+silver+copper);
    }

    public Valuables getSumGold(){
        return valuables.conversion(value);
    }
    public void reset(){
        value = 0;
    }

}
