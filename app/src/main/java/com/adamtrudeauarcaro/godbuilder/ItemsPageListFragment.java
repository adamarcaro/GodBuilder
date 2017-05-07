package com.adamtrudeauarcaro.godbuilder;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.relics;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.starters;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.trees;

/**
 * Created by adama on 2017-05-06.
 */

public class ItemsPageListFragment extends Fragment implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    char infoItemType;
    View view;
    Button btn;
    ListView lv;
    ExpandableListView treesList;
    SearchView sv;
    AdapterItemPage adapter;
    ItemAdapterItemPage treeAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        infoItemType = getArguments().getChar("infoItemType", 'I');

        if(infoItemType == 'R' || infoItemType == 'S')
        {
            if(view == null)
                view = inflater.inflate(R.layout.item_list_item_page, null);

            sv = (SearchView) view.findViewById(R.id.searchView1);
            lv = (ListView) view.findViewById(R.id.listView1);
            btn = (Button) view.findViewById(R.id.dismiss);

            if(infoItemType == 'R')
                adapter = new AdapterItemPage(getActivity(), relics);
            else
                adapter = new AdapterItemPage(getActivity(), starters);
            lv.setAdapter(adapter);
            sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean onQueryTextSubmit(String txt) {
                    return false;
                }

                public boolean onQueryTextChange(String txt) {
                    adapter.getFilter().filter(txt);
                    return false;
                }
            });
        } else {
            if(view == null)
                view = inflater.inflate(R.layout.item_list_trees_item_page, null);

            sv = (SearchView) view.findViewById(R.id.search);
            treesList = (ExpandableListView) view.findViewById(R.id.expandableList);
            btn = (Button) view.findViewById(R.id.dismiss);

            treeAdapter = new ItemAdapterItemPage(getContext(), trees);
            treesList.setAdapter(treeAdapter);

            SearchManager searchManager = (SearchManager) getActivity().getSystemService(getContext().SEARCH_SERVICE);
            sv.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            sv.setOnQueryTextListener(this);
            sv.setOnCloseListener(this);
        }

        return view;
    }

    public boolean onQueryTextChange(String query) {
        if(query.equals("")) {
            collapseAll();
            return false;
        } else {
            treeAdapter.filterData(query);
            expandAll();
            return false;
        }
    }

    public boolean onQueryTextSubmit(String query) {
        treeAdapter.filterData(query);
        expandAll();
        return false;
    }

    //Opens all trees
    private void expandAll() {
        int count = treeAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            treesList.expandGroup(i);
        }
    }

    //Closes all trees
    private void collapseAll() {
        int count = treeAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            treesList.collapseGroup(i);
        }
    }

    public boolean onClose() {
        treeAdapter.filterData("");
        return false;
    }

}
