package me.Jack.Projects.ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment02 {

    Scanner scanner = new Scanner(System.in);
    int input;
    ArrayList<Integer> num = new ArrayList<>();
    ArrayList<Integer> numK = new ArrayList<>();

    public void run(){
        do {
            input = scanner.nextInt();
            if(input != 0)
                if(!num.contains(input))
                num.add(input);
                else System.out.println("Duplicate number");
            Collections.sort(num);
        } while(input != 0);

        for (int i = 0; i < num.size(); i++) {
            for (int j = 0; j < num.get(i); j++) {
                numK.add(num.get(i));
            }
        }
        System.out.println(num);
        System.out.println(numK);

    }
}
