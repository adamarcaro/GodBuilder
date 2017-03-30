package com.adamtrudeauarcaro.godbuilder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;


public class ItemMagFragment extends DialogFragment {

    Button btn;
    ListView lv;
    SearchView sv;
    String[] names={"Reinforced Shoes", "Shoes of Focus", "Shoes of the Magi", "Traveler's Shoes",
            "Bancroft's Talon", "Book of the Dead", "Book of Thoth", "Breastplate of Valor", "Bulwark of Hope",
            "Celestial Legion Helm", "Chronos' Pendant",
            "Demonic Grip", "Divine Ruin", "Doom Orb", "Dynasty Plate Helm",
            "Ethereal Staff",
            "Gauntlet of Thebes", "Gem of Isolation", "Genji's Guard",
            "Hastened Fatalis", "Heartward Amulet", "Hide of the Nemean Lion", "Hide of the Urchin",
            "Jade Emperor's Crown",
            "Lotus Crown",
            "Magi's Blessing", "Mail of Renewal", "Mantle of Discord", "Midgardian Mail", "Mystical Mail",
            "Obsidian Shard", "Oni Hunter's Garb",
            "Pestilence", "Polynomicon", "Pythagorem's Piece",
            "Rod of Asclepius", "Rod of Tahuti",
            "Shaman's Ring", "Shield of Regrowth", "Shogun's Kusari", "Soul Reaver", "Sovereignty", "Spear of Desolation", "Spear of the Magus", "Spectral Armor", "Spirit Robe", "Stone of Binding", "Stone of Fal", "Stone of Gaia",
            "Telkhine's Ring",
            "Void Stone",
            "Warlock's Sash", "Winged Blade", "Witchblade"
    };
    int[] images={R.drawable.reinforced_shoes, R.drawable.shoes_of_focus, R.drawable.shoes_of_the_magi, R.drawable.travelers_shoes,
            R.drawable.bancrofts_talon, R.drawable.book_of_the_dead, R.drawable.book_of_thoth, R.drawable.breastplate_of_valor, R.drawable.bulwark_of_hope,
            R.drawable.celestial_legion_helm, R.drawable.chronos_pendant,
            R.drawable.demonic_grip, R.drawable.divine_ruin, R.drawable.doom_orb, R.drawable.dynasty_plate_helm,
            R.drawable.ethereal_staff,
            R.drawable.gauntlet_of_thebes, R.drawable.gem_of_isolation, R.drawable.genjis_guard,
            R.drawable.hastened_fatalis, R.drawable.heartward_amulet, R.drawable.hide_of_the_nemean_lion, R.drawable.hide_of_the_urchin,
            R.drawable.jade_emperors_crown,
            R.drawable.lotus_crown,
            R.drawable.magis_blessing, R.drawable.mail_of_renewal, R.drawable.mantle_of_discord, R.drawable.midgardian_mail, R.drawable.mystical_mail,
            R.drawable.obsidian_shard, R.drawable.oni_hunters_garb,
            R.drawable.pestilence, R.drawable.polynomicon, R.drawable.pythagorems_piece,
            R.drawable.rod_of_asclepius, R.drawable.rod_of_tahuti,
            R.drawable.shamans_ring, R.drawable.shield_of_regrowth, R.drawable.shoguns_kusari, R.drawable.soul_reaver, R.drawable.sovereignty, R.drawable.spear_of_desolation, R.drawable.spear_of_the_magus, R.drawable.spectral_armor, R.drawable.spirit_robe, R.drawable.stone_of_binding, R.drawable.stone_of_fal, R.drawable.stone_of_gaia,
            R.drawable.telkhines_ring,
            R.drawable.void_stone,
            R.drawable.warlocks_sash, R.drawable.winged_blade, R.drawable.witchblade};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Indicate layout for dialog
        View myView=inflater.inflate(R.layout.item_list, null);

        //Set dialog title
        getDialog().setTitle("Magical Items");

        //Defining searchview, listview, button
        SearchView sv=(SearchView) myView.findViewById(R.id.searchView1);
        ListView lv=(ListView) myView.findViewById(R.id.listView1);
        Button btn=(Button) myView.findViewById(R.id.dismiss);

        //Initialize and set adapter for items
        final Adapter adapter = new Adapter(getActivity(), this.getItems());
        lv.setAdapter(adapter);

        //Searchview functionality
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
                String name = adapter.getItem(position).getName();
                int image_id = adapter.getItem(position).getImage();
                String image_name = getActivity().getResources().getResourceEntryName(image_id);
                mListener.onListItemClick(name, image_name, image_id);
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
    public static ItemMagFragment newInstance()
    {
        ItemMagFragment f = new ItemMagFragment();
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
        void onListItemClick(String name, String imageName, int resourceId);
    }

    OnListItemClickedListener mListener;

    public void setOnListItemSelectedListener(OnListItemClickedListener listener) {
        this.mListener = listener;
    }

}