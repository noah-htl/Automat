package org.example;


public class Additum2 implements Runnable{
    @Override
    public void run() {
        Zustand<Integer> q0 = new Zustand<>("q0");
        Zustand<Integer> q1 = new Zustand<>("q1");
        Zustand<Integer> q2 = new Zustand<>("q2");
        Zustand<Integer> q3 = new Zustand<>("q3");
        Zustand<Integer> q4 = new Zustand<>("q4");
        Zustand<Integer> q5 = new Zustand<>("q5");
        Zustand<Integer> q6 = new Zustand<>("q6");
        Zustand<Integer> q7 = new Zustand<>("q7", true);

        q0.addUebergang(q1, integer -> integer >= 1 && integer <= 28);
        q0.addUebergang(q2, 29, 30);
        q0.addUebergang(q3, 31);

        q1.addUebergang(q4, integer -> integer >= 1 && integer <= 12);
        q2.addUebergang(q5, 1,3,4,5,6,7,8,9,10,11,12);
        q3.addUebergang(q6, 1,3,5,7,8,10,12);

        q4.addUebergang(q7, 2006);
        q5.addUebergang(q7, 2006);
        q6.addUebergang(q7, 2006);

        Automat<Integer> integerAutomat = new Automat<>(q0);

        Zustand<Integer> ergebnis = integerAutomat.run(28,2,2006);
        System.out.println(ergebnis);
    }
}
