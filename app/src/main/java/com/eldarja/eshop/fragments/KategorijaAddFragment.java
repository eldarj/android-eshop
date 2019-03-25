package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.eldarja.eshop.R;
import com.eldarja.eshop.helpers.MyFragmentHelper;

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

        final EditText txtKategorijaNaziv = view.findViewById(R.id.txtKategorijaNewNaziv);
        final EditText txtKategorijaOpis = view.findViewById(R.id.txtKategorijaNewOpis);

        Button btnKategorijaDalje = view.findViewById(R.id.btnKategorijaNewNext);
        btnKategorijaDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAGX", txtKategorijaNaziv.getText().toString());
                Log.i("TAGX", txtKategorijaOpis.getText().toString());

                MyFragmentHelper.displayFragment((AppCompatActivity) getActivity(),
                        R.id.fragmentContainer,
                        KategorijaChooseItemsFragment.newInstance());
            }
        });

        return view;
    }
}
