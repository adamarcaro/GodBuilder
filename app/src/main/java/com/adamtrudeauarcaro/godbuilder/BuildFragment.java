package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.itemsAll;

/**
 * Created by Adam Trudeau Arcaro on 2016-10-08.
 */

public class BuildFragment extends Fragment {

    View myView;
    AlertDialog alertDialog;

    God god;
    String infoGodName, infoGodTitle, infoGodNameString, infoPantheon, infoClass, infoBuildNumber;
    int infoGodImage, infoPantheonIcon, infoClassIcon, infoHealth, infoMana, infoDamage, infoProtPhys, infoProtMag;
    char infoType;
    double infoHp5, infoMp5, infoAttackSpeed, infoSpeed;

    int buildCost, buildHealth, buildMana, buildDamage, buildLifesteal, buildPower, buildPenetration, buildProtPhys, buildProtMag, buildCritChance, buildCdr, buildCcr;
    double buildHp5, buildMp5, buildAttackSpeed, buildSpeed;

    int item1Stacks, item2Stacks,  item3Stacks, item4Stacks, item5Stacks, item6Stacks;

    ArrayList<Item> items = itemsAll;
    static ArrayList<Item> passives = new ArrayList<Item>();

    public BuildFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.god_build, container, false);

        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        getGodArgs();

        //Clears build if used old saving system
        int cleared = pref.getInt("cleared", 0);
        if (cleared == 0) {
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.putInt("cleared", 1);
            editor.apply();
        }

        //Initializing Build Name
        final ImageView clearBuildButton = (ImageView) myView.findViewById(R.id.clearBuildButton);
        final TextView buildName = (TextView) myView.findViewById(R.id.buildName);
        final ImageView statsButton = (ImageView) myView.findViewById(R.id.statsButton);

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
        buildName.setText(getBuildName(god.getNameString() + "_build_" + infoBuildNumber));

        //Loading build images
        starter.setImageResource(getImage(god.getNameString() + "_starter_" + infoBuildNumber));
        relic1.setImageResource(getImage(god.getNameString() + "_relic1_" + infoBuildNumber));
        relic2.setImageResource(getImage(god.getNameString() + "_relic2_" + infoBuildNumber));
        item1.setImageResource(getImage(god.getNameString() + "_item1_" + infoBuildNumber));
        item2.setImageResource(getImage(god.getNameString() + "_item2_" + infoBuildNumber));
        item3.setImageResource(getImage(god.getNameString() + "_item3_" + infoBuildNumber));
        item4.setImageResource(getImage(god.getNameString() + "_item4_" + infoBuildNumber));
        item5.setImageResource(getImage(god.getNameString() + "_item5_" + infoBuildNumber));
        item6.setImageResource(getImage(god.getNameString() + "_item6_" + infoBuildNumber));

        //Loading build names
        starterName.setText(getName(god.getNameString() + "_starter_name_" + infoBuildNumber));
        relic1Name.setText(getName(god.getNameString() + "_relic1_name_" + infoBuildNumber));
        relic2Name.setText(getName(god.getNameString() + "_relic2_name_" + infoBuildNumber));
        item1Name.setText(getName(god.getNameString() + "_item1_name_" + infoBuildNumber));
        item2Name.setText(getName(god.getNameString() + "_item2_name_" + infoBuildNumber));
        item3Name.setText(getName(god.getNameString() + "_item3_name_" + infoBuildNumber));
        item4Name.setText(getName(god.getNameString() + "_item4_name_" + infoBuildNumber));
        item5Name.setText(getName(god.getNameString() + "_item5_name_" + infoBuildNumber));
        item6Name.setText(getName(god.getNameString() + "_item6_name_" + infoBuildNumber));

        statsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                calculateStats();
                passives = getPassives();

                //MIGHT NOT NEED THIS, REQUIRES TESTING
                for(int i = 0; i < passives.size(); i++)
                    if(passives.get(i) == null)
                        passives.remove(i);

                //If no passives, display message
                if(passives.isEmpty() && god.getType() != 'R')
                {
                    passives.add(new Item("No Passives", "You have not selected any relics or items with passive effects."));
                }
                if(god.getType() == 'R')
                {
                    passives.add(new Item("Acorn of Yggdrasil", "Any time Ratatoskr uses an ability that successfully hits any target, he is healed."));
                }

                StatFragment dialog = new StatFragment();
                dialog.setArguments(passBuildStatArgs());
                dialog.show(getActivity().getFragmentManager(), "statsDialog");
            }

            ;
        });

        buildName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                View mView = getActivity().getLayoutInflater().inflate(R.layout.build_name, null);
                final EditText nameField = (EditText) mView.findViewById(R.id.buildName);
                Button confirm = (Button) mView.findViewById(R.id.confirm);
                Button cancel = (Button) mView.findViewById(R.id.cancel);

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                mBuilder.setTitle("Build Name");
                mBuilder.setView(mView);

                confirm.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String name = nameField.getText().toString();
                        saveName(god.getNameString() + "_build_" + infoBuildNumber, name);
                        buildName.setText(name);
                        alertDialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog = mBuilder.create();
                alertDialog.show();
            }

            ;
        });

        clearBuildButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                View mView = getActivity().getLayoutInflater().inflate(R.layout.clear_build, null);
                final TextView areYouSure = (TextView) mView.findViewById(R.id.areYouSure);
                Button confirm = (Button) mView.findViewById(R.id.confirm);
                Button cancel = (Button) mView.findViewById(R.id.cancel);

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                mBuilder.setTitle("Delete Build");
                mBuilder.setView(mView);

                confirm.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        //Saving empty strings as names
                        saveName(god.getNameString() + "_starter_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_relic1_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_relic2_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_item1_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_item2_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_item3_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_item4_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_item5_name_" + infoBuildNumber, "");
                        saveName(god.getNameString() + "_item6_name_" + infoBuildNumber, "");

                        //Saving no_item image as images
                        saveImage(god.getNameString() + "_starter_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_relic1_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_relic2_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_item1_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_item2_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_item3_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_item4_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_item5_" + infoBuildNumber, "no_item");
                        saveImage(god.getNameString() + "_item6_" + infoBuildNumber, "no_item");

                        //Loading names
                        starterName.setText(getName(god.getNameString() + "_starter_name_" + infoBuildNumber));
                        relic1Name.setText(getName(god.getNameString() + "_relic1_name_" + infoBuildNumber));
                        relic2Name.setText(getName(god.getNameString() + "_relic2_name_" + infoBuildNumber));
                        item1Name.setText(getName(god.getNameString() + "_item1_name_" + infoBuildNumber));
                        item2Name.setText(getName(god.getNameString() + "_item2_name_" + infoBuildNumber));
                        item3Name.setText(getName(god.getNameString() + "_item3_name_" + infoBuildNumber));
                        item4Name.setText(getName(god.getNameString() + "_item4_name_" + infoBuildNumber));
                        item5Name.setText(getName(god.getNameString() + "_item5_name_" + infoBuildNumber));
                        item6Name.setText(getName(god.getNameString() + "_item6_name_" + infoBuildNumber));

                        //Loading images
                        starter.setImageResource(getImage(god.getNameString() + "_starter_" + infoBuildNumber));
                        relic1.setImageResource(getImage(god.getNameString() + "_relic1_" + infoBuildNumber));
                        relic2.setImageResource(getImage(god.getNameString() + "_relic2_" + infoBuildNumber));
                        item1.setImageResource(getImage(god.getNameString() + "_item1_" + infoBuildNumber));
                        item2.setImageResource(getImage(god.getNameString() + "_item2_" + infoBuildNumber));
                        item3.setImageResource(getImage(god.getNameString() + "_item3_" + infoBuildNumber));
                        item4.setImageResource(getImage(god.getNameString() + "_item4_" + infoBuildNumber));
                        item5.setImageResource(getImage(god.getNameString() + "_item5_" + infoBuildNumber));
                        item6.setImageResource(getImage(god.getNameString() + "_item6_" + infoBuildNumber));

                        alertDialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog = mBuilder.create();
                alertDialog.show();
            }

            ;
        });

       starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_starter_name_" + infoBuildNumber).equals("")) {
                    ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'S');
                    dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                        public void onListItemClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_starter_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_starter_" + infoBuildNumber, imageName);
                            starter.setImageResource(getImage(god.getNameString() + "_starter_" + infoBuildNumber));
                            starterName.setText(name);
                        }
                    });
                    dialog.show(getActivity().getFragmentManager(), "relic1Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    Item item = getItemByName(starterName.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);
                    stacksContainer.setVisibility(View.GONE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'S');
                            dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                                public void onListItemClick(String name, String imageName, int resourceId) {
                                    saveName(god.getNameString() + "_starter_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_starter_" + infoBuildNumber, imageName);
                                    starter.setImageResource(getImage(god.getNameString() + "_starter_" + infoBuildNumber));
                                    starterName.setText(name);
                                }
                            });
                            dialog.show(getActivity().getFragmentManager(), "starterDialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_starter_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_starter_" + infoBuildNumber, "no_item");
                            starterName.setText(getName(god.getNameString() + "_starter_name_" + infoBuildNumber));
                            starter.setImageResource(getImage(god.getNameString() + "_starter_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });

        relic1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_relic1_name_" + infoBuildNumber).equals("")) {
                    ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'R');
                    dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                        public void onListItemClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_relic1_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_relic1_" + infoBuildNumber, imageName);
                            relic1.setImageResource(getImage(god.getNameString() + "_relic1_" + infoBuildNumber));
                            relic1Name.setText(name);
                        }
                    });
                    dialog.show(getActivity().getFragmentManager(), "relic1Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    Item item = getItemByName(relic1Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);
                    stacksContainer.setVisibility(View.GONE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'R');
                            dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                                public void onListItemClick(String name, String imageName, int resourceId) {
                                    saveName(god.getNameString() + "_relic1_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_relic1_" + infoBuildNumber, imageName);
                                    relic1.setImageResource(getImage(god.getNameString() + "_relic1_" + infoBuildNumber));
                                    relic1Name.setText(name);
                                }
                            });
                            dialog.show(getActivity().getFragmentManager(), "relic1Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_relic1_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_relic1_" + infoBuildNumber, "no_item");
                            relic1Name.setText(getName(god.getNameString() + "_relic1_name_" + infoBuildNumber));
                            relic1.setImageResource(getImage(god.getNameString() + "_relic1_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });

        relic2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_relic2_name_" + infoBuildNumber).equals("")) {
                    ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'R');
                    dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                        public void onListItemClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_relic2_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_relic2_" + infoBuildNumber, imageName);
                            relic2.setImageResource(getImage(god.getNameString() + "_relic2_" + infoBuildNumber));
                            relic2Name.setText(name);
                        }
                    });
                    dialog.show(getActivity().getFragmentManager(), "relic2Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    Item item = getItemByName(relic2Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);
                    stacksContainer.setVisibility(View.GONE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'R');
                            dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                                public void onListItemClick(String name, String imageName, int resourceId) {
                                    saveName(god.getNameString() + "_relic2_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_relic2_" + infoBuildNumber, imageName);
                                    relic2.setImageResource(getImage(god.getNameString() + "_relic2_" + infoBuildNumber));
                                    relic2Name.setText(name);
                                }
                            });
                            dialog.show(getActivity().getFragmentManager(), "relic2Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_relic2_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_relic2_" + infoBuildNumber, "no_item");
                            relic2Name.setText(getName(god.getNameString() + "_relic2_name_" + infoBuildNumber));
                            relic2.setImageResource(getImage(god.getNameString() + "_relic2_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });

        if (god.getType() == 'R')
        {
            item1.setImageResource(R.drawable.acorn);
            item1Name.setText("Acorn of Yggdrasil");
        } else {
            item1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(getName(god.getNameString() + "_item1_name_" + infoBuildNumber).equals("")) {
                        TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                        dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                            public void onChildClick(String name, String imageName, int resourceId) {
                                saveName(god.getNameString() + "_item1_name_" + infoBuildNumber, name);
                                saveImage(god.getNameString() + "_item1_" + infoBuildNumber, imageName);
                                item1.setImageResource(getImage(god.getNameString() + "_item1_" + infoBuildNumber));
                                item1Name.setText(name);
                            }
                        });
                        dialog.show(getFragmentManager(), "item1Dialog");
                    } else {
                        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                        final Item item = getItemByName(item1Name.getText().toString());

                        ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                        TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                        itemImage.setImageResource(item.getImage());
                        itemName.setText(item.getName());

                        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                        mBuilder.setView(mView);

                        ListView statsList = (ListView) mView.findViewById(R.id.stats);
                        StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                        statsList.setAdapter(statAdapter);

                        TextView passive = (TextView) mView.findViewById(R.id.passive);
                        RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                        if(item.getPassive() != null)
                            passive.setText(item.getPassive());
                        else
                            passiveContainer.setVisibility(View.GONE);

                        TextView maxStacksText = (TextView) mView.findViewById(R.id.max_stacks);
                        maxStacksText.setText("(Enter a value between 0-" + item.getMaxStacks() + ")");
                        final EditText stacks = (EditText) mView.findViewById(R.id.stacks_input);
                        stacks.setText(String.valueOf(item1Stacks));
                        stacks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            public void onFocusChange(View v, boolean hasFocus) {
                                if(!hasFocus)
                                {
                                    int stacksInput = Integer.parseInt(stacks.getText().toString());
                                    if(stacksInput > item.getMaxStacks()) {
                                        item1Stacks = item.getMaxStacks();
                                        stacks.setText(String.valueOf(item.getMaxStacks()));
                                    }
                                    else
                                        item1Stacks = stacksInput;
                                }
                            }
                        });
                        RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);

                        RelativeLayout frame = (RelativeLayout) mView.findViewById(R.id.stats_frame);
                        frame.setOnTouchListener(new View.OnTouchListener() {
                            public boolean onTouch(View v, MotionEvent event) {
                                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                    if (stacks.isFocused()) {
                                        Rect outRect = new Rect();
                                        stacks.getGlobalVisibleRect(outRect);
                                        if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                                            stacks.clearFocus();
                                            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                        }
                                    }
                                }
                                return false;
                            }
                        });

                        if(item.getMaxStacks() == 0)
                            stacksContainer.setVisibility(View.GONE);
                        else
                            stacksContainer.setVisibility(View.VISIBLE);


                        Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                        dismiss.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks())
                                    item1Stacks = item.getMaxStacks();
                                else
                                    item1Stacks = stacksInput;
                                alertDialog.dismiss();
                            }
                        });

                        RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                        RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                        changeLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                                dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                                    public void onChildClick(String name, String imageName, int resourceId) {
                                        item1Stacks = 0;
                                        stacks.setText(String.valueOf(item1Stacks));
                                        saveName(god.getNameString() + "_item1_name_" + infoBuildNumber, name);
                                        saveImage(god.getNameString() + "_item1_" + infoBuildNumber, imageName);
                                        item1.setImageResource(getImage(god.getNameString() + "_item1_" + infoBuildNumber));
                                        item1Name.setText(name);
                                    }
                                });
                                dialog.show(getFragmentManager(), "item1Dialog");
                                alertDialog.dismiss();
                            }
                        });

                        removeLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                saveName(god.getNameString() + "_item1_name_" + infoBuildNumber, "");
                                saveImage(god.getNameString() + "_item1_" + infoBuildNumber, "no_item");
                                item1Name.setText(getName(god.getNameString() + "_item1_name_" + infoBuildNumber));
                                item1.setImageResource(getImage(god.getNameString() + "_item1_" + infoBuildNumber));
                                alertDialog.dismiss();
                            }
                        });

                        mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface dialog) {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks())
                                    item1Stacks = item.getMaxStacks();
                                else
                                    item1Stacks = stacksInput;
                            }
                        });

                        alertDialog = mBuilder.create();
                        alertDialog.show();
                    }
                }
            });
        }

        item2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_item2_name_" + infoBuildNumber).equals("")) {
                    TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                    dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                        public void onChildClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_item2_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_item2_" + infoBuildNumber, imageName);
                            item2.setImageResource(getImage(god.getNameString() + "_item2_" + infoBuildNumber));
                            item2Name.setText(name);
                        }
                    });
                    dialog.show(getFragmentManager(), "item2Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    final Item item = getItemByName(item2Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    TextView maxStacksText = (TextView) mView.findViewById(R.id.max_stacks);
                    maxStacksText.setText("(Enter a value between 0-" + item.getMaxStacks() + ")");
                    final EditText stacks = (EditText) mView.findViewById(R.id.stacks_input);
                    stacks.setText(String.valueOf(item2Stacks));
                    stacks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus)
                            {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks()) {
                                    item2Stacks = item.getMaxStacks();
                                    stacks.setText(String.valueOf(item.getMaxStacks()));
                                }
                                else
                                    item2Stacks = stacksInput;
                            }
                        }
                    });
                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);

                    RelativeLayout frame = (RelativeLayout) mView.findViewById(R.id.stats_frame);
                    frame.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                if (stacks.isFocused()) {
                                    Rect outRect = new Rect();
                                    stacks.getGlobalVisibleRect(outRect);
                                    if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                                        stacks.clearFocus();
                                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                    }
                                }
                            }
                            return false;
                        }
                    });

                    if(item.getMaxStacks() == 0)
                        stacksContainer.setVisibility(View.GONE);
                    else
                        stacksContainer.setVisibility(View.VISIBLE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item2Stacks = item.getMaxStacks();
                            else
                                item2Stacks = stacksInput;
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                            dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                                public void onChildClick(String name, String imageName, int resourceId) {
                                    item2Stacks = 0;
                                    stacks.setText(String.valueOf(item2Stacks));
                                    saveName(god.getNameString() + "_item2_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_item2_" + infoBuildNumber, imageName);
                                    item2.setImageResource(getImage(god.getNameString() + "_item2_" + infoBuildNumber));
                                    item2Name.setText(name);
                                }
                            });
                            dialog.show(getFragmentManager(), "item2Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_item2_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_item2_" + infoBuildNumber, "no_item");
                            item2Name.setText(getName(god.getNameString() + "_item2_name_" + infoBuildNumber));
                            item2.setImageResource(getImage(god.getNameString() + "_item2_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item2Stacks = item.getMaxStacks();
                            else
                                item2Stacks = stacksInput;
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });
        
        item3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_item3_name_" + infoBuildNumber).equals("")) {
                    TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                    dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                        public void onChildClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_item3_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_item3_" + infoBuildNumber, imageName);
                            item3.setImageResource(getImage(god.getNameString() + "_item3_" + infoBuildNumber));
                            item3Name.setText(name);
                        }
                    });
                    dialog.show(getFragmentManager(), "item3Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    final Item item = getItemByName(item3Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    TextView maxStacksText = (TextView) mView.findViewById(R.id.max_stacks);
                    maxStacksText.setText("(Enter a value between 0-" + item.getMaxStacks() + ")");
                    final EditText stacks = (EditText) mView.findViewById(R.id.stacks_input);
                    stacks.setText(String.valueOf(item3Stacks));
                    stacks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus)
                            {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks()) {
                                    item3Stacks = item.getMaxStacks();
                                    stacks.setText(String.valueOf(item.getMaxStacks()));
                                }
                                else
                                    item3Stacks = stacksInput;
                            }
                        }
                    });
                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);

                    RelativeLayout frame = (RelativeLayout) mView.findViewById(R.id.stats_frame);
                    frame.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                if (stacks.isFocused()) {
                                    Rect outRect = new Rect();
                                    stacks.getGlobalVisibleRect(outRect);
                                    if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                                        stacks.clearFocus();
                                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                    }
                                }
                            }
                            return false;
                        }
                    });

                    if(item.getMaxStacks() == 0)
                        stacksContainer.setVisibility(View.GONE);
                    else
                        stacksContainer.setVisibility(View.VISIBLE);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item3Stacks = item.getMaxStacks();
                            else
                                item3Stacks = stacksInput;
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                            dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                                public void onChildClick(String name, String imageName, int resourceId) {
                                    item3Stacks = 0;
                                    stacks.setText(String.valueOf(item3Stacks));
                                    saveName(god.getNameString() + "_item3_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_item3_" + infoBuildNumber, imageName);
                                    item3.setImageResource(getImage(god.getNameString() + "_item3_" + infoBuildNumber));
                                    item3Name.setText(name);
                                }
                            });
                            dialog.show(getFragmentManager(), "item3Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_item3_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_item3_" + infoBuildNumber, "no_item");
                            item3Name.setText(getName(god.getNameString() + "_item3_name_" + infoBuildNumber));
                            item3.setImageResource(getImage(god.getNameString() + "_item3_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item3Stacks = item.getMaxStacks();
                            else
                                item3Stacks = stacksInput;
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_item4_name_" + infoBuildNumber).equals("")) {
                    TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                    dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                        public void onChildClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_item4_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_item4_" + infoBuildNumber, imageName);
                            item4.setImageResource(getImage(god.getNameString() + "_item4_" + infoBuildNumber));
                            item4Name.setText(name);
                        }
                    });
                    dialog.show(getFragmentManager(), "item4Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    final Item item = getItemByName(item4Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    TextView maxStacksText = (TextView) mView.findViewById(R.id.max_stacks);
                    maxStacksText.setText("(Enter a value between 0-" + item.getMaxStacks() + ")");
                    final EditText stacks = (EditText) mView.findViewById(R.id.stacks_input);
                    stacks.setText(String.valueOf(item4Stacks));
                    stacks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus)
                            {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks()) {
                                    item4Stacks = item.getMaxStacks();
                                    stacks.setText(String.valueOf(item.getMaxStacks()));
                                }
                                else
                                    item4Stacks = stacksInput;
                            }
                        }
                    });
                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);

                    RelativeLayout frame = (RelativeLayout) mView.findViewById(R.id.stats_frame);
                    frame.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                if (stacks.isFocused()) {
                                    Rect outRect = new Rect();
                                    stacks.getGlobalVisibleRect(outRect);
                                    if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                                        stacks.clearFocus();
                                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                    }
                                }
                            }
                            return false;
                        }
                    });

                    if(item.getMaxStacks() == 0)
                        stacksContainer.setVisibility(View.GONE);
                    else
                        stacksContainer.setVisibility(View.VISIBLE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item4Stacks = item.getMaxStacks();
                            else
                                item4Stacks = stacksInput;
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                            dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                                public void onChildClick(String name, String imageName, int resourceId) {
                                    item4Stacks = 0;
                                    stacks.setText(String.valueOf(item4Stacks));
                                    saveName(god.getNameString() + "_item4_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_item4_" + infoBuildNumber, imageName);
                                    item4.setImageResource(getImage(god.getNameString() + "_item4_" + infoBuildNumber));
                                    item4Name.setText(name);
                                }
                            });
                            dialog.show(getFragmentManager(), "item4Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_item4_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_item4_" + infoBuildNumber, "no_item");
                            item4Name.setText(getName(god.getNameString() + "_item4_name_" + infoBuildNumber));
                            item4.setImageResource(getImage(god.getNameString() + "_item4_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item4Stacks = item.getMaxStacks();
                            else
                                item4Stacks = stacksInput;
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_item5_name_" + infoBuildNumber).equals("")) {
                    TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                    dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                        public void onChildClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_item5_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_item5_" + infoBuildNumber, imageName);
                            item5.setImageResource(getImage(god.getNameString() + "_item5_" + infoBuildNumber));
                            item5Name.setText(name);
                        }
                    });
                    dialog.show(getFragmentManager(), "item5Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    final Item item = getItemByName(item5Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    final TextView maxStacksText = (TextView) mView.findViewById(R.id.max_stacks);
                    maxStacksText.setText("(Enter a value between 0-" + item.getMaxStacks() + ")");
                    final EditText stacks = (EditText) mView.findViewById(R.id.stacks_input);
                    stacks.setText(String.valueOf(item5Stacks));
                    stacks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus)
                            {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks()) {
                                    item5Stacks = item.getMaxStacks();
                                    stacks.setText(String.valueOf(item.getMaxStacks()));
                                }
                                else
                                    item5Stacks = stacksInput;
                            }
                        }
                    });
                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);

                    RelativeLayout frame = (RelativeLayout) mView.findViewById(R.id.stats_frame);
                    frame.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                if (stacks.isFocused()) {
                                    Rect outRect = new Rect();
                                    stacks.getGlobalVisibleRect(outRect);
                                    if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                                        stacks.clearFocus();
                                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                    }
                                }
                            }
                            return false;
                        }
                    });

                    if(item.getMaxStacks() == 0)
                        stacksContainer.setVisibility(View.GONE);
                    else
                        stacksContainer.setVisibility(View.VISIBLE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item5Stacks = item.getMaxStacks();
                            else
                                item5Stacks = stacksInput;
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                            dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                                public void onChildClick(String name, String imageName, int resourceId) {
                                    item5Stacks = 0;
                                    stacks.setText(String.valueOf(item5Stacks));
                                    saveName(god.getNameString() + "_item5_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_item5_" + infoBuildNumber, imageName);
                                    item5.setImageResource(getImage(god.getNameString() + "_item5_" + infoBuildNumber));
                                    item5Name.setText(name);
                                }
                            });
                            dialog.show(getFragmentManager(), "item5Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_item5_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_item5_" + infoBuildNumber, "no_item");
                            item5Name.setText(getName(god.getNameString() + "_item5_name_" + infoBuildNumber));
                            item5.setImageResource(getImage(god.getNameString() + "_item5_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item5Stacks = item.getMaxStacks();
                            else
                                item5Stacks = stacksInput;
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
            }
        });

        item6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(getName(god.getNameString() + "_item6_name_" + infoBuildNumber).equals("")) {
                    TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                    dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                        public void onChildClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_item6_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_item6_" + infoBuildNumber, imageName);
                            item6.setImageResource(getImage(god.getNameString() + "_item6_" + infoBuildNumber));
                            item6Name.setText(name);
                        }
                    });
                    dialog.show(getFragmentManager(), "item6Dialog");
                } else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.item_stats_in_build, null);

                    final Item item = getItemByName(item6Name.getText().toString());

                    ImageView itemImage = (ImageView) mView.findViewById(R.id.item_header_image);
                    TextView itemName = (TextView) mView.findViewById(R.id.item_header_name);
                    itemImage.setImageResource(item.getImage());
                    itemName.setText(item.getName());

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getRootView().getContext());
                    mBuilder.setView(mView);

                    ListView statsList = (ListView) mView.findViewById(R.id.stats);
                    StatAdapter statAdapter = new StatAdapter(getContext(), getItemStatValues(item));
                    statsList.setAdapter(statAdapter);

                    TextView passive = (TextView) mView.findViewById(R.id.passive);
                    RelativeLayout passiveContainer = (RelativeLayout) mView.findViewById(R.id.passive_container);
                    if(item.getPassive() != null)
                        passive.setText(item.getPassive());
                    else
                        passiveContainer.setVisibility(View.GONE);

                    TextView maxStacksText = (TextView) mView.findViewById(R.id.max_stacks);
                    maxStacksText.setText("(Enter a value between 0-" + item.getMaxStacks() + ")");
                    final EditText stacks = (EditText) mView.findViewById(R.id.stacks_input);
                    stacks.setText(String.valueOf(item6Stacks));
                    stacks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus)
                            {
                                int stacksInput = Integer.parseInt(stacks.getText().toString());
                                if(stacksInput > item.getMaxStacks())
                                    item6Stacks = item.getMaxStacks();
                                else
                                    item6Stacks = stacksInput;

                                stacks.setText(String.valueOf(item6Stacks));
                            }
                        }
                    });
                    RelativeLayout stacksContainer = (RelativeLayout) mView.findViewById(R.id.stacks_container);

                    RelativeLayout frame = (RelativeLayout) mView.findViewById(R.id.stats_frame);
                    frame.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                if (stacks.isFocused()) {
                                    Rect outRect = new Rect();
                                    stacks.getGlobalVisibleRect(outRect);
                                    if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                                        stacks.clearFocus();
                                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                    }
                                }
                            }
                            return false;
                        }
                    });

                    if(item.getMaxStacks() == 0)
                        stacksContainer.setVisibility(View.GONE);
                    else
                        stacksContainer.setVisibility(View.VISIBLE);

                    Button dismiss = (Button) mView.findViewById(R.id.dismiss);

                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item6Stacks = item.getMaxStacks();
                            else
                                item6Stacks = stacksInput;
                            alertDialog.dismiss();
                        }
                    });

                    RelativeLayout changeLayout = (RelativeLayout) mView.findViewById(R.id.changeLayout);
                    RelativeLayout removeLayout = (RelativeLayout) mView.findViewById(R.id.removeLayout);

                    changeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TreeFragment dialog = TreeFragment.newInstance(god.getType(), 'I');
                            dialog.setOnChildClickListener(new TreeFragment.OnChildClickListener() {
                                public void onChildClick(String name, String imageName, int resourceId) {
                                    item6Stacks = 0;
                                    stacks.setText(String.valueOf(item6Stacks));
                                    saveName(god.getNameString() + "_item6_name_" + infoBuildNumber, name);
                                    saveImage(god.getNameString() + "_item6_" + infoBuildNumber, imageName);
                                    item6.setImageResource(getImage(god.getNameString() + "_item6_" + infoBuildNumber));
                                    item6Name.setText(name);
                                }
                            });
                            dialog.show(getFragmentManager(), "item6Dialog");
                            alertDialog.dismiss();
                        }
                    });

                    removeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveName(god.getNameString() + "_item6_name_" + infoBuildNumber, "");
                            saveImage(god.getNameString() + "_item6_" + infoBuildNumber, "no_item");
                            item6Name.setText(getName(god.getNameString() + "_item6_name_" + infoBuildNumber));
                            item6.setImageResource(getImage(god.getNameString() + "_item6_" + infoBuildNumber));
                            alertDialog.dismiss();
                        }
                    });

                    mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            int stacksInput = Integer.parseInt(stacks.getText().toString());
                            if(stacksInput > item.getMaxStacks())
                                item6Stacks = item.getMaxStacks();
                            else
                                item6Stacks = stacksInput;
                        }
                    });

                    alertDialog = mBuilder.create();
                    alertDialog.show();
                }
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
        String name = pref.getString(item, "Build " + infoBuildNumber);
        return name;
    }

    private void getGodArgs() {
        infoGodName = getArguments().getString("infoGodName", "Agni");
        infoGodTitle = getArguments().getString("infoGodTitle", "God of Fire");

        infoGodNameString = getArguments().getString("infoGodNameString", "agni");
        infoGodImage = getArguments().getInt("infoGodImage", R.drawable.agni);
        infoPantheon = getArguments().getString("infoPantheon", "Hindu");
        infoPantheonIcon = getArguments().getInt("infoPantheonIcon", R.drawable.icon_hindu);
        infoClass = getArguments().getString("infoClass", "Mage");
        infoClassIcon = getArguments().getInt("infoClassIcon", R.drawable.icon_mage);
        infoType = getArguments().getChar("infoType", 'M');

        infoHealth = getArguments().getInt("infoHealth", 1780);
        infoMana = getArguments().getInt("infoMana", 1155);
        infoDamage = getArguments().getInt("infoDamage", 65);
        infoProtPhys = getArguments().getInt("infoProtPhys", 63);
        infoProtMag = getArguments().getInt("infoProtMag", 30);
        infoSpeed = getArguments().getDouble("infoSpeed", 350);

        infoHp5 = getArguments().getDouble("infoHp5", 16.4);
        infoMp5 = getArguments().getDouble("infoMp5", 12.1);
        infoAttackSpeed = getArguments().getDouble("infoAttackSpeed", 1.19);

        infoBuildNumber = getArguments().getString("infoBuildNumber", "1");

        god = new God(infoGodName, infoGodTitle, infoGodNameString, infoGodImage,
                infoPantheon, infoPantheonIcon, infoClass, infoClassIcon, infoType,
                infoHealth, infoMana, infoDamage, infoProtPhys, infoProtMag, infoSpeed,
                infoHp5, infoMp5, infoAttackSpeed);
    }

    public void calculateStats() {
        Boolean rodOfTahutiPassive = false;

        Boolean sovereigntyPassive = false;
        Boolean heartwardAmuletPassive = false;
        Boolean gauntletOfThebesPassive = false;
        Boolean shogunsKusariPassive = false;
        Boolean bookOfThothPassive = false;
        Boolean transcendencePassive = false;

        ArrayList<String> itemNames = new ArrayList<String>();
        String item1Name = getName(god.getNameString() + "_item1_name_" + infoBuildNumber);
        String item2Name = getName(god.getNameString() + "_item2_name_" + infoBuildNumber);
        String item3Name = getName(god.getNameString() + "_item3_name_" + infoBuildNumber);
        String item4Name = getName(god.getNameString() + "_item4_name_" + infoBuildNumber);
        String item5Name = getName(god.getNameString() + "_item5_name_" + infoBuildNumber);
        String item6Name = getName(god.getNameString() + "_item6_name_" + infoBuildNumber);
        itemNames.add(item1Name);
        itemNames.add(item2Name);
        itemNames.add(item3Name);
        itemNames.add(item4Name);
        itemNames.add(item5Name);
        itemNames.add(item6Name);

        ArrayList<Item> buildItems = new ArrayList<Item>();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();
        Item item6 = new Item();

        for(int i = 0 ; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(item1Name))
                item1 = items.get(i);
            if(items.get(i).getName().equals(item2Name))
                item2 = items.get(i);
            if(items.get(i).getName().equals(item3Name))
                item3 = items.get(i);
            if(items.get(i).getName().equals(item4Name))
                item4 = items.get(i);
            if(items.get(i).getName().equals(item5Name))
                item5 = items.get(i);
            if(items.get(i).getName().equals(item6Name))
                item6 = items.get(i);
        }

        buildItems.add(item1);
        buildItems.add(item2);
        buildItems.add(item3);
        buildItems.add(item4);
        buildItems.add(item5);
        buildItems.add(item6);

        buildCost = item1.getCost() + item2.getCost() + item3.getCost() + item4.getCost() + item5.getCost() + item6.getCost();
        if(god.getSpeed() == 450)
            buildCost += 1600;
        buildHealth = god.getHealth() + item1.getHealth() + item2.getHealth() + item3.getHealth() +
                item4.getHealth() + item5.getHealth() + item6.getHealth();
        buildMana = god.getMana() + item1.getMana() + item2.getMana() + item3.getMana() +
                item4.getMana() + item5.getMana() + item6.getMana();
        buildHp5 = god.getHp5() + item1.getHp5() + item2.getHp5() + item3.getHp5() +
                item4.getHp5() + item5.getHp5() + item6.getHp5();
        buildMp5 = god.getMp5() + item1.getMp5() + item2.getMp5() + item3.getMp5() +
                item4.getMp5() + item5.getMp5() + item6.getMp5();
        buildPower = item1.getDamage() + item2.getDamage() + item3.getDamage() +
                item4.getDamage() + item5.getDamage() + item6.getDamage();
        if(god.getType() == 'M')
            buildDamage = (int)Math.round(god.getDamage() + (buildPower*0.2));
        else
            buildDamage = god.getDamage() + buildPower;

        buildLifesteal = Math.round(item1.getLifesteal() + item2.getLifesteal() + item3.getLifesteal() +
                item4.getLifesteal() + item5.getLifesteal() + item6.getLifesteal());
        buildPenetration = item1.getPenetration() + item2.getPenetration() + item3.getPenetration() +
                item4.getPenetration() + item5.getPenetration() + item6.getPenetration();
        buildProtPhys = god.getProtPhys() + item1.getProtPhys() + item2.getProtPhys() + item3.getProtPhys() +
                item4.getProtPhys() + item5.getProtPhys() + item6.getProtPhys();
        buildProtMag = god.getProtMag() + item1.getProtMag() + item2.getProtMag() + item3.getProtMag() +
                item4.getProtMag() + item5.getProtMag() + item6.getProtMag();

        double speedSum = god.getSpeed() + god.getSpeed()*((item1.getSpeed() + item2.getSpeed() + item3.getSpeed() + item4.getSpeed() + item5.getSpeed() + item6.getSpeed())/100);
        double speedDiminished = 0;
        buildSpeed = god.getSpeed();
        if(speedSum > 540.5) {
            speedDiminished = (speedSum - 540.5) * 0.5;
            buildSpeed = speedDiminished + 66.8 + 457;
        } else if(speedSum > 457) {
            speedDiminished = (speedSum - 457) * 0.8;
            buildSpeed = speedDiminished + 457;
        } else {
            buildSpeed = speedSum;
        }

        buildAttackSpeed = god.getAttackSpeed() + item1.getAttackSpeed() + item2.getAttackSpeed() + item3.getAttackSpeed() +
                item4.getAttackSpeed() + item5.getAttackSpeed() + item6.getAttackSpeed();
        buildAttackSpeed = Math.round(buildAttackSpeed*100.0)/100.0;
        buildCritChance = item1.getCritChance() + item2.getCritChance() + item3.getCritChance() +
                item4.getCritChance() + item5.getCritChance() + item6.getCritChance();
        buildCdr = item1.getCdr() + item2.getCdr() + item3.getCdr() +
                item4.getCdr() + item5.getCdr() + item6.getCdr();
        buildCcr = item1.getCcr() + item2.getCcr() + item3.getCcr() +
                item4.getCcr() + item5.getCcr() + item6.getCcr();

        ArrayList<Integer> itemStacks = new ArrayList<Integer>();
        itemStacks.add(item1Stacks);
        itemStacks.add(item2Stacks);
        itemStacks.add(item3Stacks);
        itemStacks.add(item4Stacks);
        itemStacks.add(item5Stacks);
        itemStacks.add(item6Stacks);
        for(int i = 0; i < buildItems.size(); i++)
        {
            Item item = buildItems.get(i);
            if(item.getMaxStacks() != 0)
            {
                if(infoType == 'M')
                {
                    if(item.getName().equals("Doom Orb"))
                    {
                        buildPower += 2*itemStacks.get(i);
                    }
                    if(item.getName().equals("Bancroft's Talon"))
                    {
                        buildPower += itemStacks.get(i);
                        buildLifesteal += Math.round((15.0/100.0)*itemStacks.get(i));
                    }
                    if(item.getName().equals("Book of Thoth"))
                    {
                        buildMana += 10*itemStacks.get(i);
                    }
                    if(item.getName().equals("Warlock's Sash"))
                    {
                        buildHealth += 3*itemStacks.get(i);
                        buildPower += 0.6*itemStacks.get(i);
                    }
                } else {
                    if(item.getName().equals("Devourer's Gauntlet"))
                    {
                        buildPower += 0.4*itemStacks.get(i);
                        buildLifesteal += 0.2*itemStacks.get(i);
                    }
                    if(item.getName().equals("Rage"))
                    {
                        buildCritChance += itemStacks.get(i);
                    }
                    if(item.getName().equals("Masamune"))
                    {
                        buildProtPhys += 7*itemStacks.get(i);
                        buildProtMag += 7*itemStacks.get(i);
                    }
                    if(item.getName().equals("Stone Cutting Sword"))
                    {
                        buildProtPhys += 10*itemStacks.get(i);
                    }
                    if(item.getName().equals("Transcendence"))
                    {
                        buildMana += 15*itemStacks.get(i);
                    }
                }

                if(item.getName().equals("Hide of the Urchin") || item.getName().equals("Reinforced Greaves") || item.getName().equals("Reinforced Shoes"))
                {
                    buildProtPhys += 3*itemStacks.get(i);
                    buildProtMag += 3*itemStacks.get(i);
                }

                if(item.getName().equals("Telkhines Ring") || item.getName().equals("Ichaival") || item.getName().equals("Silverbranch Bow"))
                {
                    buildPower += 10*itemStacks.get(i);
                }

            }
        }


