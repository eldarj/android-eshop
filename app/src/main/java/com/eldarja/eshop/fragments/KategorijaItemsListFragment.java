package com.eldarja.eshop.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
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
import com.eldarja.eshop.data.ItemVM;
import com.eldarja.eshop.data.KategorijaVM;
import com.eldarja.eshop.data.Storage;

import java.util.List;

public class KategorijaItemsListFragment extends DialogFragment {

    private static final String PARENT_KATEGORIJA = "PARENT_KATEGORIJA";
    private KategorijaVM kategorijaVM;
    private List<ItemVM> items;
    private BaseAdapter itemsAdapter;

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

        TextView txtKategorijaParentNaziv = view.findViewById(R.id.txtKategorijaParentNaziv);
        txtKategorijaParentNaziv.setText(kategorijaVM.getNaziv());

        items = kategorijaVM.getItems();
        ListView katItems = view.findViewById(R.id.listKategorijaItems);
        itemsAdapter = new BaseAdapter() {
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
        };
        katItems.setAdapter(itemsAdapter);

        katItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAGX", "LONGCLICK");
                do_izbrisiItemLongClick(position, view);
                return true;
            }
        });


        return view;
    }

    private void do_izbrisiItemLongClick(int position, final View parentView) {
        final ItemVM itm = items.get(position);
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setIcon(android.R.drawable.ic_dialog_alert);
        adb.setTitle("Izbriši item");
        adb.setMessage("Želite izbrisati item " + itm.getItemNaziv());
        adb.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.setPositiveButton("Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                kategorijaVM.removeItem(itm);
                items = kategorijaVM.getItems();
                itemsAdapter.notifyDataSetChanged();
                Snackbar.make(parentView, "Uspješno ste izbrisali item!", Snackbar.LENGTH_LONG).show();
            }
        });
        adb.show();
    }
}
