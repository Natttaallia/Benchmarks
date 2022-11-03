package com.example.benchmarks.app.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.domain.models.OperationItem;

import java.util.ArrayList;
import java.util.List;

public class OperationsAdapter extends RecyclerView.Adapter<OperationViewHolder> {
    private ArrayList<OperationItem> data = new ArrayList<>();

    public void setData(ArrayList<OperationItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OperationViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_operation, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        holder.setTitle(data.get(position).getTitleId(), data.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
