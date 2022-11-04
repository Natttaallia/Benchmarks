package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.data.models.OperationStatus;
import com.example.benchmarks.domain.models.collection.CustomDataStructure;

import io.reactivex.rxjava3.core.Observable;


public abstract class Operation {
    public static Long OPERATION_TIME_DEFAULT = -1L;

    CustomDataStructure collection;
    int id;
    Long time = OPERATION_TIME_DEFAULT;
    OperationStatus status = OperationStatus.READY;

    Operation(CustomDataStructure collection, int id) {
        this.collection = collection;
        this.id = id;
    }

    public Observable<Integer> executeAndReturnUptime(int operationsAmount) {
        return Observable.defer(() -> emitter -> {
            time = OPERATION_TIME_DEFAULT;
            status = OperationStatus.LOADING;
            emitter.onNext(id);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < operationsAmount; i++) {
                execute();
            }
            time = System.currentTimeMillis() - startTime;
            status = OperationStatus.READY;
            emitter.onNext(id);
        });
    }
    abstract void execute();

    public Long getTime() {
        return time;
    }

    public OperationStatus getStatus() {
        return status;
    }
}
