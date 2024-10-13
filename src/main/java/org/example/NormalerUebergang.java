package org.example;

import java.util.Objects;

public final class NormalerUebergang<T> extends Uebergang<T>{
    private final T type;

    public NormalerUebergang(Zustand<T> from, Zustand<T> to, T type) {
        super(from, to);
        this.type = type;
    }

    public T type() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (NormalerUebergang) obj;
        return Objects.equals(this.from(), that.from()) &&
                Objects.equals(this.to(), that.to()) &&
                Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from(), to(), type);
    }

    @Override
    public String toString() {
        return "NormalerUebergang[" +
                "from=" + from() + ", " +
                "to=" + to() + ", " +
                "type=" + type + ']';
    }

    @Override
    public boolean canBeTaken(T type) {
        return this.type.equals(type);
    }
}
