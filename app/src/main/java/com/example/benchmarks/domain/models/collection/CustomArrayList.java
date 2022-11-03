package com.example.benchmarks.domain.models.collection;

import java.util.ArrayList;

public class CustomArrayList<T extends ArrayList> extends CustomCollection<T> {

    public CustomArrayList(int size) {
        super(size);
    }

    @Override
    public void add(int index, Integer element) {
        data.add(index, element);
    }
}
