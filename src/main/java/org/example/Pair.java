package org.example;

public class Pair<T> {
    private T first;
    private T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    @Override
    public boolean equals(Object obj) {
        Pair<T> pair = (Pair<T>)obj;
        if(
                this.getFirst().equals(pair.getFirst()) &&
                        this.getSecond().equals(pair.getSecond())
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getFirst().toString() + "," + this.getSecond().toString();
    }
}