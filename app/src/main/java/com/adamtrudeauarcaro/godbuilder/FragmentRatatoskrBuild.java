package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Adam Trudeau Arcaro on 2016-10-08.
 */

public class FragmentRatatoskrBuild extends Fragment {

    View myView;
    String godName;
    String buildNum;
    AlertDialog buildNameDialog;

    public FragmentRatatoskrBuild() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.god_build, container, false);
        godName = getArguments().getString("infoGodName", "ratatoskr");
        buildNum = getArguments().getString("buildNum", "1");

        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);

        //Clears build if used old saving system
        int cleared = pref.getInt("cleared", 0);
        if(cleared == 0) {
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.putInt("cleared", 1);
            editor.apply();
        }

        //Initializing Build Name
        final TextView buildName = (TextView) myView.findViewById(R.id.buildName);
        final ImageView editNameButton = (ImageView) myView.findViewById(R.id.editNameButton);

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

        //Loading build name
        buildName.setText(getBuildName(godName + "_build_" + buildNum));

        //Loading build images
        starter.setImageResource(getImage(godName + "_starter_" + buildNum));
        relic1.setImageResource(getImage(godName + "_relic1_" + buildNum));
        relic2.setImageResource(getImage(godName + "_relic2_" + buildNum));
        item1.setImageResource(R.drawable.acorn);
        item2.setImageResource(getImage(godName + "_item2_" + buildNum));
        item3.setImageResource(getImage(godName + "_item3_" + buildNum));
        item4.setImageResource(getImage(godName + "_item4_" + buildNum));
        item5.setImageResource(getImage(godName + "_item5_" + buildNum));
        item6.setImageResource(getImage(godName + "_item6_" + buildNum));

        //Loading build names
        starterName.setText(getName(godName + "_starter_name_" + buildNum));
        relic1Name.setText(getName(godName + "_relic1_name_" + buildNum));
        relic2Name.setText(getName(godName + "_relic2_name_" + buildNum));
        item1Name.setText("Acorn of Yggdrasil");
        item2Name.setText(getName(godName + "_item2_name_" + buildNum));
        item3Name.setText(getName(godName + "_item3_name_" + buildNum));
        item4Name.setText(getName(godName + "_item4_name_" + buildNum));
        item5Name.setText(getName(godName + "_item5_name_" + buildNum));
        item6Name.setText(getName(godName + "_item6_name_" + buildNum));

        editNameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                View mView = getActivity().getLayoutInflater().inflate(R.layout.build_name, null);
                final EditText nameField = (EditText) mView.findViewById(R.id.buildName);
                Button confirm = (Button) mView.findViewById(R.id.confirm);
                Button cancel = (Button) mView.findViewById(R.id.cancel);

                nameField.setMaxLines(1);

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                mBuilder.setTitle("Build Name");
                mBuilder.setView(mView);
                mBuilder.setCancelable(false);

                confirm.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String name = nameField.getText().toString();
                        saveName(godName + "_build_" + buildNum, name);
                        buildName.setText(name);
                        buildNameDialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        buildNameDialog.dismiss();
                    }
                });

                buildNameDialog = mBuilder.create();
                buildNameDialog.show();
            };
        });

        starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemPhysStarterFragment dialog = ItemPhysStarterFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysStarterFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_starter_name_" + buildNum, name);
                        saveImage(godName + "_starter_" + buildNum, imageName);
                        starter.setImageResource(getImage(godName + "_starter_" + buildNum));
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
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_relic1_name_" + buildNum, name);
                        saveImage(godName + "_relic1_" + buildNum, imageName);
                        relic1.setImageResource(getImage(godName + "_relic1_" + buildNum));
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
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_relic2_name_" + buildNum, name);
                        saveImage(godName + "_relic2_" + buildNum, imageName);
                        relic2.setImageResource(getImage(godName + "_relic2_" + buildNum));
                        relic2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "relic2Dialog");
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRatatoskrFragment dialog = ItemRatatoskrFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRatatoskrFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item2_name_" + buildNum, name);
                        saveImage(godName + "_item2_" + buildNum, imageName);
                        item2.setImageResource(getImage(godName + "_item2_" + buildNum));
                        item2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item2Dialog");
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRatatoskrFragment dialog = ItemRatatoskrFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRatatoskrFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item3_name_" + buildNum, name);
                        saveImage(godName + "_item3_" + buildNum, imageName);
                        item3.setImageResource(getImage(godName + "_item3_" + buildNum));
                        item3Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item3Dialog");
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRatatoskrFragment dialog = ItemRatatoskrFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRatatoskrFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item4_name_" + buildNum, name);
                        saveImage(godName + "_item4_" + buildNum, imageName);
                        item4.setImageResource(getImage(godName + "_item4_" + buildNum));
                        item4Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item4Dialog");
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRatatoskrFragment dialog = ItemRatatoskrFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRatatoskrFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item5_name_" + buildNum, name);
                        saveImage(godName + "_item5_" + buildNum, imageName);
                        item5.setImageResource(getImage(godName + "_item5_" + buildNum));
                        item5Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item5Dialog");
            }
        });

        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRatatoskrFragment dialog = ItemRatatoskrFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRatatoskrFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(godName + "_item6_name_" + buildNum, name);
                        saveImage(godName + "_item6_" + buildNum, imageName);
                        item6.setImageResource(getImage(godName + "_item6_" + buildNum));
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
        int id = getActivity().getResources().getIdentifier(drawable_name, "drawable", getActivity().getPackageName());
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

    public String getBuildName(String item) {
        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String name = pref.getString(item, "Build " + buildNum);
        return name;
    }

}
