package me.Jack.Review;

import me.Jack.Methods;

import java.util.*;

public class Review {

    Methods m = new Methods();

    public void Review1(){
        //Milky Chance - Blossom
        //Question 2
        int i = 0;
        double d = 1;
        short s = 2;
        float f = 3;
        long l = 4;
        boolean b = true;
        char c = 'a';
        byte bit = 1;

        int numberOfWaterBottles = 12;
        double price = 3.50;
        String waterBrandName = "Pure Life";

        numberOfWaterBottles = 24;
        price = 4.50;
        waterBrandName = "Selection Natural Spring Water";

        ArrayList<Double> listOfPrices = new ArrayList<>();

        System.out.println(price/numberOfWaterBottles);

        for(int j = 0; j <= numberOfWaterBottles; j++){
            System.out.print(j + " bottle(s) of " + waterBrandName + " costs ");
            System.out.println((price/numberOfWaterBottles) * j);
        }

        for(int j = 0; j <= 100; j++){
            listOfPrices.add(price/numberOfWaterBottles * j);
        }

        int count = 0;
        while(count <= 30){
            System.out.print(count + " ");
            if(count % 3 == 0){
                System.out.println();
            }
            count++;
        }
    }

    public void Review2() {
        //Two Door Cinema Club - Beacon

        //Exercise 1
        String notes = "ABCDEFG";

        String[] major = notes.split("(?=C)");

        System.out.println(major[1] + major[0]);

        //Exercise 2
        ArrayList<String> vocalists = new ArrayList<>();
        vocalists.add("Beyonce (f)");
        vocalists.add("David Bowie (m)");
        vocalists.add("Elvis Costella (m)");
        vocalists.add("Madonna (f)");
        vocalists.add("Elton John (m)");
        vocalists.add("Charles Aznavour (m)");

        int men = 0, women = 0;

        for (int i = 0; i < vocalists.size(); i++) {
            if (vocalists.get(i).contains("(f")) {
                women++;
            } else if (vocalists.get(i).contains("(m")) {
                men++;
            } else {
                System.out.println("No gender found: " + vocalists.get(i));
            }
        }

        System.out.println("Women: " + women);
        System.out.println("Men: " + men);

        //Exercise 3
        ArrayList<String> instruments = new ArrayList<>();
        instruments.add("cello");
        instruments.add("guitar");
        instruments.add("violin");
        instruments.add("double bass");

        CharSequence vowels [] = {"a", "e", "i", "o", "u"};

        //One loop
        for(String s : instruments){
            System.out.println(s.toLowerCase().replaceAll("[aeiou]", ""));
        }

        //Exercise 4
        int countToThousand = 1;
        int numbersNoRemainder3 = 0;

        do {
            if(countToThousand % 3 == 0){
                numbersNoRemainder3++;
            }
            countToThousand++;
        } while (countToThousand<1000);

        System.out.println(numbersNoRemainder3);

        //Exercise 5
        for (int i = 1; i < 21; i++) {
            System.out.println("Number: " + i);
            System.out.println("Single score: " + i);
            System.out.println("Double Score: " + i*2);
            System.out.println("Treble Score: " + i*3);
        }

        //Exercise 6
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print("white-black-");
                if(j % 3 == 0){
                    System.out.println("white-black");
                }
            }
        }

        //Exercise 7
        int consecutiveNumbers [] = new int[6];
        Scanner scanner = new Scanner(System.in);
        boolean sequential = true;
        System.out.println("Enter 5 digits");

        for (int i = 0; i < 5; i++) {
            consecutiveNumbers [i] = scanner.nextInt();
        }

        Arrays.sort(consecutiveNumbers);

        for (int i = 0; i < 5; i++) {
            if(consecutiveNumbers[i] + 1 != consecutiveNumbers[i + 1]){
                sequential = false;
            }
        }

        System.out.println(sequential);

        //Exercise 8
        Set<Integer> dupeNumbers = new HashSet<>();
        System.out.println("Enter 5 digits");
        for (int i = 0; i < 5; i++) {
            dupeNumbers.add(scanner.nextInt());
        }

        if(dupeNumbers.size() < 5){
            System.out.println("Duplicates found");
        } else {
            System.out.println("No duplicates");
        }

        //Exercise 9
        char [] word = "DIAGONALLY".toCharArray();
        for (int i = 0; i < word.length; i++) {
            System.out.println(m.padL(word[i] + "", i+1));
        }

        //Exercise 10
        ArrayList<Integer> manScores = new ArrayList<>();
        ArrayList<Integer> otherScores = new ArrayList<>();
        int wins=0, ties=0, losses=0;
        String results = "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 3, "
                + "Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4, Manchester United 4 Swansea 1";
        String games[] = results.split(",");
        for(int i=0; i < games.length; i++){
            String str = games[i];
            if(str.contains("Manchester United")){
                StringBuilder sb = new StringBuilder(str);
                int scoreLoc = str.indexOf("Manchester United")+18;
                char c = str.charAt(scoreLoc);
                manScores.add(Character.getNumericValue(c));
                sb.deleteCharAt(scoreLoc);
                sb.delete(scoreLoc-18, scoreLoc);
                String oScore = sb.toString();
                for(int i1=0; i1 < oScore.length(); i1++){
                    char c1 = oScore.charAt(i1);
                    if(Character.isDigit(c1)){
                        otherScores.add(Character.getNumericValue(c1));
                    }
                }
            }
            if(manScores.get(i) > otherScores.get(i)){
                wins++;
            } else if(manScores.get(i) == otherScores.get(i)){
                ties++;
            } else if(manScores.get(i) < otherScores.get(i)){
                losses++;
            }
        }
        System.out.println("Wins: " + wins + " \nTies: " + ties + "\nLosses: " + losses);
    }

    public void test(){
        String results = "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4";
        String games [] = results.split(",");
        for (int i = 0; i < games.length; i++) {
            ArrayList<Integer> manScores = new ArrayList<>();
            ArrayList<Integer> otherScores = new ArrayList<>();
            //games[i].replaceAll("Manchester United", "");
            int scoreLoc = games[i].indexOf("Manchester United")+18;
            char cScore = games[i].charAt(scoreLoc);
            int score = Character.getNumericValue(cScore);
            manScores.add(score);
            for (int j = 0; j < manScores.size(); j++) {
                System.out.println(manScores.get(j));
            }
        }
    }
}
