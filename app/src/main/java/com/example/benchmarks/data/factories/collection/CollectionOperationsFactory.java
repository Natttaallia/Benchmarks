package com.example.benchmarks.data.factories.collection;

import com.example.benchmarks.data.models.OperationItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import kotlin.Triple;

public class CollectionOperationsFactory {

    CollectionAddOperationsFactory addOperationsFactory = new CollectionAddOperationsFactory();
    CollectionRemoveOperationsFactory removeOperationsFactory = new CollectionRemoveOperationsFactory();
    CollectionSearchOperationsFactory searchOperationsFactory = new CollectionSearchOperationsFactory();

    public ArrayList<OperationItem> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        arrayList.addAll(addOperationsFactory.getCollectionsOperations(collections));
        arrayList.addAll(removeOperationsFactory.getCollectionsOperations(collections));
        arrayList.addAll(searchOperationsFactory.getCollectionsOperations(collections));
        return arrayList;
    }

}
