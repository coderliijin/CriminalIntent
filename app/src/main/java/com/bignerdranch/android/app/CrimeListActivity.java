package com.bignerdranch.android.app;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/3/25.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
