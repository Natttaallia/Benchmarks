package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomCollection;
import com.example.benchmarks.domain.models.position.Position;

import io.reactivex.rxjava3.core.Observable;


public abstract class Operation {
    Position position;
    CustomCollection collection;

    Operation(Position position, CustomCollection collection) {
        this.position = position;
        this.collection = collection;
    }

    public Observable<Long> executeAndReturnUptime(int operationsAmount) {
        return Observable.defer(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < operationsAmount; i++) {
                execute();
            }
            collection.size();
            return Observable.just(System.currentTimeMillis() - startTime);
        });
    }
    abstract void execute();
}
