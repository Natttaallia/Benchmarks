package com.example.benchmarks.data.factories.collection;

import androidx.annotation.StringRes;

import com.example.benchmarks.R;
import com.example.benchmarks.data.models.OperationItem;
import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.SearchOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kotlin.Triple;

public class CollectionSearchOperationsFactory {

    ArrayList<OperationItem> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        arrayList.add(getOperationItem(new ArrayList<>(collections.component3()), R.string.search_al));
        arrayList.add(getOperationItem(new LinkedList<>(collections.component3()), R.string.search_ll));
        arrayList.add(getOperationItem(new CopyOnWriteArrayList<>(collections.component3()), R.string.search_cl));
        return arrayList;
    }

    OperationItem getOperationItem(List<Integer> data, @StringRes int title) {
        return new OperationItem(new SearchOperation(new CustomList<>(data)), title);
    }
}