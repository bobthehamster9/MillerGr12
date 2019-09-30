package me.Jack.Projects;

import java.math.BigDecimal;

public class SimpleMethods {

    public void out (int numToPrint){
        System.out.println(numToPrint);
    }

    public void out(double numToPrint){
        System.out.println(numToPrint);
    }

    public void out(String s){
        System.out.println(s);
    }

    public boolean isPrimeNumber(int number){
        for(int i=2;2*i<number;i++) {
            if(number%i==0)
                return false;
        }
        return true;
    }

     int greatestCommon(int a, int b) {
        if (b == 0) return a ;
        else return (greatestCommon (b, a % b));
    }

     int lowestCommon(int num1, int num2){
        return num1 * (num2 / greatestCommon(num1, num2));
    }

    BigDecimal myRound(double num, int places){
       return new BigDecimal(num).setScale(places, BigDecimal.ROUND_HALF_UP);
    }

    public void run(){
        out("I will be paid on Friday, the");
        out(23);
        out("rd day of September.\nI expect to be paid $");
        out(234.56);
        for (int i = 0; i < 5; i++) {
            out(i);
        }
        out("The number " + 9 + " is " + isPrimeNumber(9));
        out(lowestCommon(3, 6));
        out(greatestCommon(3, 6));
        System.out.println(myRound(39.41, 1));
    }

}
