package com.example.benchmarks.data.factories.collection;

import androidx.annotation.StringRes;

import com.example.benchmarks.data.models.OperationItem;
import com.example.benchmarks.domain.models.collection.CustomList;
import com.example.benchmarks.domain.models.operation.AddOperation;
import com.example.benchmarks.domain.models.position.Position;

import java.util.List;

public class CollectionAddOperationsFactory extends PositionOperationsFactory {

    @Override
    OperationItem getOperationItem(List<Integer> data, Position position, @StringRes int title) {
        return new OperationItem(new AddOperation(new CustomList<>(data, position)), title);
    }
}
