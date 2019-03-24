package com.eldarja.eshop;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eldarja.eshop.fragments.KategorijeListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment(new KategorijeListFragment());
    }

    private void displayFragment(KategorijeListFragment kategorijeListFragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragmentContainer, kategorijeListFragment);
    }
}
