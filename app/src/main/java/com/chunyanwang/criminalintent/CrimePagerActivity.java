package com.chunyanwang.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;
import java.util.UUID;

/**
 * CrimePagerActivity that handles swiping of different CrimeFragment.
 */

public class CrimePagerActivity extends FragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.chunyanwang.criminalintent.crime_id";

    private ViewPager viewPager;
    private List<Crime> crimes;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        viewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);
        crimes = CrimeLab.get(this).getCrimes();
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                CrimeFragment f = CrimeFragment.newInstance(crimes.get(position).getId());
                return f;
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getId().equals(crimeId)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }



}
