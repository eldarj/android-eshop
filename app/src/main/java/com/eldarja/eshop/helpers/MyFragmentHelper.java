package com.eldarja.eshop.helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.eldarja.eshop.fragments.KategorijeListFragment;

public class MyFragmentHelper {
    public  static void displayFragment(AppCompatActivity activity,
                                        int placeholderId,
                                        Fragment kategorijeListFragment) {
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        fragmentTransaction.replace(placeholderId, kategorijeListFragment);
        fragmentTransaction.commit();
    }
}
