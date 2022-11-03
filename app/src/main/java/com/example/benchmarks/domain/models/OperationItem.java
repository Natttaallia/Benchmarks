package com.example.benchmarks.domain.models;

import androidx.annotation.StringRes;

import com.example.benchmarks.domain.models.operation.Operation;

public class OperationItem {
    Operation operation;
    @StringRes int titleId;
    Long time = 0L;

    public OperationItem(Operation operation, @StringRes int titleId) {
        this.operation = operation;
        this.titleId = titleId;
    }

    public int getTitleId() {
        return titleId;
    }

    public Long getTime() {
        return time;
    }

    public Operation getOperation() {
        return operation;
    }

}
