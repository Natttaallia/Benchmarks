package com.example.benchmarks.data.factories.collection;

import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.Operation;
import com.example.benchmarks.domain.models.operation.SearchOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kotlin.Triple;

public class CollectionSearchOperationsFactory {

    ArrayList<Operation> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<Operation> arrayList = new ArrayList<>();
        arrayList.add(getOperation(new ArrayList<>(collections.component3())));
        arrayList.add(getOperation(new LinkedList<>(collections.component3())));
        arrayList.add(getOperation(new CopyOnWriteArrayList<>(collections.component3())));
        return arrayList;
    }

    Operation getOperation(List<Integer> data) {
        return new SearchOperation(new CustomList<>(data));
    }
}