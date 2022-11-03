package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomCollection;
import com.example.benchmarks.domain.models.position.Position;

public class RemoveOperation extends Operation {

    public RemoveOperation(Position position, CustomCollection collection) {
        super(position, collection);
    }

    @Override
    void execute() {
        collection.remove(position.getPosition(collection.size()));
    }
}
