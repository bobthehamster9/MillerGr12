package me.Jack.Projects.ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PromptForTextAndSort {

    String input;
    Scanner scanner  = new Scanner(System.in);
    ArrayList<String> text = new ArrayList<>();

    public void run(){
        do {
            input = scanner.nextLine();
            if(!input.equals("") && !input.equalsIgnoreCase("stop"))
            text.add(input);
            Collections.sort(text);
        } while(!input.equals("") && !input.equalsIgnoreCase("stop"));
        System.out.println(input);
        System.out.println(text);
    }

}
