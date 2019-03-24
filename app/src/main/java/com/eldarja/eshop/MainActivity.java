package com.eldarja.eshop;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eldarja.eshop.fragments.KategorijeListFragment;
import com.eldarja.eshop.helpers.MyFragmentHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragmentHelper.displayFragment(this, R.id.fragmentContainer, new KategorijeListFragment());
    }
}
