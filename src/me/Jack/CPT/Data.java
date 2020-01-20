package me.Jack.CPT;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Data {

    String line;
    String path = "src\\me\\Jack\\CPT\\Files\\";

    String[] provinces = {"ALBERTA", "BRITISH COLUMBIA", "MANITOBA", "NEW BRUNSWICK", "NEWFOUNDLAND AND LABRADOR", "NORTHWEST TERRITORY", "NOVA SCOTIA", "NUNAVUT", "ONTARIO", "PRINCE EDWARD ISLAND", "QUEBEC", "SASKATCHEWAN", "YUKON"};
    String[] grades = {"GRADE", "9", "10", "11", "12"};
    String[] year = {"YEAR", "2000", "2001", "2002", "2003", "2004", "2005", "2006"};
    String[] month = {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] day = {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] genders = {"MALE", "FEMALE"};

    ArrayList<String> keys = new ArrayList<>();
    HashMap<String, String> firstName = new HashMap<>();
    HashMap<String, String> address = new HashMap<>();
    HashMap<String, String> city = new HashMap<>();
    HashMap<String, Integer> province = new HashMap<>();
    HashMap<String, String> postalCode = new HashMap<>();
    HashMap<String, String> phoneNum = new HashMap<>();
    HashMap<String, Integer> DOByear = new HashMap<>();
    HashMap<String, Integer> DOBday = new HashMap<>();
    HashMap<String, Integer> DOBmonth = new HashMap<>();
    HashMap<String, Integer> gender = new HashMap<>();
    HashMap<String, Integer> grade = new HashMap<>();
    HashMap<String, String> courses = new HashMap<>();
    HashMap<String, Integer> age = new HashMap<>();

    //Course code, course desc
    ArrayList<String> course9Keys = new ArrayList<>();
    ArrayList<String> course10Keys = new ArrayList<>();
    ArrayList<String> course11Keys = new ArrayList<>();
    ArrayList<String> course12Keys = new ArrayList<>();
    HashMap<String, String> courseTable = new HashMap<>();

    ArrayList<String> tmpFile = new ArrayList<>();

    public void initData() throws IOException {
       readStudentData();
       readCourseData();
    }

    public void readStudentData() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "StudentData.txt")));
            keys.clear();
        while ((line = br.readLine()) != null) {
            String[] info = line.split(",");
            String key = info[2] + ", " + info[0];
            //studentNum, firstName, lastName, address, city, province, postal code, phone#, year, day, month, gender, grade, course1, avg, course2, avg, course3, avg....
            firstName.put(key, info[1]);
            address.put(key, info[3]);
            city.put(key, info[4]);
            province.put(key, Integer.parseInt(info[5]));
            postalCode.put(key, info[6]);
            phoneNum.put(key, info[7]);
            DOByear.put(key, Integer.parseInt(info[8]));
            DOBday.put(key, Integer.parseInt(info[9]));
            DOBmonth.put(key, Integer.parseInt(info[10]));
            gender.put(key, Integer.parseInt(info[11]));
            grade.put(key, Integer.parseInt(info[12]));
            courses.put(key, info[13]);
            age.put(key, Integer.parseInt(info[15]));
            keys.add(key);
            tmpFile.add(line);
        }
        br.close();
    }

    public void writeToFile(String information, String key) throws IOException{
        PrintWriter printWriter = new PrintWriter(path + "StudentData.txt");
        if(!keys.contains(key)){
            tmpFile.add(information);
        }

        for (int i = 0; i < tmpFile.size(); i++) {
            key = key.replaceAll(" ", "");
            String [] reorganize = key.split(",");
            if (tmpFile.get(i).contains(reorganize[1])){
                tmpFile.set(i, information);
                System.out.println(tmpFile);
            }
        }

        for (int i = 0; i < tmpFile.size(); i++) {
            printWriter.println(tmpFile.get(i));
        }

        printWriter.close();
        //System.out.println(tmpFile);
        tmpFile.clear();
    }

    public void readCourseData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path + "CourseData.txt")));
        course9Keys.add("COURSE");
        course10Keys.add("COURSE");
        course11Keys.add("COURSE");
        course12Keys.add("COURSE");
        while ((line = br.readLine()) != null) {
            String[] classes = line.split(",");
            for (int i = 0 ; i < classes.length; i++) {
                switch (classes[i].charAt(3)){
                    case '1':
                        course9Keys.add(classes[i]);
                        break;
                    case '2':
                        course10Keys.add(classes[i]);
                        break;
                    case '3':
                        course11Keys.add(classes[i]);
                        break;
                    case '4':
                        course12Keys.add(classes[i]);
                        break;
                }
                courseTable.put(classes[i], "");
            }
        }
    }

    public int calculateAge(LocalDate birthdate){
        Period p = Period.between(birthdate, LocalDate.now());
        return p.getYears();
    }

}
