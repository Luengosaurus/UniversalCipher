package com.exfume.luengo.universalcipher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class CipherAdapter extends FragmentStatePagerAdapter {

    private Fragment Cipher;
    private Fragment Decipher;

    public CipherAdapter(FragmentManager fm) {
        super(fm);
    }
    public void addCipher(Fragment Cipher, Fragment Decipher){
        this.Cipher = Cipher;
        this.Decipher = Decipher;
    }
    @Override
    public Fragment getItem(int position) {
        return position == 0 ? this.Cipher : this.Decipher;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? "CIPHER" : "DECIPHER";
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
