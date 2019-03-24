package com.eldarja.eshop.fragments;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.KategorijaVM;
import com.eldarja.eshop.data.Storage;

import java.util.List;

public class KategorijeListFragment extends Fragment {

    private ListView listKategorije;
    private Button btnKategorija;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kategorija_list_fragment, container, false);

        final List<KategorijaVM> kategorije = Storage.getKategorije();

        listKategorije = view.findViewById(R.id.listKorpaStavke);
        listKategorije.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return kategorije.size();
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup parent) {
                if (view == null ){
                    //LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
                    view = inflater.inflate(R.layout.kategorija_list_stavka, parent, false);
                }


                return view;
            }
        });

        btnKategorija = view.findViewById(R.id.btnKorpa);
        btnKategorija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "KOOK");
            }
        });
        return view;
    }
}
