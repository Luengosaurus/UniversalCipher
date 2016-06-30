package com.exfume.luengo.universalcipher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Benjamin on 28/06/2016.
 */
public class KeyManagement extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mFragments;
    ArrayList<String> mTitles;

    public KeyManagement(FragmentManager fm  ) {
        super(fm);
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
    }
    public void add(Fragment fragment, String title){
        this.mFragments.add(fragment);
        this.mTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
