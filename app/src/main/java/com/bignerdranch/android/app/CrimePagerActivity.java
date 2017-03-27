package com.bignerdranch.android.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Coder_Li on 2017/3/27.
 */

public class CrimePagerActivity extends FragmentActivity {
    private List<Crime>mCrimes;
    private ViewPager mViewPager;
    private static final String EXTRA_CRIME_ID="com.bignerdranch.crime_id";
    //实现从crimelistfragment点击跳转到这个activity的方法，并把mid保存在intent中
    public static final Intent newIntent(Context context, UUID mId){
        Intent intent=new Intent(context,CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,mId);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        mViewPager= (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);
        mCrimes=CrimeLab.get(this).getCrimes();
        FragmentManager fm =getSupportFragmentManager(); 
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime=mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        UUID crimeId= (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
    }
}
