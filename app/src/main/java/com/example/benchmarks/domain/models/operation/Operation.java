package com.example.benchmarks.domain.models.operation;

import android.util.Pair;

import com.example.benchmarks.data.models.OperationStatus;
import com.example.benchmarks.domain.models.collection.CustomDataStructure;

import io.reactivex.rxjava3.core.Observable;


public abstract class Operation {
    CustomDataStructure collection;

    Operation(CustomDataStructure collection) {
        this.collection = collection;
    }

    public Observable<Pair<Integer, Long>> executeAndReturnUptime(int index, int operationsAmount) {
        return Observable.defer(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < operationsAmount; i++) {
                execute();
            }
            return Observable.just(new Pair<>(index, System.currentTimeMillis() - startTime));
        });
    }
    abstract void execute();
}
