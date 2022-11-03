package com.example.benchmarks.data;

import com.example.benchmarks.R;
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
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customArrayList), R.string.add_b_al));
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customLinkedList), R.string.add_b_ll));
        arrayList.add(new OperationItem<>(new AddOperation<>(startPosition, customCopyOnWriteArrayList), R.string.add_b_cl));
        arrayList.add(new OperationItem<>(new AddOperation<>(middlePosition, customArrayList), R.string.add_m_al));
        arrayList.add(new OperationItem<>(new AddOperation<>(middlePosition, customLinkedList), R.string.add_m_ll));
        arrayList.add(new OperationItem<>(new AddOperation<>(middlePosition, customCopyOnWriteArrayList), R.string.add_m_cl));
        arrayList.add(new OperationItem<>(new AddOperation<>(endPosition, customArrayList), R.string.add_e_al));
        arrayList.add(new OperationItem<>(new AddOperation<>(endPosition, customLinkedList), R.string.add_e_ll));
        arrayList.add(new OperationItem<>(new AddOperation<>(endPosition, customCopyOnWriteArrayList), R.string.add_e_cl));
        return arrayList;
    }

}
