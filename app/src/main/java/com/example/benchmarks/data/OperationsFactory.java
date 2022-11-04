package com.example.benchmarks.data;

import com.example.benchmarks.R;
import com.example.benchmarks.data.models.OperationItem;
import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.AddOperation;
import com.example.benchmarks.domain.models.operation.RemoveOperation;
import com.example.benchmarks.domain.models.operation.SearchOperation;
import com.example.benchmarks.domain.models.position.EndPosition;
import com.example.benchmarks.domain.models.position.MiddlePosition;
import com.example.benchmarks.domain.models.position.StartPosition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import kotlin.Triple;

public class OperationsFactory {

    StartPosition startPosition = new StartPosition();
    MiddlePosition middlePosition = new MiddlePosition();
    EndPosition endPosition = new EndPosition();

    public ArrayList<OperationItem> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        int position = 0;
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new ArrayList(collections.component1()), startPosition), position++), R.string.add_b_al));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new LinkedList(collections.component2()), startPosition), position++), R.string.add_b_ll));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3()), startPosition), position++), R.string.add_b_cl));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new ArrayList(collections.component1()), middlePosition), position++), R.string.add_m_al));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new LinkedList(collections.component2()), middlePosition), position++), R.string.add_m_ll));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3()), middlePosition), position++), R.string.add_m_cl));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new ArrayList(collections.component1()), endPosition), position++), R.string.add_e_al));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new LinkedList(collections.component2()), endPosition), position++), R.string.add_e_ll));
        arrayList.add(new OperationItem(new AddOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3()), endPosition), position++), R.string.add_e_cl));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new ArrayList(collections.component1()), startPosition), position++), R.string.remove_b_al));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new LinkedList(collections.component2()), startPosition), position++), R.string.remove_b_ll));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3()), startPosition), position++), R.string.remove_b_cl));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new ArrayList(collections.component1()), middlePosition), position++), R.string.remove_m_al));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new LinkedList(collections.component2()), middlePosition), position++), R.string.remove_m_ll));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3()), middlePosition), position++), R.string.remove_m_cl));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new ArrayList(collections.component1()), endPosition), position++), R.string.remove_e_al));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new LinkedList(collections.component2()), endPosition), position++), R.string.remove_e_ll));
        arrayList.add(new OperationItem(new RemoveOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3()), endPosition), position++), R.string.remove_e_cl));
        arrayList.add(new OperationItem(new SearchOperation(new CustomList<>(new ArrayList(collections.component3())), position++), R.string.search_al));
        arrayList.add(new OperationItem(new SearchOperation(new CustomList<>(new LinkedList(collections.component3())), position++), R.string.search_ll));
        arrayList.add(new OperationItem(new SearchOperation(new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position), R.string.search_cl));
        return arrayList;
    }

}
