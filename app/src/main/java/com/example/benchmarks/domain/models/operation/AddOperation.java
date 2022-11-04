package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomDataStructure;
import com.example.benchmarks.domain.models.position.Position;

public class AddOperation extends Operation {

    public AddOperation(Position position, CustomDataStructure collection, int id) {
        super(position, collection, id);
    }

    @Override
    void execute() {
        collection.add(position.getPosition(collection.size()), 1);
    }
}
