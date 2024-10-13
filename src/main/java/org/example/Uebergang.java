package org.example;

public abstract class Uebergang<T> {
    private final Zustand<T> from;
    private final Zustand<T> to;

    public Uebergang(Zustand<T> from, Zustand<T> to) {
        this.from = from;
        this.to = to;
    }

    public abstract boolean canBeTaken(T type);

    public Zustand<T> from() {
        return from;
    }

    public Zustand<T> to() {
        return to;
    }
}
