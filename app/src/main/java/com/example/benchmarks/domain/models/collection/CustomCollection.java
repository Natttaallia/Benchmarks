package com.example.benchmarks.domain.models.collection;

public abstract class CustomCollection<T> {

    T data;

    public CustomCollection(T data) {
        this.data = data;
    }

    public abstract int size();

    public abstract void add(int index, Integer element);

    public abstract void remove(int position);
}
