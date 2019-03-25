package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eldarja.eshop.R;

public class KategorijaAddFragment extends Fragment {

    public static KategorijaAddFragment newInstance() {
        KategorijaAddFragment kategorijaAddFragment = new KategorijaAddFragment();
        Bundle args = new Bundle();
        kategorijaAddFragment.setArguments(args);

        return kategorijaAddFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // get args
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.kategorija_add_fragment, container, false);

        return view;
    }
}
