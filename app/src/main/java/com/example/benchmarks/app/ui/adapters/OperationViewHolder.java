package com.example.benchmarks.app.ui.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;

public class OperationViewHolder extends RecyclerView.ViewHolder{
    private final TextView textView;

    public OperationViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_operation_title);
    }

    public TextView getTextView() {
        return textView;
    }
}

