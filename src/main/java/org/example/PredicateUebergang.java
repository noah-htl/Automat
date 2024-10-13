package org.example;

import java.util.function.Predicate;

public class PredicateUebergang<T> extends Uebergang<T>{
    private final Predicate<T> predicate;

    public PredicateUebergang(Zustand<T> from, Zustand<T> to, Predicate<T> predicate) {
        super(from, to);

        this.predicate = predicate;
    }

    @Override
    public boolean canBeTaken(T type) {
        return predicate.test(type);
    }
}
