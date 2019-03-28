package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.KategorijaVM;
import com.eldarja.eshop.helpers.MyFragmentHelper;

public class KategorijaAddFragment extends Fragment {

    private EditText txtKategorijaNaziv;
    private EditText txtKategorijaOpis;
    private Button btnDodajIteme;

    public static KategorijaAddFragment newInstance() {
        return new KategorijaAddFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kategorija_add_fragment, container, false);

        txtKategorijaNaziv = view.findViewById(R.id.txtKategorijaNewNaziv);
        txtKategorijaOpis = view.findViewById(R.id.txtKategorijaNewOpis);

        btnDodajIteme = view.findViewById(R.id.btnDodajIteme);
        btnDodajIteme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_btnDodajItemeClick();
            }
        });
        return view;
    }

    private void do_btnDodajItemeClick() {
        if (!txtKategorijaNaziv.getText().toString().isEmpty()) {
            KategorijaVM nova = new KategorijaVM(txtKategorijaNaziv.getText().toString());
            MyFragmentHelper.displayDialog((AppCompatActivity) getActivity(),
                    "KATEGORIJA_CHOOSE_ITEMS_DLG",
                    KategorijaChooseItemsFragment.newInstance(nova));
        } else {
            Toast.makeText(getActivity(), "Polje Naziv je neophodno!", Toast.LENGTH_LONG).show();
        }
    }
}