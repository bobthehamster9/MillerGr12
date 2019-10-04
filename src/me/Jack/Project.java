package me.Jack;

import me.Jack.Projects.AdvancedMethods;
import me.Jack.Projects.CalculateInterest;
import me.Jack.Projects.QuadraticFactor;
import me.Jack.Projects.SimpleMethods;
import me.Jack.Review.*;

import java.io.IOException;

public class Project {

    public static void main(String[] args) throws IOException {
        Review r = new Review();
        SimpleMethods sm = new SimpleMethods();
        AdvancedMethods am =  new AdvancedMethods();
        QuadraticFactor qf = new QuadraticFactor();
        CalculateInterest ci = new CalculateInterest();
        ci.run();
        //qf.run();
        //am.run();
        //sm.run();
        //r.Review1();
        //r.Review2();
        //r.test();
    }

}
