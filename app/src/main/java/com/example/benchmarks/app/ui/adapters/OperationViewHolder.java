package com.example.benchmarks.app.ui.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;

public class OperationViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public OperationViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_operation_title);
    }

    public void setTitle(int titleId, Long time) {
        textView.setText(itemView.getContext().getString(titleId, getTime(time)));
    }

    private String getTime(Long time) {
        if (time == 0L) return itemView.getContext().getString(R.string.empty_time);
        return time.toString();
    }


}

