package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-03-13.
 */
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TabFragmentKumbhakarna extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate tab_layout_agni and setup Views.
        View myView =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        viewPager = (ViewPager) myView.findViewById(R.id.viewpager);

        ImageView godImage = (ImageView) myView.findViewById(R.id.godImage);
        TextView godName = (TextView) myView.findViewById(R.id.godName);
        TextView godTitle = (TextView) myView.findViewById(R.id.godTitle);

        godImage.setImageResource(R.drawable.kumbhakarna);
        godName.setText(R.string.kumbhakarna);
        godName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.icon_hindu,0);
        godTitle.setText(R.string.kumbhakarna_title);

        //Set an Adapter for the View Pager
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return myView;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //Return fragment with respect to Position .
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new FragmentKumbhakarna1();
                case 1 : return new FragmentKumbhakarna2();
                case 2 : return new FragmentKumbhakarna3();
            }
            return null;
        }

        public int getCount() {
            return int_items;
        }

        //This method returns the title of the tab according to the position.
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 : return "Build 1";
                case 1 : return "Build 2";
                case 2 : return "Build 3";
            }
            return null;
        }
    }
}
