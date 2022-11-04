package com.example.benchmarks.domain.models.collection;

public abstract class CustomDataStructure<T> {

    T data;

    public CustomDataStructure(T data) {
        this.data = data;
    }

    public abstract void add(Integer element);

    public abstract void remove();
}
