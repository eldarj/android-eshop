package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.ItemVM;
import com.eldarja.eshop.data.KategorijaVM;
import com.eldarja.eshop.data.Storage;

import java.util.ArrayList;
import java.util.List;

public class KategorijaAddItemsFragment extends DialogFragment {

    private static final String KATEGORIJA_ARG_KEY = "KATEGORIJA";
    private KategorijaVM kategorijaVM;
    private List<ItemVM> listItemi;
    private List<ItemVM> initialListItemi;
    private TextView txtKategorijaNaziv;
    private ListView listKategorijaItems;
    private Button btnKategorijaSave;
    private SearchView searchPretraga;
    private BaseAdapter kategorijaItemsAdapter;

    public static KategorijaAddItemsFragment newInstance(KategorijaVM kategorijaVM) {
        KategorijaAddItemsFragment kategorijaChooseItemsFragment = new KategorijaAddItemsFragment();
        Bundle args = new Bundle();
        args.putSerializable(KATEGORIJA_ARG_KEY, kategorijaVM);
        kategorijaChooseItemsFragment.setArguments(args);

        return kategorijaChooseItemsFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(KATEGORIJA_ARG_KEY)) {
            kategorijaVM =(KategorijaVM)getArguments().getSerializable(KATEGORIJA_ARG_KEY);
        }

        setStyle(STYLE_NORMAL, R.style.DialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.kategorija_choose_items_fragment, container, false);

        initialListItemi = listItemi = Storage.getItemi();

        txtKategorijaNaziv = view.findViewById(R.id.txtkategorijaNaziv);
        txtKategorijaNaziv.setText(kategorijaVM.getNaziv());

        searchPretraga = view.findViewById(R.id.txtPretragaItems);
        searchPretraga.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                do_filterPretraga(s);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                do_filterPretraga(s);
                return false;
            }
        });

        listKategorijaItems = view.findViewById(R.id.listKategorijaChooseItems);
        kategorijaItemsAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return listItemi.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.kategorija_choose_items_stavka, parent, false);
                }

                TextView txtKategorijaItemNaziv = convertView.findViewById(R.id.txtKategorijaItemNaziv);
                txtKategorijaItemNaziv.setText(listItemi.get(position).getItemNaziv());

                return convertView;
            }
        };
        listKategorijaItems.setAdapter(kategorijaItemsAdapter);

        btnKategorijaSave = view.findViewById(R.id.btnKategorijaNewSave);
        btnKategorijaSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAGX", "SNIMLJENA KATEGORIJA!");
            }
        });
        return view;
    }

    private void do_filterPretraga(String s) {
        List<ItemVM> filtered = new ArrayList<>();
        for (ItemVM i:initialListItemi) {
            if (i.getItemNaziv().toLowerCase().contains(s.toLowerCase())){
                filtered.add(i);
            }
        }
        listItemi = filtered;
        kategorijaItemsAdapter.notifyDataSetChanged();
    }
}
