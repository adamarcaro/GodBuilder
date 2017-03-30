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


public class ItemRelicFragment extends DialogFragment {

    String[] names={"Aegis Amulet", "Blink Rune", "Bracer of Undoing", "Cursed Ankh", "Hand of the Gods",
                    "Heavenly Wings", "Horrific Emblem", "Magic Shell", "Meditation Cloak", "Phantom Veil",
                    "Purification Beads", "Shield of Thorns", "Sundering Spear", "Teleport Glyph"};

    int[] images={R.drawable.aegis_amulet, R.drawable.blink_rune, R.drawable.bracer_of_undoing, R.drawable.cursed_ankh, R.drawable.hand_of_the_gods,
            R.drawable.heavenly_wings, R.drawable.horrific_emblem, R.drawable.magic_shell, R.drawable.meditation_cloak, R.drawable.phantom_veil,
            R.drawable.purification_beads, R.drawable.shield_of_thorns, R.drawable.sundering_spear, R.drawable.teleport_glyph};


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Indicate layout for dialog
        View myView=inflater.inflate(R.layout.item_list, null);

        //Set dialog title
        getDialog().setTitle("Relics");

        //Defining searchview, listview, button
        SearchView sv=(SearchView) myView.findViewById(R.id.searchView1);
        ListView lv=(ListView) myView.findViewById(R.id.listView1);
        Button btn=(Button) myView.findViewById(R.id.dismiss);

        //Initialize and set adapter for items
        final Adapter adapter = new Adapter(getActivity(), this.getItems());
        lv.setAdapter(adapter);

        //Searchview functionality
        sv.setQueryHint("Search relics..");
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

        return myView;
    }

    //Fragment contstructor
    public static ItemRelicFragment newInstance()
    {
        ItemRelicFragment f = new ItemRelicFragment();
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
        void onListItemClick(String name, String imageName, int resourceId);
    }

    OnListItemClickedListener mListener;

    public void setOnListItemSelectedListener(OnListItemClickedListener listener) {
        this.mListener = listener;
    }

}
