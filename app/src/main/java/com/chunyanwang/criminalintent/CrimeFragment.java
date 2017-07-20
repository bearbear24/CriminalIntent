package com.chunyanwang.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


public class CrimeFragment extends Fragment {

    private static final String TAG = "CrimeFragment";
    private static final String ARG_CRIME_ID = "crime_id";

    private Crime crime;

    private EditText titleField;
    private Button dateButton;
    private CheckBox checkBox;

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeFragment f = new CrimeFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        Log.d(TAG, "crimeId: " + crimeId.toString());
        crime = CrimeLab.get(getActivity()).getCrime(crimeId);
        Log.d(TAG, "crime: " + crime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        titleField = (EditText) v.findViewById(R.id.crime_title);
        titleField.setText(crime.title());
        dateButton = (Button) v.findViewById(R.id.crime_date);
        checkBox = (CheckBox) v.findViewById(R.id.crime_solved);
        checkBox.setChecked(crime.isSolved());

        titleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        dateButton.setText(crime.getDate().toString());
        dateButton.setEnabled(false);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setSolved(isChecked);
            }
        });
        return v;
    }
}
