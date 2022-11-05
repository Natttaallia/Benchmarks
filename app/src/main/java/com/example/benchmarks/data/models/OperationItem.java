package com.example.benchmarks.data.models;

public class OperationItem {
    public static Long OPERATION_TIME_DEFAULT = -1L;

    public Long time = OPERATION_TIME_DEFAULT;
    public OperationStatus status = OperationStatus.READY;
    String title;

    public OperationItem(String titleId) {
        this.title = titleId;
    }

    public String getTitle() {
        return title;
    }
}