//--------Passives that directly affect stats------------------------------------------------------------
        //Common passives
        for(int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).equals("Sovereignty"))
                sovereigntyPassive = true;
            if (itemNames.get(i).equals("Heartward Amulet"))
                heartwardAmuletPassive = true;
            if (itemNames.get(i).equals("Gauntlet of Thebes"))
                gauntletOfThebesPassive = true;
            if (itemNames.get(i).equals("Shogun's Kusari"))
                shogunsKusariPassive = true;
        }
        //Magical Passives
        if(infoType == 'M') {
            for(int i = 0; i < itemNames.size(); i++) {
                if (itemNames.get(i).equals("Rod of Tahuti"))
                    rodOfTahutiPassive = true;
                if (itemNames.get(i).equals("Book of Thoth"))
                    bookOfThothPassive = true;
            }
        } else {
            for(int i = 0; i < itemNames.size(); i++)
                if(itemNames.get(i).equals("Transcendence"))
                    transcendencePassive = true;
        }
        //Changing stats due to passives
        if(bookOfThothPassive || transcendencePassive)
            buildPower += (buildMana*0.03);
        if(rodOfTahutiPassive)
            buildPower += (buildPower*0.25);
        if(sovereigntyPassive) {
            buildProtPhys += 30;
            buildHp5 += 25.0;
        }
        if(heartwardAmuletPassive) {
            buildProtMag += 20;
            buildMp5 += 20.0;
        }
        if(gauntletOfThebesPassive) {
            buildProtPhys += 20;
            buildProtMag += 20;
        }
        if(shogunsKusariPassive)
            buildAttackSpeed += 0.15;
    }

    public ArrayList<Item> getPassives() {
        String item1Name = getName(god.getNameString() + "_item1_name_" + infoBuildNumber);
        String item2Name = getName(god.getNameString() + "_item2_name_" + infoBuildNumber);
        String item3Name = getName(god.getNameString() + "_item3_name_" + infoBuildNumber);
        String item4Name = getName(god.getNameString() + "_item4_name_" + infoBuildNumber);
        String item5Name = getName(god.getNameString() + "_item5_name_" + infoBuildNumber);
        String item6Name = getName(god.getNameString() + "_item6_name_" + infoBuildNumber);

        //Creating item objects from item names
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();
        Item item6 = new Item();
        for(int i = 0 ; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(item1Name))
                item1 = items.get(i);
            if(items.get(i).getName().equals(item2Name))
                item2 = items.get(i);
            if(items.get(i).getName().equals(item3Name))
                item3 = items.get(i);
            if(items.get(i).getName().equals(item4Name))
                item4 = items.get(i);
            if(items.get(i).getName().equals(item5Name))
                item5 = items.get(i);
            if(items.get(i).getName().equals(item6Name))
                item6 = items.get(i);
        }


        ArrayList<Item> passives = new ArrayList<Item>();
        if(item1.getPassive() != null)
            passives.add(item1);
        if(item2.getPassive() != null)
            passives.add(item2);
        if(item3.getPassive() != null)
            passives.add(item3);
        if(item4.getPassive() != null)
            passives.add(item4);
        if(item5.getPassive() != null)
            passives.add(item5);
        if(item6.getPassive() != null)
            passives.add(item6);

        return passives;
    }

    public Bundle passBuildStatArgs() {
        Bundle args = new Bundle();

        args.putChar("infoType", infoType);

        args.putInt("buildCost", buildCost);
        args.putInt("buildHealth", buildHealth);
        args.putInt("buildMana", buildMana);
        args.putInt("buildDamage", buildDamage);
        args.putInt("buildPower", buildPower);
        args.putInt("buildLifesteal", buildLifesteal);
        args.putInt("buildPenetration", buildPenetration);
        args.putInt("buildProtPhys", buildProtPhys);
        args.putInt("buildProtMag", buildProtMag);
        args.putInt("buildCritChance", buildCritChance);
        args.putInt("buildCdr", buildCdr);
        args.putInt("buildCcr", buildCcr);

        args.putDouble("buildHp5", buildHp5);
        args.putDouble("buildMp5", buildMp5);
        args.putDouble("buildAttackSpeed", buildAttackSpeed);
        args.putDouble("buildSpeed", buildSpeed);

        return args;
    }

    public Item getItemByName(String name) {
        Item x = new Item();
        for(int i = 0; i < items.size(); i++)
            if(items.get(i).getName().equals(name))
                x = items.get(i);
        return x;
    }

    public ArrayList<Stat> getItemStatValues(Item item) {
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

        return stats;
    }
}
