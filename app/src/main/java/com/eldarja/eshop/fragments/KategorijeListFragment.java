package com.eldarja.eshop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.eldarja.eshop.R;
import com.eldarja.eshop.data.KategorijaVM;
import com.eldarja.eshop.data.Storage;
import com.eldarja.eshop.helpers.MyFragmentHelper;
import com.eldarja.eshop.helpers.MyRunnable;

import java.util.List;

public class KategorijeListFragment extends Fragment {

    private ListView listKategorije;
    private FloatingActionButton btnNovaKategorija;
    private List<KategorijaVM> kategorije;
    private BaseAdapter adapterKategorije;


    public static KategorijeListFragment newInstance() {
        KategorijeListFragment frag = new KategorijeListFragment();
        Bundle args = new Bundle();
        // add params and set bundle to frag
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null ){
            // get params
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kategorija_list_fragment, container, false);

        kategorije = Storage.getKategorije();

        listKategorije = view.findViewById(R.id.listKorpaStavke);
        bindKategorijeList();
        listKategorije.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyFragmentHelper.displayFragment((AppCompatActivity) getActivity(),
                        R.id.fragmentContainer,
                        KategorijaItemsListFragment.newInstance(kategorije.get(position)));
            }
        });

        btnNovaKategorija = view.findViewById(R.id.btnNovaKategorija);
        btnNovaKategorija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_btnAddNewClick();
            }
        });
        return view;
    }

    private void do_btnAddNewClick() {
        MyRunnable<KategorijaVM> callback = new MyRunnable<KategorijaVM>() {
            @Override
            public void run(KategorijaVM result) {
                adapterKategorije.notifyDataSetChanged();
                Toast.makeText(getActivity(), "Uspješno ste snimili novu kategoriju " + result.getNaziv(), Toast.LENGTH_SHORT).show();
            }
        };
        MyFragmentHelper.displayDialog((AppCompatActivity) getActivity(),
                "CREATE_NEW_CAT_DIALOG",
                KategorijaCreateNewFragment.newInstance(callback));
    }

    private void bindKategorijeList() {
        adapterKategorije = new BaseAdapter() {
            @Override
            public int getCount() {
                return kategorije.size();
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
            public View getView(int position, View view, ViewGroup parent) {
                if (view == null ){
                    //LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
                    view = inflater.inflate(R.layout.kategorija_list_stavka, parent, false);
                }

                TextView txtKategorijaStavka = view.findViewById(R.id.txtKategorijaStavka);
                txtKategorijaStavka.setText(kategorije.get(position).getNaziv());

                Log.i("TAGX", kategorije.get(position).getNaziv());

                return view;
            }
        };
        listKategorije.setAdapter(adapterKategorije);
    }
}
