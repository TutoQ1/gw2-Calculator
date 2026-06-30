package org.example.demo.services.Implements;

import org.example.demo.entity.Valuables;

import java.util.ArrayList;

public class Convertor {

    ArrayList<Valuables> list = new ArrayList<>();

    public void conversion(long value){
        double gold = (double) value/10000;
        double silver = ((double) value%10000)/100;
        double copper = (double) value % 100;

        list.add(new Valuables(gold,silver,copper));

    }
}
