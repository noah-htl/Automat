package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        this.uebergaenge.add(new NormalerUebergang<T>(this, target, type));
    }

    public void addUebergang(Zustand<T> target, Predicate<T> type) {
        this.uebergaenge.add(new PredicateUebergang<>(this, target, type));
    }

    public void addUebergang(Zustand<T> target, T ...type) {
        for(T t:type) {
            this.uebergaenge.add(new NormalerUebergang<T>(this, target, t));
        }
    }

    public Uebergang<T> getUebergang(T token) {
        for (Uebergang<T> uebergang:uebergaenge) {
            if(uebergang.canBeTaken(token)) {
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
