package com.eldarja.eshop.helpers;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MyFragmentHelper {
    public  static void displayFragment(AppCompatActivity activity, int elementId, Fragment frag) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(elementId, frag);
        ft.addToBackStack(null);
        ft.commit();
    }

    public static void displayDialog(AppCompatActivity activity, String tag, DialogFragment frag){
        FragmentManager fm = activity.getSupportFragmentManager();
        frag.show(fm, tag);
    }
}
