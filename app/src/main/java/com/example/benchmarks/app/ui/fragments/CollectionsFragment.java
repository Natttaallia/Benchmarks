package com.example.benchmarks.app.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class CollectionsFragment extends Fragment {
    private TextInputLayout mOperationsAmountLayout;
    private TextInputEditText mOperationsAmountInput;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private OperationsAdapter mAdapter;
    private CollectionsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CollectionsViewModel.class);

        mProgressBar = view.findViewById(R.id.fragment_collections_pb);
        mRecyclerView = view.findViewById(R.id.collections_rv);
        mOperationsAmountInput = view.findViewById(R.id.c_operations_amount_input);
        mOperationsAmountLayout = view.findViewById(R.id.c_operations_amount_layout);
        Button mOperationsAmountButton = view.findViewById(R.id.c_operations_amount_btn);
        initRecyclerView();
        observeCollectionSize();
        mOperationsAmountButton.setOnClickListener(this::onButtonClick);
    }

    private void observeCollectionSize() {
        ((MainActivity) getActivity()).getCollectionSize().observe(getViewLifecycleOwner(), size -> {
            viewModel.createCollections(size);
            observeCollections();
        });
    }

    private void observeCollections() {
        viewModel.collections.observe(getViewLifecycleOwner(), triple -> {
            viewModel.loadOperationsItem();
            mProgressBar.setVisibility(View.GONE);
            observeOperations();
        });
    }

    private void observeOperations() {
        viewModel.operations.observe(getViewLifecycleOwner(), operationItems -> {
            mAdapter.setData(operationItems);
            observeItemChanged();
        });
    }

    private void observeItemChanged() {
        viewModel.itemChangedPosition
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(position -> {
            Log.e("pos", String.valueOf(position));
            mAdapter.notifyItemChanged(position);
        });
    }

    private void onButtonClick(View view) {
        if (viewModel.checkOperationsAmount(mOperationsAmountInput.getText().toString())) {
            viewModel.startCalculation();
        } else {
            setInputErrorText(getString(R.string.invalid_input));
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
}
