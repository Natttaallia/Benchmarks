package com.example.benchmarks.app.ui.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.benchmarks.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CollectionSizeDialog extends DialogFragment {

    public static String TAG = "CollectionSizeDialog";

    private TextInputEditText inputEditText;
    private TextInputLayout sizeInputLayout;

    public interface CollectionSizeDialogListener {
        void sendSize(int size);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_collection_size, container, false);
        Button button = view.findViewById(R.id.button);
        inputEditText = view.findViewById(R.id.size_input);
        sizeInputLayout = (TextInputLayout) view.findViewById(R.id.size_input_layout);
        button.setOnClickListener(x -> {
            String input = inputEditText.getText().toString();
            int number = 0;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                sizeInputLayout.setError("Error. You need to enter elements count.");
                inputEditText.setText("");
            }
            if (number >= 1_000_000 && number <= 10_000_000) {
                sendBackResult(number);
            } else {
                sizeInputLayout.setError("Error. You need to enter elements count.");
                inputEditText.clearComposingText();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    public void sendBackResult(int size) {
        ((CollectionSizeDialogListener) requireActivity()).sendSize(size);
        dismiss();
    }
}