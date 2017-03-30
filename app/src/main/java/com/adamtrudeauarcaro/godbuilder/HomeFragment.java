package com.adamtrudeauarcaro.godbuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import static com.adamtrudeauarcaro.godbuilder.GodDrawer.gods;
import static com.adamtrudeauarcaro.godbuilder.GodDrawer.hideSoftKeyboard;

/**
 * Created by adama on 2017-03-24.
 */

public class HomeFragment extends Fragment {

    public static ListView lv;
    public static SearchView sv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.home,null);

        lv = (ListView) myView.findViewById(R.id.home_list);
        sv = (SearchView) myView.findViewById(R.id.home_search);
        sv.setQueryHint("Search Gods...");

        final GodAdapter adapter = new GodAdapter(getActivity(), gods);
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String name = adapter.getItem(position).getName();

                switch (name) {
                    case "Agni": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "agni");
                        args.putInt("infoGodImage", R.drawable.agni);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ah Muzen Cab": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ah_muzen_cab");
                        args.putInt("infoGodImage", R.drawable.ah_muzen_cab);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ah Puch": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ah_puch");
                        args.putInt("infoGodImage", R.drawable.ah_puch);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Amaterasu": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "amaterasu");
                        args.putInt("infoGodImage", R.drawable.amaterasu);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Anhur": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "anhur");
                        args.putInt("infoGodImage", R.drawable.anhur);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Anubis": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "anubis");
                        args.putInt("infoGodImage", R.drawable.anubis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ao Kuang": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ao_kuang");
                        args.putInt("infoGodImage", R.drawable.ao_kuang);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Aphrodite": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "aphrodite");
                        args.putInt("infoGodImage", R.drawable.aphrodite);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Apollo": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "apollo");
                        args.putInt("infoGodImage", R.drawable.apollo);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Arachne": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "arachne");
                        args.putInt("infoGodImage", R.drawable.arachne);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ares": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ares");
                        args.putInt("infoGodImage", R.drawable.ares);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Artemis": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "artemis");
                        args.putInt("infoGodImage", R.drawable.artemis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Athena": {
                        Fragment myFragment = new TabFragmentMag();
                        Bundle args = new Bundle();
                        args.putString("infoGodName", "athena");
                        args.putInt("infoGodImage", R.drawable.athena);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Awilix": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "awilix");
                        args.putInt("infoGodImage", R.drawable.awilix);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bacchus": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bacchus");
                        args.putInt("infoGodImage", R.drawable.bacchus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bakasura": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bakasura");
                        args.putInt("infoGodImage", R.drawable.bakasura);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bastet": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bastet");
                        args.putInt("infoGodImage", R.drawable.bastet);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bellona": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bellona");
                        args.putInt("infoGodImage", R.drawable.bellona);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Cabrakan": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "cabrakan");
                        args.putInt("infoGodImage", R.drawable.cabrakan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Camazotz": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "camazotz");
                        args.putInt("infoGodImage", R.drawable.camazotz);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Cernunnos": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "cernunnos");
                        args.putInt("infoGodImage", R.drawable.cernunnos);
                        args.putInt("infoPantheonIcon", R.drawable.icon_celtic);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chaac": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "chaac");
                        args.putInt("infoGodImage", R.drawable.chaac);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chang'e": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "change");
                        args.putInt("infoGodImage", R.drawable.change);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chiron": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "chiron");
                        args.putInt("infoGodImage", R.drawable.chiron);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chronos": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "chronos");
                        args.putInt("infoGodImage", R.drawable.chronos);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Cupid": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "cupid");
                        args.putInt("infoGodImage", R.drawable.cupid);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Erlang Shen": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "erlang_shen");
                        args.putInt("infoGodImage", R.drawable.erlang_shen);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Fafnir": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "fafnir");
                        args.putInt("infoGodImage", R.drawable.fafnir);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Fenrir": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "fenrir");
                        args.putInt("infoGodImage", R.drawable.fenrir);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Freya": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "freya");
                        args.putInt("infoGodImage", R.drawable.freya);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Geb": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "geb");
                        args.putInt("infoGodImage", R.drawable.geb);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Guan Yu": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "guan_yu");
                        args.putInt("infoGodImage", R.drawable.guan_yu);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hades": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hades");
                        args.putInt("infoGodImage", R.drawable.hades);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "He Bo": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "he_bo");
                        args.putInt("infoGodImage", R.drawable.he_bo);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hel": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hel");
                        args.putInt("infoGodImage", R.drawable.hel);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hercules": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hercules");
                        args.putInt("infoGodImage", R.drawable.hercules);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hou Yi": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hou_yi");
                        args.putInt("infoGodImage", R.drawable.hou_yi);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hun Batz": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hun_batz");
                        args.putInt("infoGodImage", R.drawable.hun_batz);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Isis": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "isis");
                        args.putInt("infoGodImage", R.drawable.isis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Izanami": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "izanami");
                        args.putInt("infoGodImage", R.drawable.izanami);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Janus": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "janus");
                        args.putInt("infoGodImage", R.drawable.janus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Jing Wei": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "jing_wei");
                        args.putInt("infoGodImage", R.drawable.jing_wei);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kali": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kali");
                        args.putInt("infoGodImage", R.drawable.kali);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Khepri": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "khepri");
                        args.putInt("infoGodImage", R.drawable.khepri);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kukulkan": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kukulkan");
                        args.putInt("infoGodImage", R.drawable.kukulkan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kumbhakarna": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kumbhakarna");
                        args.putInt("infoGodImage", R.drawable.kumbhakarna);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kuzenbo": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kuzenbo");
                        args.putInt("infoGodImage", R.drawable.kuzenbo);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Loki": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "loki");
                        args.putInt("infoGodImage", R.drawable.loki);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Medusa": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "medusa");
                        args.putInt("infoGodImage", R.drawable.medusa);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Mercury": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "mercury");
                        args.putInt("infoGodImage", R.drawable.mercury);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ne Zha": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ne_zha");
                        args.putInt("infoGodImage", R.drawable.ne_zha);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Neith": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "neith");
                        args.putInt("infoGodImage", R.drawable.neith);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nemesis": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nemesis");
                        args.putInt("infoGodImage", R.drawable.nemesis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nike": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nike");
                        args.putInt("infoGodImage", R.drawable.nike);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nox": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nox");
                        args.putInt("infoGodImage", R.drawable.nox);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nu Wa": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nu_wa");
                        args.putInt("infoGodImage", R.drawable.nu_wa);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Odin": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "odin");
                        args.putInt("infoGodImage", R.drawable.odin);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Osiris": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "osiris");
                        args.putInt("infoGodImage", R.drawable.osiris);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Poseidon": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "poseidon");
                        args.putInt("infoGodImage", R.drawable.poseidon);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ra": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ra");
                        args.putInt("infoGodImage", R.drawable.ra);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Raijin": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "raijin");
                        args.putInt("infoGodImage", R.drawable.raijin);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Rama": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "rama");
                        args.putInt("infoGodImage", R.drawable.rama);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ratatoskr": {
                        Fragment myFragment = new TabFragmentRatatoskr();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ratatoskr");
                        args.putInt("infoGodImage", R.drawable.ratatoskr);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ravana": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ravana");
                        args.putInt("infoGodImage", R.drawable.ravana);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Scylla": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "scylla");
                        args.putInt("infoGodImage", R.drawable.scylla);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Serqet": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "serqet");
                        args.putInt("infoGodImage", R.drawable.serqet);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Skadi": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "skadi");
                        args.putInt("infoGodImage", R.drawable.skadi);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sobek": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sobek");
                        args.putInt("infoGodImage", R.drawable.sobek);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sol": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sol");
                        args.putInt("infoGodImage", R.drawable.sol);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sun Wukong": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sun_wukong");
                        args.putInt("infoGodImage", R.drawable.sun_wukong);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Susano": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "susano");
                        args.putInt("infoGodImage", R.drawable.susano);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sylvanus": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sylvanus");
                        args.putInt("infoGodImage", R.drawable.sylvanus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Terra": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "terra");
                        args.putInt("infoGodImage", R.drawable.terra);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Thanatos": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "thanatos");
                        args.putInt("infoGodImage", R.drawable.thanatos);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "The Morrigan": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "the_morrigan");
                        args.putInt("infoGodImage", R.drawable.the_morrigan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_celtic);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Thor": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "thor");
                        args.putInt("infoGodImage", R.drawable.thor);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Thoth": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "thoth");
                        args.putInt("infoGodImage", R.drawable.thoth);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Tyr": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "tyr");
                        args.putInt("infoGodImage", R.drawable.tyr);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ullr": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ullr");
                        args.putInt("infoGodImage", R.drawable.ullr);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Vamana": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "vamana");
                        args.putInt("infoGodImage", R.drawable.vamana);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Vulcan": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "vulcan");
                        args.putInt("infoGodImage", R.drawable.vulcan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Xbalanque": {
                        Fragment myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "xbalanque");
                        args.putInt("infoGodImage", R.drawable.xbalanque);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Xing Tian": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "xing_tian");
                        args.putInt("infoGodImage", R.drawable.xing_tian);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ymir": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ymir");
                        args.putInt("infoGodImage", R.drawable.ymir);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Zeus": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "zeus");
                        args.putInt("infoGodImage", R.drawable.zeus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Zhong Kui": {
                        Fragment myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "zhong_kui");
                        args.putInt("infoGodImage", R.drawable.zhong_kui);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }

                }
            }
        });

        return myView;
    }

    public void replaceFragment(Fragment myFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, myFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
