package com.example.benchmarks.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.benchmarks.R;
import com.example.benchmarks.app.ui.adapters.VPAdapter;
import com.example.benchmarks.app.ui.dialogs.CollectionSizeDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements CollectionSizeDialog.CollectionSizeDialogListener {

    private int collectionSize;

    public int getCollectionSize() {
        return collectionSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(vpAdapter);
        CollectionSizeDialog dialog = new CollectionSizeDialog();
        if (savedInstanceState == null) {
            showDialog(dialog);
        }
    }

    public void showDialog(CollectionSizeDialog dialog) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content,
                dialog).commit();
//        dialog.show(getSupportFragmentManager(), CollectionSizeDialog.TAG);
    }

    @Override
    public void sendSize(int size) {
        collectionSize = size;
    }
}