package com.example.benchmarks.data;

import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.domain.models.collection.CustomArrayList;
import com.example.benchmarks.domain.models.operation.AddOperation;
import com.example.benchmarks.domain.models.position.EndPosition;
import com.example.benchmarks.domain.models.position.MiddlePosition;
import com.example.benchmarks.domain.models.position.StartPosition;

import java.util.ArrayList;

public class OperationsFactory {

    int size;

    OperationsFactory(int size) {
        this.size = size;
    }

    StartPosition startPosition = new StartPosition();
    MiddlePosition middlePosition = new MiddlePosition();
    EndPosition endPosition = new EndPosition();

    CustomArrayList<ArrayList<Integer>> customArrayList = new CustomArrayList<>(size);

    ArrayList<OperationItem> getOperations() {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customArrayList), "Title"));
        return arrayList;
    }

}
