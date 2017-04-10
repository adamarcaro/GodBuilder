package com.adamtrudeauarcaro.godbuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.getGods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.gods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.hideSoftKeyboard;

/**
 * Created by adama on 2017-03-24.
 */

public class HomeFragment extends Fragment {

    public static ListView lv;
    public static SearchView sv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.home,null);

        final ArrayList<God> gods = getGods();

        lv = (ListView) myView.findViewById(R.id.home_list);
        sv = (SearchView) myView.findViewById(R.id.home_search);
        sv.setQueryHint("Search Gods...");

        final GodAdapter adapter = new GodAdapter(getActivity(), gods);
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

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

        return myView;
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

}
