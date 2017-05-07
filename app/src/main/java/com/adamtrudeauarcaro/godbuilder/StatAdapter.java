package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
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

    static class ViewHolder {
        private TextView statLabel;
        private TextView statValue;
    }

    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.stat_entry, null);
            holder = new ViewHolder();
            holder.statLabel = (TextView) view.findViewById(R.id.statLabel);
            holder.statValue = (TextView) view.findViewById(R.id.statValue);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.statLabel.setText(stats.get(position).getStatLabel());
        holder.statValue.setText(stats.get(position).getStatValue());

        if(stats.get(position).getCapped())
            holder.statValue.setTextColor(ContextCompat.getColor(c, R.color.smooth_red));
        else if(!stats.get(position).getCapped())
            holder.statValue.setTextColor(ContextCompat.getColor(c, R.color.holoBlue));

        return view;
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

    public int getViewTypeCount() {
        return getCount();
    }

    public int getItemViewType(int position) {
        return position;
    }
    
}

