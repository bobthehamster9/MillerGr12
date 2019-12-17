package me.Jack.Projects.Sorting1;

public class TenIntegersSorted {

    int[] iArray = new int[11];
    int[] Sorted = new int[11];
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
        for (int i = 1; i < iArray.length; i++) {
            System.out.print(iArray[i] + " ");
        }

        System.out.println();

        for (int i = 1; i < iArray.length-1; i++) {
            Sorted[i] = iArray[i];
        }
    }

}
