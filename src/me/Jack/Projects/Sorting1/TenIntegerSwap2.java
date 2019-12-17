package me.Jack.Projects.Sorting1;

public class TenIntegerSwap2 {

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
        sortArray(iArray);
        printArray(iArray);
    }

    public void sortArray(int[] Array) {
        for (int i = 1; i < Array.length/2; i++) {
            int temp = Array[i];
            Array[i] = Array[Array.length - i];
            Array[Array.length - i] = temp;
        }
    }

    public void printArray(int [] Array){
        System.out.print("\nChanged: ");
        for (int i = 1; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
    }

    //Tried doing it the fast way with collections, didn't like it since it doesn't have a value at iArray[0]

}
