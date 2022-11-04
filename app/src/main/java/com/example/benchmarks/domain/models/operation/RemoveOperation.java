package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomDataStructure;
import com.example.benchmarks.domain.models.position.Position;

public class RemoveOperation extends Operation {

    public RemoveOperation(Position position, CustomDataStructure collection, int id) {
        super(position, collection, id);
    }

    @Override
    void execute() {
        collection.remove(position.getPosition(collection.size()));
    }
}
