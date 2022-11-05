package com.example.benchmarks.data.factories.collection;

import com.example.benchmarks.domain.models.operation.Operation;
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

    public ArrayList<Operation> getCollectionsOperations(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections) {
        ArrayList<Operation> arrayList = new ArrayList<>();
        arrayList.addAll(getTriple(collections, startPosition));
        arrayList.addAll(getTriple(collections, middlePosition));
        arrayList.addAll(getTriple(collections, endPosition));
        return arrayList;
    }

    ArrayList<Operation> getTriple(Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections, Position position) {
        ArrayList<Operation> arrayList = new ArrayList<>();
        arrayList.add(getOperationArrayList(collections.component1(), position));
        arrayList.add(getOperationLinkedList(collections.component2(), position));
        arrayList.add(getOperationCopyList(collections.component3(), position));
        return arrayList;
    }

    Operation getOperationArrayList(List<Integer> data, Position position) {
        return getOperation(new ArrayList<>(data), position);
    }

    Operation getOperationLinkedList(List<Integer> data, Position position) {
        return getOperation(new LinkedList<>(data), position);
    }

    Operation getOperationCopyList(List<Integer> data, Position position) {
        return getOperation(new CopyOnWriteArrayList<>(data), position);
    }

    abstract Operation getOperation(List<Integer> integers, Position position);
}
