package com.adamtrudeauarcaro.godbuilder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.gods;

/**
 * Created by adama on 2017-05-05.
 */

public class ItemsPageFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    View view;
    God god;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null)
            view =  inflater.inflate(R.layout.items_page, null);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Items");

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //Return fragment with respect to Position .
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : {
                    Fragment myFragment = new ItemsPageListFragment();
                    Bundle args = new Bundle();
                    args.putChar("infoItemType", 'I');
                    myFragment.setArguments(args);
                    return myFragment;
                }
                case 1 : {
                    Fragment myFragment = new ItemsPageListFragment();
                    Bundle args = new Bundle();
                    args.putChar("infoItemType", 'S');
                    myFragment.setArguments(args);
                    return myFragment;
                }
                case 2 : {
                    Fragment myFragment = new ItemsPageListFragment();
                    Bundle args = new Bundle();
                    args.putChar("infoItemType", 'R');
                    myFragment.setArguments(args);
                    return myFragment;
                }
            }
            return null;
        }

        public int getCount() {
            return int_items;
        }

        //This method returns the title of the tab according to the position.
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 : return "Items";
                case 1 : return "Starters";
                case 2 : return "Relics";
            }
            return null;
        }
    }

    public Bundle createGodBundle(God god, String infoBuildNumber) {
        Bundle args = new Bundle();

        args.putString("infoGodName", god.getName());
        args.putString("infoGodTitle", god.getTitle());

        args.putString("infoGodNameString", god.getNameString());
        args.putInt("infoGodImage", god.getImage());
        args.putString("infoPantheon", god.getPantheon());
        args.putInt("infoPantheonIcon", god.getPantheonIcon());
        args.putString("infoClass", god.getClassName());
        args.putInt("infoClassIcon", god.getClassIcon());
        args.putChar("infoType", god.getType());

        args.putInt("infoHealth", god.getHealth());
        args.putInt("infoMana", god.getMana());
        args.putInt("infoDamage", god.getDamage());
        args.putInt("infoProtPhys", god.getProtPhys());
        args.putInt("infoProtMag", god.getProtMag());
        args.putDouble("infoSpeed", god.getSpeed());

        args.putDouble("infoHp5", god.getHp5());
        args.putDouble("infoMp5", god.getMp5());
        args.putDouble("infoAttackSpeed", god.getAttackSpeed());

        args.putString("infoBuildNumber", infoBuildNumber);

        return args;
    }
}
