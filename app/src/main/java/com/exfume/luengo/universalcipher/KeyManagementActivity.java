package com.exfume.luengo.universalcipher;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.exfume.luengo.universalcipher.adapter.KeyManagement;
import com.exfume.luengo.universalcipher.key.AES;


public class KeyManagementActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private KeyManagement mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        setToolbar();
        mPagerAdapter = new KeyManagement(getSupportFragmentManager());
        mPagerAdapter.add(new AES(), "AES");
        mViewPager = (ViewPager) findViewById(R.id.main_pager);
        mViewPager.setAdapter(mPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle(getString(R.string.key_management));
        }

    }

}
