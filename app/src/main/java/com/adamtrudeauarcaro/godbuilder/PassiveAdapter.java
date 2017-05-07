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
import android.widget.ImageView;
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

    static class ViewHolder {
        private TextView itemName;
        private TextView passive;
    }
    
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        // Get the data item for this position
        Item item = getItem(position);
        String passive = item.getPassive();
        String itemName = item.getName();
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.stat_passive_entry, parent, false);
            holder = new ViewHolder();
            holder.itemName = (TextView) view.findViewById(R.id.item_name);
            holder.passive = (TextView) view.findViewById(R.id.passive);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Populate the data into the template view using the data object
        holder.itemName.setText(itemName);
        holder.passive.setText(passive);

        // Return the completed view to render on screen
        return view;
    }
}