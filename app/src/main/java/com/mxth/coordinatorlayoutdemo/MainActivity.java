package com.mxth.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        List<BaseFragment> datas=new ArrayList<>();
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),datas);
        tabs = (TabLayout) findViewById(R.id.sliding_tabs);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabs.addTab(tabs.newTab().setText(tabStrs[0]));
        tabs.addTab(tabs.newTab().setText(tabStrs[1]));
        tabs.addTab(tabs.newTab().setText(tabStrs[2]));
        tabs.addTab(tabs.newTab().setText(tabStrs[3]));
        tabs.addTab(tabs.newTab().setText(tabStrs[4]));
        tabs.addTab(tabs.newTab().setText(tabStrs[5]));
        tabs.addTab(tabs.newTab().setText(tabStrs[6]));
//        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);//tab较多时使用此模式
        datas.add(new Fragment1());
        datas.add(new Fragment2());
        datas.add(new Fragment3());
        datas.add(new Fragment4());
        datas.add(new Fragment5());
        datas.add(new Fragment6());
        datas.add(new Fragment7());
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
    }
    private class MyAdapter extends FragmentStatePagerAdapter{
        private final List<BaseFragment> datas;
        public MyAdapter(FragmentManager fm, List<BaseFragment> datas) {
            super(fm);
            this.datas=datas;
        }
        @Override
        public Fragment getItem(int position) {
            return datas.get(position);
        }
        @Override
        public int getCount() {
            return datas.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabStrs[position];
        }
    }
    private String[] tabStrs=new String[]{"项目一","项目二","项目三","项目四","项目五","项目六","项目七"};
}
