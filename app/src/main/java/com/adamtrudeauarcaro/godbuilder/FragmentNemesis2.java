package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Adam Trudeau Arcaro on 2016-10-08.
 */

public class FragmentNemesis2 extends Fragment {

    View myView;

    public FragmentNemesis2() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.god_build, container, false);

        //Initializing ImageButtons
        final ImageButton starter = (ImageButton) myView.findViewById(R.id.imageStarterItem);
        final ImageButton relic1 = (ImageButton) myView.findViewById(R.id.imageRelic1);
        final ImageButton relic2 = (ImageButton) myView.findViewById(R.id.imageRelic2);
        final ImageButton item1 = (ImageButton) myView.findViewById(R.id.imageItem1);
        final ImageButton item2 = (ImageButton) myView.findViewById(R.id.imageItem2);
        final ImageButton item3 = (ImageButton) myView.findViewById(R.id.imageItem3);
        final ImageButton item4 = (ImageButton) myView.findViewById(R.id.imageItem4);
        final ImageButton item5 = (ImageButton) myView.findViewById(R.id.imageItem5);
        final ImageButton item6 = (ImageButton) myView.findViewById(R.id.imageItem6);

        //Initializing TextViews
        final TextView starterName = (TextView) myView.findViewById(R.id.nameStarter);
        final TextView relic1Name = (TextView) myView.findViewById(R.id.nameRelic1);
        final TextView relic2Name = (TextView) myView.findViewById(R.id.nameRelic2);
        final TextView item1Name = (TextView) myView.findViewById(R.id.nameItem1);
        final TextView item2Name = (TextView) myView.findViewById(R.id.nameItem2);
        final TextView item3Name = (TextView) myView.findViewById(R.id.nameItem3);
        final TextView item4Name = (TextView) myView.findViewById(R.id.nameItem4);
        final TextView item5Name = (TextView) myView.findViewById(R.id.nameItem5);
        final TextView item6Name = (TextView) myView.findViewById(R.id.nameItem6);

        //Loading build images
        starter.setImageResource(getImage("nemesis_starter_2"));
        relic1.setImageResource(getImage("nemesis_relic1_2"));
        relic2.setImageResource(getImage("nemesis_relic2_2"));
        item1.setImageResource(getImage("nemesis_item1_2"));
        item2.setImageResource(getImage("nemesis_item2_2"));
        item3.setImageResource(getImage("nemesis_item3_2"));
        item4.setImageResource(getImage("nemesis_item4_2"));
        item5.setImageResource(getImage("nemesis_item5_2"));
        item6.setImageResource(getImage("nemesis_item6_2"));

        //Loading build names
        starterName.setText(getName("nemesis_starter_name_2"));
        relic1Name.setText(getName("nemesis_relic1_name_2"));
        relic2Name.setText(getName("nemesis_relic2_name_2"));
        item1Name.setText(getName("nemesis_item1_name_2"));
        item2Name.setText(getName("nemesis_item2_name_2"));
        item3Name.setText(getName("nemesis_item3_name_2"));
        item4Name.setText(getName("nemesis_item4_name_2"));
        item5Name.setText(getName("nemesis_item5_name_2"));
        item6Name.setText(getName("nemesis_item6_name_2"));

        starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemPhysStarterFragment dialog = ItemPhysStarterFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysStarterFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_starter_name_2", name);
                        saveImage("nemesis_starter_2", resourceId);
                        starter.setImageResource(resourceId);
                        starterName.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "starterDialog");
            }
        });

        relic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_relic1_name_2", name);
                        saveImage("nemesis_relic1_2", resourceId);
                        relic1.setImageResource(resourceId);
                        relic1Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "relic1Dialog");
            }
        });

        relic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_relic2_name_2", name);
                        saveImage("nemesis_relic2_2", resourceId);
                        relic2.setImageResource(resourceId);
                        relic2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "relic2Dialog");
            }
        });

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_item1_name_2", name);
                        saveImage("nemesis_item1_2", resourceId);
                        item1.setImageResource(resourceId);
                        item1Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item1Dialog");
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_item2_name_2", name);
                        saveImage("nemesis_item2_2", resourceId);
                        item2.setImageResource(resourceId);
                        item2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item2Dialog");
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_item3_name_2", name);
                        saveImage("nemesis_item3_2", resourceId);
                        item3.setImageResource(resourceId);
                        item3Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item3Dialog");
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_item4_name_2", name);
                        saveImage("nemesis_item4_2", resourceId);
                        item4.setImageResource(resourceId);
                        item4Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item4Dialog");
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_item5_name_2", name);
                        saveImage("nemesis_item5_2", resourceId);
                        item5.setImageResource(resourceId);
                        item5Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item5Dialog");
            }
        });

        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, int resourceId) {
                        saveName("nemesis_item6_name_2", name);
                        saveImage("nemesis_item6_2", resourceId);
                        item6.setImageResource(resourceId);
                        item6Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item6Dialog");
            }
        });

        return myView;
    }

    public int getImage(String item){
        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int id = pref.getInt(item, R.drawable.no_item);
        return id;
    }

    public void saveImage(String item, int resourceId){
        SharedPreferences starterSP = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = starterSP.edit();
        edit.putInt(item, resourceId);
        edit.apply();
    }

    public String getName(String item){
        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String name = pref.getString(item, "");
        return name;
    }

    public void saveName(String item, String name){
        SharedPreferences starterSP = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = starterSP.edit();
        edit.putString(item, name);
        edit.apply();
    }

}