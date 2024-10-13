package org.example;

import java.util.ArrayList;
import java.util.List;

public class Zustand<T> {
    private final String id;
    private final List<Uebergang<T>> uebergaenge = new ArrayList<>();
    private final boolean isEnd;

    public Zustand(String id, boolean end) {
        this.id = id;
        this.isEnd = end;
    }

    public Zustand(String id) {
        this(id, false);
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

    public boolean isEnd() {
        return isEnd;
    }
}
