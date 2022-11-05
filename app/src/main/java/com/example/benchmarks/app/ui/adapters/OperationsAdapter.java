package com.example.benchmarks.app.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.data.models.OperationItem;
import com.example.benchmarks.data.models.OperationStatus;

import java.util.ArrayList;

public class OperationsAdapter extends RecyclerView.Adapter<OperationViewHolder> {
    private ArrayList<OperationItem> data = new ArrayList<>();

    public void setData(ArrayList<OperationItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OperationViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_operation, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        holder.setTitle(data.get(position).getTitle(), data.get(position).time);
        holder.setStatus(data.get(position).status);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void startLoading() {
        for (OperationItem operationItem : data) {
            operationItem.status = OperationStatus.LOADING;
        }
        notifyDataSetChanged();
    }

    public void setResultForItem(Integer position, Long time) {
        data.get(position).time = time;
        data.get(position).status = OperationStatus.READY;
        notifyItemChanged(position);
    }
}
