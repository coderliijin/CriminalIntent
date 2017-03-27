package com.bignerdranch.android.app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity{
    private static final String EXTRA_CRIME_ID="com.bignerdranch.crime_id";
    //实现从crimelistfragment点击跳转到这个activity的方法，并把mid保存在intent中
    public static final Intent newIntent(Context context, UUID mId){
        Intent intent=new Intent(context,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,mId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID crimeId= (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }


}
