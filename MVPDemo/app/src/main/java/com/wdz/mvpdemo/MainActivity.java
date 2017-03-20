package com.wdz.mvpdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.wdz.mvpdemo.module.elementary.ElementaryFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(android.R.id.tabs) TabLayout tabLayout;
    @Bind(R.id.toolBar) Toolbar toolbar;
    @Bind(R.id.viewPager) ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {


            @Override
            public Fragment getItem(int position) {

                switch (position){
                    case 0:
                        return new ElementaryFragment();
                    case 1:
                        return new ElementaryFragment();
                    case 2:
                        return new ElementaryFragment();
                    case 3:
                        return new ElementaryFragment();
                    case 4:
                        return new ElementaryFragment();
                    case 5:
                        return new ElementaryFragment();
                    default:
                        return new ElementaryFragment();
                }

            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){

                    case 0:
                        return "基本";
                    case 1:
                        return "转换(map)";
                    case 2:
                        return "压合(zip)";
                    case 3:
                        return "Token(flatMap)";
                    case 4:
                        return "Token_高级(retryWhen)";
                    case 5:
                        return "缓存";
                    default:
                        return "基本";
                }
            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }
}
