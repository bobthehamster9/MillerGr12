package me.Jack.Projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sorting2 {
    Scanner scanner = new Scanner(System.in);
    int [] a = new int[10];
    int [] aRead = new int[10];

    public void run() throws FileNotFoundException {
        System.out.println("Enter 10 numbers");
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\jack\\Documents\\MillerGr12\\src\\me\\Jack\\Projects\\SortingFile\\10Numbers")));
    }

}
