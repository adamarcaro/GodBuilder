package com.example.adamtrudeauarcaro.godbuilder;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Adam Trudeau Arcaro on 2016-10-08.
 */

public class FragmentAhMuzenCab extends Fragment {

    View myView;

    public FragmentAhMuzenCab() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.god_ah_muzen_cab, container, false);

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

        //Loading build
        starter.setImageResource(getImage("ah_muzen_cab_starter"));
        relic1.setImageResource(getImage("ah_muzen_cab_relic1"));
        relic2.setImageResource(getImage("ah_muzen_cab_relic2"));
        item1.setImageResource(getImage("ah_muzen_cab_item1"));
        item2.setImageResource(getImage("ah_muzen_cab_item2"));
        item3.setImageResource(getImage("ah_muzen_cab_item3"));
        item4.setImageResource(getImage("ah_muzen_cab_item4"));
        item5.setImageResource(getImage("ah_muzen_cab_item5"));
        item6.setImageResource(getImage("ah_muzen_cab_item6"));

        starter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ItemPhysStarterFragment dialog = ItemPhysStarterFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysStarterFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_starter", resourceId);
                        starter.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "starterDialog");
            }
        });

        relic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_relic1", resourceId);
                        relic1.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "relic1Dialog");
            }
        });

        relic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_relic2", resourceId);
                        relic2.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "relic2Dialog");
            }
        });

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_item1", resourceId);
                        item1.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "item1Dialog");
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_item2", resourceId);
                        item2.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "item2Dialog");
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_item3", resourceId);
                        item3.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "item3Dialog");
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_item4", resourceId);
                        item4.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "item4Dialog");
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_item5", resourceId);
                        item5.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "item5Dialog");
            }
        });

        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        saveImage("ah_muzen_cab_item6", resourceId);
                        item6.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "item6Dialog");
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

}
