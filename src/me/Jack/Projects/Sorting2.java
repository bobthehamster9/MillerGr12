package me.Jack.Projects;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sorting2 {
    Scanner scanner = new Scanner(System.in);
    String path  = "C:\\Users\\Jack\\Documents\\MillerGr12\\src\\me\\Jack\\Projects\\SortingFiles";
    String line;
    int count;
    int [] a = new int[10];
    int [] aRead = new int[10];

    public void run() throws IOException {
        System.out.println("Enter 10 numbers");
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path + "\\10Numbers.txt")));
        count = 0;
        while((line = bufferedReader.readLine()) != null){
            aRead[count] = Integer.parseInt(line);
            count++;
        }
        Arrays.sort(aRead);
        PrintWriter pw = new PrintWriter("2000BubbleNumbers.txt", "UTF-8");
        for (int i = 0; i < 2000; i++) {
            pw.println((int) (Math.random() * 5000));
        }
        pw.close();
    }

}
