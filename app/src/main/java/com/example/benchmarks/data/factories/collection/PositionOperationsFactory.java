package com.example.benchmarks.data.factories.collection;

import androidx.annotation.StringRes;

import com.example.benchmarks.R;
import com.example.benchmarks.data.models.OperationItem;
import com.example.benchmarks.domain.models.position.EndPosition;
import com.example.benchmarks.domain.models.position.MiddlePosition;
import com.example.benchmarks.domain.models.position.Position;
import com.example.benchmarks.domain.models.position.StartPosition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kotlin.Triple;

public abstract class PositionOperationsFactory {

    StartPosition startPosition = new StartPosition();
    MiddlePosition middlePosition = new MiddlePosition();
    EndPosition endPosition = new EndPosition();

    public ArrayList<OperationItem> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        arrayList.add(getOperationItemArrayList(collections.component1(), startPosition, R.string.add_b_al));
        arrayList.add(getOperationItemLinkedList(collections.component2(), startPosition, R.string.add_b_ll));
        arrayList.add(getOperationItemCopyList(collections.component3(), startPosition, R.string.add_b_cl));
        arrayList.add(getOperationItemArrayList(collections.component1(), middlePosition, R.string.add_m_al));
        arrayList.add(getOperationItemLinkedList(collections.component2(), middlePosition, R.string.add_m_ll));
        arrayList.add(getOperationItemCopyList(collections.component3(), middlePosition, R.string.add_m_cl));
        arrayList.add(getOperationItemArrayList(collections.component1(), endPosition, R.string.add_e_al));
        arrayList.add(getOperationItemLinkedList(collections.component2(), endPosition, R.string.add_e_ll));
        arrayList.add(getOperationItemCopyList(collections.component3(), endPosition, R.string.add_e_cl));
        return arrayList;
    }

    OperationItem getOperationItemArrayList(List<Integer> data, Position position, @StringRes int title) {
        return getOperationItem(new ArrayList<>(data), position, title);
    }

    OperationItem getOperationItemLinkedList(List<Integer> data, Position position, @StringRes int title) {
        return getOperationItem(new LinkedList<>(data), position, title);
    }

    OperationItem getOperationItemCopyList(List<Integer> data, Position position, @StringRes int title) {
        return getOperationItem(new CopyOnWriteArrayList<>(data), position, title);
    }

    abstract OperationItem getOperationItem(List<Integer> integers, Position position, int title);
}
