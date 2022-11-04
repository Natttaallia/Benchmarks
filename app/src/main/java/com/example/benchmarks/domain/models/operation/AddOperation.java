package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomDataStructure;

public class AddOperation extends Operation {
    public static int ELEMENT = 1;

    public AddOperation(CustomDataStructure collection, int id) {
        super(collection, id);
    }

    @Override
    void execute() {
        collection.add(ELEMENT);
    }
}
