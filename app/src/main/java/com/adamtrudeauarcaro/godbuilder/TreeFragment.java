package com.adamtrudeauarcaro.godbuilder;

import android.app.SearchManager;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.ancientBlade;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.boots;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.breastplate;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.cloak;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.cudgel;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.druidStone;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.emeraldRing;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.enchantedBuckler;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.enchantedKusari;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.glowingEmerald;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.hiddenDagger;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.imperialHelmet;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.ironMail;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.katana;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.lightBlade;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.lostArtifact;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.mace;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.magicFocus;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.morningstar;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.roundShield;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.shoes;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.shortBow;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.shuriken;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.soulReliquary;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.spikedGauntlet;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.talisman;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.tinyTrinket;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesMag;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesMagCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesPhys;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesPhysCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesRat;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.treesRatCommon;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.uncommonSash;


public class TreeFragment extends DialogFragment implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    char infoType, itemGroup;

    private SearchView search;
    private ItemAdapter itemAdapter;
    private ExpandableListView list;
    private LinearLayout remove;
    private Button dismiss;
    private ArrayList<ItemTree> treeList = new ArrayList<ItemTree>();
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Indicate layout for dialog
        if(view == null)
            view=inflater.inflate(R.layout.item_list_trees, null);

        //Defining searchview, listview, button
        search = (SearchView) view.findViewById(R.id.search);
        list =(ExpandableListView) view.findViewById(R.id.expandableList);
        dismiss = (Button) view.findViewById(R.id.dismiss);

        infoType = getArguments().getChar("infoType", 'M');
        itemGroup = getArguments().getChar("itemGroup", 'I');

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(getContext().SEARCH_SERVICE);
        search.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

        list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,int groupPosition, int childPosition, long id) {
                String name = itemAdapter.getChild(groupPosition, childPosition).getName();
                int image_id = itemAdapter.getChild(groupPosition, childPosition).getImage();
                String image_name = getActivity().getResources().getResourceEntryName(image_id);
                mListener.onChildClick(name, image_name, image_id);
                dismiss();
                return false;
            }
        });

        //display the list
        displayList();

        dismiss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

    //Opens all trees
    private void expandAll() {
        int count = itemAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            list.expandGroup(i);
        }
    }

    //Closes all trees
    private void collapseAll() {
        int count = itemAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            list.collapseGroup(i);
        }
    }

    //method to expand all groups
    private void displayList() {

        //display the list
        loadSomeData();

        //get reference to the ExpandableListView
        list = (ExpandableListView) view.findViewById(R.id.expandableList);
        //create the adapter by passing your ArrayList data
        itemAdapter = new ItemAdapter(getContext(), treeList);
        //attach the adapter to the list
        list.setAdapter(itemAdapter);

    }

    private void loadSomeData() {
            //Physical
            if (infoType == 'M') {
                search.setQueryHint("Search magical items...");
                treeList = treesMagCommon;
            } else if (infoType == 'P' || infoType == 'R') {
                search.setQueryHint("Search physical items...");
                if (infoType == 'P') {
                    treeList = treesPhysCommon;
                } else {
                    treeList = treesRatCommon;
                }
            }
    }

    public boolean onClose() {
        itemAdapter.filterData("");
        return false;
    }

    public boolean onQueryTextChange(String query) {
        if(query.equals("")) {
            collapseAll();
            return false;
        } else {
            itemAdapter.filterData(query);
            expandAll();
            return false;
        }
    }

    public boolean onQueryTextSubmit(String query) {
        itemAdapter.filterData(query);
        expandAll();
        return false;
    }

    //Fragment contstructor
    public static TreeFragment newInstance(char infoType, char itemGroup)
    {
        TreeFragment f = new TreeFragment();
        Bundle args = new Bundle();
        args.putChar("infoType", infoType);
        args.putChar("itemGroup", itemGroup);
        f.setArguments(args);
        return f;
    }

    //Setting listener to connect list to God fragment
    public interface OnChildClickListener {
        void onChildClick(String name, String imageName, int resourceId);
    }

    OnChildClickListener mListener;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.mListener = listener;
    }

}