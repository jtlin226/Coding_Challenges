package com.revature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Driver {
    static boolean checkRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        String temp = s1 + s1;

        if (temp.indexOf(s2) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        //Adding elements to HashMap
        hmap.put(1, "AB");
        hmap.put(2, "CD");
        hmap.put(3, "EF");
        hmap.put(4, "GH");
        hmap.put(5, "IJ");

        System.out.println("While loop:");
        Iterator<Map.Entry<Integer, String>> iterator = hmap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            System.out.println("Key: "+me2.getKey() + " & Value: " + me2.getValue());
        }
        System.out.println();

        System.out.println("Advanced for loop:");
        for (Map.Entry<Integer, String> integerStringEntry : hmap.entrySet()) {
            Map.Entry me2 = (Map.Entry) integerStringEntry;
            System.out.println("Key: " + me2.getKey() + " & Value: " + me2.getValue());
        }

        System.out.println();
        System.out.println("Rotation of String");
        String a = "abcd";
        String b = "dabc";
        String c = "dbac";

        System.out.println(a + " | " + b + " : " + checkRotation(a,b));
        System.out.println(a + " | " + c + " : " + checkRotation(a,c));
    }
}
