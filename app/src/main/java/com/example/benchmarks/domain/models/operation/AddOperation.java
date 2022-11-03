package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomCollection;
import com.example.benchmarks.domain.models.position.Position;

public class AddOperation<P extends Position, C extends CustomCollection> extends Operation<P, C>{
    public AddOperation(P position, C collection) {
        super(position, collection);
    }

    @Override
    void execute() {
        collection.add(position.getPosition(collection.size()), 1);
    }
}
