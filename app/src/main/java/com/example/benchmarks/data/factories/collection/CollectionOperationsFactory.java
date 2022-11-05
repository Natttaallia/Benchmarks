package com.example.benchmarks.data.factories.collection;

import com.example.benchmarks.domain.models.operation.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import kotlin.Triple;

public class CollectionOperationsFactory {

    CollectionAddOperationsFactory addOperationsFactory = new CollectionAddOperationsFactory();
    CollectionRemoveOperationsFactory removeOperationsFactory = new CollectionRemoveOperationsFactory();
    CollectionSearchOperationsFactory searchOperationsFactory = new CollectionSearchOperationsFactory();

    public ArrayList<Operation> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<Operation> arrayList = new ArrayList<>();
        arrayList.addAll(addOperationsFactory.getCollectionsOperations(collections));
        arrayList.addAll(removeOperationsFactory.getCollectionsOperations(collections));
        arrayList.addAll(searchOperationsFactory.getCollectionsOperations(collections));
        return arrayList;
    }

}
