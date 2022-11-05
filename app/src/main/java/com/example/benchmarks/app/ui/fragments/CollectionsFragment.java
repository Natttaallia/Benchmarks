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
import com.example.benchmarks.app.viewmodels.CollectionsViewModel;
import com.example.benchmarks.data.factories.OperationItemsFactory;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class CollectionsFragment extends Fragment {

    OperationItemsFactory operationItemsFactory = new OperationItemsFactory();

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
        if (getActivity() == null) return;
        ((MainActivity) getActivity()).collectionSize.observe(getViewLifecycleOwner(), size -> {
            viewModel.createCollections(size);
            observeInitialization();
        });
    }

    private void observeInitialization() {
        viewModel.isOperationsInitialize.observe(getViewLifecycleOwner(), isCompleted -> {
            if (isCompleted) {
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    private void onButtonClick(View view) {
        if (viewModel.checkOperationsAmount(mOperationsAmountInput.getText().toString())) {
            mAdapter.startLoading();
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
        mAdapter.setData(operationItemsFactory.getOperationItems(getResources().getStringArray(R.array.collection_operation_titles)));
        observeItemChanged();
    }

    private void observeItemChanged() {
        viewModel.itemChangedPosition
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pair -> mAdapter.setResultForItem(pair.first, pair.second));
    }
}
