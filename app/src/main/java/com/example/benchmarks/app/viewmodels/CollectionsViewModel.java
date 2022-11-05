package com.example.benchmarks.app.viewmodels;

import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.benchmarks.data.factories.collection.CollectionOperationsFactory;
import com.example.benchmarks.domain.models.operation.Operation;
import com.example.benchmarks.domain.models.usecases.GetCollectionsUseCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import kotlin.Triple;

public class CollectionsViewModel extends ViewModel {

    private final GetCollectionsUseCase getCollectionsUseCase = new GetCollectionsUseCase();
    private final CollectionOperationsFactory operationsFactory = new CollectionOperationsFactory();

    private Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>> collections;
    private ArrayList<Operation> operations;

    private final MutableLiveData<Boolean> _isOperationsInitialize = new MutableLiveData<>(false);
    public LiveData<Boolean> isOperationsInitialize = _isOperationsInitialize;

    public PublishSubject<Pair<Integer, Long>> itemChangedPosition = PublishSubject.create();

    int collectionSize;
    int operationsAmount;

    public void createCollections(Integer size) {
        collectionSize = size;
        getCollectionsUseCase.getCollections(collectionSize)
                .subscribeOn(Schedulers.computation())
                .subscribe(data -> {
                    collections = data;
                    loadOperations();
                });
    }

    public boolean checkOperationsAmount(String text) {
        try {
            operationsAmount = Integer.parseInt(text);
            return (operationsAmount < collectionSize && operationsAmount > 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void startCalculation() {
        for (int i = 0; i < operations.size(); i++) {
            operations.get(i).executeAndReturnUptime(i, operationsAmount)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.computation())
                    .subscribe(pair -> itemChangedPosition.onNext(pair));
        }
    }

    void loadOperations() {
        Single.just(operationsFactory.getCollectionsOperations(collections))
                .subscribeOn(Schedulers.computation())
                .subscribe(data -> {
                    operations = data;
                    _isOperationsInitialize.postValue(true);
                });
    }
}
