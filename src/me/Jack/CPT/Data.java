package me.Jack.CPT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    String line;

    //
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

    HashMap<String, String> courseData = new HashMap<>();

    public void initData() throws IOException {
       readFromFile("StudentData.txt");
    }

    public void readFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src\\me\\Jack\\CPT\\Files\\" + path)));
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
            keys.add(key);
        }
    }

}
