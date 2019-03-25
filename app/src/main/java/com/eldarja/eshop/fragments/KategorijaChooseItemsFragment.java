package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.ItemVM;
import com.eldarja.eshop.data.Storage;

import org.w3c.dom.Text;

import java.util.List;

public class KategorijaChooseItemsFragment extends Fragment {

    private List<ItemVM> listItemi;

    public static KategorijaChooseItemsFragment newInstance() {
        return new KategorijaChooseItemsFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.kategorija_choose_items, container, false);

        listItemi = Storage.getItemi();

        ListView listKategorijaItems = view.findViewById(R.id.listKategorijaChooseItems);
        listKategorijaItems.setAdapter(new BaseAdapter() {
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
        });

        Button btnKategorijaSave = view.findViewById(R.id.btnKategorijaNewSave);
        btnKategorijaSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAGX", "SNIMLJENA KATEGORIJA!");
            }
        });
        return view;
    }
}
