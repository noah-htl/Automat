package org.example;

public record Uebergang<T> (Zustand<T> from, Zustand<T> to, T type) {
}
