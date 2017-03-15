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

public class Adapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<Item> items;
    ArrayList<Item> filterList;
    CustomFilter filter;

    public Adapter(Context c, ArrayList<Item> items) {
        this.c = c;
        this.items = items;
        this.filterList = items;
    }

    public int getCount() {
        return items.size();
    }

    public Item getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return items.indexOf(getItem(position));
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item_selection, null);

        TextView name = (TextView) convertView.findViewById(R.id.item_name);
        ImageView image = (ImageView) convertView.findViewById(R.id.item_image);

        name.setText(items.get(position).getName());
        image.setImageResource(items.get(position).getImage());

        return convertView;
    }

    public Filter getFilter() {

        if(filter == null)
            filter = new CustomFilter();

        return filter;
    }

    //Inner class for filtering
    class CustomFilter extends Filter {

        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<Item> filters = new ArrayList<Item>();

                for(int i = 0; i < filterList.size(); i++)
                {
                    if(filterList.get(i).getName().toUpperCase().contains(constraint))
                    {
                        Item item = new Item(filterList.get(i).getName(), filterList.get(i).getImage());
                        filters.add(item);
                    }
                }

                results.count = filters.size();
                results.values = filters;

            } else {

                results.count = filterList.size();
                results.values = filterList;

            }

            return results;
        }

        protected void publishResults(CharSequence constraint, FilterResults results) {

            items = (ArrayList<Item>) results.values;
            notifyDataSetChanged();

        }
    }

}

