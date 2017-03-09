package com.example.adamtrudeauarcaro.godbuilder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;


public class ItemRelicFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    ArrayAdapter<String> adapter;
    String[] names={"Aegis Amulet", "Blink Rune", "Bracer of Undoing", "Cursed Ankh", "Hand of the Gods",
                    "Heavenly Wings", "Horrific Emblem", "Magic Shell", "Meditation Cloak", "Phantom Veil",
                    "Purification Beads", "Shield of Thorns", "Sundering Spear", "Teleport Glyph"};

    int[] images={R.drawable.fafnir, R.drawable.fenrir, R.drawable.freya,
                    R.drawable.geb, R.drawable.guan_yu,R.drawable.fafnir, R.drawable.fenrir, R.drawable.freya,
                    R.drawable.geb, R.drawable.guan_yu,R.drawable.fafnir, R.drawable.fenrir, R.drawable.freya,
                    R.drawable.geb};


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView=inflater.inflate(R.layout.item_list, null);

        //SET TITLE DIALOG TITLE
        getDialog().setTitle("Relics");

        //BUTTON,LISTVIEW,SEARCHVIEW INITIALIZATIONS
        lv=(ListView) myView.findViewById(R.id.listView1);
        sv=(SearchView) myView.findViewById(R.id.searchView1);
        btn=(Button) myView.findViewById(R.id.dismiss);

        //CREATE AND SET ADAPTER TO LISTVIEW
        final Adapter adapter = new Adapter(getActivity(), this.getItems());
        lv.setAdapter(adapter);

        //SEARCH
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

        //BUTTON
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                dismiss();
            }
        });

        return myView;
    }

    public static ItemRelicFragment newInstance(){
        ItemRelicFragment f = new ItemRelicFragment();
        return f;
    }

    private ArrayList<Item> getItems() {

        ArrayList<Item> items = new ArrayList<Item>();
        Item item;

        for(int i = 0; i < names.length; i++)
        {
            item = new Item(names[i], images[i]);
            items.add(item);
        }

        return items;

    }

}
