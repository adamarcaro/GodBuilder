package com.adamtrudeauarcaro.godbuilder;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Adam Trudeau Arcaro on 2016-10-08.
 */

public class FragmentAgni1 extends Fragment {

    View myView;
    String godName;

    public FragmentAgni1() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.god_build, container, false);
        godName = getArguments().getString("godName", "");

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
        starter.setImageResource(getImage(godName + "_starter"));
        relic1.setImageResource(getImage(godName + "_relic1"));
        relic2.setImageResource(getImage(godName + "_relic2"));
        item1.setImageResource(getImage(godName + "_item1"));
        item2.setImageResource(getImage(godName + "_item2"));
        item3.setImageResource(getImage(godName + "_item3"));
        item4.setImageResource(getImage(godName + "_item4"));
        item5.setImageResource(getImage(godName + "_item5"));
        item6.setImageResource(getImage(godName + "_item6"));

        //Loading build names
        starterName.setText(getName(godName + "_starter_name"));
        relic1Name.setText(getName(godName + "_relic1_name"));
        relic2Name.setText(getName(godName + "_relic2_name"));
        item1Name.setText(getName(godName + "_item1_name"));
        item2Name.setText(getName(godName + "_item2_name"));
        item3Name.setText(getName(godName + "_item3_name"));
        item4Name.setText(getName(godName + "_item4_name"));
        item5Name.setText(getName(godName + "_item5_name"));
        item6Name.setText(getName(godName + "_item6_name"));

        starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemMagStarterFragment1 dialog = ItemMagStarterFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagStarterFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_starter_name", name);
                        saveImage(godName + "_starter", imageName);
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
                ItemRelicFragment1 dialog = ItemRelicFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_relic1_name", name);
                        saveImage(godName + "_relic1", imageName);
                        starter.setImageResource(resourceId);
                        relic1Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "relic1Dialog");
            }
        });

        relic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRelicFragment1 dialog = ItemRelicFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_relic2_name", name);
                        saveImage(godName + "_relic2", imageName);
                        starter.setImageResource(resourceId);
                        relic2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "relic2Dialog");
            }
        });

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemMagFragment1 dialog = ItemMagFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item1_name", name);
                        saveImage(godName + "_item1", imageName);
                        starter.setImageResource(resourceId);
                        item1Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item1Dialog");
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemMagFragment1 dialog = ItemMagFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item2_name", name);
                        saveImage(godName + "_item2", imageName);
                        starter.setImageResource(resourceId);
                        item2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item2Dialog");
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemMagFragment1 dialog = ItemMagFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item3_name", name);
                        saveImage(godName + "_item3", imageName);
                        starter.setImageResource(resourceId);
                        item3Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item3Dialog");
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemMagFragment1 dialog = ItemMagFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item4_name", name);
                        saveImage(godName + "_item4", imageName);
                        starter.setImageResource(resourceId);
                        item4Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item4Dialog");
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemMagFragment1 dialog = ItemMagFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item5_name", name);
                        saveImage(godName + "_item5", imageName);
                        starter.setImageResource(resourceId);
                        item5Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item5Dialog");
            }
        });

        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemMagFragment1 dialog = ItemMagFragment1.newInstance();
                dialog.setOnListItemSelectedListener(new ItemMagFragment1.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item6_name", name);
                        saveImage(godName + "_item6", imageName);
                        starter.setImageResource(resourceId);
                        item6Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item6Dialog");
            }
        });

        return myView;
    }

    public int getImage(String item) {
        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String drawable_name = pref.getString(item, "no_item");
        final int id = getActivity().getResources().getIdentifier(item, drawable_name, getActivity().getPackageName());
        return id;
    }

    public void saveImage(String item, String drawable_name) {
        SharedPreferences starterSP = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = starterSP.edit();
        edit.putString(item, drawable_name);
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
