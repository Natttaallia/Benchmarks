package com.example.benchmarks.data;

import androidx.annotation.StringRes;

import com.example.benchmarks.domain.models.operation.Operation;

public class OperationItem {
    Operation operation;
    @StringRes int titleId;

    public OperationItem(Operation operation, @StringRes int titleId) {
        this.operation = operation;
        this.titleId = titleId;
    }

    public int getTitleId() {
        return titleId;
    }

    public Long getTime() {
        return operation.getTime();
    }

    public Operation getOperation() {
        return operation;
    }

    public OperationStatus getStatus() {return operation.getStatus(); }

}
