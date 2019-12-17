package me.Jack.Projects.Sorting1;

public class TenIntegerShiftUpOne {

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
        int temp = Array[Array.length - 1];
        for (int i = Array.length-1; i > 1; i--) {
            Array[i] = Array[i-1];
        }
        Array[1] = temp;
    }

    public void printArray(int [] Array){
        System.out.print("\nChanged: ");
        for (int i = 1; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
    }

    //Doesn't like Array Copy cause you started the array at 1 ¯\_(ツ)_/¯

}
