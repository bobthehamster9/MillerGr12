package me.Jack.Projects;

import me.Jack.Methods;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarDates {

    Methods methods = new Methods();

    private Scanner scanner = new Scanner(System.in);
    private String [][] statHolidays = new String [52][13];
    int col;

    String [] provinceList = {"ON", "QC", "AB", "BC", "MB", "SK", "NU", "NT", "NT", "YT", "NB", "NL", "NS", "PE"};



    public void run() {
        //Clearing the array
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 12; j++) {
                statHolidays[i][j] = "";
            }
        }

        //Nationwide
        for (int i = 0; i < 12; i++) {
            statHolidays[0][i] += "New Year's Day";
            statHolidays[15][i] += "Good Friday";
            statHolidays[26][i] += "Canada's Day";
            statHolidays[35][i] += "Labour Day";
            statHolidays[51][i] += "Christmas Day";
        }

        //Quebec doesn't celebrate Good Friday oh dieux
        statHolidays[15][1] = "";

        //Nationwide except NB, NL, NS, PE
        for (int i = 0; i < 8; i++) {
            statHolidays[20][i] += "Victoria Day";
            statHolidays[41][i] += "Thanksgiving";
        }

        //Family Day
        statHolidays[7][0] += "Family Day";
        statHolidays[7][2] += "Family Day";
        statHolidays[7][5] += "Family Day";
        statHolidays[7][9] += "Family Day";

        for (int i = 2; i < 8; i++) {
            statHolidays[45][i] += "Remembrance Day";
        }

        //Remembrance Day;
        statHolidays[45][12] += "Remembrance Day";
        statHolidays[45][9] += "Remembrance Day";

        //Civic Holiday
        statHolidays[31][0] += "Civic Holiday";
        statHolidays[31][2] += "Civic Holiday";
        statHolidays[31][3] += "Civic Holiday";
        statHolidays[31][5] += "Civic Holiday";
        statHolidays[31][6] += "Civic Holiday";
        statHolidays[31][9] += "Civic Holiday";



        //Family Day BC
        statHolidays[6][3] += "Family Day";
        statHolidays[7][12] += "Islanders Day";
        statHolidays[7][4] += "Louis Riel Day";
        statHolidays[10][10] += "St. Patrick Day";
        statHolidays[16][1] += "Easter Monday";
        statHolidays[16][10] += "St. George's Day";
        statHolidays[24][7] += "National Aboriginal Day";
        statHolidays[25][1] += "Fete Nationale";
        statHolidays[25][10] += "Discovery Day";
        statHolidays[27][7] += "Nunavut Day";
        statHolidays[51][0] += ", Boxing Day";


        //Prompt for date
        int year, month, day, hour, minute, startWeek, endWeek;
        String province;
        ArrayList<String> fridays = new ArrayList<>();
        System.out.println("Enter a year");
        year = scanner.nextInt();
        System.out.println("Enter a month");
        month = scanner.nextInt();
        System.out.println("Enter a day");
        day = scanner.nextInt();
        System.out.println("Enter an hour");
        hour = scanner.nextInt();
        System.out.println("Enter a minute");
        minute = scanner.nextInt();
        //Check if the date given is valid
        System.out.println("Is valid date/time: " + checkDate(year, month, day, hour, minute));
        calendar.setLenient(true);
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
        //Quarter
        int qMonth = calendar.get(Calendar.MONTH);
        int quarter = (qMonth / 3) + 1;
        System.out.println("This date is in the " + quarter + " quarter");

        //First day of every month
        for (int i = 0; i < 3; i++) {
            int firstDayMonth = (quarter * 3) - i - 1;
            calendar.set(Calendar.MONTH, firstDayMonth);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            System.out.println(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println(calendar.getTime());
        }

        System.out.println("\n\n Fridays in the quarter \n");
        for (int i = 0; i < 3; i++) {
            int monthVar = (quarter * 3) - i;
            calendar.set(Calendar.MONTH, monthVar);
            for (int j = 0; j < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); j++) {
                calendar.set(Calendar.DAY_OF_MONTH, j);
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    System.out.println(calendar.getTime());
                }
            }
        }

        System.out.println("\n\nMonday \n");
        for (int i = 0; i < 3; i++) {
            int monthVar = (quarter * 3) - i -1;
            calendar.set(Calendar.MONTH, monthVar);
            for (int j = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); j > 0; j--) {
                calendar.set(Calendar.DAY_OF_MONTH, j);
                if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                    System.out.println(calendar.getTime());
                    break;
                }
            }

            for (int j = 1; j < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); j++) {
                calendar.set(Calendar.DAY_OF_MONTH, j);
                if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                    System.out.println(calendar.getTime());
                    break;
                }
            }
        }

        //Semi Monthly Pay
        System.out.println("\n\nSemi Monthly Pay\n");
        for (int i = 0; i < 3; i++) {
            int monthVar = (quarter * 3) - i -1;
            calendar.set(Calendar.MONTH, monthVar);
            calendar.set(Calendar.DAY_OF_MONTH, 15);
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                calendar.add(Calendar.DAY_OF_MONTH, -2);
            }
            System.out.println(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println(calendar.getTime());
        }

        System.out.println("\n\nEnter a province | AB, BC, MB, NB, NL, NT, NS, NU, ON, PEI, QB, SK, YK");
        province = scanner.next();
        System.out.println("Enter the starting week");
        startWeek = scanner.nextInt();
        System.out.println("Enter the ending week");
        endWeek = scanner.nextInt();
        checkStatHolidays(province, startWeek, endWeek);
    }

    private Calendar calendar = Calendar.getInstance();

    //If you wanted to check the time you could make this again however I don't see why that is relevant when I can do it all at once in here
    private boolean checkDate(int year, int month, int day, int hour, int minute) {
        calendar.setLenient(false);
        calendar.set(year, month, day, hour, minute);
        try {
            calendar.getTime();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void checkStatHolidays(String p, int startWeek, int endWeek){
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.DAY_OF_YEAR, 1 + (7 * (startWeek-1)));

        for (col = 0; col < 12; col++) {
            if(p.equals(provinceList[col])) break;
        }

        System.out.println("Week #   Start Date   End Date          Holidays");
        System.out.println("------   ----------   -------------     -------------");
        for (int i = startWeek; i < endWeek+1; i++) {
            String startDate = formatDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            String endDate = formatDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            System.out.print(methods.padR((i)+"", 9));
            System.out.print(methods.padR(startDate, 13));
            System.out.print(methods.padR(endDate, 18));
            System.out.println(statHolidays[i-1][col]);
        }
    }

    public String formatDate(int year, int month, int day){
       return  year + "/" + (month+1) + "/" + day;
    }


}
