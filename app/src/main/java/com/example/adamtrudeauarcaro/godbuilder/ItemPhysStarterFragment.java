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


public class ItemPhysStarterFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    ArrayAdapter<String> adapter;
    String[] items={"Bumba's Mask", "Rangda's Mask", "Bluestone Pendant", "Death's Toll",
                    "Mark of the Vanguard", "Swift Wing", "War Flag", "Watcher's Gift"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View myView=inflater.inflate(R.layout.item_list, null);
        //SET TITLE DIALOG TITLE
        getDialog().setTitle("Starter Items");
        //BUTTON,LISTVIEW,SEARCHVIEW INITIALIZATIONS
        lv=(ListView) myView.findViewById(R.id.listView1);
        sv=(SearchView) myView.findViewById(R.id.searchView1);
        btn=(Button) myView.findViewById(R.id.dismiss);
        //CREATE AND SET ADAPTER TO LISTVIEW
        adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        lv.setAdapter(adapter);
        //SEARCH
        sv.setQueryHint("Search..");
        sv.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String txt) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public boolean onQueryTextChange(String txt) {
                // TODO Auto-generated method stub
                adapter.getFilter().filter(txt);
                return false;
            }
        });
        //BUTTON
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dismiss();
            }
        });

        return myView;
    }

    public static ItemPhysStarterFragment newInstance(){
        ItemPhysStarterFragment f = new ItemPhysStarterFragment();
        return f;
    }

}