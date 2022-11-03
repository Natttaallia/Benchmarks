package com.example.benchmarks.domain.models.collection;

import java.util.List;

public class CustomList<T extends List> extends CustomCollection<T> {

    public CustomList(T data) {
        super(data);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void add(int index, Integer element) {
        data.add(index, element);
    }

    @Override
    public void remove(int position) {
        data.remove(position);
    }
}
