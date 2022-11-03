package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomCollection;
import com.example.benchmarks.domain.models.position.Position;

public abstract class Operation<P extends Position, C extends CustomCollection> {
    P position;
    C collection;

    Operation(P position, C collection) {
        this.position = position;
        this.collection = collection;
    }

    <T> long executeAndReturnUptime(T data, int operationsAmount) {
        collection.initialize(data);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < operationsAmount; i++) {
            execute();
        }
        return System.currentTimeMillis() - startTime;
    }
    abstract void execute();
}
