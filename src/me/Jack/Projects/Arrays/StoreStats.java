package me.Jack.Projects.Arrays;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StoreStats {

    public void run() {
        File f = new File ("C:\\Users\\jack\\Documents\\MillerGr12\\src\\me\\Jack\\Project02Data.txt");

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(f));
        }
        catch (FileNotFoundException e) {
            System.out.println("the file cannot be opened!  Error Number - " + e);
        }

        String line = null;

        String[][] storeList = {
                {"101", "St. John's, Newfoundland"},
                {"102", "Halifax, Nova Scotia"},
                {"103", "Fredericton, New Brunswick"},
                {"201", "Quebec City, Quebec"},
                {"202", "Montreal, Quebec"},
                {"301", "Ottawa, Ontario"},
                {"302", "Toronto, Ontario"},
                {"303", "Mississauga, Ontario"},
                {"304", "Hamilton, Ontario"},
                {"305", "Kitchener, Ontario"},
                {"401", "Winnipeg, Ontario"},
                {"402", "Regina, Saskatchewan"},
                {"403", "Calgary, Alberta"},
                {"404", "Edmonton, Alberta"},
                {"405", "Vancouver, British Columbia"},
        };

        System.out.println();

        String[][] productList = {
                {" ", "Total"},
                {"PR121", "Metal Pipe"},
                {"PR122", "Smooth Wall Steel Pipe"},
                {"PR123", "Corrugated Metal Pipe"},
                {"PR124", "Structural Plate Corrugated Metal Pipe"},
                {"PR231", "Tunnel Liner Plate"},
                {"PR331", "Concrete Arch Systems"},
                {"PR441", "Gates"},
                {"PR512", "Polyethylene Pipe"},
                {"PR513", "Polyvinyl Chloride Pipe"},
                {"PR661", "Beaver Control"},
                {"PR701", "End Treatments"},
                {"PR811", "Culvert Liner"},
        };

        double dSalesAmt;
        double [][][] dTableOfData = new double [16][12][14];

        int linesRead = 0,Row = 0, Col = 0, Cell = 0;

        String[] data;
        boolean dataRead = false;

        do {
            try {
                linesRead++;
                line = in.readLine();
            } catch (IOException e) {
                System.out.println("There is a problem at line " + linesRead + " Error number - " + e);
            }

            if (line == null) {
                dataRead = true;
            } else {
                if(!line.equals("")) {
                    data = line.split(",");
                    System.out.println(line);
                    for (Row = 1; Row <= 10; Row++) {
                        if (data[2].equals(productList[Row][0])) break;
                    }

                    for (Cell = 0; Cell < storeList.length - 1; Cell++) {
                        if (data[0].equals(storeList[Cell][0])) break;
                    }

                    Col = Integer.parseInt(data[1]);
                    Col = (Col / 100) % 100;
                    if ((Col < 1) | (Col > 12)) Col = 13;

                    dSalesAmt = Double.parseDouble(data[3]);

                    dTableOfData[Cell][Row][Col] += dSalesAmt;
                    dTableOfData[Cell][0][0] += dSalesAmt;
                    dTableOfData[Cell][Row][0] += dSalesAmt;
                    dTableOfData[Cell][0][Col] += dSalesAmt;
                }
            }
        } while (!dataRead);
        NumberFormat nf = new DecimalFormat("##,###,###.00");
        NumberFormat pf = new DecimalFormat ("###.0");
        int iLen = 13;
        for (int i = 0; i < storeList.length; i++) {
            System.out.println("\n\n\n");
            System.out.println("                                                                   2018    Sales   for ABC WIDGETS LTD.");
            System.out.printf("%100s",storeList[i][1] + "\n");
            System.out.println("Product                                    JANUARY       FEBRARY     MARCH       APRIL       MAY     JUNE        JULY        AUGUST      SEPTEMBER     OCTOBER     NOVEMBER        DECEMBER    YEAR TOTAL      %");
            System.out.println("-------------------------------------      ----------  ----------  ----------  ---------   ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  -----");
            for (Row = 1; Row <= 11; Row++) {
                System.out.printf("%-40s", productList[Row][1]);

                for (Col = 1; Col <= 12; Col++) {
                    System.out.printf("%,13.2f", dTableOfData[i][Row][Col]);
                }

                System.out.printf("%,13.2f", dTableOfData[i][Row][0]);
                System.out.printf("%6.1f%s%n", 100.0 * dTableOfData[i][Row][0] / dTableOfData[i][0][0], "%");
            }

            System.out.println("========================================   ===========  ===========  ===========  ===========  ===========  ===========  ===========  ===========  ===========  ===========  ===========  ===========  =============  =====");

            Row = 0;
            System.out.printf("%-42s", " TOTAL: ");
            for (Col = 1; Col <= 12; Col++) {
                System.out.printf("%,13.2f", dTableOfData[i][Row][Col]);
            }

            System.out.printf("%,15.2f", dTableOfData[i][Row][0]);
            System.out.printf("%6.1f%s%n", 100.0 * dTableOfData[i][0][0] / dTableOfData[i][0][0], "%");
        }
    }
}