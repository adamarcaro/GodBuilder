package com.adamtrudeauarcaro.godbuilder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;


public class ItemMagStarterFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    String[] names={"No starter", "Bumba's Mask", "Rangda's Mask", "Mark of the Vanguard", "Sands of Time",
                    "Soul Stone", "Swift Wing", "Vampiric Shroud", "Watcher's Gift"};
    int[] images={R.drawable.no_starter, R.drawable.bumbas_mask, R.drawable.rangdas_mask, R.drawable.mark_of_the_vanguard, R.drawable.sands_of_time,
                    R.drawable.soul_stone, R.drawable.swift_wing, R.drawable.vampiric_shroud, R.drawable.watchers_gift};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Indicate layout for dialog
        View myView=inflater.inflate(R.layout.item_list, null);

        //Set dialog title
        getDialog().setTitle("Starter Items");

        //Defining searchview, listview, button
        SearchView sv=(SearchView) myView.findViewById(R.id.searchView1);
        ListView lv=(ListView) myView.findViewById(R.id.listView1);
        Button btn=(Button) myView.findViewById(R.id.dismiss);

        //Initialize and set adapter for items
        final Adapter adapter = new Adapter(getActivity(), this.getItems());
        lv.setAdapter(adapter);

        //Searchview functionality
        sv.setQueryHint("Search starter items..");
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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                String name = adapter.getItem(position).getName();
                int image_id = adapter.getItem(position).getImage();
                mListener.onListItemClick(name, image_id);
                dismiss();
            }
        });

        //Cancel button
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                dismiss();
            }
        });

        return myView;
    }

    //Fragment contstructor
    public static ItemMagStarterFragment newInstance()
    {
        ItemMagStarterFragment f = new ItemMagStarterFragment();
        return f;
    }

    //Populates list with items
    private ArrayList<Item> getItems()
    {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item;

        for(int i = 0; i < names.length; i++) {
            item = new Item(names[i], images[i]);
            items.add(item);
        }

        return items;
    }

    //Setting listener to connect list to God fragment
    public interface OnListItemClickedListener {
        void onListItemClick(String name, int resourceId);
    }

    OnListItemClickedListener mListener;

    public void setOnListItemSelectedListener(OnListItemClickedListener listener) {
        this.mListener = listener;
    }

}