package com.developers.carlos.iglesiamilagrosa;

import android.graphics.drawable.Icon;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.developers.carlos.iglesiamilagrosa.dialogos.LoginDialogo;
import com.developers.carlos.iglesiamilagrosa.fragmentos.PublicacionesFragment;
import com.developers.carlos.iglesiamilagrosa.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class InformateActivity extends AppCompatActivity{

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informate);

        setToolbar();

        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
        //crearTabs();
    }

    private void crearTabs(){
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(getResources().getString(R.string.str_tab_publicaciones)));
        tabs.addTab(tabs.newTab().setText(getResources().getString(R.string.str_tab_favoritos)));
    }

    /**
     * Establece la toolbar como action bar
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            //ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            //ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(PublicacionesFragment.nuevaInstancia(1), getResources().getString(R.string.str_tab_publicaciones));
        adapter.addFragment(PublicacionesFragment.nuevaInstancia(2), getResources().getString(R.string.str_tab_favoritos));
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_informate, menu);
        MenuItem item = menu.findItem(R.id.action_shop);

        // Obtener drawable del item
        LayerDrawable icon = (LayerDrawable) item.getIcon();

        // Actualizar el contador
        Utils.setBadgeCount(this, icon, 8);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_shop) {
            return true;
        }

        if (id == R.id.action_publica) {
            new LoginDialogo().show(getSupportFragmentManager(), "LoginDialogo");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }


    }

}
