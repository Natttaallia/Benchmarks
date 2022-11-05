package com.example.benchmarks.data.factories.collection;

import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.Operation;
import com.example.benchmarks.domain.models.operation.RemoveOperation;
import com.example.benchmarks.domain.models.position.Position;

import java.util.List;

public class CollectionRemoveOperationsFactory extends PositionOperationsFactory {

    @Override
    Operation getOperation(List<Integer> data, Position position) {
        return new RemoveOperation(new CustomList<>(data, position));
    }
}
