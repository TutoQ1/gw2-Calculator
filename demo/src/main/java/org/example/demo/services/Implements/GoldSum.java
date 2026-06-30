package org.example.demo.services.Implements;


import org.example.demo.entity.Valuables;


public class GoldSum{

    Valuables valuables = new Valuables();
    long value = 0;

    public  void validation(double gold, double silver, double copper)throws IllegalArgumentException{

        if(gold<0||silver<0||copper<0){
           throw  new IllegalArgumentException("VALOR INVALIDO");
        }

    }


    public void sumGold(double gold,double silver, double copper) throws Exception{
           gold *= 10000;
           silver *= 100;

           value += (long) (gold + silver + copper);

    }

    public Valuables getSumGold(){
        return valuables.conversion(value);
    }
    public void reset(){
        value = 0;
    }

}
