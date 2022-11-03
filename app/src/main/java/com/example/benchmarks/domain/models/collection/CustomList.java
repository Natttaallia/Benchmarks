package com.example.benchmarks.domain.models.collection;

import java.util.List;

public class CustomList<T extends List> extends CustomCollection<T> {

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void add(int index, Integer element) {
        data.add(index, element);
    }
}
