package com.example.benchmarks.data;

import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.AddOperation;
import com.example.benchmarks.domain.models.position.EndPosition;
import com.example.benchmarks.domain.models.position.MiddlePosition;
import com.example.benchmarks.domain.models.position.StartPosition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class OperationsFactory {

    StartPosition startPosition = new StartPosition();
    MiddlePosition middlePosition = new MiddlePosition();
    EndPosition endPosition = new EndPosition();

    CustomList<ArrayList<Integer>> customArrayList = new CustomList<>();
    CustomList<LinkedList<Integer>> customLinkedList = new CustomList<>();
    CustomList<CopyOnWriteArrayList<Integer>> customCopyOnWriteArrayList = new CustomList<>();

    public ArrayList<OperationItem> getCollectionsOperations() {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customArrayList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customLinkedList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customCopyOnWriteArrayList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(middlePosition, customArrayList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(middlePosition, customLinkedList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(middlePosition, customCopyOnWriteArrayList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(endPosition, customArrayList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(endPosition, customLinkedList), "Title"));
        arrayList.add(new OperationItem<>(new AddOperation<>(endPosition, customCopyOnWriteArrayList), "Title"));
        return arrayList;
    }

}
