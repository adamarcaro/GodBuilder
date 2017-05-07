package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-03-13.
 */
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.favGods;

public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5;
    God god;
    String infoGodName, infoGodTitle, infoGodNameString, infoPantheon, infoClass;
    int infoGodImage, infoPantheonIcon, infoClassIcon, infoHealth, infoMana, infoDamage, infoProtPhys, infoProtMag;
    char infoType;
    double infoHp5, infoMp5, infoAttackSpeed, infoSpeed;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Getting God from GodDrawer arguments
        getGodArgs();

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(god.getName() + " Builder");

        //Inflate tab_layout_agni and setup Views.
        View myView =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        viewPager = (ViewPager) myView.findViewById(R.id.viewpager);

        ImageView godImage = (ImageView) myView.findViewById(R.id.godImage);
        TextView godName = (TextView) myView.findViewById(R.id.godName);
        TextView godTitle = (TextView) myView.findViewById(R.id.godTitle);
        ImageView godClass = (ImageView) myView.findViewById(R.id.className);
        ImageView godPantheon = (ImageView) myView.findViewById(R.id.pantheon);

        godImage.setImageResource(infoGodImage);
        godName.setText(getGodName(infoGodNameString));
        godTitle.setText(getGodTitle(infoGodNameString));
        godClass.setImageResource(god.getClassIcon());
        godPantheon.setImageResource(god.getPantheonIcon());

        //Set an Adapter for the View Pager
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        RelativeLayout favStarContainer = (RelativeLayout) myView.findViewById(R.id.fav_star_container);
        final ImageView favStar = (ImageView) myView.findViewById(R.id.fav_star);
        final SharedPreferences pref = getActivity().getPreferences(getContext().MODE_PRIVATE);

        Boolean isFav = pref.getBoolean(god.getNameString()+"_fav", false);

        god.setFav(isFav);

        if(isFav)
            favStar.setImageResource(R.drawable.bolt_filled);
        else
            favStar.setImageResource(R.drawable.bolt_empty);

        favStarContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(god.getFav())
                {
                    god.setFav(false);
                    favGods = removeGodFromList(favGods);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean(god.getNameString() + "_fav", false);
                    editor.apply();
                    favStar.setImageResource(R.drawable.bolt_empty);
                    Toast.makeText(getContext(), "Removed " + god.getName() + " from favorites", Toast.LENGTH_SHORT).show();
                } else {
                    god.setFav(true);
                    favGods.add(god);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean(god.getNameString() + "_fav", true);
                    editor.apply();
                    favStar.setImageResource(R.drawable.bolt_filled);
                    Toast.makeText(getContext(), "Added " + god.getName() + " to favorites", Toast.LENGTH_SHORT).show();
                }
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
                    BuildFragment myFragment = new BuildFragment();
                    myFragment.setArguments(createGodBundle(god, "1"));
                    return myFragment;
                }
                case 1 : {
                    BuildFragment myFragment = new BuildFragment();
                    myFragment.setArguments(createGodBundle(god, "2"));
                    return myFragment;
                }
                case 2 : {
                    BuildFragment myFragment = new BuildFragment();
                    myFragment.setArguments(createGodBundle(god, "3"));
                    return myFragment;
                }
                case 3 : {
                    BuildFragment myFragment = new BuildFragment();
                    myFragment.setArguments(createGodBundle(god, "4"));
                    return myFragment;
                }
                case 4 : {
                    BuildFragment myFragment = new BuildFragment();
                    myFragment.setArguments(createGodBundle(god, "5"));
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
                case 0 : return "I";
                case 1 : return "II";
                case 2 : return "III";
                case 3 : return "IV";
                case 4 : return "V";
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

    private void getGodArgs()
    {
        infoGodName = getArguments().getString("infoGodName", "Agni");
        infoGodTitle = getArguments().getString("infoGodTitle", "God of Fire");

        infoGodNameString = getArguments().getString("infoGodNameString", "agni");
        infoGodImage = getArguments().getInt("infoGodImage", R.drawable.agni);
        infoPantheon = getArguments().getString("infoPantheon", "Hindu");
        infoPantheonIcon = getArguments().getInt("infoPantheonIcon", R.drawable.icon_hindu);
        infoClass = getArguments().getString("infoClass", "Mage");
        infoClassIcon = getArguments().getInt("infoClassIcon", R.drawable.icon_mage);
        infoType = getArguments().getChar("infoType", 'M');

        infoHealth = getArguments().getInt("infoHealth", 1780);
        infoMana = getArguments().getInt("infoMana", 1155);
        infoDamage = getArguments().getInt("infoDamage", 65);
        infoProtPhys = getArguments().getInt("infoProtPhys", 63);
        infoProtMag = getArguments().getInt("infoProtMag", 30);
        infoSpeed = getArguments().getDouble("infoSpeed", 350);

        infoHp5 = getArguments().getDouble("infoHp5", 16.4);
        infoMp5 = getArguments().getDouble("infoMp5", 12.1);
        infoAttackSpeed = getArguments().getDouble("infoAttackSpeed", 1.19);

        god = new God(infoGodName, infoGodTitle, infoGodNameString, infoGodImage,
                infoPantheon, infoPantheonIcon, infoClass, infoClassIcon, infoType,
                infoHealth, infoMana, infoDamage, infoProtPhys, infoProtMag, infoSpeed,
                infoHp5, infoMp5, infoAttackSpeed);
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

    public ArrayList<God> removeGodFromList(ArrayList<God> list) {
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getName().equals(god.getName()))
                list.remove(i);
        return list;
    }

}
