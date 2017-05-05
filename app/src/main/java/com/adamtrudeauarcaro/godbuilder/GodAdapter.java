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

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.classNames;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.pantheonNames;

/**
 * Created by adama on 2017-02-11.
 */


public class GodAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private ArrayList<God> gods;
    private ArrayList<God> filterList;
    private CustomFilter filter;
    private ArrayList<String> classFilters = new ArrayList<String>();
    private ArrayList<String> pantheonFilters = new ArrayList<String>();

    public GodAdapter(Context context, ArrayList<God> gods) {
        this.context = context;
        this.gods = gods;
        this.filterList = gods;
    }

    public int getCount() {
        return gods.size();
    }

    public God getItem(int position) {
        return gods.get(position);
    }

    public long getItemId(int position) {
        return gods.indexOf(getItem(position));
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.god_selection, null);
        }

        final God god = gods.get(position);
        TextView name = (TextView) view.findViewById(R.id.god_name);
        ImageView image = (ImageView) view.findViewById(R.id.god_image);
        ImageView pantheon = (ImageView) view.findViewById(R.id.pantheon);
        ImageView type = (ImageView) view.findViewById(R.id.type);

        name.setText(god.getName());
        image.setImageResource(god.getImage());
        pantheon.setImageResource(god.getPantheonIcon());
        type.setImageResource(god.getClassIcon());

        return view;
    }

    public int getViewTypeCount() {
        return filterList.size();
    }

    public int getItemViewType(int position) {
        return position;
    }

    //Add / Remove single pantheon / class
    public void addPantheon(String pantheon) {
        if(!pantheonFilters.contains(pantheon))
            pantheonFilters.add(pantheon);
        notifyDataSetChanged();
    }

    public void removePantheon(String pantheon) {
        if (pantheonFilters.contains(pantheon))
            pantheonFilters.remove(pantheon);
        notifyDataSetChanged();
    }

    public void addClass(String className) {
        if(!classFilters.contains(className))
            classFilters.add(className);
        notifyDataSetChanged();
    }

    public void removeClass(String className) {
        if (classFilters.contains(className))
            classFilters.remove(className);
        notifyDataSetChanged();
    }

    //Add / Remove all pantheons / classes
    public void addAllPantheons(){
        for(int i = 0; i < pantheonNames.size(); i++)
            if(pantheonFilters.contains(pantheonNames.get(i)))
                pantheonFilters.remove(pantheonNames.get(i));
        notifyDataSetChanged();
    }

    public void removeAllPantheons(){
        for(int i = 0; i < pantheonNames.size(); i++)
            if(!pantheonFilters.contains(pantheonNames.get(i)))
                pantheonFilters.add(pantheonNames.get(i));
        notifyDataSetChanged();
    }

    public void addAllClasses() {
        for (int i = 0; i < classNames.size(); i++)
            if(!classFilters.contains(classNames.get(i)))
                classFilters.add(classNames.get(i));
        notifyDataSetChanged();
    }

    public void removeAllClasses() {
        for (int i = 0; i < classNames.size(); i++)
            if(classFilters.contains(classNames.get(i)))
                classFilters.remove(classNames.get(i));
        notifyDataSetChanged();
    }

    public void clearFilters() {
        classFilters.clear();
        pantheonFilters.clear();
        notifyDataSetChanged();
    }

    //Filter class and methods
    public Filter getFilter() {
        if(filter == null)
            filter = new CustomFilter();
        return filter;
    }

    class CustomFilter extends Filter {

        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if(constraint != null)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<God> filters = new ArrayList<God>();

                for(int i = 0; i < filterList.size(); i++)
                {
                    God god = filterList.get(i);
                    if(filterList.get(i).getName().toUpperCase().contains(constraint) && classFilters.contains(god.getClassName()) && pantheonFilters.contains(god.getPantheon()))
                    {
                        God newGod = new God(filterList.get(i).getName(), filterList.get(i).getTitle(), filterList.get(i).getNameString(), filterList.get(i).getImage(),
                                filterList.get(i).getPantheon(), filterList.get(i).getPantheonIcon(), filterList.get(i).getClassName(), filterList.get(i).getClassIcon(), filterList.get(i).getType(),
                                filterList.get(i).getHealth(), filterList.get(i).getMana(), filterList.get(i).getDamage(), filterList.get(i).getProtPhys(), filterList.get(i).getProtMag(), filterList.get(i).getSpeed(),
                                filterList.get(i).getHp5(), filterList.get(i).getMp5(), filterList.get(i).getAttackSpeed());
                        filters.add(newGod);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else {
                ArrayList<God> filters = new ArrayList<God>();

                for(int i = 0; i < filterList.size(); i++)
                {
                    God god = filterList.get(i);
                    if(classFilters.contains(god.getClassName()) && pantheonFilters.contains(god.getPantheon()))
                    {
                        God newGod = new God(filterList.get(i).getName(), filterList.get(i).getTitle(), filterList.get(i).getNameString(), filterList.get(i).getImage(),
                                filterList.get(i).getPantheon(), filterList.get(i).getPantheonIcon(), filterList.get(i).getClassName(), filterList.get(i).getClassIcon(), filterList.get(i).getType(),
                                filterList.get(i).getHealth(), filterList.get(i).getMana(), filterList.get(i).getDamage(), filterList.get(i).getProtPhys(), filterList.get(i).getProtMag(), filterList.get(i).getSpeed(),
                                filterList.get(i).getHp5(), filterList.get(i).getMp5(), filterList.get(i).getAttackSpeed());
                        filters.add(newGod);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }
            return results;
        }

        protected void publishResults(CharSequence constraint, FilterResults results) {
            gods = (ArrayList<God>) results.values;
            notifyDataSetChanged();
        }
    }

}
