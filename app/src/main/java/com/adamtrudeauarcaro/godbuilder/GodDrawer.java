package com.adamtrudeauarcaro.godbuilder;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class GodDrawer extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Toolbar toolbar;
    public static ArrayList<God> gods = new ArrayList<God>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_drawer);
        createGods();
        //Setup DrawerLayout and NavigationView
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view) ;

        //Inflating first fragment
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new HomeFragment()).commit();

        //Setup click events on the Navigation View Items.
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                int id = menuItem.getItemId();

                switch(id) {
                    case R.id.nav_home: fragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit(); break;
                    case R.id.nav_agni: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "agni");
                        args.putInt("infoGodImage", R.drawable.agni);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ah_muzen_cab: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ah_muzen_cab");
                        args.putInt("infoGodImage", R.drawable.ah_muzen_cab);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ah_puch: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ah_puch");
                        args.putInt("infoGodImage", R.drawable.ah_puch);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_amaterasu: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "amaterasu");
                        args.putInt("infoGodImage", R.drawable.amaterasu);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_anhur: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "anhur");
                        args.putInt("infoGodImage", R.drawable.anhur);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_anubis: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "anubis");
                        args.putInt("infoGodImage", R.drawable.anubis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ao_kuang: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ao_kuang");
                        args.putInt("infoGodImage", R.drawable.ao_kuang);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_aphrodite: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "aphrodite");
                        args.putInt("infoGodImage", R.drawable.aphrodite);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_apollo: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "apollo");
                        args.putInt("infoGodImage", R.drawable.apollo);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_arachne: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "arachne");
                        args.putInt("infoGodImage", R.drawable.arachne);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ares: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ares");
                        args.putInt("infoGodImage", R.drawable.ares);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_artemis: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "artemis");
                        args.putInt("infoGodImage", R.drawable.artemis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_athena: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "athena");
                        args.putInt("infoGodImage", R.drawable.athena);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_awilix: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "awilix");
                        args.putInt("infoGodImage", R.drawable.awilix);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_bacchus: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bacchus");
                        args.putInt("infoGodImage", R.drawable.bacchus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_bakasura: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bakasura");
                        args.putInt("infoGodImage", R.drawable.bakasura);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_bastet: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bastet");
                        args.putInt("infoGodImage", R.drawable.bastet);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_bellona: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "bellona");
                        args.putInt("infoGodImage", R.drawable.bellona);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_cabrakan: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "cabrakan");
                        args.putInt("infoGodImage", R.drawable.cabrakan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_camazotz: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "camazotz");
                        args.putInt("infoGodImage", R.drawable.camazotz);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_cernunnos: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "cernunnos");
                        args.putInt("infoGodImage", R.drawable.cernunnos);
                        args.putInt("infoPantheonIcon", R.drawable.icon_celtic);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_chaac: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "chaac");
                        args.putInt("infoGodImage", R.drawable.chaac);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_change: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "change");
                        args.putInt("infoGodImage", R.drawable.change);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_chiron: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "chiron");
                        args.putInt("infoGodImage", R.drawable.chiron);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_chronos: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "chronos");
                        args.putInt("infoGodImage", R.drawable.chronos);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_cupid: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "cupid");
                        args.putInt("infoGodImage", R.drawable.cupid);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_erlang_shen: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "erlang_shen");
                        args.putInt("infoGodImage", R.drawable.erlang_shen);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_fafnir: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "fafnir");
                        args.putInt("infoGodImage", R.drawable.fafnir);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_fenrir: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "fenrir");
                        args.putInt("infoGodImage", R.drawable.fenrir);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_freya: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "freya");
                        args.putInt("infoGodImage", R.drawable.freya);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_geb: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "geb");
                        args.putInt("infoGodImage", R.drawable.geb);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_guan_yu: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "guan_yu");
                        args.putInt("infoGodImage", R.drawable.guan_yu);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_hades: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hades");
                        args.putInt("infoGodImage", R.drawable.hades);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_he_bo: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "he_bo");
                        args.putInt("infoGodImage", R.drawable.he_bo);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_hel: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hel");
                        args.putInt("infoGodImage", R.drawable.hel);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_hercules: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hercules");
                        args.putInt("infoGodImage", R.drawable.hercules);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_hou_yi: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hou_yi");
                        args.putInt("infoGodImage", R.drawable.hou_yi);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_hun_batz: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "hun_batz");
                        args.putInt("infoGodImage", R.drawable.hun_batz);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_isis: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "isis");
                        args.putInt("infoGodImage", R.drawable.isis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_izanami: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "izanami");
                        args.putInt("infoGodImage", R.drawable.izanami);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_janus: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "janus");
                        args.putInt("infoGodImage", R.drawable.janus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_jing_wei:  {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "jing_wei");
                        args.putInt("infoGodImage", R.drawable.jing_wei);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_kali: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kali");
                        args.putInt("infoGodImage", R.drawable.kali);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_khepri: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "khepri");
                        args.putInt("infoGodImage", R.drawable.khepri);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_kukulkan: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kukulkan");
                        args.putInt("infoGodImage", R.drawable.kukulkan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_kumbhakarna: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kumbhakarna");
                        args.putInt("infoGodImage", R.drawable.kumbhakarna);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_kuzenbo: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "kuzenbo");
                        args.putInt("infoGodImage", R.drawable.kuzenbo);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_loki: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "loki");
                        args.putInt("infoGodImage", R.drawable.loki);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_medusa: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "medusa");
                        args.putInt("infoGodImage", R.drawable.medusa);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_mercury: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "mercury");
                        args.putInt("infoGodImage", R.drawable.mercury);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_neith: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "neith");
                        args.putInt("infoGodImage", R.drawable.neith);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_nemesis: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nemesis");
                        args.putInt("infoGodImage", R.drawable.nemesis);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ne_zha: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ne_zha");
                        args.putInt("infoGodImage", R.drawable.ne_zha);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_nike: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nike");
                        args.putInt("infoGodImage", R.drawable.nike);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_nox: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nox");
                        args.putInt("infoGodImage", R.drawable.nox);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_nu_wa: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "nu_wa");
                        args.putInt("infoGodImage", R.drawable.nu_wa);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_odin: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "odin");
                        args.putInt("infoGodImage", R.drawable.odin);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_osiris: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "osiris");
                        args.putInt("infoGodImage", R.drawable.osiris);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_poseidon: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "poseidon");
                        args.putInt("infoGodImage", R.drawable.poseidon);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ra: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ra");
                        args.putInt("infoGodImage", R.drawable.ra);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_raijin: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "raijin");
                        args.putInt("infoGodImage", R.drawable.raijin);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_rama: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "rama");
                        args.putInt("infoGodImage", R.drawable.rama);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ratatoskr: {
                        TabFragmentRatatoskr myFragment = new TabFragmentRatatoskr();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ratatoskr");
                        args.putInt("infoGodImage", R.drawable.ratatoskr);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ravana: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ravana");
                        args.putInt("infoGodImage", R.drawable.ravana);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_scylla: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "scylla");
                        args.putInt("infoGodImage", R.drawable.scylla);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_serqet: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "serqet");
                        args.putInt("infoGodImage", R.drawable.serqet);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_skadi: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "skadi");
                        args.putInt("infoGodImage", R.drawable.skadi);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_sobek: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sobek");
                        args.putInt("infoGodImage", R.drawable.sobek);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_sol: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sol");
                        args.putInt("infoGodImage", R.drawable.sol);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_sun_wukong: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sun_wukong");
                        args.putInt("infoGodImage", R.drawable.sun_wukong);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_susano: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "susano");
                        args.putInt("infoGodImage", R.drawable.susano);
                        args.putInt("infoPantheonIcon", R.drawable.icon_japanese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_sylvanus: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "sylvanus");
                        args.putInt("infoGodImage", R.drawable.sylvanus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_terra: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "terra");
                        args.putInt("infoGodImage", R.drawable.terra);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_thanatos: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "thanatos");
                        args.putInt("infoGodImage", R.drawable.thanatos);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_the_morrigan: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "the_morrigan");
                        args.putInt("infoGodImage", R.drawable.the_morrigan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_celtic);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_thor: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "thor");
                        args.putInt("infoGodImage", R.drawable.thor);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_thoth: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "thoth");
                        args.putInt("infoGodImage", R.drawable.thoth);
                        args.putInt("infoPantheonIcon", R.drawable.icon_egyptian);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_tyr: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "tyr");
                        args.putInt("infoGodImage", R.drawable.tyr);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ullr: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ullr");
                        args.putInt("infoGodImage", R.drawable.ullr);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_vamana: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "vamana");
                        args.putInt("infoGodImage", R.drawable.vamana);
                        args.putInt("infoPantheonIcon", R.drawable.icon_hindu);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_vulcan: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "vulcan");
                        args.putInt("infoGodImage", R.drawable.vulcan);
                        args.putInt("infoPantheonIcon", R.drawable.icon_roman);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_xbalanque: {
                        TabFragmentPhys myFragment = new TabFragmentPhys();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "xbalanque");
                        args.putInt("infoGodImage", R.drawable.xbalanque);
                        args.putInt("infoPantheonIcon", R.drawable.icon_mayan);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_xing_tian: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "xing_tian");
                        args.putInt("infoGodImage", R.drawable.xing_tian);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_ymir: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "ymir");
                        args.putInt("infoGodImage", R.drawable.ymir);
                        args.putInt("infoPantheonIcon", R.drawable.icon_norse);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_zeus: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "zeus");
                        args.putInt("infoGodImage", R.drawable.zeus);
                        args.putInt("infoPantheonIcon", R.drawable.icon_greek);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                    case R.id.nav_zhong_kui: {
                        TabFragmentMag myFragment = new TabFragmentMag();

                        Bundle args = new Bundle();
                        args.putString("infoGodName", "zhong_kui");
                        args.putInt("infoGodImage", R.drawable.zhong_kui);
                        args.putInt("infoPantheonIcon", R.drawable.icon_chinese);
                        myFragment.setArguments(args);

                        fragmentTransaction.replace(R.id.containerView, myFragment).commit();
                        break;
                    }
                }

                return false;
            }

        });

        //Setup Drawer Toggle of the Toolbar
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void createGods() {
        String[] names = {"Agni", "Ah Muzen Cab", "Ah Puch", "Amaterasu", "Anhur", "Anubis", "Ao Kuang", "Aphrodite", "Apollo", "Arachne", "Ares", "Artemis", "Athena", "Awilix",
                "Bacchus", "Bakasura", "Bastet", "Bellona",
                "Cabrakan", "Camazotz", "Cernunnos", "Chaac", "Chang'e", "Chiron", "Chronos", "Cupid",
                "Erlang Shen",
                "Fafnir", "Fenrir", "Freya",
                "Geb", "Guan Yu",
                "Hades", "He Bo", "Hel", "Hercules", "Hou Yi", "Hun Batz",
                "Isis", "Izanami",
                "Janus", "Jing Wei",
                "Kali", "Khepri", "Kukulkan", "Kumbhakarna", "Kuzenbo",
                "Loki",
                "Medusa", "Mercury",
                "Ne Zha", "Neith", "Nemesis", "Nike", "Nox", "Nu Wa",
                "Odin", "Osiris",
                "Poseidon",
                "Ra", "Raijin", "Rama", "Ratatoskr", "Ravana",
                "Scylla", "Serqet", "Skadi", "Sobek", "Sol", "Sun Wukong", "Susano", "Sylvanus",
                "Terra", "Thanatos", "The Morrigan", "Thor", "Thoth", "Tyr",
                "Ullr",
                "Vamana", "Vulcan",
                "Xbalanque", "Xing Tian",
                "Ymir",
                "Zeus", "Zhong Kui"};

        int[] images = {R.drawable.agni, R.drawable.ah_muzen_cab, R.drawable.ah_puch, R.drawable.amaterasu, R.drawable.anhur, R.drawable.anubis, R.drawable.ao_kuang, R.drawable.aphrodite, R.drawable.apollo, R.drawable.arachne, R.drawable.ares, R.drawable.artemis, R.drawable.athena, R.drawable.awilix,
                R.drawable.bacchus, R.drawable.bakasura, R.drawable.bastet, R.drawable.bellona,
                R.drawable.cabrakan, R.drawable.camazotz, R.drawable.cernunnos, R.drawable.chaac, R.drawable.change, R.drawable.chiron, R.drawable.chronos, R.drawable.cupid,
                R.drawable.erlang_shen,
                R.drawable.fafnir, R.drawable.fenrir, R.drawable.freya,
                R.drawable.geb, R.drawable.guan_yu,
                R.drawable.hades, R.drawable.he_bo, R.drawable.hel, R.drawable.hercules, R.drawable.hou_yi, R.drawable.hun_batz,
                R.drawable.isis, R.drawable.izanami,
                R.drawable.janus, R.drawable.jing_wei,
                R.drawable.kali, R.drawable.khepri, R.drawable.kukulkan, R.drawable.kumbhakarna, R.drawable.kuzenbo,
                R.drawable.loki,
                R.drawable.medusa, R.drawable.mercury,
                R.drawable.ne_zha, R.drawable.neith, R.drawable.nemesis, R.drawable.nike, R.drawable.nox, R.drawable.nu_wa,
                R.drawable.odin, R.drawable.osiris,
                R.drawable.poseidon,
                R.drawable.ra, R.drawable.raijin, R.drawable.rama, R.drawable.ratatoskr, R.drawable.ravana,
                R.drawable.scylla, R.drawable.serqet, R.drawable.skadi, R.drawable.sobek, R.drawable.sol, R.drawable.sun_wukong, R.drawable.susano, R.drawable.sylvanus,
                R.drawable.terra, R.drawable.thanatos, R.drawable.the_morrigan, R.drawable.thor, R.drawable.thoth, R.drawable.tyr,
                R.drawable.ullr,
                R.drawable.vamana, R.drawable.vulcan,
                R.drawable.xbalanque, R.drawable.xing_tian,
                R.drawable.ymir,
                R.drawable.zeus, R.drawable.zhong_kui};

        String[] pantheons = {"Hindu", "Mayan", "Mayan", "Japanese", "Egyptian", "Egyptian", "Chinese", "Greek", "Greek", "Greek", "Greek", "Greek", "Greek", "Mayan",
        /*b*/   "Roman", "Hindu", "Egyptian", "Roman",
        /*c*/   "Mayan", "Mayan", "Celtic", "Mayan", "Chinese", "Greek", "Greek", "Roman",
        /*e*/   "Chinese",
        /*f*/   "Norse", "Norse", "Norse",
        /*g*/   "Egyptian", "Chinese",
        /*h*/   "Greek", "Chinese", "Norse", "Roman", "Chinese", "Mayan",
        /*i*/   "Egyptian", "Japanese",
        /*j*/   "Roman", "Chinese",
        /*k*/   "Hindu", "Egyptian", "Mayan", "Hindu", "Japanese",
        /*l*/   "Norse",
        /*m*/   "Greek", "Roman",
        /*n*/   "Chinese", "Egyptian", "Greek", "Greek", "Roman", "Chinese",
        /*o*/   "Norse", "Egyptian",
        /*p*/   "Greek",
        /*r*/   "Egyptian", "Japanese", "Hindu", "Norse", "Hindu",
        /*s*/   "Greek", "Egyptian", "Norse", "Egyptian", "Norse", "Chinese", "Japanese", "Roman",
        /*t*/   "Roman", "Greek", "Celtic", "Norse", "Egyptian", "Norse",
        /*u*/   "Norse",
        /*v*/   "Hindu", "Roman",
        /*x*/   "Mayan", "Chinese",
        /*y*/   "Norse",
        /*z*/   "Greek", "Chinese"};

        int[] pantheonIcons = {R.drawable.icon_hindu, R.drawable.icon_mayan, R.drawable.icon_mayan, R.drawable.icon_japanese, R.drawable.icon_egyptian, R.drawable.icon_egyptian, R.drawable.icon_chinese, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_mayan,
        /*b*/   R.drawable.icon_roman, R.drawable.icon_hindu, R.drawable.icon_egyptian, R.drawable.icon_roman,
        /*c*/   R.drawable.icon_mayan, R.drawable.icon_mayan, R.drawable.icon_celtic, R.drawable.icon_mayan, R.drawable.icon_chinese, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_roman,
        /*e*/   R.drawable.icon_chinese,
        /*f*/   R.drawable.icon_norse, R.drawable.icon_norse, R.drawable.icon_norse,
        /*g*/   R.drawable.icon_egyptian, R.drawable.icon_chinese,
        /*h*/   R.drawable.icon_greek, R.drawable.icon_chinese, R.drawable.icon_norse, R.drawable.icon_roman, R.drawable.icon_chinese, R.drawable.icon_mayan,
        /*i*/   R.drawable.icon_egyptian, R.drawable.icon_japanese,
        /*j*/   R.drawable.icon_roman, R.drawable.icon_chinese,
        /*k*/   R.drawable.icon_hindu, R.drawable.icon_egyptian, R.drawable.icon_mayan, R.drawable.icon_hindu, R.drawable.icon_japanese,
        /*l*/   R.drawable.icon_norse,
        /*m*/   R.drawable.icon_greek, R.drawable.icon_roman,
        /*n*/   R.drawable.icon_chinese, R.drawable.icon_egyptian, R.drawable.icon_greek, R.drawable.icon_greek, R.drawable.icon_roman, R.drawable.icon_chinese,
        /*o*/   R.drawable.icon_norse, R.drawable.icon_egyptian,
        /*p*/   R.drawable.icon_greek,
        /*r*/   R.drawable.icon_egyptian, R.drawable.icon_japanese, R.drawable.icon_hindu, R.drawable.icon_norse, R.drawable.icon_hindu,
        /*s*/   R.drawable.icon_greek, R.drawable.icon_egyptian, R.drawable.icon_norse, R.drawable.icon_egyptian, R.drawable.icon_norse, R.drawable.icon_chinese, R.drawable.icon_japanese, R.drawable.icon_roman,
        /*t*/   R.drawable.icon_roman, R.drawable.icon_greek, R.drawable.icon_celtic, R.drawable.icon_norse, R.drawable.icon_egyptian, R.drawable.icon_norse,
        /*u*/   R.drawable.icon_norse,
        /*v*/   R.drawable.icon_hindu, R.drawable.icon_roman,
        /*x*/   R.drawable.icon_mayan, R.drawable.icon_chinese,
        /*y*/   R.drawable.icon_norse,
        /*z*/   R.drawable.icon_greek, R.drawable.icon_chinese};

        String[] types = {"Mage", "Hunter", "Mage", "Warrior", "Hunter", "Mage", "Mage", "Mage", "Hunter", "Assassin", "Guardian", "Hunter", "Guardian", "Assassin",
        /*b*/   "Guardian", "Assassin", "Assassin", "Warrior",
        /*c*/   "Guardian", "Assassin", "Hunter", "Warrior", "Mage", "Hunter", "Mage", "Hunter",
        /*e*/   "Warrior",
        /*f*/   "Guardian", "Assassin", "Mage",
        /*g*/   "Guardian", "Warrior",
        /*h*/   "Mage", "Mage", "Mage", "Warrior", "Hunter", "Assassin",
        /*i*/   "Mage", "Hunter",
        /*j*/   "Mage", "Hunter",
        /*k*/   "Assassin", "Guardian", "Mage", "Guardian", "Guardian",
        /*l*/   "Assassin",
        /*m*/   "Hunter", "Assassin",
        /*n*/   "Assassin", "Hunter", "Assassin", "Warrior", "Mage", "Mage",
        /*o*/   "Warrior", "Warrior",
        /*p*/   "Mage",
        /*r*/   "Mage", "Mage", "Hunter", "Assassin", "Warrior",
        /*s*/   "Mage", "Assassin", "Hunter", "Guardian", "Mage", "Warrior", "Assassin", "Guardian",
        /*t*/   "Guardian", "Assassin", "Mage", "Assassin", "Mage", "Warrior",
        /*u*/   "Hunter",
        /*v*/   "Warrior", "Mage",
        /*x*/   "Hunter", "Guardian",
        /*y*/   "Guardian",
        /*z*/   "Mage", "Mage"};

        int[] typeIcons = {R.drawable.icon_mage, R.drawable.icon_hunter, R.drawable.icon_mage, R.drawable.icon_warrior, R.drawable.icon_hunter, R.drawable.icon_mage, R.drawable.icon_mage, R.drawable.icon_mage, R.drawable.icon_hunter, R.drawable.icon_assassin, R.drawable.icon_guardian, R.drawable.icon_hunter, R.drawable.icon_guardian, R.drawable.icon_assassin,
        /*b*/   R.drawable.icon_guardian, R.drawable.icon_assassin, R.drawable.icon_assassin, R.drawable.icon_warrior,
        /*c*/   R.drawable.icon_guardian, R.drawable.icon_assassin, R.drawable.icon_guardian, R.drawable.icon_warrior, R.drawable.icon_mage, R.drawable.icon_hunter, R.drawable.icon_mage, R.drawable.icon_hunter,
        /*e*/   R.drawable.icon_warrior,
        /*f*/   R.drawable.icon_guardian, R.drawable.icon_assassin, R.drawable.icon_mage,
        /*g*/   R.drawable.icon_guardian, R.drawable.icon_warrior,
        /*h*/   R.drawable.icon_mage, R.drawable.icon_mage, R.drawable.icon_mage, R.drawable.icon_warrior, R.drawable.icon_hunter, R.drawable.icon_assassin,
        /*i*/   R.drawable.icon_mage, R.drawable.icon_hunter,
        /*j*/   R.drawable.icon_mage, R.drawable.icon_hunter,
        /*k*/   R.drawable.icon_assassin, R.drawable.icon_guardian, R.drawable.icon_mage, R.drawable.icon_guardian, R.drawable.icon_guardian,
        /*l*/   R.drawable.icon_assassin,
        /*m*/   R.drawable.icon_hunter, R.drawable.icon_assassin,
        /*n*/   R.drawable.icon_assassin, R.drawable.icon_hunter, R.drawable.icon_assassin, R.drawable.icon_warrior, R.drawable.icon_mage, R.drawable.icon_mage,
        /*o*/   R.drawable.icon_warrior, R.drawable.icon_warrior,
        /*p*/   R.drawable.icon_mage,
        /*r*/   R.drawable.icon_mage, R.drawable.icon_mage, R.drawable.icon_hunter, R.drawable.icon_assassin, R.drawable.icon_warrior,
        /*s*/   R.drawable.icon_mage, R.drawable.icon_assassin, R.drawable.icon_hunter, R.drawable.icon_guardian, R.drawable.icon_mage, R.drawable.icon_warrior, R.drawable.icon_assassin, R.drawable.icon_guardian,
        /*t*/   R.drawable.icon_guardian, R.drawable.icon_assassin, R.drawable.icon_mage, R.drawable.icon_assassin, R.drawable.icon_mage, R.drawable.icon_warrior,
        /*u*/   R.drawable.icon_hunter,
        /*v*/   R.drawable.icon_warrior, R.drawable.icon_mage,
        /*x*/   R.drawable.icon_hunter, R.drawable.icon_guardian,
        /*y*/   R.drawable.icon_guardian,
        /*z*/   R.drawable.icon_mage, R.drawable.icon_mage};

        ArrayList<God> gods = new ArrayList<God>();
        God god;

        for(int i = 0; i < names.length; i++)
        {
            god = new God(names[i], images[i], pantheons[i], pantheonIcons[i], types[i], typeIcons[i]);
            gods.add(god);
        }

        this.gods = gods;
    }

    public ArrayList<God> getGods() {
        return gods;
    }
}

