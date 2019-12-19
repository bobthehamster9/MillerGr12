package me.Jack.Projects.ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PromptForNumbersAndSort {

    double input;
    Scanner scanner  = new Scanner(System.in);
    ArrayList<Double> num = new ArrayList<>();

    public void run(){
        do {
            input = scanner.nextDouble();
            if(input != 0)
            num.add(input);
            Collections.sort(num);
        } while(input != 0);
        System.out.println(num);
    }

}
