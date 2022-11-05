package com.example.benchmarks.domain.models.collection;

import static com.example.benchmarks.domain.models.usecases.GetCollectionsUseCase.DEFAULT_ELEMENT;

import java.util.Map;
import java.util.Random;

public class CustomMap<T extends Map> extends CustomDataStructure<T> {

    Random random = new Random();

    public CustomMap(T data) {
        super(data);
    }

    @Override
    public void add() {
        data.put(random.nextInt(), DEFAULT_ELEMENT);
    }

    @Override
    public void remove() {
        data.remove(data.keySet().toArray()[0]);
    }

    @Override
    public void search() {
        data.containsValue(DEFAULT_ELEMENT);
    }
}