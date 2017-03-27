package com.bignerdranch.android.app;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/25.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mResolved;
    public Crime(){
        mId=UUID.randomUUID();
        mDate=new Date();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismResolved() {
        return mResolved;
    }

    public void setmResolved(boolean mResolved) {
        this.mResolved = mResolved;
    }
}
