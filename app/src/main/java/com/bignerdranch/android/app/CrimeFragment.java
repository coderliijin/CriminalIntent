package com.bignerdranch.android.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Administrator on 2017/3/25.
 */

public class CrimeFragment extends Fragment {
    private Crime mcrime;
    private EditText mEditText;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private static final String ARG_CRIME_ID="Crime_Id";
    public static CrimeFragment newInstance(UUID mid){
        Bundle bundle=new Bundle();
        bundle.putSerializable(ARG_CRIME_ID,mid);
        CrimeFragment crimeFragment=new CrimeFragment();
        crimeFragment.setArguments(bundle);
        return crimeFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mcrime=new Crime();
       // UUID crimeId= (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
        UUID crimeId= (UUID) getArguments().getSerializable(ARG_CRIME_ID);
      mcrime=CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_crime,container,false);
        //获取标题
        mEditText= (EditText) v.findViewById(R.id.crime_title);
        mEditText.setText(mcrime.getmTitle());
        //按钮
        mDateButton= (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mcrime.getmDate().toString());
        mDateButton.setEnabled(false);
        //复选框
        mSolvedCheckBox= (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mcrime.ismResolved());
        //设置标题监听事件
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               mcrime.setmTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //设置复选框得监听事件
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mcrime.setmResolved(isChecked);
            }
        });
        
        return v;
        
    }
}
