package com.bignerdranch.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CrimeAdapter mCrimeadapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_crime_list,container,false);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    /***********************************************************************/
    private void updateUI() {
        CrimeLab crimelab=CrimeLab.get(getActivity());
        List<Crime> crimes=crimelab.getCrimes();
        if (mCrimeadapter==null){
            mCrimeadapter=new CrimeAdapter(crimes);
            mRecyclerView.setAdapter(mCrimeadapter);
        }else{
            mCrimeadapter.notifyDataSetChanged();
        }
            
        
    }
  
    /*********************************************************************/
    //创建Crimeadapter适配器
    private class CrimeAdapter extends RecyclerView.Adapter<crimeHolder>{
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes){
            mCrimes=crimes;
        }
        @Override
        public crimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.list_item_crime,parent,false);
            return new crimeHolder(view);
        }

        @Override
        public void onBindViewHolder(crimeHolder holder, int position) {
            Crime crime=mCrimes.get(position);
            holder.bindCrime(crime);

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
    /*********************************************************************/
    //创建crimeholder
    private class  crimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private  TextView mTitleTextview;
        private TextView mDateTextview;
        private CheckBox mSolvedCheckBox;
        private Crime mCrimes;
        public crimeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextview= (TextView) itemView.findViewById(R.id.list_item_crime_Title_Text_view);
            mDateTextview= (TextView) itemView.findViewById(R.id.list_item_crime_Date_Text_view);
            mSolvedCheckBox= (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_Box);
        }
        public void bindCrime(Crime crime){
            mCrimes=crime;
            mTitleTextview.setText(mCrimes.getmTitle());
            mDateTextview.setText(mCrimes.getmDate().toString());
            mSolvedCheckBox.setChecked(mCrimes.ismResolved());
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(getActivity(),mCrimes.getmTitle()+"clicked!",Toast.LENGTH_SHORT).show();
            Intent intent=CrimeActivity.newIntent(getActivity(),mCrimes.getmId());
            startActivity(intent);
        }
    }
    /******************************************************/
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
