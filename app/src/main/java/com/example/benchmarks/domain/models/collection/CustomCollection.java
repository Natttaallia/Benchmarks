package com.example.benchmarks.domain.models.collection;

public abstract class CustomCollection<T> {

    T data;
    int size;

    CustomCollection(int size) {
        this.size = size;
    }

    public void initialize(T data) {
        this.data = data;
    }

    public int size() {
        return size;
    }

    public abstract void add(int index, Integer element);
}
