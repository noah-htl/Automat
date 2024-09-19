package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zustand<T> {
    private final String id;
    private final List<Uebergang<T>> uebergaenge = new ArrayList<>();

    public Zustand(String id) {
        this.id = id;
    }

    public void addUebergang(Zustand<T> target, T type) {
        this.uebergaenge.add(new Uebergang<T>(this, target, type));
    }

    public Uebergang<T> getUebergang(T token) {
        for (Uebergang<T> uebergang:uebergaenge) {
            if(uebergang.type().equals(token)) {
                return uebergang;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
