package com.example.benchmarks.data.factories;

import com.example.benchmarks.data.models.OperationItem;

import java.util.ArrayList;

public class OperationItemsFactory {
    public ArrayList<OperationItem> getOperationItems(String[] titles) {
        ArrayList<OperationItem> arrayList = new ArrayList<>();
        for (String title : titles) {
            arrayList.add(new OperationItem(title));
        }
        return arrayList;
    }
}
