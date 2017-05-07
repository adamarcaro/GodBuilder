package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-04-10.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapterItemPage extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ItemTree> treeList;
    private ArrayList<ItemTree> originalList;
    private AlertDialog dialog;

    static class ViewHolder {
        private ImageView itemImage;
        private TextView itemName;
        private RelativeLayout container;
    }

    static class ViewHolderTree {
        private ImageView treeImage;
        private TextView treeName;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_selection_item_page, null);
            holder = new ViewHolder();
            holder.itemImage = (ImageView) view.findViewById(R.id.item_image);
            holder.itemName = (TextView) view.findViewById(R.id.item_name);
            holder.container = (RelativeLayout) view.findViewById(R.id.container);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final Item item = getChild(groupPosition, childPosition);
        holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getName());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mView = inflater.inflate(R.layout.item_stats_item_page, null);

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                mBuilder.setView(mView);

                ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                itemImage.setImageResource(item.getImage());
                itemName.setText(item.getName());

                TextView itemType = (TextView) mView.findViewById(R.id.item_type);
                if(item.getItemType() == 'M')
                    itemType.setText(R.string.magical);
                else if(item.getItemType() == 'P')
                    itemType.setText(R.string.physical);
                else
                    itemType.setText(R.string.physical_and_magical);

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
                StatAdapter statAdapter = new StatAdapter(context, stats);
                statsList.setAdapter(statAdapter);

                TextView passive = (TextView) mView.findViewById(R.id.passive);
                RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                if(item.getPassive() != null)
                    passive.setText(item.getPassive());
                else
                    passiveContainer.setVisibility(View.GONE);

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

    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {
        ViewHolderTree holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_tree, null);
            holder = new ViewHolderTree();
            holder.treeImage = (ImageView)  view.findViewById(R.id.tree_image);
            holder.treeName = (TextView) view.findViewById(R.id.tree_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolderTree) view.getTag();
        }

        ItemTree tree = (ItemTree) getGroup(groupPosition);
        holder.treeImage.setImageResource(tree.getImage());
        holder.treeName.setText(tree.getName());

        return view;
    }

    public ItemAdapterItemPage(Context context, ArrayList<ItemTree> treeList) {
        this.context = context;
        this.treeList = new ArrayList<ItemTree>();
        this.treeList.addAll(treeList);
        this.originalList = new ArrayList<ItemTree>();
        this.originalList.addAll(treeList);
    }

    public Item getChild(int groupPosition, int childPosition) {
        ArrayList<Item> itemList = treeList.get(groupPosition).getItemList();
        return itemList.get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {

        ArrayList<Item> itemList = treeList.get(groupPosition).getItemList();
        return itemList.size();

    }

    public Object getGroup(int groupPosition) {
        return treeList.get(groupPosition);
    }

    public int getGroupCount() {
        return treeList.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){

        query = query.toLowerCase();
        Log.v("ItemAdapter", String.valueOf(treeList.size()));
        treeList.clear();

        if(query.isEmpty()){
            treeList.addAll(originalList);
        }
        else {

            for(ItemTree tree: originalList){

                ArrayList<Item> itemList = tree.getItemList();
                ArrayList<Item> newList = new ArrayList<Item>();
                for(Item item: itemList){
                    if(item.getName().toLowerCase().contains(query)){
                        newList.add(item);
                    }
                }
                if(newList.size() > 0){
                    ItemTree newTree = new ItemTree(tree.getImage(), tree.getName(),newList);
                    treeList.add(newTree);
                }
            }
        }

        Log.v("ItemAdapter", String.valueOf(treeList.size()));
        notifyDataSetChanged();

    }


}