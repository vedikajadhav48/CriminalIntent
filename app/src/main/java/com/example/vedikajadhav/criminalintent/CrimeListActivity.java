package com.example.vedikajadhav.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Vedika Jadhav on 2/15/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId(){
        //return R.layout.activity_twopane;
        return R.layout.activity_masterdetail;
    }
}
