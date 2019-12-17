package me.Jack;

import me.Jack.Projects.*;
import me.Jack.Review.*;

import java.io.IOException;

public class Project {

    public static void main(String[] args) throws IOException {
        Review r = new Review();
        SimpleMethods sm = new SimpleMethods();
        AdvancedMethods am =  new AdvancedMethods();
        QuadraticFactor qf = new QuadraticFactor();
        CalculateInterest ci = new CalculateInterest();
        ArrayExercises ae = new ArrayExercises();
        PrintACheque pac = new PrintACheque();
        StoreStats ss = new StoreStats();
        CalendarDates cd = new CalendarDates();
        Frame1 f1 = new Frame1();
        FramePlay framePlay = new FramePlay();
        FirstSwing firstSwing = new FirstSwing();
        Survey survey = new Survey();
        TenIntegers tenIntegers = new TenIntegers();

        tenIntegers.run();
        //survey.run();
        //firstSwing.run();
        //framePlay.run();
        //f1.run();
        //cd.run();
        //ss.run();
        //pac.run();
        //ae.run();
        //ci.run();
        //qf.run();
        //am.run();
        //sm.run();
        //r.Review1();
        //r.Review2();
        //r.test();
    }

}