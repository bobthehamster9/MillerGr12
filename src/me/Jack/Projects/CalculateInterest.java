package me.Jack.Projects;

import me.Jack.Methods;
import java.io.*;
import java.util.*;

public class CalculateInterest {

    HashMap<String, String> accounts = new HashMap<>();
    Methods methods = new Methods();
    private static double interestRates[] = {0.005/12, 0.0025/365, 0.02/365, 0.0225/12, 0.025/12};

    private ArrayList<String> readFile() throws IOException {
        ArrayList<String> rawAccounts = new ArrayList<>();
        File file = new File(Methods.path + "Project01Data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while((st = br.readLine()) != null){
            rawAccounts.add(st);
        }
        return rawAccounts;
    }

    private HashMap<String, String> setupAccounts(ArrayList<String> acc){
        HashMap<String, String> accountsMin = new HashMap<>();
        for (int i = 0; i < acc.size(); i++) {
            String[] data = acc.get(i).split(",");
            String accID = data[0] + data[1];
            for (int j = 2; j < data.length; j++) {
                accounts.put(accID, accounts.get(accID) + "," + data[j]);
            }

            String balances[] = accounts.get(accID).split(",");
            double[] doubleBalance = new double[balances.length];
            for (int j = 1; j < balances.length; j++) {
            doubleBalance[j] = Double.parseDouble(balances[j]);
        }

            double totalBal [] = new double[acc.size()];
            double total = 0;
            for (int k = 1; k < balances.length; k++) {
                total += Double.parseDouble(balances[k]);
            }
            totalBal[i] = total;
            System.out.println(total);
            Arrays.sort(doubleBalance);
            System.out.println(doubleBalance[1]);
            accountsMin.put(accID, doubleBalance[1] + "," + totalBal[i]);
        }
        return accountsMin;
    }

    private HashMap<String, Double> calculateInterest(HashMap<String, String> acc){
        String bals [];
        HashMap<String, Double> itsTooEarly = new HashMap<>(); //3:49 AM This code is gonna be a shitshow
        for (Map.Entry<String, String> entry: acc.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            bals = value.split(",");

            double monthly = Double.parseDouble(bals[0]);
            double daily = Double.parseDouble(bals[1]);

            if(key.contains("CMI")){ //Monthly
                itsTooEarly.put(key, methods.round(monthly * interestRates[0], 2));
            } else if (key.contains("SDI")){ //Daily
                itsTooEarly.put(key, methods.round(daily * interestRates[2], 2));
            } else if (key.contains("CDI")){ //Daily
                itsTooEarly.put(key, methods.round(daily * interestRates[1], 2));
            } else if (key.contains("SMI")){ //Monthly
                itsTooEarly.put(key, methods.round(monthly * interestRates[3], 2));
            } else if (key.contains("STF")){ //Monthly
                itsTooEarly.put(key, methods.round(monthly * interestRates[4], 2));
            } else {
                System.out.println("no acc type");
            }
        }
        return itsTooEarly;
    }

    private void writeFile(HashMap<String, Double> values) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter dailyWriter = new PrintWriter("AccountDailyBalances.txt", "UTF-8");
        PrintWriter monthlyWriter = new PrintWriter("AccountMonthlyBalances.txt", "UTF-8");
        for (Map.Entry<String, Double> entry: values.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            if(key.contains("CMI") || key.contains("SMI") || key.contains("STF")){
                monthlyWriter.println(key + ", " + value);
            } else if (key.contains("SDI") || key.contains("CDI")){
                dailyWriter.println(key + ", " + value);
            }
        }
        dailyWriter.close();
        monthlyWriter.close();
    }

    public void run() throws IOException {
        writeFile(calculateInterest(setupAccounts(readFile())));
    }
}