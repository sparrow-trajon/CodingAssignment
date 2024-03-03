package org.example;

import java.util.*;

public class Main {

    public static final double[] CURRENCY={100,50,20,10,5,2,1,.5};

    public static void main(String[] args) {
        double productPrice=7.50;
        double amountPaid=10;

       Map<Double, Integer> currencyCount= change(amountPaid-productPrice);
        displayCurrency(currencyCount);
    }

    private static void displayCurrency(Map<Double, Integer> currencyCount) {
        System.out.println("Your change is :");

        currencyCount.entrySet().stream().forEach(x->{
            System.out.print(x.getValue()+" *$ "+x.getKey());

        System.out.println("");
        });
    }

    /**
     * Create an application that will, given a UK currency amount and
     * the purchase price of a product, display the change to be
     * returned split down by denomination, largest first.
     */
    public static  Map<Double, Integer>  change(double amount){
        Map<Double, Integer> cu= new LinkedHashMap<>();

      for(int i=0;i<CURRENCY.length;i++){
          double curr=CURRENCY[i];
          if(amount>=curr){
              cu.put(curr, (int)(amount/curr));
              amount%=curr;
          }
      }
    return cu;
    }
}