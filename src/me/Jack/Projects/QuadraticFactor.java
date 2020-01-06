package me.Jack.Projects;

import java.util.ArrayList;
import java.util.Scanner;

public class QuadraticFactor {

    Scanner scanner = new Scanner(System.in);

    double COEFF, COEFF2, COEFF3;

    ArrayList<Double> findFactors(double a, double b, double c){
        ArrayList<Double> factors = new ArrayList<>();
        double result = b * b - 4.0 * a * c;

        if (result > 0.0) {
            double f1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
            double f2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);
            factors.add(f1);
            factors.add(f2);
            System.out.println("The roots are " + f1 + " and " + f2);
        } else if (result == 0.0) {
            double f1 = -b / (2.0 * a);
            factors.add(f1);
            System.out.println("The root is " + f1);
        } else {
            System.out.println("The equation has no real roots.");
        }
        return factors;
    }

    public void run(){
        System.out.println("Enter the coefficient of your first term");
        COEFF = scanner.nextDouble();
        System.out.println("Enter the coefficient of your second term");
        COEFF2 = scanner.nextDouble();
        System.out.println("Enter the coefficient of your third term");
        COEFF3 = scanner.nextDouble();
        for (double d : findFactors(COEFF, COEFF2, COEFF3)) {
            System.out.print(("(x"+d*-1+")"));
        }
    }

}
