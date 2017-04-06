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
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("agni", R.drawable.agni, R.drawable.icon_hindu, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ah Muzen Cab": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ah_muzen_cab", R.drawable.ah_muzen_cab, R.drawable.icon_mayan, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ah Puch": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ah_puch", R.drawable.ah_puch, R.drawable.icon_mayan, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Amaterasu": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("amaterasu", R.drawable.amaterasu, R.drawable.icon_japanese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Anhur": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("anhur", R.drawable.anhur, R.drawable.icon_egyptian, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Anubis": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("anubis", R.drawable.anubis, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ao Kuang": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ao_kuang", R.drawable.ao_kuang, R.drawable.icon_chinese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Aphrodite": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("aphrodite", R.drawable.aphrodite, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Apollo": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("apollo", R.drawable.apollo, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Arachne": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("arachne", R.drawable.arachne, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ares": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ares", R.drawable.ares, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Artemis": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("artemis", R.drawable.artemis, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Athena": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("athena", R.drawable.athena, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Awilix": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("awilix", R.drawable.awilix, R.drawable.icon_mayan, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bacchus": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bacchus", R.drawable.bacchus, R.drawable.icon_roman, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bakasura": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bakasura", R.drawable.bakasura, R.drawable.icon_hindu, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bastet": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bastet", R.drawable.bastet, R.drawable.icon_egyptian, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Bellona": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bellona", R.drawable.bellona, R.drawable.icon_roman, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Cabrakan": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("cabrakan", R.drawable.cabrakan, R.drawable.icon_mayan, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Camazotz": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("camazotz", R.drawable.camazotz, R.drawable.icon_mayan, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Cernunnos": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("cernunnos", R.drawable.cernunnos, R.drawable.icon_celtic, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chaac": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("chaac", R.drawable.chaac, R.drawable.icon_mayan, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chang'e": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("change", R.drawable.change, R.drawable.icon_chinese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chiron": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("chiron", R.drawable.chiron, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Chronos": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("chronos", R.drawable.chronos, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Cupid": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("cupid", R.drawable.cupid, R.drawable.icon_roman, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Erlang Shen": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("erlang_shen", R.drawable.erlang_shen, R.drawable.icon_chinese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Fafnir": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("fafnir", R.drawable.fafnir, R.drawable.icon_norse, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Fenrir": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("fenrir", R.drawable.fenrir, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Freya": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("freya", R.drawable.freya, R.drawable.icon_norse, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Geb": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("geb", R.drawable.geb, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Guan Yu": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("guan_yu", R.drawable.guan_yu, R.drawable.icon_chinese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hades": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hades", R.drawable.hades, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "He Bo": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("he_bo", R.drawable.he_bo, R.drawable.icon_chinese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hel": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hel", R.drawable.hel, R.drawable.icon_norse, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hercules": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hercules", R.drawable.hercules, R.drawable.icon_roman, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hou Yi": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hou_yi", R.drawable.hou_yi, R.drawable.icon_chinese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Hun Batz": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hun_batz", R.drawable.hun_batz, R.drawable.icon_mayan, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Isis": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("isis", R.drawable.isis, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Izanami": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("izanami", R.drawable.izanami, R.drawable.icon_japanese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Janus": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("janus", R.drawable.janus, R.drawable.icon_roman, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Jing Wei": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("jing_wei", R.drawable.jing_wei, R.drawable.icon_chinese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kali": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kali", R.drawable.kali, R.drawable.icon_hindu, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Khepri": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("khepri", R.drawable.khepri, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kukulkan": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kukulkan", R.drawable.kukulkan, R.drawable.icon_mayan, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kumbhakarna": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kumbhakarna", R.drawable.kumbhakarna, R.drawable.icon_hindu, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Kuzenbo": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kuzenbo", R.drawable.kuzenbo, R.drawable.icon_japanese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Loki": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("loki", R.drawable.loki, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Medusa": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("medusa", R.drawable.medusa, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Mercury": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("mercury", R.drawable.mercury, R.drawable.icon_roman, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ne Zha": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ne_zha", R.drawable.ne_zha, R.drawable.icon_chinese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Neith": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("neith", R.drawable.neith, R.drawable.icon_egyptian, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nemesis": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nemesis", R.drawable.nemesis, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nike": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nike", R.drawable.nike, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nox": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nox", R.drawable.nox, R.drawable.icon_roman, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Nu Wa": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nu_wa", R.drawable.nu_wa, R.drawable.icon_chinese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Odin": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("odin", R.drawable.odin, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Osiris": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("osiris", R.drawable.osiris, R.drawable.icon_egyptian, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Poseidon": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("poseidon", R.drawable.poseidon, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ra": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ra", R.drawable.ra, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Raijin": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("raijin", R.drawable.raijin, R.drawable.icon_japanese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Rama": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("rama", R.drawable.rama, R.drawable.icon_hindu, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ratatoskr": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ratatoskr", R.drawable.ratatoskr, R.drawable.icon_norse, 'R'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ravana": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ravana", R.drawable.ravana, R.drawable.icon_hindu, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Scylla": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("scylla", R.drawable.scylla, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Serqet": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("serqet", R.drawable.serqet, R.drawable.icon_egyptian, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Skadi": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("skadi", R.drawable.skadi, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sobek": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sobek", R.drawable.sobek, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sol": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sol", R.drawable.sol, R.drawable.icon_norse, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sun Wukong": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sun_wukong", R.drawable.sun_wukong, R.drawable.icon_chinese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Susano": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("susano", R.drawable.susano, R.drawable.icon_japanese, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Sylvanus": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sylvanus", R.drawable.sylvanus, R.drawable.icon_roman, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Terra": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("terra", R.drawable.terra, R.drawable.icon_roman, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Thanatos": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("thanatos", R.drawable.thanatos, R.drawable.icon_greek, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "The Morrigan": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("the_morrigan", R.drawable.the_morrigan, R.drawable.icon_celtic, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Thor": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("thor", R.drawable.thor, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Thoth": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("thoth", R.drawable.thoth, R.drawable.icon_egyptian, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Tyr": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("tyr", R.drawable.tyr, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ullr": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ullr", R.drawable.ullr, R.drawable.icon_norse, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Vamana": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("vamana", R.drawable.vamana, R.drawable.icon_hindu, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Vulcan": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("vulcan", R.drawable.vulcan, R.drawable.icon_roman, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Xbalanque": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("xbalanque", R.drawable.xbalanque, R.drawable.icon_mayan, 'P'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Xing Tian": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("xing_tian", R.drawable.xing_tian, R.drawable.icon_chinese, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Ymir": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ymir", R.drawable.ymir, R.drawable.icon_norse, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Zeus": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("zeus", R.drawable.zeus, R.drawable.icon_greek, 'M'));
                        hideSoftKeyboard(getActivity());
                        replaceFragment(myFragment);
                        break;
                    }
                    case "Zhong Kui": {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("zhong_kui", R.drawable.zhong_kui, R.drawable.icon_chinese, 'M'));
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
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    public Bundle passArgs(String god_name, int godImage, int godPantheonIcon, char type) {
        Bundle args = new Bundle();
        args.putString("infoGodName", god_name);
        args.putInt("infoGodImage", godImage);
        args.putInt("infoPantheonIcon", godPantheonIcon);
        args.putChar("infoType", type);
        return args;
    }

}
