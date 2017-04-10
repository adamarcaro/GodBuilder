package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adama on 2017-02-11.
 */

//Adapter for populating list view

public class StatAdapter extends BaseAdapter {

    Context c;
    ArrayList<Stat> stats;

    public StatAdapter(Context c, ArrayList<Stat> stats) {
        this.c = c;
        this.stats = stats;
    }

    public int getCount() {
        return stats.size();
    }

    public Stat getItem(int position) {
        return stats.get(position);
    }

    public long getItemId(int position) {
        return stats.indexOf(getItem(position));
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.stat_entry, null);

        TextView statLabel = (TextView) convertView.findViewById(R.id.statLabel);
        TextView statValue = (TextView) convertView.findViewById(R.id.statValue);

        statLabel.setText(stats.get(position).getStatLabel());
        statValue.setText(stats.get(position).getStatValue());

        return convertView;
    }

}

