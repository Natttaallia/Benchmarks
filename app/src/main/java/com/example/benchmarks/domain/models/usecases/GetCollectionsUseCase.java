package com.example.benchmarks.domain.models.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Triple;

public class GetCollectionsUseCase {
    private final Integer DEFAULT_ELEMENT = 7;

    @NonNull
    public Observable<Triple> getCollections(int size) {
        return Observable.zip(
                getArrayList(size),
                getCopyList(size),
                getLinkedList(size),
                Triple::new);
    }

    Observable<ArrayList<Integer>> getArrayList(int size) {
        return Observable.defer(() -> Observable.just(new ArrayList<>(Collections.nCopies(size, DEFAULT_ELEMENT))));
    }

    Observable<CopyOnWriteArrayList<Integer>> getCopyList(int size) {
        return Observable.defer(() -> Observable.just(new CopyOnWriteArrayList<>(Collections.nCopies(size, DEFAULT_ELEMENT))));
    }

    Observable<LinkedList<Integer>> getLinkedList(int size) {
        return Observable.defer(() -> Observable.just(new LinkedList<>(Collections.nCopies(size, DEFAULT_ELEMENT))));
    }
}
