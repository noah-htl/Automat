package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zustand<String> q1 = new Zustand<>("q1");
        Zustand<String> q2 = new Zustand<>("q2");
        Zustand<String> q3 = new Zustand<>("q3");
        Zustand<String> q4 = new Zustand<>("q4");

        q1.addUebergang(q2, "1");
        q2.addUebergang(q3, "0");
        q2.addUebergang(q4, "1");
        q3.addUebergang(q3, "0");
        q4.addUebergang(q4, "1");
        q4.addUebergang(q3, "0");

        Automat<String> stringAutomat = new Automat<>(q1);

        String[] arr = new String[] {"1","1","0","0"};

        Zustand<String> ergebnis = stringAutomat.run(new ArrayList<>(List.of(arr)));
        System.out.println(ergebnis);
    }
}