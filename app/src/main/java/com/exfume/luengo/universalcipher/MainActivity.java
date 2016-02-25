package com.exfume.luengo.universalcipher;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.exfume.luengo.universalcipher.fragments.vigenere_cipher;
import com.exfume.luengo.universalcipher.fragments.vigenere_decipher;

/**
 * Created by Benjamin on 19/02/2016.
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.main_pager);
        mViewPager.setAdapter(mPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setDrawer(navigationView);
            selectItem(navigationView.getMenu().findItem(R.id.Vigenere));
        }

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        }

    }

    private void setDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        selectItem(menuItem);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

    }

    private void selectItem(MenuItem itemDrawer) {

        switch (itemDrawer.getItemId()) {
            case R.id.Vigenere:
                mPagerAdapter.addCipher(new vigenere_cipher(),new vigenere_decipher() );
                break;
        }
        setTitle(itemDrawer.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        private Fragment[] mFragmentList;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentList = new Fragment[2];
        }

        public void addCipher(Fragment Cipher, Fragment Decipher){
            this.mFragmentList[0] = Cipher;
            this.mFragmentList[1] = Decipher;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList[position];
        }


        @Override
        public CharSequence getPageTitle(int position) {
          return position == 0 ? "CIPHER" : "DECIPHER";
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
