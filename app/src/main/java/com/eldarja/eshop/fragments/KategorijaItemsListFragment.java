package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.ItemVM;
import com.eldarja.eshop.data.KategorijaVM;

import java.util.List;

public class KategorijaItemsListFragment extends DialogFragment {

    private static final String PARENT_KATEGORIJA = "PARENT_KATEGORIJA";
    private KategorijaVM kategorijaVM;
    private List<ItemVM> items;

    public static KategorijaItemsListFragment newInstance(KategorijaVM kat) {
        KategorijaItemsListFragment frag = new KategorijaItemsListFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARENT_KATEGORIJA, kat);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(PARENT_KATEGORIJA)) {
            kategorijaVM = (KategorijaVM) getArguments().getSerializable(PARENT_KATEGORIJA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.kategorija_items_list_fragment, container, false);

        items = kategorijaVM.getItems();
        ListView katItems = view.findViewById(R.id.listKategorijaItems);
        katItems.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return items.size();
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
                    convertView = getLayoutInflater().inflate(R.layout.kategorija_items_list_stavka, parent, false);
                }

                TextView itemNaziv = convertView.findViewById(R.id.txtKategorijaItemNaziv);
                itemNaziv.setText(items.get(position).getItemNaziv());

                return convertView;
            }
        });

        return view;
    }
}
