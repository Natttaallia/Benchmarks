package com.example.benchmarks.app.ui.adapters;

import static com.example.benchmarks.data.models.OperationItem.OPERATION_TIME_DEFAULT;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.data.models.OperationStatus;

public class OperationViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    private final ProgressBar progressBar;

    public OperationViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_operation_title);
        progressBar = itemView.findViewById(R.id.item_operation_pb);
    }

    public void setTitle(String title, Long time) {
        textView.setText(getTitle(title, time));
    }

    public void setStatus(OperationStatus status) {
        progressBar.setVisibility(status == OperationStatus.LOADING ? View.VISIBLE : View.GONE);
    }

    private String getTitle(String title, Long time) {
        if (time.equals(OPERATION_TIME_DEFAULT)) return title + itemView.getContext().getString(R.string.empty_time);
        return title + itemView.getContext().getString(R.string.time_ms, time);
    }

}

