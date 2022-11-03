package com.example.benchmarks.domain.models;

import com.example.benchmarks.domain.models.operation.Operation;

public class OperationItem<O extends Operation> {
    O operation;
    String title;
    Long time = 0L;

    public OperationItem(O operation, String title) {
        this.operation = operation;
        this.title = title;
    }

}
