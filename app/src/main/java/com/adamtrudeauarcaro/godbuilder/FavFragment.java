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
import java.util.Collections;
import java.util.Comparator;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.classNames;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.favGods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.gods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.hideSoftKeyboard;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.pantheonNames;

/**
 * Created by adama on 2017-03-24.
 */

public class FavFragment extends Fragment {

    GodAdapter adapter;
    ArrayList<ToggleButton> classes = new ArrayList<ToggleButton>();
    ArrayList<ToggleButton> pantheons = new ArrayList<ToggleButton>();
    View view;
    FiltersViewAdapter filterAdapter;

    static class ViewHolder {
        private ListView lv;
        private SearchView sv;
        private ViewPager filtersSection;
        private RelativeLayout flipClass, flipPantheon, arrowRight, arrowLeft;
        private ToggleButton mage, assassin, warrior, guardian, hunter;
        private ToggleButton norse, roman, egyptian, hindu, celtic, chinese, mayan, japanese, greek;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewHolder holder;
        if(view == null)
        {
            view = inflater.inflate(R.layout.home, null);
            holder = new ViewHolder();
            holder.lv = (ListView) view.findViewById(R.id.home_list);
            holder.sv = (SearchView) view.findViewById(R.id.home_search);
            holder.filtersSection = (ViewPager) view.findViewById(R.id.myfivepanelpager);

            holder.flipClass = (RelativeLayout) view.findViewById(R.id.flip_class);
            holder.flipPantheon = (RelativeLayout) view.findViewById(R.id.flip_pantheon);
            holder.arrowRight = (RelativeLayout) view.findViewById(R.id.arrow_right);
            holder.arrowLeft = (RelativeLayout) view.findViewById(R.id.arrow_left);

            holder.mage = (ToggleButton) view.findViewById(R.id.mage);
            holder.assassin = (ToggleButton) view.findViewById(R.id.assassin);
            holder.warrior = (ToggleButton) view.findViewById(R.id.warrior);
            holder.guardian = (ToggleButton) view.findViewById(R.id.guardian);
            holder.hunter = (ToggleButton) view.findViewById(R.id.hunter);
            holder.norse = (ToggleButton) view.findViewById(R.id.norse);
            holder.roman = (ToggleButton) view.findViewById(R.id.roman);
            holder.egyptian = (ToggleButton) view.findViewById(R.id.egyptian);
            holder.hindu = (ToggleButton) view.findViewById(R.id.hindu);
            holder.celtic = (ToggleButton) view.findViewById(R.id.celtic);
            holder.chinese= (ToggleButton) view.findViewById(R.id.chinese);
            holder.mayan = (ToggleButton) view.findViewById(R.id.mayan);
            holder.japanese = (ToggleButton) view.findViewById(R.id.japanese);
            holder.greek = (ToggleButton) view.findViewById(R.id.greek);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Favorites");

        classes.add(holder.mage);
        classes.add(holder.warrior);
        classes.add(holder.guardian);
        classes.add(holder.hunter);
        classes.add(holder.assassin);

        pantheons.add(holder.norse);
        pantheons.add(holder.mayan);
        pantheons.add(holder.roman);
        pantheons.add(holder.celtic);
        pantheons.add(holder.japanese);
        pantheons.add(holder.chinese);
        pantheons.add(holder.egyptian);
        pantheons.add(holder.hindu);
        pantheons.add(holder.greek);

        RelativeLayout appNameContainer = (RelativeLayout) view.findViewById(R.id.app_name_container);
        appNameContainer.setVisibility(View.GONE);

        holder.sv.setQueryHint(getString(R.string.search_gods));

        holder.filtersSection.setAdapter(new FiltersViewAdapter());
        favGods = sortItemsByName(favGods);
        adapter = new GodAdapter(getActivity(), favGods);

        if (favGods.size() > 0)
        {
            holder.lv.setAdapter(adapter);
        }

        holder.arrowRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                holder.filtersSection.setCurrentItem(1, true);
            }
        });

        holder.arrowLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                holder.filtersSection.setCurrentItem(0, true);
            }
        });

        holder.flipClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int checked = 0;
                int unchecked = 0;
                for(int i = 0; i < classes.size(); i++)
                    if(classes.get(i).isChecked()) checked++; else unchecked++;

                if(checked > unchecked)
                {
                    adapter.getFilter().filter(holder.sv.getQuery());
                    adapter.removeAllClasses();
                    for(int i = 0; i < classes.size(); i++)
                        classes.get(i).setChecked(false);
                } else {
                    adapter.getFilter().filter(holder.sv.getQuery());
                    adapter.addAllClasses();
                    for(int i = 0; i < classes.size(); i++)
                        classes.get(i).setChecked(true);
                }
            }
        });

        holder.flipPantheon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int checked = 0;
                int unchecked = 0;
                for(int i = 0; i < pantheons.size(); i++)
                    if(pantheons.get(i).isChecked()) checked++; else unchecked++;

                if(checked > unchecked)
                {
                    adapter.removeAllPantheons();
                    adapter.getFilter().filter(holder.sv.getQuery());
                    for(int i = 0; i < pantheons.size(); i++)
                        pantheons.get(i).setChecked(false);
                } else {
                    adapter.addAllPantheons();
                    adapter.getFilter().filter(holder.sv.getQuery());
                    for(int i = 0; i < pantheons.size(); i++)
                        pantheons.get(i).setChecked(true);
                }
            }
        });

        for(int i = 0; i < classes.size(); i++)
        {
            final int position = i;

            classes.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        adapter.addClass(classNames.get(position));
                        adapter.getFilter().filter(holder.sv.getQuery());
                    }
                    else {
                        adapter.removeClass(classNames.get(position));
                        adapter.getFilter().filter(holder.sv.getQuery());
                    }
                }
            });

            if(classes.get(i).isChecked()) {
                adapter.addClass(classNames.get(position));
                adapter.getFilter().filter(holder.sv.getQuery());
            } else {
                adapter.removeClass(classNames.get(position));
                adapter.getFilter().filter(holder.sv.getQuery());
            }
        }

        for(int i = 0; i < pantheons.size(); i++)
        {
            final int position = i;
            pantheons.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        adapter.addPantheon(pantheonNames.get(position));
                        adapter.getFilter().filter(holder.sv.getQuery());
                    }
                    else {
                        adapter.removePantheon(pantheonNames.get(position));
                        adapter.getFilter().filter(holder.sv.getQuery());
                    }
                }
            });

            if(pantheons.get(i).isChecked()) {
                adapter.addPantheon(pantheonNames.get(i));
                adapter.getFilter().filter(holder.sv.getQuery());
            } else {
                adapter.removePantheon(pantheonNames.get(i));
                adapter.getFilter().filter(holder.sv.getQuery());
            }
        }

        holder.sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        holder.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    public ArrayList<God> sortItemsByName(ArrayList<God> list) {
        Collections.sort(list, new Comparator<God>() {
            public int compare(final God object1, final God object2) {
                return object1.getName().compareTo(object2.getName());
            }
        });

        return list;
    }

}
