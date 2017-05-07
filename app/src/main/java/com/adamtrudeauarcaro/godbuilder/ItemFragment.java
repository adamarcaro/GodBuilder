package com.adamtrudeauarcaro.godbuilder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.relics;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starterMagCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starterPhysCommon;


public class ItemFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    ArrayList<Item> items = new ArrayList<Item>();
    View view;
    char infoType, itemGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Indicate layout for dialog
        if(view == null)
            view = inflater.inflate(R.layout.item_list, null);
        //Defining searchview, listview, button
        sv = (SearchView) view.findViewById(R.id.searchView1);
        lv = (ListView) view.findViewById(R.id.listView1);
        btn = (Button) view.findViewById(R.id.dismiss);

        infoType = getArguments().getChar("infoType", 'M');
        itemGroup = getArguments().getChar("itemGroup", 'S');

        if (itemGroup == 'S') {
            sv.setQueryHint("Search starter items...");
            getDialog().setTitle("Starter Items");
            if (infoType == 'M') {
                items.addAll(starterMagCommon);
            } else {
                items.addAll(starterPhysCommon);
            }
        } else if (itemGroup == 'R') {
            sv.setQueryHint("Search relics...");
            getDialog().setTitle("Relics");
            items.addAll(relics);
        }


        //Initialize and set adapter for items
        final Adapter adapter = new Adapter(getActivity(), items);
        lv.setAdapter(adapter);

        //Searchview functionality
        sv.setOnQueryTextListener(new OnQueryTextListener() {
            public boolean onQueryTextSubmit(String txt) {
                return false;
            }

            public boolean onQueryTextChange(String txt) {
                adapter.getFilter().filter(txt);
                return false;
            }
        });

        //Listener for itemclick on list
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String name = adapter.getItem(position).getName();
                int image_id = adapter.getItem(position).getImage();
                String image_name = getActivity().getResources().getResourceEntryName(image_id);
                mListener.onListItemClick(name, image_name, image_id);
                dismiss();
            }
        });

        //Cancel button
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                dismiss();
            }
        });

        return view;
    }

    //Fragment contstructor
    public static ItemFragment newInstance(char infoType, char itemGroup) {
        ItemFragment f = new ItemFragment();
        Bundle args = new Bundle();
        args.putChar("infoType", infoType);
        args.putChar("itemGroup", itemGroup);
        f.setArguments(args);
        return f;
    }

    //Setting listener to connect list to God fragment
    public interface OnListItemClickedListener {
        void onListItemClick(String name, String imageName, int resourceId);
    }

    OnListItemClickedListener mListener;

    public void setOnListItemSelectedListener(OnListItemClickedListener listener) {
        this.mListener = listener;
    }

}