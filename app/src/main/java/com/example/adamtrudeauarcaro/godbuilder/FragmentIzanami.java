package com.example.adamtrudeauarcaro.godbuilder;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Adam Trudeau Arcaro on 2016-10-08.
 */

public class FragmentIzanami extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.god_izanami, container, false);
        return myView;
    }
}
