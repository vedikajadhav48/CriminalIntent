package com.example.vedikajadhav.criminalintent;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;


public abstract class SingleFragmentActivity extends ActionBarActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

       /* if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
          //  android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            android.app.ActionBar actionBar = getActionBar();
            actionBar.setSubtitle(R.string.actionBar_subtitle);
            // ActionBar actionBar = getActionBar();
            // actionBar.setSubtitle("Bodies of Water");
        }*/

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }

    }

}
