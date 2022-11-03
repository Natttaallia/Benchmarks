package com.example.benchmarks.app.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.benchmarks.app.ui.fragments.CollectionsFragment;
import com.example.benchmarks.app.ui.fragments.MapsFragment;

public class VPAdapter extends FragmentStateAdapter {

    public VPAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new CollectionsFragment();
        } else {
            return new MapsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

