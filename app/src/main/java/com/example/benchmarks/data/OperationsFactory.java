package com.example.benchmarks.data;

import com.example.benchmarks.R;
import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.AddOperation;
import com.example.benchmarks.domain.models.operation.RemoveOperation;
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
        arrayList.add(new OperationItem(new AddOperation(startPosition, new CustomList<>(new ArrayList(collections.component1())), position++), R.string.add_b_al));
        arrayList.add(new OperationItem(new AddOperation(startPosition, new CustomList<>(new LinkedList(collections.component2())), position++), R.string.add_b_ll));
        arrayList.add(new OperationItem(new AddOperation(startPosition, new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position++), R.string.add_b_cl));
        arrayList.add(new OperationItem(new AddOperation(middlePosition, new CustomList<>(new ArrayList(collections.component1())), position++), R.string.add_m_al));
        arrayList.add(new OperationItem(new AddOperation(middlePosition, new CustomList<>(new LinkedList(collections.component2())), position++), R.string.add_m_ll));
        arrayList.add(new OperationItem(new AddOperation(middlePosition, new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position++), R.string.add_m_cl));
        arrayList.add(new OperationItem(new AddOperation(endPosition, new CustomList<>(new ArrayList(collections.component1())), position++), R.string.add_e_al));
        arrayList.add(new OperationItem(new AddOperation(endPosition, new CustomList<>(new LinkedList(collections.component2())), position++), R.string.add_e_ll));
        arrayList.add(new OperationItem(new AddOperation(endPosition, new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position++), R.string.add_e_cl));
        arrayList.add(new OperationItem(new RemoveOperation(startPosition, new CustomList<>(new ArrayList(collections.component1())), position++), R.string.remove_b_al));
        arrayList.add(new OperationItem(new RemoveOperation(startPosition, new CustomList<>(new LinkedList(collections.component2())), position++), R.string.remove_b_ll));
        arrayList.add(new OperationItem(new RemoveOperation(startPosition, new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position++), R.string.remove_b_cl));
        arrayList.add(new OperationItem(new RemoveOperation(middlePosition, new CustomList<>(new ArrayList(collections.component1())), position++), R.string.remove_m_al));
        arrayList.add(new OperationItem(new RemoveOperation(middlePosition, new CustomList<>(new LinkedList(collections.component2())), position++), R.string.remove_m_ll));
        arrayList.add(new OperationItem(new RemoveOperation(middlePosition, new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position++), R.string.remove_m_cl));
        arrayList.add(new OperationItem(new RemoveOperation(endPosition, new CustomList<>(new ArrayList(collections.component1())), position++), R.string.remove_e_al));
        arrayList.add(new OperationItem(new RemoveOperation(endPosition, new CustomList<>(new LinkedList(collections.component2())), position++), R.string.remove_e_ll));
        arrayList.add(new OperationItem(new RemoveOperation(endPosition, new CustomList<>(new CopyOnWriteArrayList(collections.component3())), position), R.string.remove_e_cl));
        return arrayList;
    }

}
