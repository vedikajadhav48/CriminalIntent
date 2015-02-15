package com.example.vedikajadhav.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Vedika Jadhav on 2/15/2015.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Crime(){
        //generate Unique Identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
