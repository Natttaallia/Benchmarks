package com.example.benchmarks.domain.models.collection;

public abstract class CustomCollection<T> {

    T data;

    public void initialize(T data) {
        this.data = data;
    }

    public abstract int size();

    public abstract void add(int index, Integer element);
}
