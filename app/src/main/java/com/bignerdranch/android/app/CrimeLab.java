package com.bignerdranch.android.app;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/25.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    //返回Crimelab对象
    public static CrimeLab get(Context context){
        if (sCrimeLab==null){
            sCrimeLab=new CrimeLab(context);
        }
        return sCrimeLab;
        
    }
    private CrimeLab(Context context){
        mCrimes=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Crime crime=new Crime();
            crime.setmTitle("Crime#"+i);
            crime.setmResolved(i%2==0);
            mCrimes.add(crime);
            
        }
    }
   //返回集合
    public List<Crime> getCrimes(){
       return mCrimes; 
    }
    //返回Crimes对象
    public Crime getCrime(UUID id){
        for (Crime crime:mCrimes){
            if (crime.getmId().equals(id)){
                return  crime;
            }
        }
        return  null;
    }
    }
