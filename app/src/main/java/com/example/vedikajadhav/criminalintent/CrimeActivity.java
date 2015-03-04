package com.example.vedikajadhav.criminalintent;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Vedika Jadhav on 2/15/2015.
 */
public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment()
    {
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
