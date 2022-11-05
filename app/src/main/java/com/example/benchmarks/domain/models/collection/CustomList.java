package com.example.benchmarks.domain.models.collection;

import static com.example.benchmarks.domain.models.usecases.GetCollectionsUseCase.DEFAULT_ELEMENT;

import com.example.benchmarks.domain.models.position.Position;

import java.util.List;

public class CustomList<T extends List> extends CustomDataStructure<T> {

    public static int ELEMENT = 1;
    Position position;

    public CustomList(T data) {
        super(data);
    }

    public CustomList(T data, Position position) {
        super(data);
        this.position = position;
    }

    @Override
    public void add() {
        data.add(computePosition(), ELEMENT);
    }

    @Override
    public void remove() {
        data.remove(computePosition());
    }

    @Override
    public void search() {
        data.indexOf(DEFAULT_ELEMENT);
    }

    private int computePosition() {
        return position.getPosition(data.size());
    }
}
