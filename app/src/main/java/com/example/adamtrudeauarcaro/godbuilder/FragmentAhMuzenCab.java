package com.example.adamtrudeauarcaro.godbuilder;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
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

        //ImageButtons
        //Starter Item + Relics
        final ImageButton starter = (ImageButton) myView.findViewById(R.id.imageStarterItem);
        final ImageButton relic1 = (ImageButton) myView.findViewById(R.id.imageRelic1);
        final ImageButton relic2 = (ImageButton) myView.findViewById(R.id.imageRelic2);

        //Full Build
        final ImageButton item1 = (ImageButton) myView.findViewById(R.id.imageItem1);
        final ImageButton item2 = (ImageButton) myView.findViewById(R.id.imageItem2);
        final ImageButton item3 = (ImageButton) myView.findViewById(R.id.imageItem3);

        final ImageButton item4 = (ImageButton) myView.findViewById(R.id.imageItem4);
        final ImageButton item5 = (ImageButton) myView.findViewById(R.id.imageItem5);
        final ImageButton item6 = (ImageButton) myView.findViewById(R.id.imageItem6);

        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemPhysStarterFragment dialog = ItemPhysStarterFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemPhysStarterFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
                        starter.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "relic1Dialog");
            }
        });

        relic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.setOnListItemSelectedListener(new ItemRelicFragment.OnListItemClickedListener() {
                    public void onListItemClick(int resourceId) {
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
                        relic2.setImageResource(resourceId);
                    }
                });
                dialog.show(getFragmentManager(), "relic2Dialog");
            }
        });

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Here
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.show(getFragmentManager(), "item1Dialog");
            }
        });

        return myView;
    }
}
