package com.example.benchmarks.domain.models.operation;

import com.example.benchmarks.domain.models.collection.CustomDataStructure;

public class SearchOperation extends Operation {

    public SearchOperation(CustomDataStructure collection, int id) {
        super(collection, id);
    }

    @Override
    void execute() {
        collection.search();
    }
}
