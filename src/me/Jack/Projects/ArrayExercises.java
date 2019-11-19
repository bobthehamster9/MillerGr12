package me.Jack.Projects;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayExercises {

    private void E2 (){
        int rowTotal, colTotal, oldRowTotal = 0, oldColTotal = 0;

        int largestSum [][] = new int[10][10];
        for (int i = 0; i < largestSum.length; i++) {
            for (int j = 0; j < largestSum.length; j++) {
                largestSum[i][j] = (int) (Math.random() * 100);

            }
        }
        for (int i = 0; i < largestSum.length ; i++) {
            rowTotal = 0;
            colTotal = 0;
            for (int j = 0; j < largestSum.length ; j++) {
                rowTotal += largestSum[i][j];
                colTotal += largestSum[j][i];
            }
            oldRowTotal = Math.max(rowTotal, oldRowTotal);
            oldColTotal = Math.max(colTotal, oldColTotal);
        }
        System.out.println("The largest sum is: " + Math.max(oldRowTotal, oldColTotal));
    }

    private void E3 (){
        Scanner scanner = new Scanner(System.in);
        int search [] = new int[10];
        for (int i = 0; i < search.length; i++) {
            search[i] = (int) ((Math.random() * 49) + 1);
            System.out.print(search[i] + ",");
        }
        System.out.println();
        System.out.println("Enter an integer");
        int guess = scanner.nextInt();
        for (int i: search) {
            if(i == guess){
                System.out.println("Value found");
            }
        }
    }

    private void E4 (){
        int count = 11;
        String[] words = {"Big", "Time", "Rush", "was", "an", "American", "pop", "music", "boy", "band", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        while(count < 26) {
            Scanner scanner = new Scanner(System.in);
            for (String s : words) {
                System.out.println(s);
            }
            System.out.println("Enter a word");
            String word = scanner.next();
            List<String> list = Arrays.asList(words);
            if(list.contains(word)){
                System.out.println("Word fount at index: " + list.indexOf(word));
            } else {
                System.out.println("word added");
                words[count] = word;
                count++;
                System.out.println(count);
            }
        }
    }

    public void run(){
        E2();
        E3();
        E4();
    }
}
