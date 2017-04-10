package com.adamtrudeauarcaro.godbuilder;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

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
    Stat cost, health, mana, hp5, mp5, damage, power, lifesteal, penetration, protPhys, protMag, attackSpeed, speed, critChance, cdr, ccr;

    int buildCost, buildHealth, buildMana, buildDamage, buildPower, buildLifesteal, buildPenetration, buildProtPhys, buildProtMag, buildCritChance, buildCdr, buildCcr;
    double buildHp5, buildMp5, buildAttackSpeed, buildSpeed;

    ArrayList<Item> items = itemsAll;
    ArrayList<Item> passives = new ArrayList<Item>();

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
                View mView = getActivity().getLayoutInflater().inflate(R.layout.stats_list, null);
                TextView costText = (TextView) mView.findViewById(R.id.cost_text);
                ListView listView = (ListView) mView.findViewById(R.id.listView);
                ListView listViewPassives = (ListView) mView.findViewById(R.id.listViewPassives);
                Button close = (Button) mView.findViewById(R.id.close);

                ArrayList<Stat> stats = new ArrayList<Stat>();

                calculateStats();

                health = new Stat("Health: ", String.valueOf(buildHealth));
                mana = new Stat("Mana: ", String.valueOf(buildMana));
                hp5 = new Stat("HP5: ", String.valueOf(buildHp5));
                mp5 = new Stat("MP5: ", String.valueOf(buildMp5));
                damage = new Stat("Basic Attack Damage: ", String.valueOf(buildDamage));
                power = new Stat("Power: ", String.valueOf(buildPower));
                lifesteal = new Stat("Lifesteal: ", String.valueOf(buildLifesteal)+"%");
                penetration = new Stat("Penetration: ", String.valueOf(buildPenetration));
                protPhys = new Stat("Physical Protection: ", String.valueOf(buildProtPhys));
                protMag = new Stat("Magical Protection: ", String.valueOf(buildProtMag));
                attackSpeed = new Stat("Attack Speed: ", String.valueOf(buildAttackSpeed));
                speed = new Stat("Movement Speed: ", String.valueOf(Math.round(buildSpeed)));
                critChance = new Stat("Crit Chance: ", String.valueOf(buildCritChance)+"%");
                cdr = new Stat("Cooldown Reduction: ", String.valueOf(buildCdr)+"%");
                ccr = new Stat("CC Reduction: ", String.valueOf(buildCcr)+"%");

                costText.setText("Build Cost: " + String.valueOf(buildCost) + " gold");

                stats.add(health);
                stats.add(mana);
                stats.add(hp5);
                stats.add(mp5);
                stats.add(damage);
                stats.add(power);
                stats.add(lifesteal);
                stats.add(penetration);
                stats.add(protPhys);
                stats.add(protMag);
                stats.add(attackSpeed);
                stats.add(speed);
                stats.add(critChance);
                stats.add(cdr);
                stats.add(ccr);

                StatAdapter statAdapter = new StatAdapter(getActivity(), stats);
                listView.setAdapter(statAdapter);

                passives = getPassives();

                //MIGHT NOT NEED THIS, REQUIRES TESTING
                for(int i = 0; i < passives.size(); i++)
                    if(passives.get(i) == null)
                        passives.remove(i);

                //If no passives, display message
                if(passives.isEmpty() && god.getType() != 'R')
                {
                    passives.add(new Item("No Passives", "You have note selected any relics or items with passive effects."));
                }
                if(god.getType() == 'R')
                {
                    passives.add(new Item("Acorn of Yggdrasil", "Any time Ratatoskr uses an ability that successfully hits any target, he is healed."));
                }

                PassiveAdapter passiveAdapter = new PassiveAdapter(getActivity(), passives);
                listViewPassives.setAdapter(passiveAdapter);


                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                mBuilder.setTitle("Build Stats");
                mBuilder.setView(mView);

                close.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog = mBuilder.create();
                alertDialog.show();
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

        relic1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
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
            }
        });

        relic2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
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
            }
        });

        starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
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
            }
        });

        if (god.getType() == 'R')
        {
            item1.setImageResource(R.drawable.acorn);
            item1Name.setText("Acorn of Yggdrasil");
        } else {
            item1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'I');
                    dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                        public void onListItemClick(String name, String imageName, int resourceId) {
                            saveName(god.getNameString() + "_item1_name_" + infoBuildNumber, name);
                            saveImage(god.getNameString() + "_item1_" + infoBuildNumber, imageName);
                            item1.setImageResource(getImage(god.getNameString() + "_item1_" + infoBuildNumber));
                            item1Name.setText(name);
                        }
                    });
                    dialog.show(getActivity().getFragmentManager(), "item1Dialog");
                }
            });
        }

        item2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'I');
                dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(god.getNameString() + "_item2_name_" + infoBuildNumber, name);
                        saveImage(god.getNameString() + "_item2_" + infoBuildNumber, imageName);
                        item2.setImageResource(getImage(god.getNameString() + "_item2_" + infoBuildNumber));
                        item2Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item2Dialog");
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'I');
                dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(god.getNameString() + "_item3_name_" + infoBuildNumber, name);
                        saveImage(god.getNameString() + "_item3_" + infoBuildNumber, imageName);
                        item3.setImageResource(getImage(god.getNameString() + "_item3_" + infoBuildNumber));
                        item3Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item3Dialog");
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'I');
                dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(god.getNameString() + "_item4_name_" + infoBuildNumber, name);
                        saveImage(god.getNameString() + "_item4_" + infoBuildNumber, imageName);
                        item4.setImageResource(getImage(god.getNameString() + "_item4_" + infoBuildNumber));
                        item4Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item4Dialog");
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'I');
                dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(god.getNameString() + "_item5_name_" + infoBuildNumber, name);
                        saveImage(god.getNameString() + "_item5_" + infoBuildNumber, imageName);
                        item5.setImageResource(getImage(god.getNameString() + "_item5_" + infoBuildNumber));
                        item5Name.setText(name);
                    }
                });
                dialog.show(getActivity().getFragmentManager(), "item5Dialog");
            }
        });

        item6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemFragment dialog = ItemFragment.newInstance(god.getType(), 'I');
                dialog.setOnListItemSelectedListener(new ItemFragment.OnListItemClickedListener() {
                    public void onListItemClick(String name, String imageName, int resourceId) {
                        saveName(god.getNameString() + "_item6_name_" + infoBuildNumber, name);
                        saveImage(god.getNameString() + "_item6_" + infoBuildNumber, imageName);
                        item6.setImageResource(getImage(god.getNameString() + "_item6_" + infoBuildNumber));
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
        String name = pref.getString(item, "Build " + infoBuildNumber);
        return name;
    }

    private void getGodArgs()
    {
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
        String item1Name = getName(god.getNameString() + "_item1_name_" + infoBuildNumber);
        String item2Name = getName(god.getNameString() + "_item2_name_" + infoBuildNumber);
        String item3Name = getName(god.getNameString() + "_item3_name_" + infoBuildNumber);
        String item4Name = getName(god.getNameString() + "_item4_name_" + infoBuildNumber);
        String item5Name = getName(god.getNameString() + "_item5_name_" + infoBuildNumber);
        String item6Name = getName(god.getNameString() + "_item6_name_" + infoBuildNumber);

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

        buildLifesteal = item1.getLifesteal() + item2.getLifesteal() + item3.getLifesteal() +
                item4.getLifesteal() + item5.getLifesteal() + item6.getLifesteal();
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


    }

    public ArrayList<Item> getPassives() {
        String relic1Name = getName(god.getNameString() + "_relic1_name_" + infoBuildNumber);
        String relic2Name = getName(god.getNameString() + "_relic2_name_" + infoBuildNumber);
        String item1Name = getName(god.getNameString() + "_item1_name_" + infoBuildNumber);
        String item2Name = getName(god.getNameString() + "_item2_name_" + infoBuildNumber);
        String item3Name = getName(god.getNameString() + "_item3_name_" + infoBuildNumber);
        String item4Name = getName(god.getNameString() + "_item4_name_" + infoBuildNumber);
        String item5Name = getName(god.getNameString() + "_item5_name_" + infoBuildNumber);
        String item6Name = getName(god.getNameString() + "_item6_name_" + infoBuildNumber);

        Item relic1 = new Item();
        Item relic2 = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();
        Item item6 = new Item();
        for(int i = 0 ; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(relic1Name))
                relic1 = items.get(i);
            if(items.get(i).getName().equals(relic2Name))
                relic2 = items.get(i);
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
        if(relic1.getPassive() != null)
            passives.add(relic1);
        if(relic2.getPassive() != null)
            passives.add(relic2);
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

}
