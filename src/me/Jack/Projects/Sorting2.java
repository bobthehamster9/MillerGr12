package me.Jack.Projects;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sorting2 {
    Scanner scanner = new Scanner(System.in);
    PrintWriter pw;
    String path  = "C:\\Users\\Jack\\Documents\\MillerGr12\\src\\me\\Jack\\Projects\\SortingFiles\\";
    String line;
    int count;
    int [] a = new int[10];
    int [] read = new int[10];
    int [] read100 = new int[100];
    int [] read2000 = new int[2000];
    int [] read2000Bubble = new int[2000];

    public void run() throws IOException {
        System.out.println("Enter 10 numbers");
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path + "10Numbers.txt")));
        readFromFile(read, bufferedReader);
        Arrays.sort(read);
        bufferedReader = new BufferedReader(new FileReader(new File(path + "100Numbers.txt")));
        readFromFile(read100, bufferedReader);
        Arrays.sort(read100);
        bufferedReader = new BufferedReader(new FileReader(new File(path + "2000Numbers.txt")));
        readFromFile(read2000, bufferedReader);
        Arrays.sort(read2000);
        pw = new PrintWriter(path + "2000NumbersSorted.txt");
        for (int i = 0; i < read2000.length; i++) {
            pw.println(read2000[i]);
        }
        pw.close();
        bufferedReader = new BufferedReader(new FileReader(new File(path + "2000BubbleNumbers.txt")));
        readFromFile(read2000Bubble, bufferedReader);
        //Bubble sorted
        for (int i = 0; i < read2000Bubble.length-1; i++) {
            for (int j = 0; j < read2000Bubble.length - i - 1; j++) {
                if(read2000Bubble[j] > read2000Bubble[j + 1]){
                    int temp = read2000Bubble[j];
                    read2000Bubble[j] = read2000Bubble[j+1];
                    read2000Bubble[j+1] = temp;
                }
            }
        }
    }

    public void readFromFile(int [] Array, BufferedReader bufferedReader) throws IOException{
        count = 0;
        while((line = bufferedReader.readLine()) != null){
            Array[count] = Integer.parseInt(line);
            count++;
        }
    }

}
