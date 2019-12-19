package me.Jack.Projects.ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment03 {

    Scanner scanner = new Scanner(System.in);
    int input;
    ArrayList<Integer> num = new ArrayList<>();
    ArrayList<Integer> numR = new ArrayList<>();

    public void run(){
        do {
            input = scanner.nextInt();
            if(input != 0)
                    num.add(input);
            Collections.sort(num);
        } while(input != 0);

        for (int i = 0; i < num.size(); i++) {
            int n = num.get(i);
            if(!numR.contains(n))
                numR.add(n);
        }
        System.out.println(num);
        System.out.println(numR);

    }
}
