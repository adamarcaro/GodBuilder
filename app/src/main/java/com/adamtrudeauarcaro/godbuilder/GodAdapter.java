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

//Adapter for populating grid view

public class GodAdapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<God> gods;
    ArrayList<God> filterList;
    CustomFilter filter;

    public GodAdapter(Context c, ArrayList<God> gods) {
        this.c = c;
        this.gods = gods;
        this.filterList = gods;
    }

    public int getCount() {
        return gods.size();
    }

    public Object getItem(int position) {
        return gods.get(position);
    }

    public long getItemId(int position) {
        return gods.indexOf(getItem(position));
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.god_selection, null);

        TextView name = (TextView) convertView.findViewById(R.id.god_name);
        ImageView image = (ImageView) convertView.findViewById(R.id.god_image);

        name.setText(gods.get(position).getName());
        image.setImageResource(gods.get(position).getImage());

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
                ArrayList<God> filters = new ArrayList<God>();

                for(int i = 0; i < filterList.size(); i++)
                {
                    if(filterList.get(i).getName().toUpperCase().contains(constraint))
                    {
                        God god = new God(filterList.get(i).getName(), filterList.get(i).getImage(),
                                filterList.get(i).getPantheon(), filterList.get(i).getPantheonIcon(),
                                filterList.get(i).getType(), filterList.get(i).getTypeIcon());
                        filters.add(god);
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

            gods = (ArrayList<God>) results.values;
            notifyDataSetChanged();

        }
    }

}
