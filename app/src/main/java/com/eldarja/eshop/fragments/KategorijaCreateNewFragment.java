package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.KategorijaVM;
import com.eldarja.eshop.data.Storage;
import com.eldarja.eshop.helpers.MyFragmentHelper;
import com.eldarja.eshop.helpers.MyRunnable;

public class KategorijaCreateNewFragment extends DialogFragment {
    private static final String KATEGORIJA_CALLBACK = "KATEGORIJA_CALLBACK";
    private EditText txtKategorijaNaziv;
    private Button btnDodajIteme;
    private Button btnSnimi;
    private MyRunnable<KategorijaVM> callback;

    public static KategorijaCreateNewFragment newInstance(MyRunnable<KategorijaVM> callback) {
        KategorijaCreateNewFragment frag = new KategorijaCreateNewFragment();
        Bundle args = new Bundle();
        args.putSerializable(KATEGORIJA_CALLBACK, callback);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(KATEGORIJA_CALLBACK)) {
            callback = (MyRunnable<KategorijaVM>) getArguments().getSerializable(KATEGORIJA_CALLBACK);
        }

        setStyle(STYLE_NORMAL, R.style.DialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kategorija_create_new_fragment, container, false);

        txtKategorijaNaziv = view.findViewById(R.id.txtKategorijaNewNaziv);

        btnSnimi = view.findViewById(R.id.btnSnimi);
        btnSnimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_btnSnimiClick();
            }
        });

        btnDodajIteme = view.findViewById(R.id.btnDodajIteme);
        btnDodajIteme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_btnDodajItemeClick();
            }
        });
        return view;
    }

    private void do_btnSnimiClick() {
        if (!txtKategorijaNaziv.getText().toString().isEmpty()) {
            KategorijaVM nova = new KategorijaVM(txtKategorijaNaziv.getText().toString());
            Storage.kategorije.add(nova);
            getDialog().dismiss();
            callback.run(nova);
        } else {
            Toast.makeText(getActivity(), "Polje Naziv je neophodno!", Toast.LENGTH_LONG).show();
        }
    }

    private void do_btnDodajItemeClick() {
            MyFragmentHelper.displayDialog((AppCompatActivity) getActivity(),
                    "KATEGORIJA_CHOOSE_ITEMS_DLG",
                    KategorijaAddItemsFragment.newInstance(txtKategorijaNaziv.getText().toString()));
    }
}
