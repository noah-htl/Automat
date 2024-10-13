package org.example;

import java.util.ArrayList;
import java.util.List;

public class Automat<T> {
    private final Zustand<T> startZustand;

    public Automat(Zustand<T> startZustand) {
        this.startZustand = startZustand;
    }

    public Zustand<T> run(T ...tokens) {
        return this.run(new ArrayList<>(List.of(tokens)));
    }

    public Zustand<T> run(List<T> tokens) {
        Zustand<T> zustand = startZustand;

        while (!tokens.isEmpty()) {
            Uebergang<T> uebergang = zustand.getUebergang(tokens.removeFirst());
            if(uebergang == null) {
                throw new RuntimeException("No transition found");
            }

            zustand = uebergang.to();
        }

        if(!zustand.isEnd()) {
            throw new RuntimeException("Invalid end point");
        }

        return zustand;
    }
}
