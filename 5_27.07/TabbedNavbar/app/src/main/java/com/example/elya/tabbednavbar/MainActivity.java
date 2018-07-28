package com.example.elya.tabbednavbar;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(), "Home");
        adapter.addFragment(new TwoFragment(), "Tab2");
        adapter.addFragment(new ThreeFragment(), "Tab3");

        ViewPager mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);

        setTabIcons(tabLayout);

    }

    private void setTabIcons(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_cloud);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_laptop);
    }
}
