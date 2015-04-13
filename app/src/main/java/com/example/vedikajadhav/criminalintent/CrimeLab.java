package com.example.vedikajadhav.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Vedika Jadhav on 2/15/2015.
 */
public class CrimeLab {
    private static final String TAG = "CrimeLab";
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private static final String FILENAME = "crimes.json";
    private Context mAppContext;
    private CriminalIntentJSONSerializer mSerializer;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);
        //mCrimes = new ArrayList<Crime>();
        try{
            mCrimes = mSerializer.loadCrimes();
        }catch (Exception e){
            mCrimes = new ArrayList<Crime>();
            Log.e(TAG, "Error Loading Crimes: ", e);
        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    public void addCrime(Crime c){
        mCrimes.add(c);
    }

    public void deleteCrime(Crime c){
        mCrimes.remove(c);
    }

    public boolean saveCrimes(){
        try{
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "Crimes saved to a file");
            return true;
        }catch (Exception e){
           // e.printStackTrace();
            Log.e(TAG, "Error saving Crimes: ", e);
            return false;
        }
    }


}
