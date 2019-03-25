package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private Button btnKategorijaDalje;

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

        txtKategorijaNaziv = view.findViewById(R.id.txtKategorijaNewNaziv);
        txtKategorijaOpis = view.findViewById(R.id.txtKategorijaNewOpis);

        btnKategorijaDalje = view.findViewById(R.id.btnKategorijaNewNext);
        btnKategorijaDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_btnKategorijaDaljeClick();
            }
        });
        return view;
    }

    private void do_btnKategorijaDaljeClick() {
        if (!txtKategorijaNaziv.getText().toString().isEmpty()) {
            KategorijaVM nova = new KategorijaVM(txtKategorijaNaziv.getText().toString());

            FragmentManager fm = getFragmentManager();
            KategorijaChooseItemsFragment dlg = KategorijaChooseItemsFragment.newInstance(nova);
            dlg.show(fm, "KATEGORIJA_CHOOSE_ITEMS_DLG");

//            MyFragmentHelper.displayFragment((AppCompatActivity) getActivity(),
//                    R.id.fragmentContainer,
//                    KategorijaChooseItemsFragment.newInstance(nova));
        } else {
            Toast.makeText(getActivity(), "Polje Naziv je neophodno!", Toast.LENGTH_LONG).show();
        }
    }
}
