package com.example.benchmarks.domain.models.collection;

import com.example.benchmarks.domain.models.position.Position;

import java.util.List;

public class CustomList<T extends List> extends CustomDataStructure<T> {

    Position position;

    public CustomList(T data, Position position) {
        super(data);
        this.position = position;
    }

    @Override
    public void add(Integer element) {
        data.add(computePosition(), element);
    }

    @Override
    public void remove() {
        data.remove(computePosition());
    }

    private int computePosition() {
        return position.getPosition(data.size());
    }
}
