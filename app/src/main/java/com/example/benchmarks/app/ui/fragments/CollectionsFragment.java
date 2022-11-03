package com.example.benchmarks.app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmarks.R;
import com.example.benchmarks.app.ui.MainActivity;
import com.example.benchmarks.app.ui.adapters.OperationsAdapter;
import com.example.benchmarks.app.ui.viewmodels.CollectionsViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CollectionsFragment extends Fragment {
    private int operationsAmount;
    private TextInputLayout mOperationsAmountLayout;
    private TextInputEditText mOperationsAmountInput;
    private RecyclerView mRecyclerView;
    private OperationsAdapter mAdapter;
    private CollectionsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CollectionsViewModel.class);
        mRecyclerView = view.findViewById(R.id.collections_rv);
        initRecyclerView();

        mOperationsAmountInput = view.findViewById(R.id.c_operations_amount_input);
        mOperationsAmountLayout = view.findViewById(R.id.c_operations_amount_layout);
        final Button operationsAmountButton = view.findViewById(R.id.c_operations_amount_btn);
        operationsAmountButton.setOnClickListener(this::onButtonClick);

        observeOperations();
    }

    private void observeOperations() {
        viewModel.getOperations().observe(getViewLifecycleOwner(), operationItems -> {
            mAdapter.setData(operationItems);
        });
    }

    private void onButtonClick(View view) {
        String input = mOperationsAmountInput.getText().toString();
        int operationsAmount = 0;
        int collectionSize = ((MainActivity) getActivity()).getCollectionSize();
        try {
            operationsAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            setInputErrorText("Enter a number.");
        }
        if (operationsAmount >= collectionSize) {
            setInputErrorText("Try less operations.");
        } else if (operationsAmount <= 0) {
            setInputErrorText("Try more operations.");
        } else {
            this.operationsAmount = operationsAmount;
            startCalculations();
        }
    }

    private void setInputErrorText(String text) {
        mOperationsAmountLayout.setError(text);
        mOperationsAmountInput.setText("");
    }

    private void initRecyclerView() {
        mAdapter = new OperationsAdapter();
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void startCalculations() {

    }
}
