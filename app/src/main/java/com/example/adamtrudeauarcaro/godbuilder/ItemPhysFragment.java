package com.example.adamtrudeauarcaro.godbuilder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;


public class ItemPhysFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    String[] names={"Ninja Tabi", "Reinforced Greaves", "Talaria Boots", "Warrior Tabi",
            "Ancile", "Asi",
            "Blackthorn Hammer", "Bloodforge", "Brawler's Beat Stick", "Breastplate of Valor", "Bulwark of Hope",
            "Deathbringer", "Devourer's Gauntlet",
            "Emperor's Armor",
            "Frostbound Hammer",
            "Gauntlet of Thebes", "Genji's Guard", "Gladiator's Shield",
            "Hastened Fatalis", "Heartseeker", "Heartward Amulet", "Hide of the Nemean Lion", "Hide of the Urchin", "Hydra's Lament",
            "Ichaival",
            "Jotunn's Wrath",
            "Magi's Blessing", "Mail of Renewal", "Malice", "Mantle of Discord", "Masamune", "Midgardian Mail", "Mystical Mail",
            "Odysseus' Bow", "Oni Hunter's Garb",
            "Pestilence",
            "Qin's Sais",
            "Rage", "Relic Dagger", "Runeforged Hammer", "Runic Shield",
            "Shield of Regrowth", "Shifter's Shield", "Shogun's Kusari", "Silverbranch Bow", "Soul Eater", "Sovereignty", "Spectral Armor", "Spirit Robe", "Stone Cutting Sword", "Stone of Gaia",
            "The Crusher", "The Executioner", "Titan's Bane", "Transcendence",
            "Void Shield",
            "Wind Demon", "Winged Blade", "Witchblade"};
    int[] images={R.drawable.ninja_tabi, R.drawable.reinforced_greaves, R.drawable.talaria_boots, R.drawable.warrior_tabi,
            R.drawable.ancile, R.drawable.asi,
            R.drawable.blackthorn_hammer, R.drawable.bloodforge, R.drawable.brawlers_beat_stick, R.drawable.breastplate_of_valor, R.drawable.bulwark_of_hope,
            R.drawable.deathbringer, R.drawable.devourers_gauntlet,
            R.drawable.emperors_armor,
            R.drawable.frostbound_hammer,
            R.drawable.gauntlet_of_thebes, R.drawable.genjis_guard, R.drawable.gladiators_shield,
            R.drawable.hastened_fatalis, R.drawable.heartseeker, R.drawable.heartward_amulet, R.drawable.hide_of_the_nemean_lion, R.drawable.hide_of_the_urchin, R.drawable.hydras_lament,
            R.drawable.ichaival,
            R.drawable.jotunns_wrath,
            R.drawable.magis_blessing, R.drawable.mail_of_renewal, R.drawable.malice, R.drawable.mantle_of_discord, R.drawable.masamune, R.drawable.midgardian_mail, R.drawable.mystical_mail,
            R.drawable.odysseus_bow, R.drawable.oni_hunters_garb,
            R.drawable.pestilence,
            R.drawable.qins_sais,
            R.drawable.rage, R.drawable.relic_dagger, R.drawable.runeforged_hammer, R.drawable.runic_shield,
            R.drawable.shield_of_regrowth, R.drawable.shifters_shield, R.drawable.shoguns_kusari, R.drawable.silverbranch_bow, R.drawable.soul_eater, R.drawable.sovereignty, R.drawable.spectral_armor, R.drawable.spirit_robe, R.drawable.stone_cutting_sword, R.drawable.stone_of_gaia,
            R.drawable.the_crusher, R.drawable.the_executioner, R.drawable.titans_bane, R.drawable.transcendence,
            R.drawable.void_shield,
            R.drawable.wind_demon, R.drawable.winged_blade, R.drawable.witchblade};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Indicate layout for dialog
        View myView=inflater.inflate(R.layout.item_list, null);

        //Set dialog title
        getDialog().setTitle("Physical Items");

        //Defining searchview, listview, button
        SearchView sv=(SearchView) myView.findViewById(R.id.searchView1);
        ListView lv=(ListView) myView.findViewById(R.id.listView1);
        Button btn=(Button) myView.findViewById(R.id.dismiss);

        //Initialize and set adapter for items
        final Adapter adapter = new Adapter(getActivity(), this.getItems());
        lv.setAdapter(adapter);

        //Searchview functionality
        //**BUG** Upon searching for an item and selecting it, aegis is returned because index becomes 1
        sv.setQueryHint("Search items..");
        sv.setOnQueryTextListener(new OnQueryTextListener() {
            public boolean onQueryTextSubmit(String txt) {
                return false;
            }
            public boolean onQueryTextChange(String txt) {
                adapter.getFilter().filter(txt);
                return false;
            }
        });

        //Listener for itemclick on list
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                int image_id = images[position];
                mListener.onListItemClick(image_id);
                dismiss();
            }
        });

        //Cancel button
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                dismiss();
            }
        });

        return myView;
    }

    //Fragment contstructor
    public static ItemPhysFragment newInstance()
    {
        ItemPhysFragment f = new ItemPhysFragment();
        return f;
    }

    //Populates list with items
    private ArrayList<Item> getItems()
    {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item;

        for(int i = 0; i < names.length; i++) {
            item = new Item(names[i], images[i]);
            items.add(item);
        }

        return items;
    }

    //Setting listener to connect list to God fragment
    public interface OnListItemClickedListener {
        void onListItemClick(int resourceId);
    }

    OnListItemClickedListener mListener;

    public void setOnListItemSelectedListener(OnListItemClickedListener listener) {
        this.mListener = listener;
    }

}