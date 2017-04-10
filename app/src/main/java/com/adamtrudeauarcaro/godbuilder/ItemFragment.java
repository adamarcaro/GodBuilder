package com.adamtrudeauarcaro.godbuilder;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.boots;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.itemsMag;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.itemsMagCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.itemsPhys;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.itemsPhysCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.relics;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.shoes;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starterMag;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starterMagCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starterPhys;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starterPhysCommon;


public class ItemFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    ArrayList<Item> items = new ArrayList<Item>();
    char infoType, itemGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Indicate layout for dialog
        View myView=inflater.inflate(R.layout.item_list, null);

        infoType = getArguments().getChar("infoType", 'M');
        itemGroup = getArguments().getChar("itemGroup", 'I');

        if(itemGroup == 'I') {
            if (infoType == 'R') {
                items.addAll(itemsPhysCommon);
            } else if (infoType == 'M') {
                items.addAll(shoes);
                items.addAll(itemsMagCommon);
            } else {
                items.addAll(boots);
                items.addAll(itemsPhysCommon);
            }
        } else if(itemGroup == 'S') {
            if(infoType == 'M') {
                items.addAll(starterMagCommon);
            } else {
                items.addAll(starterPhysCommon);
            }
        } else if(itemGroup == 'R') {
            items.addAll(relics);
        }

        getDialog().setTitle("Starter Items");


        //Defining searchview, listview, button
        SearchView sv=(SearchView) myView.findViewById(R.id.searchView1);
        ListView lv=(ListView) myView.findViewById(R.id.listView1);
        LinearLayout remove = (LinearLayout) myView.findViewById(R.id.removeLayout);
        Button btn=(Button) myView.findViewById(R.id.dismiss);

        //Initialize and set adapter for items
        final Adapter adapter = new Adapter(getActivity(), items);
        lv.setAdapter(adapter);

        //Searchview functionality
        sv.setQueryHint("Search...");
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

        remove.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                String name = "";
                int image_id = R.drawable.no_item;
                String image_name = "no_item";
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
    public static ItemFragment newInstance(char infoType, char itemGroup)
    {
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