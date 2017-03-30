package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-03-13.
 */
import android.media.Image;
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

public class TabFragmentMag extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    String infoGodName;
    int infoGodImage, infoPantheonIcon;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        infoGodName = getArguments().getString("infoGodName", "agni");
        infoGodImage = getArguments().getInt("infoGodImage", R.drawable.agni);
        infoPantheonIcon = getArguments().getInt("infoPantheonIcon", R.drawable.icon_hindu);

        //Inflate tab_layout_agni and setup Views.
        View myView =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        viewPager = (ViewPager) myView.findViewById(R.id.viewpager);

        ImageView godImage = (ImageView) myView.findViewById(R.id.godImage);
        TextView godName = (TextView) myView.findViewById(R.id.godName);
        TextView godTitle = (TextView) myView.findViewById(R.id.godTitle);

        godImage.setImageResource(infoGodImage);
        godName.setText(getGodName(infoGodName));
        godName.setCompoundDrawablesWithIntrinsicBounds(0,0,infoPantheonIcon,0);
        godTitle.setText(getGodTitle(infoGodName));

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
                case 0 : {
                    FragmentMagBuild myFragment = new FragmentMagBuild();

                    Bundle args = new Bundle();
                    args.putString("infoGodName", infoGodName);
                    args.putString("buildNum", "1");
                    myFragment.setArguments(args);

                    return myFragment;
                }
                case 1 : {
                    FragmentMagBuild myFragment = new FragmentMagBuild();

                    Bundle args = new Bundle();
                    args.putString("infoGodName", infoGodName);
                    args.putString("buildNum", "2");
                    myFragment.setArguments(args);

                    return myFragment;
                }
                case 2 : {
                    FragmentMagBuild myFragment = new FragmentMagBuild();

                    Bundle args = new Bundle();
                    args.putString("infoGodName", infoGodName);
                    args.putString("buildNum", "3");
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
                case 0 : return "Build 1";
                case 1 : return "Build 2";
                case 2 : return "Build 3";
            }
            return null;
        }
    }

    private String getGodName(String name) {
        String packageName = getActivity().getPackageName();
        int resId = getResources().getIdentifier(name, "string", packageName);
        return getString(resId);
    }

    private String getGodTitle(String name) {
        String packageName = getActivity().getPackageName();
        int resId = getResources().getIdentifier(name + "_title", "string", packageName);
        return getString(resId);
    }

}
