package com.adamtrudeauarcaro.godbuilder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.classNames;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.favGods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.gods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.hideSoftKeyboard;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.pantheonNames;

/**
 * Created by adama on 2017-03-24.
 */

public class HomeFragment extends Fragment {

    private ListView lv;
    private SearchView sv;
    private GodAdapter adapter;

    private RelativeLayout flipClass, flipPantheon, arrowRight, arrowLeft;
    private ToggleButton mage, assassin, warrior, guardian, hunter;
    private ToggleButton norse, roman, egyptian, hindu, celtic, chinese, mayan, japanese, greek;
    private ArrayList<ToggleButton> classes = new ArrayList<ToggleButton>();
    private ArrayList<ToggleButton> pantheons = new ArrayList<ToggleButton>();

    private ViewPager filtersSection;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null)
            view = inflater.inflate(R.layout.home, null);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Gods");
        instantiateViews();
        populateLists();

        //List view and adapter
        adapter = new GodAdapter(getActivity(), gods);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String name = adapter.getItem(position).getName();

                for(int i = 0; i < gods.size(); i++) {
                    if(gods.get(i).getName().equals(name))
                    {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(createGodBundle(gods.get(i)));
                        replaceFragment(myFragment);
                        hideSoftKeyboard(getActivity());
                        break;
                    }
                }
            }
        });

        //Search view
        sv.setQueryHint(getString(R.string.search_gods));
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        //Viewpager navigation buttons
        arrowRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                filtersSection.setCurrentItem(1, true);
            }
        });
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                filtersSection.setCurrentItem(0, true);
            }
        });

        //Flip filters buttons
        flipClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int checked = 0;
                int unchecked = 0;
                for(int i = 0; i < classes.size(); i++)
                    if(classes.get(i).isChecked()) checked++; else unchecked++;

                if(checked > unchecked)
                {
                    adapter.getFilter().filter(sv.getQuery());
                    adapter.removeAllClasses();
                    for(int i = 0; i < classes.size(); i++)
                        classes.get(i).setChecked(false);
                } else {
                    adapter.getFilter().filter(sv.getQuery());
                    adapter.addAllClasses();
                    for(int i = 0; i < classes.size(); i++)
                        classes.get(i).setChecked(true);
                }
            }
        });
        flipPantheon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int checked = 0;
                int unchecked = 0;
                for(int i = 0; i < pantheons.size(); i++)
                    if(pantheons.get(i).isChecked()) checked++; else unchecked++;

                if(checked > unchecked)
                {
                    adapter.removeAllPantheons();
                    adapter.getFilter().filter(sv.getQuery());
                    for(int i = 0; i < pantheons.size(); i++)
                        pantheons.get(i).setChecked(false);
                } else {
                    adapter.addAllPantheons();
                    adapter.getFilter().filter(sv.getQuery());
                    for(int i = 0; i < pantheons.size(); i++)
                        pantheons.get(i).setChecked(true);
                }
            }
        });

        //Class filter buttons
        for(int i = 0; i < classes.size(); i++)
        {
            final int position = i;

            classes.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        adapter.addClass(classNames.get(position));
                        adapter.getFilter().filter(sv.getQuery());
                    }
                    else {
                        adapter.removeClass(classNames.get(position));
                        adapter.getFilter().filter(sv.getQuery());
                    }
                }
            });

            if(classes.get(i).isChecked()) {
                adapter.addClass(classNames.get(position));
                adapter.getFilter().filter(sv.getQuery());
            } else {
                adapter.removeClass(classNames.get(position));
                adapter.getFilter().filter(sv.getQuery());
            }
        }

        //Pantheon filter buttons
        for(int i = 0; i < pantheons.size(); i++)
        {
            final int position = i;
            pantheons.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        adapter.addPantheon(pantheonNames.get(position));
                        adapter.getFilter().filter(sv.getQuery());
                    }
                    else {
                        adapter.removePantheon(pantheonNames.get(position));
                        adapter.getFilter().filter(sv.getQuery());
                    }
                }
            });

            if(pantheons.get(i).isChecked()) {
                adapter.addPantheon(pantheonNames.get(i));
                adapter.getFilter().filter(sv.getQuery());
            } else {
                adapter.removePantheon(pantheonNames.get(i));
                adapter.getFilter().filter(sv.getQuery());
            }
        }

        return view;
    }

    public void replaceFragment(Fragment myFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, myFragment);
        transaction.commit();
    }

    public Bundle passArgs(String god_name, int godImage, int godPantheonIcon, char type) {
        Bundle args = new Bundle();
        args.putString("infoGodName", god_name);
        args.putInt("infoGodImage", godImage);
        args.putInt("infoPantheonIcon", godPantheonIcon);
        args.putChar("infoType", type);
        return args;
    }

    public Bundle createGodBundle(God god) {
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

        return args;
    }

    public class FiltersViewAdapter extends PagerAdapter {

        public Object instantiateItem(ViewGroup collection, int position) {

            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.id.filters_class; //pass id of that view to return, Views will be added in XML.
                    break;
                case 1:
                    resId = R.id.filters_pantheon;
                    break;
            }
            return view.findViewById(resId); // return selected view.
        }

        @Override
        public int getCount() {
            return 2; // number of maximum views in View Pager.
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1; // return true if both are equal.
        }

    }

    public void instantiateViews() {
        lv = (ListView) view.findViewById(R.id.home_list);
        sv = (SearchView) view.findViewById(R.id.home_search);
        filtersSection = (ViewPager) view.findViewById(R.id.myfivepanelpager);
        filtersSection.setAdapter(new FiltersViewAdapter());

        flipClass = (RelativeLayout) view.findViewById(R.id.flip_class);
        flipPantheon = (RelativeLayout) view.findViewById(R.id.flip_pantheon);
        arrowRight = (RelativeLayout) view.findViewById(R.id.arrow_right);
        arrowLeft = (RelativeLayout) view.findViewById(R.id.arrow_left);

        mage = (ToggleButton) view.findViewById(R.id.mage);
        assassin = (ToggleButton) view.findViewById(R.id.assassin);
        warrior = (ToggleButton) view.findViewById(R.id.warrior);
        guardian = (ToggleButton) view.findViewById(R.id.guardian);
        hunter = (ToggleButton) view.findViewById(R.id.hunter);
        norse = (ToggleButton) view.findViewById(R.id.norse);
        roman = (ToggleButton) view.findViewById(R.id.roman);
        egyptian = (ToggleButton) view.findViewById(R.id.egyptian);
        hindu = (ToggleButton) view.findViewById(R.id.hindu);
        celtic = (ToggleButton) view.findViewById(R.id.celtic);
        chinese= (ToggleButton) view.findViewById(R.id.chinese);
        mayan = (ToggleButton) view.findViewById(R.id.mayan);
        japanese = (ToggleButton) view.findViewById(R.id.japanese);
        greek = (ToggleButton) view.findViewById(R.id.greek);
    }

    public void populateLists(){
        classes.add(mage);
        classes.add(warrior);
        classes.add(guardian);
        classes.add(hunter);
        classes.add(assassin);

        pantheons.add(norse);
        pantheons.add(mayan);
        pantheons.add(roman);
        pantheons.add(celtic);
        pantheons.add(japanese);
        pantheons.add(chinese);
        pantheons.add(egyptian);
        pantheons.add(hindu);
        pantheons.add(greek);
    }

}
