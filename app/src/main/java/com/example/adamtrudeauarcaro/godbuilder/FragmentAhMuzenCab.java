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
        ImageButton starter = (ImageButton) myView.findViewById(R.id.imageStarterItem);
        ImageButton relic1 = (ImageButton) myView.findViewById(R.id.imageRelic1);
        ImageButton relic2 = (ImageButton) myView.findViewById(R.id.imageRelic2);

        //Full Build
        ImageButton item1 = (ImageButton) myView.findViewById(R.id.imageItem1);
        ImageButton item2 = (ImageButton) myView.findViewById(R.id.imageItem2);
        ImageButton item3 = (ImageButton) myView.findViewById(R.id.imageItem3);

        ImageButton item4 = (ImageButton) myView.findViewById(R.id.imageItem4);
        ImageButton item5 = (ImageButton) myView.findViewById(R.id.imageItem5);
        ImageButton item6 = (ImageButton) myView.findViewById(R.id.imageItem6);

        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Here
                ItemPhysStarterFragment dialog = ItemPhysStarterFragment.newInstance();
                dialog.show(getFragmentManager(), "fragmentDialog");
            }
        });

        relic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Here
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.show(getFragmentManager(), "fragmentDialog");
            }
        });

        relic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Here
                ItemRelicFragment dialog = ItemRelicFragment.newInstance();
                dialog.show(getFragmentManager(), "fragmentDialog");
            }
        });

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Here
                ItemPhysFragment dialog = ItemPhysFragment.newInstance();
                dialog.show(getFragmentManager(), "fragmentDialog");
            }
        });

        return myView;
    }
}
