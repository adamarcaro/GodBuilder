package com.adamtrudeauarcaro.godbuilder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
    AlertDialog dialog;

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

    public View getView(final int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_selection_rs, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.tree_name);
        ImageView image = (ImageView) view.findViewById(R.id.tree_image);

        name.setText(items.get(position).getName());
        image.setImageResource(items.get(position).getImage());

        RelativeLayout info = (RelativeLayout) view.findViewById(R.id.item_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mView = inflater.inflate(R.layout.item_stats, null);

                Item item = items.get(position);
                
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                mBuilder.setView(mView);

                ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                itemImage.setImageResource(item.getImage());
                itemName.setText(item.getName());

                int itemCost, itemHealth, itemMana, itemDamage, itemProtPhys, itemProtMag, itemCritChance, itemPenetration, itemLifesteal, itemCdr, itemCcr;
                double itemHp5, itemMp5, itemAttackSpeed, itemSpeed;

                itemCost = item.getCost();
                itemHealth = item.getHealth();
                itemMana = item.getMana();
                itemDamage = item.getDamage();
                itemProtPhys = item.getProtPhys();
                itemProtMag = item.getProtMag();
                itemCritChance = item.getCritChance();
                itemPenetration = item.getPenetration();
                itemLifesteal = item.getLifesteal();
                itemCdr = item.getCdr();
                itemCcr = item.getCcr();
                itemHp5 = item.getHp5();
                itemMp5 = item.getMp5();
                itemAttackSpeed = item.getAttackSpeed();
                itemSpeed = item.getSpeed();

                ArrayList<Stat> stats = new ArrayList<Stat>();
                if(itemCost != 0)
                    stats.add(new Stat("Cost: ", String.valueOf(itemCost) + " gold", false));
                if(itemHealth != 0)
                    stats.add(new Stat("Health: ", String.valueOf(itemHealth), false));
                if(itemMana != 0)
                    stats.add(new Stat("Mana: ", String.valueOf(itemMana), false));
                if(itemDamage != 0)
                    stats.add(new Stat("Power: ", String.valueOf(itemDamage), false));
                if(itemProtPhys != 0)
                    stats.add(new Stat("Physical Protections: ", String.valueOf(itemProtPhys), false));
                if(itemProtMag != 0)
                    stats.add(new Stat("Magical Protections: ", String.valueOf(itemProtMag), false));
                if(itemCritChance != 0)
                    stats.add(new Stat("Crit Chance: ", String.valueOf(itemCritChance) + "%", false));
                if(itemPenetration != 0)
                    stats.add(new Stat("Penetration: ", String.valueOf(itemPenetration), false));
                if(itemLifesteal != 0)
                    stats.add(new Stat("Lifesteal: ", String.valueOf(itemLifesteal) + "%", false));
                if(itemCdr != 0)
                    stats.add(new Stat("Cooldown Reduction: ", String.valueOf(itemCdr) + "%", false));
                if(itemCcr != 0)
                    stats.add(new Stat("CC Reduction: ", String.valueOf(itemCcr) + "%", false));
                if(itemHp5 != 0.0)
                    stats.add(new Stat("HP5: ", String.valueOf(itemHp5), false));
                if(itemMp5 != 0.0)
                    stats.add(new Stat("MP5: ", String.valueOf(itemMp5), false));
                if(itemAttackSpeed != 0.0) {
                    String attackSpeedPercent = String.valueOf(Math.round(itemAttackSpeed*100)) + "%";
                    stats.add(new Stat("Attack Speed: ", attackSpeedPercent, false));
                }
                if(itemSpeed != 0.0)
                    stats.add(new Stat("Movement Speed: ", String.valueOf(itemSpeed), false));

                ListView statsList = (ListView) mView.findViewById(R.id.stats);
                StatAdapter statAdapter = new StatAdapter(c, stats);
                statsList.setAdapter(statAdapter);

                TextView passive = (TextView) mView.findViewById(R.id.passive);
                passive.setText(items.get(position).getPassive());

                Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog = mBuilder.create();
                dialog.show();
            }
        });

        return view;
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
                        Item item = new Item(filterList.get(i).getName(), filterList.get(i).getImage(), filterList.get(i).getCost(), filterList.get(i).getItemType(), filterList.get(i).getItemGroup(),
                                filterList.get(i).getHealth(), filterList.get(i).getMana(), filterList.get(i).getHp5(), filterList.get(i).getMp5(),
                                filterList.get(i).getDamage(), filterList.get(i).getLifesteal(), filterList.get(i).getPenetration(),
                                filterList.get(i).getProtPhys(), filterList.get(i).getProtMag(),
                                filterList.get(i).getAttackSpeed(), filterList.get(i).getSpeed(),
                                filterList.get(i).getCritChance(), filterList.get(i).getCdr(), filterList.get(i).getCcr(),
                                filterList.get(i).getPassive());
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

