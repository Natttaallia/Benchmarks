package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomDataStructure;

public class RemoveOperation extends Operation {

    public RemoveOperation(CustomDataStructure collection) {
        super(collection);
    }

    @Override
    void execute() {
        collection.remove();
    }
}
