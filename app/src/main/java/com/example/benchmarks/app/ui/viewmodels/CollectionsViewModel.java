package com.example.benchmarks.app.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.benchmarks.data.OperationsFactory;
import com.example.benchmarks.domain.models.OperationItem;

import java.util.ArrayList;
import java.util.List;

public class CollectionsViewModel extends ViewModel {

    private OperationsFactory operationsFactory = new OperationsFactory();

    private MutableLiveData<ArrayList<OperationItem>> operations;

    public LiveData<ArrayList<OperationItem>> getOperations() {
        if (operations == null) {
            operations = new MutableLiveData<>();
            loadOperations();
        }
        return operations;
    }

    private void loadOperations() {
        operations.postValue(operationsFactory.getCollectionsOperations());
    }


}
