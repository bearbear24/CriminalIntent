package com.chunyanwang.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by chunyanwang on 4/18/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
