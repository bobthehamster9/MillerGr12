package me.Jack.Review;

import java.util.ArrayList;

public class Review {

    public void Review1(){
        //Question 2
        int i = 0;
        double d = 1;
        short s = 2;
        float f = 3;
        long l = 4;
        boolean b = true;
        char c = 'a';
        byte bit = 1;

        int numberOfWaterBottles = 12;
        double price = 3.50;
        String waterBrandName = "Pure Life";

        numberOfWaterBottles = 24;
        price = 4.50;
        waterBrandName = "Selection Natural Spring Water";

        ArrayList<Double> listOfPrices = new ArrayList<>();

        System.out.println(price/numberOfWaterBottles);

        for(int j = 0; j <= numberOfWaterBottles; j++){
            System.out.print(j + " bottle(s) of " + waterBrandName + " costs ");
            System.out.println((price/numberOfWaterBottles) * j);
        }

        for(int j = 0; j <= 100; j++){
            listOfPrices.add(price/numberOfWaterBottles * j);
        }

        int count = 0;
        while(count <= 30){
            System.out.print(count + " ");
            if(count % 3 == 0){
                System.out.println();
            }
            count++;
        }
    }
}
