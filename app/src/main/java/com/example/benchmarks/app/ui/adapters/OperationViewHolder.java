package com.example.benchmarks.app.ui.adapters;

import static com.example.benchmarks.domain.models.operation.Operation.OPERATION_TIME_DEFAULT;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.data.OperationStatus;

public class OperationViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    private final ProgressBar progressBar;

    public OperationViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_operation_title);
        progressBar = itemView.findViewById(R.id.item_operation_pb);
    }

    public void setTitle(int titleId, Long time) {
        textView.setText(itemView.getContext().getString(titleId, getTime(time)));
    }

    public void setStatus(OperationStatus status) {
        progressBar.setVisibility(status == OperationStatus.LOADING ? View.VISIBLE : View.GONE);
    }

    private String getTime(Long time) {
        if (time.equals(OPERATION_TIME_DEFAULT)) return itemView.getContext().getString(R.string.empty_time);
        return time.toString();
    }


}

