package com.example.benchmarks.domain.models.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Triple;

public class GetCollectionsUseCase {
    public static Integer DEFAULT_ELEMENT = 7;

    @NonNull
    public Single<Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>>> getCollections(int size) {
        return Single.zip(
                getArrayList(size),
                getLinkedList(size),
                getCopyList(size),
                Triple::new);
    }

    Single<ArrayList<Integer>> getArrayList(int size) {
        return Single.just(new ArrayList<>(Collections.nCopies(size, DEFAULT_ELEMENT)));
    }

    Single<CopyOnWriteArrayList<Integer>> getCopyList(int size) {
        return Single.just(new CopyOnWriteArrayList<>(Collections.nCopies(size, DEFAULT_ELEMENT)));
    }

    Single<LinkedList<Integer>> getLinkedList(int size) {
        return Single.just(new LinkedList<>(Collections.nCopies(size, DEFAULT_ELEMENT)));
    }
}
