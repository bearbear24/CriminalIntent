package com.chunyanwang.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by chunyanwang on 4/18/17.
 */

public class CrimeLab {
    private static CrimeLab crimeLab;
    private List<Crime> crimeList;

    public static CrimeLab get(Context context) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(context);
        }
        return crimeLab;
    }


    private CrimeLab(Context context) {
        crimeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            crimeList.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return crimeList;
    }

    public Crime getCrime(UUID id) {
        for (Crime c: crimeList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
