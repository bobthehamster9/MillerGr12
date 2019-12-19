package me.Jack.Projects.Methods;

import java.util.Scanner;

public class AdvancedMethods {

    Scanner scanner = new Scanner(System.in);

    boolean inRange(int num, int min, int max){
        return num > min && num < max;
    }

    boolean inRange(double num, double min, double max){
        return num > min && num < max;
    }

    boolean inRange(short num, short min, short max){
        return num > min && num < max;
    }

    double ticketPrice(int age){
        return inRange(age,14,64) ? 10.50 : 7.99;
    }

    boolean checkAge(int age, int requiredAge){
        return age >= requiredAge;
    }

    public void run(){
        int age = scanner.nextInt();
        System.out.println("Movie ticket: $" + ticketPrice(age));
        System.out.println("Can vote: " + checkAge(age, 18));
        System.out.println("Can purchase alcohol in Ontario: " + checkAge(age, 19));
        System.out.println("Collect Canada Pension Benefits: " + checkAge(age, 65));
        System.out.println("Collect unemployment: " + checkAge(age, 16));
        System.out.println("Apply for drivers license in Ontario & Alberta: " + checkAge(age, 16));
        System.out.println("Join the army: " + checkAge(age, 18));
        System.out.println("Left alone at home: " + checkAge(age, 16));
        System.out.println("Tattoo: " + checkAge(age, 18));
        System.out.println("Rent a car: " + checkAge(age, 21));
        System.out.println("Pilot permit: " + checkAge(age, 14));
    }

}
