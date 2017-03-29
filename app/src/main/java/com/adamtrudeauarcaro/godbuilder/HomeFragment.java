package com.adamtrudeauarcaro.godbuilder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.gods;

/**
 * Created by adama on 2017-03-24.
 */

public class HomeFragment extends Fragment {

    public static ListView lv;
    public static SearchView sv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.home,null);

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

        return myView;
    }

}
