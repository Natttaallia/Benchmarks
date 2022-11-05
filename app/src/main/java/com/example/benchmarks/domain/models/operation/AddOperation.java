package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomDataStructure;

public class AddOperation extends Operation {

    public AddOperation(CustomDataStructure collection) {
        super(collection);
    }

    @Override
    void execute() {
        collection.add();
    }
}
