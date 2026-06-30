package org.example.demo.services.Implements;


import org.example.demo.entity.Currency;
import org.example.demo.services.InterValidations.Interface;

public class GoldSum implements Interface {
    Currency currency = new Currency();
    @Override
    public void validation(Currency currency) throws Exception {
        if(currency.getCopper()<0&&currency.getGold()<0&&currency.getSilver()<0){
            throw new Exception("Valor invalido");
        }
    }
    private long value = 0;

    public void sumGold(double gold, double silver, double copper){

        gold *= 10000;
        silver *= 100;

        value = (long) (gold+silver+copper);
    }

    public Currency getSumGold(){
        return currency.convertor(value);
    }
    public void reset(){
        value = 0;
    }

}
