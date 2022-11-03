package com.example.benchmarks.app.ui.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.benchmarks.data.OperationsFactory;
import com.example.benchmarks.domain.models.OperationItem;
import com.example.benchmarks.domain.models.usecases.GetCollectionsUseCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Triple;

public class CollectionsViewModel extends ViewModel {

    private final GetCollectionsUseCase getCollectionsUseCase = new GetCollectionsUseCase();
    private final OperationsFactory operationsFactory = new OperationsFactory();

    private final MutableLiveData<Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>>> _collections = new MutableLiveData();
    public LiveData<Triple<ArrayList<Integer>, LinkedList<Integer>, CopyOnWriteArrayList<Integer>>> collections = _collections;

    int collectionSize;
    int operationsAmount;

    private final MutableLiveData<ArrayList<OperationItem>> _operations = new MutableLiveData<>();
    public LiveData<ArrayList<OperationItem>> operations = _operations;

    public void createCollections(Integer size) {
        collectionSize = size;
        getCollectionsUseCase.getCollections(collectionSize)
                .subscribeOn(Schedulers.computation())
                .subscribe(_collections::postValue);
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
        for (OperationItem operationItem : _operations.getValue()) {
            operationItem.getOperation().executeAndReturnUptime(operationsAmount)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(time -> Log.e("time", time.toString()));
        }
    }

    public void loadOperationsItem() {
        _operations.postValue(operationsFactory.getCollectionsOperations(_collections.getValue()));
    }
}
