package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomCollection;
import com.example.benchmarks.domain.models.position.Position;

public class AddOperation extends Operation {

    public AddOperation(Position position, CustomCollection collection) {
        super(position, collection);
    }

    @Override
    void execute() {
        collection.add(position.getPosition(collection.size()), 1);
    }
}
