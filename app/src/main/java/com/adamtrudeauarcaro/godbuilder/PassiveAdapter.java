package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by adama on 2017-02-11.
 */

//Adapter for populating list view

public class PassiveAdapter extends ArrayAdapter<Item> {
    public PassiveAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        String passive = item.getPassive();
        String itemName = item.getName();
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stat_passive_entry, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.item_name);
        TextView passiveText = (TextView) convertView.findViewById(R.id.passive);
        // Populate the data into the template view using the data object
        name.setText(itemName);
        passiveText.setText(passive);

        // Return the completed view to render on screen
        return convertView;
    }
}