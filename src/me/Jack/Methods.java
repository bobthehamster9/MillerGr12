package me.Jack;

import java.math.BigDecimal;

public class Methods {

    public static String path = "C:\\Users\\jack\\Documents\\MillerGr12\\src\\me\\jack\\";

    public void clearTerminal(){
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public double round(double num, int places){
        return new BigDecimal(num).setScale(places, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public String padL(String string, int padding){
        return String.format("%1$" + padding + "s", string);
    }

    public String padR(String string, int padding){
        return String.format("%1$-" + padding + "s", string);
    }

}
