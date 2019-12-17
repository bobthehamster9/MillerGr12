package me.Jack.Projects.Sorting1;

public class TenIntegerSwap1 {

    int[] iArray = new int[11];

    public void run(){
        iArray[1] = 45;
        iArray[2] = 22;
        iArray[3] = 2;
        iArray[4] = 33;
        iArray[5] = 13;
        iArray[6] = 48;
        iArray[7] = 7;
        iArray[8] = 19;
        iArray[9] = 20;
        iArray[10] = 39;

        System.out.println("Elements: 1 2 3 4 5 6 7 8 9 10");
        System.out.print("Original: ");
        for (int i = 1; i < iArray.length; i++) {
            System.out.print(iArray[i] + " ");
        }
        for (int i = 2; i < iArray.length; i+=2) {
            sortArray(iArray[i-1], iArray[i], i-1, i);
        }
        printArray(iArray);
    }

    public void sortArray(int num1, int num2, int slot1, int slot2){
        iArray[slot1] = num2;
        iArray[slot2] = num1;
    }

    public void printArray(int[] Array){
        System.out.print("\nChanged: ");
        for (int i = 1; i < Array.length; i++) {
            System.out.print(iArray[i] + " ");
        }
    }

}
