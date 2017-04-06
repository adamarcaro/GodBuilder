package com.adamtrudeauarcaro.godbuilder;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class GodDrawer extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private AdView mAdView;
    Toolbar toolbar;

    public static ArrayList<God> gods = new ArrayList<God>();

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

        //Setup ad
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        mAdView.loadAd(adRequest);

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
                int id = menuItem.getItemId();

                switch(id) {
                    case R.id.nav_home: {
                        Fragment myFragment = new HomeFragment();
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_agni: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("agni", R.drawable.agni, R.drawable.icon_hindu, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ah_muzen_cab: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ah_muzen_cab", R.drawable.ah_muzen_cab, R.drawable.icon_mayan, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ah_puch: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ah_puch", R.drawable.ah_puch, R.drawable.icon_mayan, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_amaterasu: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("amaterasu", R.drawable.amaterasu, R.drawable.icon_japanese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_anhur: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("anhur", R.drawable.anhur, R.drawable.icon_egyptian, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_anubis: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("anubis", R.drawable.anubis, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ao_kuang: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ao_kuang", R.drawable.ao_kuang, R.drawable.icon_chinese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_aphrodite: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("aphrodite", R.drawable.aphrodite, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_apollo: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("apollo", R.drawable.apollo, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_arachne: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("arachne", R.drawable.arachne, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ares: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ares", R.drawable.ares, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_artemis: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("artemis", R.drawable.artemis, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_athena: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("athena", R.drawable.athena, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_awilix: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("awilix", R.drawable.awilix, R.drawable.icon_mayan, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_bacchus: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bacchus", R.drawable.bacchus, R.drawable.icon_roman, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_bakasura: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bakasura", R.drawable.bakasura, R.drawable.icon_hindu, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_bastet: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bastet", R.drawable.bastet, R.drawable.icon_egyptian, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_bellona: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("bellona", R.drawable.bellona, R.drawable.icon_roman, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_cabrakan: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("cabrakan", R.drawable.cabrakan, R.drawable.icon_mayan, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_camazotz: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("camazotz", R.drawable.camazotz, R.drawable.icon_mayan, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_cernunnos: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("cernunnos", R.drawable.cernunnos, R.drawable.icon_celtic, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_chaac: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("chaac", R.drawable.chaac, R.drawable.icon_mayan, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_change: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("change", R.drawable.change, R.drawable.icon_chinese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_chiron: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("chiron", R.drawable.chiron, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_chronos: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("chronos", R.drawable.chronos, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_cupid: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("cupid", R.drawable.cupid, R.drawable.icon_roman, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_erlang_shen: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("erlang_shen", R.drawable.erlang_shen, R.drawable.icon_chinese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_fafnir: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("fafnir", R.drawable.fafnir, R.drawable.icon_norse, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_fenrir: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("fenrir", R.drawable.fenrir, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_freya: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("freya", R.drawable.freya, R.drawable.icon_norse, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_geb: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("geb", R.drawable.geb, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_guan_yu: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("guan_yu", R.drawable.guan_yu, R.drawable.icon_chinese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_hades: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hades", R.drawable.hades, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_he_bo: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("he_bo", R.drawable.he_bo, R.drawable.icon_chinese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_hel: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hel", R.drawable.hel, R.drawable.icon_norse, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_hercules: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hercules", R.drawable.hercules, R.drawable.icon_roman, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_hou_yi: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hou_yi", R.drawable.hou_yi, R.drawable.icon_chinese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_hun_batz: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("hun_batz", R.drawable.hun_batz, R.drawable.icon_mayan, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_isis: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("isis", R.drawable.isis, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_izanami: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("izanami", R.drawable.izanami, R.drawable.icon_japanese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_janus: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("janus", R.drawable.janus, R.drawable.icon_roman, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_jing_wei:  {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("jing_wei", R.drawable.jing_wei, R.drawable.icon_chinese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_kali: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kali", R.drawable.kali, R.drawable.icon_hindu, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_khepri: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("khepri", R.drawable.khepri, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_kukulkan: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kukulkan", R.drawable.kukulkan, R.drawable.icon_mayan, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_kumbhakarna: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kumbhakarna", R.drawable.kumbhakarna, R.drawable.icon_hindu, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_kuzenbo: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("kuzenbo", R.drawable.kuzenbo, R.drawable.icon_japanese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_loki: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("loki", R.drawable.loki, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_medusa: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("medusa", R.drawable.medusa, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_mercury: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("mercury", R.drawable.mercury, R.drawable.icon_roman, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ne_zha: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ne_zha", R.drawable.ne_zha, R.drawable.icon_chinese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_neith: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("neith", R.drawable.neith, R.drawable.icon_egyptian, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_nemesis: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nemesis", R.drawable.nemesis, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_nike: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nike", R.drawable.nike, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_nox: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nox", R.drawable.nox, R.drawable.icon_roman, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_nu_wa: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("nu_wa", R.drawable.nu_wa, R.drawable.icon_chinese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_odin: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("odin", R.drawable.odin, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_osiris: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("osiris", R.drawable.osiris, R.drawable.icon_egyptian, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_poseidon: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("poseidon", R.drawable.poseidon, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ra: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ra", R.drawable.ra, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_raijin: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("raijin", R.drawable.raijin, R.drawable.icon_japanese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_rama: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("rama", R.drawable.rama, R.drawable.icon_hindu, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ratatoskr: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ratatoskr", R.drawable.ratatoskr, R.drawable.icon_norse, 'R'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ravana: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ravana", R.drawable.ravana, R.drawable.icon_hindu, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_scylla: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("scylla", R.drawable.scylla, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_serqet: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("serqet", R.drawable.serqet, R.drawable.icon_egyptian, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_skadi: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("skadi", R.drawable.skadi, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_sobek: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sobek", R.drawable.sobek, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_sol: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sol", R.drawable.sol, R.drawable.icon_norse, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_sun_wukong: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sun_wukong", R.drawable.sun_wukong, R.drawable.icon_chinese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_susano: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("susano", R.drawable.susano, R.drawable.icon_japanese, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_sylvanus: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("sylvanus", R.drawable.sylvanus, R.drawable.icon_roman, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_terra: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("terra", R.drawable.terra, R.drawable.icon_roman, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_thanatos: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("thanatos", R.drawable.thanatos, R.drawable.icon_greek, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_the_morrigan: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("the_morrigan", R.drawable.the_morrigan, R.drawable.icon_celtic, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_thor: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("thor", R.drawable.thor, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_thoth: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("thoth", R.drawable.thoth, R.drawable.icon_egyptian, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_tyr: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("tyr", R.drawable.tyr, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ullr: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ullr", R.drawable.ullr, R.drawable.icon_norse, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_vamana: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("vamana", R.drawable.vamana, R.drawable.icon_hindu, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_vulcan: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("vulcan", R.drawable.vulcan, R.drawable.icon_roman, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_xbalanque: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("xbalanque", R.drawable.xbalanque, R.drawable.icon_mayan, 'P'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_xing_tian: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("xing_tian", R.drawable.xing_tian, R.drawable.icon_chinese, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_ymir: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("ymir", R.drawable.ymir, R.drawable.icon_norse, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_zeus: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("zeus", R.drawable.zeus, R.drawable.icon_greek, 'M'));
                        replaceFragment(myFragment);
                        break;
                    }
                    case R.id.nav_zhong_kui: {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(passArgs("zhong_kui", R.drawable.zhong_kui, R.drawable.icon_chinese, 'M'));
                        replaceFragment(myFragment);
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
            Fragment myFragment = new HomeFragment();
            replaceFragment(myFragment);
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

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void replaceFragment(Fragment myFragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
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

    public ArrayList<God> getGods() {
        return gods;
    }
}

