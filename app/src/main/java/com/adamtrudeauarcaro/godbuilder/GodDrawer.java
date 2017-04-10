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
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GodDrawer extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private AdView mAdView;
    Toolbar toolbar;

    public static ArrayList<God> gods = new ArrayList<God>();

    public static ArrayList<Item> starterCommon = new ArrayList<Item>();
    public static ArrayList<Item> starterPhys = new ArrayList<Item>();
    public static ArrayList<Item> starterMag = new ArrayList<Item>();

    public static ArrayList<Item> starterPhysCommon = new ArrayList<Item>();
    public static ArrayList<Item> starterMagCommon = new ArrayList<Item>();

    public static ArrayList<Item> itemsCommon = new ArrayList<Item>();
    public static ArrayList<Item> itemsPhys = new ArrayList<Item>();
    public static ArrayList<Item> itemsMag = new ArrayList<Item>();

    public static ArrayList<Item> itemsPhysCommon = new ArrayList<Item>();
    public static ArrayList<Item> itemsMagCommon = new ArrayList<Item>();

    public static ArrayList<Item> boots = new ArrayList<Item>();
    public static ArrayList<Item> shoes = new ArrayList<Item>();

    public static ArrayList<Item> relics = new ArrayList<Item>();
    public static ArrayList<Item> itemsSpecial = new ArrayList<Item>();
    public static ArrayList<Item> itemsAll = new ArrayList<Item>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_drawer);

        createGods();
        createItems();

        //Setup DrawerLayout and NavigationView
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        /*
        //Setup ad
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        mAdView.loadAd(adRequest);
        */

        mNavigationView = (NavigationView) findViewById(R.id.nav_view) ;

        //Inflating first fragment
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new HomeFragment()).commit();

        //Setup click events on the Navigation View Items.
        mNavigationView.setItemIconTintList(null);

        final Menu menu = mNavigationView.getMenu();
        for (int i = 0; i < gods.size(); i++) {
            menu.add(gods.get(i).getName()).setIcon(gods.get(i).getPantheonIcon());
        }

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                int selection = menuItem.getItemId();
                String name = menuItem.getTitle().toString();

                if(selection == R.id.nav_home) {
                    Fragment myFragment = new HomeFragment();
                    replaceFragment(myFragment);
                }

                for(int i = 0; i < gods.size(); i++) {
                    if(gods.get(i).getName().equals(name))
                    {
                        Fragment myFragment = new TabFragment();
                        myFragment.setArguments(createGodBundle(gods.get(i)));
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
        //Stats are reflected for level 20
        God agni = new God(getString(R.string.agni), getString(R.string.agni_title), "agni", R.drawable.agni,
                "Hindu", R.drawable.icon_hindu, "Mage", R.drawable.icon_mage, 'M',
                1780, 1155, 64, 63, 30, 350, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.4, 12.1, 1.19); //HP5, MP5, Attack Speed

        God ahMuzenCab = new God(getString(R.string.ah_muzen_cab), getString(R.string.ah_muzen_cab_title), "ah_muzen_cab", R.drawable.ah_muzen_cab,
                "Mayan", R.drawable.icon_mayan, "Hunter", R.drawable.icon_hunter, 'P',
                1910, 1030, 82, 72, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.1, 12.0, 1.27); //HP5, MP5, Attack Speed

        God ahPuch = new God(getString(R.string.ah_puch), getString(R.string.ah_puch_title), "ah_puch", R.drawable.ah_puch,
                "Mayan", R.drawable.icon_mayan, "Mage", R.drawable.icon_mage, 'M',
                1900, 1365, 65, 63, 30, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 13.3, 1.02); //HP5, MP5, Attack Speed

        God amaterasu = new God(getString(R.string.amaterasu), getString(R.string.amaterasu_title), "amaterasu", R.drawable.amaterasu,
                "Japanese", R.drawable.icon_japanese, "Warrior", R.drawable.icon_warrior, 'P',
                2110, 920, 79, 78, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.8, 1.24); //HP5, MP5, Attack Speed

        God anhur = new God(getString(R.string.anhur), getString(R.string.anhur_title), "anhur", R.drawable.anhur,
                "Egyptian", R.drawable.icon_egyptian, "Hunter", R.drawable.icon_hunter, 'P',
                2020, 920, 90, 67, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.8, 10.9, 1.21); //HP5, MP5, Attack Speed

        God anubis = new God(getString(R.string.anubis), getString(R.string.anubis_title), "anubis", R.drawable.anubis,
                "Egyptian", R.drawable.icon_egyptian, "Mage", R.drawable.icon_mage, 'M',
                1670, 1440, 65, 60, 30, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.0, 12.0, 1.03); //HP5, MP5, Attack Speed

        God aoKuang = new God(getString(R.string.ao_kuang), getString(R.string.ao_kuang_title), "ao_kuang", R.drawable.ao_kuang,
                "Chinese", R.drawable.icon_chinese, "Mage", R.drawable.icon_mage, 'M',
                2040, 920, 83, 72, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 8.5, 1.39); //HP5, MP5, Attack Speed

        God aphrodite = new God(getString(R.string.aphrodite), getString(R.string.aphrodite_title), "aphrodite", R.drawable.aphrodite,
                "Greek", R.drawable.icon_greek, "Mage", R.drawable.icon_mage, 'M',
                1740, 1100, 61, 63, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 13.0, 1.04); //HP5, MP5, Attack Speed

        God apollo = new God(getString(R.string.apollo), getString(R.string.apollo_title), "apollo", R.drawable.apollo,
                "Greek", R.drawable.icon_greek, "Hunter", R.drawable.icon_hunter, 'P',
                1990, 1025, 92, 66, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.8, 12.6, 1.27); //HP5, MP5, Attack Speed

        God arachne = new God(getString(R.string.arachne), getString(R.string.arachne_title), "arachne", R.drawable.arachne,
                "Greek", R.drawable.icon_greek, "Assassin", R.drawable.icon_assassin, 'P',
                2025, 1030, 82, 73, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.4, 14.0, 1.40); //HP5, MP5, Attack Speed

        God ares = new God(getString(R.string.ares), getString(R.string.ares_title), "ares", R.drawable.ares,
                "Greek", R.drawable.icon_greek, "Guardian", R.drawable.icon_guardian, 'M',
                2285, 940, 69, 77, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.4, 13.0, 1.13); //HP5, MP5, Attack Speed

        God artemis = new God(getString(R.string.artemis), getString(R.string.artemis_title), "artemis", R.drawable.artemis,
                "Greek", R.drawable.icon_greek, "Hunter", R.drawable.icon_hunter, 'P',
                1890, 885, 85, 72, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.6, 9.4, 1.27); //HP5, MP5, Attack Speed

        God athena = new God(getString(R.string.athena), getString(R.string.athena_title), "athena", R.drawable.athena,
                "Greek", R.drawable.icon_greek, "Guardian", R.drawable.icon_guardian, 'M',
                2500, 870, 65, 84, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                26.0, 13.0, 1.24); //HP5, MP5, Attack Speed

        God awilix = new God(getString(R.string.awilix), getString(R.string.awilix_title), "awilix", R.drawable.awilix,
                "Mayan", R.drawable.icon_mayan, "Assassin", R.drawable.icon_assassin, 'P',
                2015, 980, 106, 73, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.6, 9.3, 1.38); //HP5, MP5, Attack Speed

        God bacchus = new God(getString(R.string.bacchus), getString(R.string.bacchus_title), "bacchus", R.drawable.bacchus,
                "Roman", R.drawable.icon_roman, "Guardian", R.drawable.icon_guardian, 'M',
                2215, 1000, 67, 79, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.8, 1.06); //HP5, MP5, Attack Speed

        God bakasura = new God(getString(R.string.bakasura), getString(R.string.bakasura_title), "bakasura", R.drawable.bakasura,
                "Hindu", R.drawable.icon_hindu, "Assassin", R.drawable.icon_assassin, 'P',
                2015, 980, 82, 69, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.6, 14.0, 1.32); //HP5, MP5, Attack Speed

        God bastet = new God(getString(R.string.bastet), getString(R.string.bastet_title), "bastet", R.drawable.bastet,
                "Egyptian", R.drawable.icon_egyptian, "Assassin", R.drawable.icon_assassin, 'P',
                2015, 1010, 81, 70, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.4, 9.4, 1.40); //HP5, MP5, Attack Speed

        God bellona = new God(getString(R.string.bellona), getString(R.string.bellona_title), "bellona", R.drawable.bellona,
                "Roman", R.drawable.icon_roman, "Warrior", R.drawable.icon_warrior, 'P',
                2180, 920, 79, 78, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.8, 1.24); //HP5, MP5, Attack Speed

        God cabrakan = new God(getString(R.string.cabrakan), getString(R.string.cabrakan_title), "cabrakan", R.drawable.cabrakan,
                "Mayan", R.drawable.icon_mayan, "Guardian", R.drawable.icon_guardian, 'M',
                2290, 880, 68, 89, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 13.0, 1.12); //HP5, MP5, Attack Speed

        God camazotz = new God(getString(R.string.camazotz), getString(R.string.camazotz_title), "camazotz", R.drawable.camazotz,
                "Mayan", R.drawable.icon_mayan, "Assassin", R.drawable.icon_assassin, 'P',
                2000, 915, 85, 73, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.4, 10.4, 1.40); //HP5, MP5, Attack Speed

        God cernunnos = new God(getString(R.string.cernunnos), getString(R.string.cernunnos_title), "cernunnos", R.drawable.cernunnos,
                "Celtic", R.drawable.icon_celtic, "Hunter", R.drawable.icon_hunter, 'P',
                2080, 960, 87, 71, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.8, 10.9, 1.28); //HP5, MP5, Attack Speed

        God chaac = new God(getString(R.string.chaac), getString(R.string.chaac_title), "chaac", R.drawable.chaac,
                "Mayan", R.drawable.icon_mayan, "Warrior", R.drawable.icon_warrior, 'P',
                2180, 905, 81, 78, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 12.5, 1.20); //HP5, MP5, Attack Speed

        God change = new God(getString(R.string.change), getString(R.string.change_title), "change", R.drawable.change,
                "Chinese", R.drawable.icon_chinese, "Mage", R.drawable.icon_mage, 'M',
                1775, 1150, 61, 65, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 14.3, 1.19); //HP5, MP5, Attack Speed

        God chiron = new God(getString(R.string.chiron), getString(R.string.chiron_title), "chiron", R.drawable.chiron,
                "Greek", R.drawable.icon_greek, "Hunter", R.drawable.icon_hunter, 'P',
                1960, 1025, 82, 68, 48, 380, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                19.0, 12.0, 1.22); //HP5, MP5, Attack Speed

        God chronos = new God(getString(R.string.chronos), getString(R.string.chronos_title), "chronos", R.drawable.chronos,
                "Greek", R.drawable.icon_greek, "Mage", R.drawable.icon_mage, 'M',
                1770, 1080, 65, 69, 30, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.6, 13.2, 1.16); //HP5, MP5, Attack Speed

        God cupid = new God(getString(R.string.cupid), getString(R.string.cupid_title), "cupid", R.drawable.cupid,
                "Roman", R.drawable.icon_roman, "Hunter", R.drawable.icon_hunter, 'P',
                1885, 1010, 81, 71, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.4, 11.6, 1.29); //HP5, MP5, Attack Speed

        God erlangShen = new God(getString(R.string.erlang_shen), getString(R.string.erlang_shen_title), "erlang_shen", R.drawable.erlang_shen,
                "Chinese", R.drawable.icon_chinese, "Warrior", R.drawable.icon_warrior, 'P',
                2115, 920, 78, 77, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                20.0, 10.7, 1.16); //HP5, MP5, Attack Speed

        God fafnir = new God(getString(R.string.fafnir), getString(R.string.fafnir_title), "fafnir", R.drawable.fafnir,
                "Norse", R.drawable.icon_norse, "Guardian", R.drawable.icon_guardian, 'M',
                2295, 1000, 68, 89, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.8, 13.5, 1.12); //HP5, MP5, Attack Speed

        God fenrir = new God(getString(R.string.fenrir), getString(R.string.fenrir_title), "fenrir", R.drawable.fenrir,
                "Norse", R.drawable.icon_norse, "Assassin", R.drawable.icon_assassin, 'P',
                2015, 930, 84, 74, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.6, 9.4, 1.34); //HP5, MP5, Attack Speed

        God freya = new God(getString(R.string.freya), getString(R.string.freya_title), "freya", R.drawable.freya,
                "Norse", R.drawable.icon_norse, "Mage", R.drawable.icon_mage, 'M',
                2005, 960, 65, 70, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                17.4, 12.3, 1.32); //HP5, MP5, Attack Speed

        God geb = new God(getString(R.string.geb), getString(R.string.geb_title), "geb", R.drawable.geb,
                "Egyptian", R.drawable.icon_egyptian, "Guardian", R.drawable.icon_guardian, 'M',
                2310, 870, 68, 79, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.6, 1.24); //HP5, MP5, Attack Speed

        God guanYu = new God(getString(R.string.guan_yu), getString(R.string.guan_yu_title), "guan_yu", R.drawable.guan_yu,
                "Chinese", R.drawable.icon_chinese, "Warrior", R.drawable.icon_warrior, 'P',
                2150, 860, 77, 76, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                20.0, 13.8, 1.18); //HP5, MP5, Attack Speed

        God hades = new God(getString(R.string.hades), getString(R.string.hades_title), "hades", R.drawable.hades,
                "Greek", R.drawable.icon_greek, "Mage", R.drawable.icon_mage, 'M',
                2090, 1325, 62, 82, 48, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.8, 12.2, 1.05); //HP5, MP5, Attack Speed

        God heBo = new God(getString(R.string.he_bo), getString(R.string.he_bo_title), "he_bo", R.drawable.he_bo,
                "Chinese", R.drawable.icon_chinese, "Mage", R.drawable.icon_mage, 'M',
                1725, 1418, 63, 61, 30, 350, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 12.9, 1.01); //HP5, MP5, Attack Speed

        God hel = new God(getString(R.string.hel), getString(R.string.hel_title), "hel", R.drawable.hel,
                "Norse", R.drawable.icon_norse, "Mage", R.drawable.icon_mage, 'M',
                1720, 1440, 63, 61, 30, 350, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                13.6, 14.0, 1.01); //HP5, MP5, Attack Speed

        God hercules = new God(getString(R.string.hercules), getString(R.string.hercules_title), "hercules", R.drawable.hercules,
                "Roman", R.drawable.icon_roman, "Warrior", R.drawable.icon_warrior, 'P',
                2200, 845, 79, 78, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                19.6, 12.3, 1.16); //HP5, MP5, Attack Speed

        God houYi = new God(getString(R.string.hou_yi), getString(R.string.hou_yi_title), "hou_yi", R.drawable.hou_yi,
                "Chinese", R.drawable.icon_chinese, "Hunter", R.drawable.icon_hunter, 'P',
                2040, 1000, 94, 69, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.6, 12.0, 1.12); //HP5, MP5, Attack Speed

        God hunBatz = new God(getString(R.string.hun_batz), getString(R.string.hun_batz_title), "hun_batz", R.drawable.hun_batz,
                "Mayan", R.drawable.icon_mayan, "Assassin", R.drawable.icon_assassin, 'P',
                1960, 980, 81, 73, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.6, 9.3, 1.38); //HP5, MP5, Attack Speed

        God isis = new God(getString(R.string.isis), getString(R.string.isis_title), "isis", R.drawable.isis,
                "Egyptian", R.drawable.icon_egyptian, "Mage", R.drawable.icon_mage, 'M',
                1725, 1300, 65, 63, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 13.4, 1.00); //HP5, MP5, Attack Speed

        God izanami = new God(getString(R.string.izanami), getString(R.string.izanami_title), "izanami", R.drawable.izanami,
                "Japanese", R.drawable.icon_japanese, "Hunter", R.drawable.icon_hunter, 'P',
                1990, 910, 63, 69, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                20.0, 12.0, 1.27); //HP5, MP5, Attack Speed

        God janus = new God(getString(R.string.janus), getString(R.string.janus_title), "janus", R.drawable.janus,
                "Roman", R.drawable.icon_roman, "Mage", R.drawable.icon_mage, 'M',
                1800, 1510, 63, 60, 30, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 14.0, 1.16); //HP5, MP5, Attack Speed

        God jingWei = new God(getString(R.string.jing_wei), getString(R.string.jing_wei_title), "jing_wei", R.drawable.jing_wei,
                "Chinese", R.drawable.icon_chinese, "Hunter", R.drawable.icon_hunter, 'P',
                2005, 925, 92, 69, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                20.6, 10.4, 1.28); //HP5, MP5, Attack Speed

        God kali = new God(getString(R.string.kali), getString(R.string.kali_title), "kali", R.drawable.kali,
                "Hindu", R.drawable.icon_hindu, "Assassin", R.drawable.icon_assassin, 'P',
                1950, 885, 83, 73, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.6, 8.5, 1.43); //HP5, MP5, Attack Speed

        God khepri = new God(getString(R.string.khepri), getString(R.string.khepri_title), "khepri", R.drawable.khepri,
                "Egyptian", R.drawable.icon_egyptian, "Guardian", R.drawable.icon_guardian, 'M',
                2290, 870, 68, 79, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.6, 1.24); //HP5, MP5, Attack Speed

        God kukulkan = new God(getString(R.string.kukulkan), getString(R.string.kukulkan_title), "kukulkan", R.drawable.kukulkan,
                "Mayan", R.drawable.icon_mayan, "Mage", R.drawable.icon_mage, 'M',
                1725, 1165, 75, 73, 30, 350, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.2, 14.0, 1.03); //HP5, MP5, Attack Speed

        God kumbhakarna = new God(getString(R.string.kumbhakarna), getString(R.string.kumbhakarna_title), "kumbhakarna", R.drawable.kumbhakarna,
                "Hindu", R.drawable.icon_hindu, "Guardian", R.drawable.icon_guardian, 'M',
                2490, 880, 68, 82, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 13.0, 1.24); //HP5, MP5, Attack Speed

        God kuzenbo = new God(getString(R.string.kuzenbo), getString(R.string.kuzenbo_title), "kuzenbo", R.drawable.kuzenbo,
                "Japanese", R.drawable.icon_japanese, "Guardian", R.drawable.icon_guardian, 'M',
                2400, 880, 68, 82, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                25.0, 13.0, 1.24); //HP5, MP5, Attack Speed

        God loki = new God(getString(R.string.loki), getString(R.string.loki_title), "loki", R.drawable.loki,
                "Norse", R.drawable.icon_norse, "Assassin", R.drawable.icon_assassin, 'P',
                1895, 910, 86, 69, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.0, 11.2, 1.38); //HP5, MP5, Attack Speed

        God medusa = new God(getString(R.string.medusa), getString(R.string.medusa_title), "medusa", R.drawable.medusa,
                "Greek", R.drawable.icon_greek, "Hunter", R.drawable.icon_hunter, 'P',
                2010, 900, 90, 72, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.6, 9.4, 1.22); //HP5, MP5, Attack Speed

        God mercury = new God(getString(R.string.mercury), getString(R.string.mercury_title), "mercury", R.drawable.mercury,
                "Roman", R.drawable.icon_roman, "Assassin", R.drawable.icon_assassin, 'P',
                1900, 1000, 81, 70, 48, 381, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 11.4, 1.48); //HP5, MP5, Attack Speed

        God neZha = new God(getString(R.string.ne_zha), getString(R.string.ne_zha_title), "ne_zha", R.drawable.ne_zha,
                "Chinese", R.drawable.icon_chinese, "Assassin", R.drawable.icon_assassin, 'P',
                1900, 900, 83, 70, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.2, 9.3, 1.42); //HP5, MP5, Attack Speed

        God neith = new God(getString(R.string.neith), getString(R.string.neith_title), "neith", R.drawable.neith,
                "Egyptian", R.drawable.icon_egyptian, "Hunter", R.drawable.icon_hunter, 'P',
                1935, 1010, 81, 72, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.8, 11.4, 1.25); //HP5, MP5, Attack Speed

        God nemesis = new God(getString(R.string.nemesis), getString(R.string.nemesis_title), "nemesis", R.drawable.nemesis,
                "Greek", R.drawable.icon_greek, "Assassin", R.drawable.icon_assassin, 'P',
                1990, 970, 84, 71, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.0, 12.3, 1.43); //HP5, MP5, Attack Speed

        God nike = new God(getString(R.string.nike), getString(R.string.nike_title), "nike", R.drawable.nike,
                "Greek", R.drawable.icon_greek, "Warrior", R.drawable.icon_warrior, 'P',
                2070, 980, 77, 75, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 12.4, 1.24); //HP5, MP5, Attack Speed

        God nox = new God(getString(R.string.nox), getString(R.string.nox_title), "nox", R.drawable.nox,
                "Roman", R.drawable.icon_roman, "Mage", R.drawable.icon_mage, 'M',
                1865, 1010, 64, 70, 30, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                20.0, 13.0, 1.16); //HP5, MP5, Attack Speed

        God nuWa = new God(getString(R.string.nu_wa), getString(R.string.nu_wa_title), "nu_wa", R.drawable.nu_wa,
                "Chinese", R.drawable.icon_chinese, "Mage", R.drawable.icon_mage, 'M',
                1900, 1125, 65, 63, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.0, 13.2, 1.34); //HP5, MP5, Attack Speed

        God odin = new God(getString(R.string.odin), getString(R.string.odin_title), "odin", R.drawable.odin,
                "Norse", R.drawable.icon_norse, "Warrior", R.drawable.icon_warrior, 'P',
                2060, 900, 78, 76, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.6, 12.1, 1.22); //HP5, MP5, Attack Speed

        God osiris = new God(getString(R.string.osiris), getString(R.string.osiris_title), "osiris", R.drawable.osiris,
                "Egyptian", R.drawable.icon_egyptian, "Warrior", R.drawable.icon_warrior, 'P',
                2175, 1030, 84, 77, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.0, 12.5, 1.28); //HP5, MP5, Attack Speed

        God poseidon = new God(getString(R.string.poseidon), getString(R.string.poseidon_title), "poseidon", R.drawable.poseidon,
                "Greek", R.drawable.icon_greek, "Mage", R.drawable.icon_mage, 'M',
                1720, 1045, 65, 52, 30, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.0, 12.6, 1.08); //HP5, MP5, Attack Speed

        God ra = new God(getString(R.string.ra), getString(R.string.ra_title), "ra", R.drawable.ra,
                "Chinese", R.drawable.icon_chinese, "Mage", R.drawable.icon_mage, 'M',
                1745, 1215, 64, 60, 30, 350, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.6, 13.6, 1.06); //HP5, MP5, Attack Speed

        God raijin = new God(getString(R.string.raijin), getString(R.string.raijin_title), "raijin", R.drawable.raijin,
                "Japanese", R.drawable.icon_japanese, "Mage", R.drawable.icon_mage, 'M',
                1985, 1115, 64, 71, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 13.8, 1.03); //HP5, MP5, Attack Speed

        God rama = new God(getString(R.string.rama), getString(R.string.rama_title), "rama", R.drawable.rama,
                "Hindu", R.drawable.icon_hindu, "Hunter", R.drawable.icon_hunter, 'P',
                1980, 885, 90, 68, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.0, 9.5, 1.27); //HP5, MP5, Attack Speed

        God ratatoskr = new God(getString(R.string.ratatoskr), getString(R.string.ratatoskr_title), "ratatoskr", R.drawable.ratatoskr,
                "Norse", R.drawable.icon_norse, "Assassin", R.drawable.icon_assassin, 'R',
                1880, 1060, 84, 72, 48, 450, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 13.8, 1.40); //HP5, MP5, Attack Speed

        God ravana = new God(getString(R.string.ravana), getString(R.string.ravana_title), "ravana", R.drawable.ravana,
                "Hindu", R.drawable.icon_hindu, "Warrior", R.drawable.icon_warrior, 'P',
                2110, 970, 75, 74, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                19.6, 12.8, 1.20); //HP5, MP5, Attack Speed

        God scylla = new God(getString(R.string.scylla), getString(R.string.scylla_title), "scylla", R.drawable.scylla,
                "Greek", R.drawable.icon_greek, "Mage", R.drawable.icon_mage, 'M',
                1725, 1418, 63, 61, 30, 350, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 12.9, 1.16); //HP5, MP5, Attack Speed

        God serqet = new God(getString(R.string.serqet), getString(R.string.serqet_title), "serqet", R.drawable.serqet,
                "Egyptian", R.drawable.icon_egyptian, "Assassin", R.drawable.icon_assassin, 'P',
                1880, 1040, 84, 72, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 10.1, 1.43); //HP5, MP5, Attack Speed

        God skadi = new God(getString(R.string.skadi), getString(R.string.skadi_title), "skadi", R.drawable.skadi,
                "Norse", R.drawable.icon_norse, "Hunter", R.drawable.icon_hunter, 'P',
                2030, 920, 85, 67, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.8, 10.9, 1.19); //HP5, MP5, Attack Speed

        God sobek = new God(getString(R.string.sobek), getString(R.string.sobek_title), "sobek", R.drawable.sobek,
                "Egyptian", R.drawable.icon_egyptian, "Guardian", R.drawable.icon_guardian, 'M',
                2110, 910, 68, 79, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.0, 13.1, 1.09); //HP5, MP5, Attack Speed

        God sol = new God(getString(R.string.sol), getString(R.string.sol_title), "sol", R.drawable.sol,
                "Norse", R.drawable.icon_norse, "Mage", R.drawable.icon_mage, 'M',
                1900, 1440, 63, 61, 30, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 12.9, 1.36); //HP5, MP5, Attack Speed

        God sunWukong = new God(getString(R.string.sun_wukong), getString(R.string.sun_wukong_title), "sun_wukong", R.drawable.sun_wukong,
                "Chinese", R.drawable.icon_chinese, "Warrior", R.drawable.icon_warrior, 'P',
                2110, 905, 79, 78, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 11.9, 1.18); //HP5, MP5, Attack Speed

        God susano = new God(getString(R.string.susano), getString(R.string.susano_title), "susano", R.drawable.susano,
                "Japanese", R.drawable.icon_japanese, "Assassin", R.drawable.icon_assassin, 'P',
                1955, 985, 82, 72, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                23.0, 9.6, 1.43); //HP5, MP5, Attack Speed

        God sylvanus = new God(getString(R.string.sylvanus), getString(R.string.sylvanus_title), "sylvanus", R.drawable.sylvanus,
                "Roman", R.drawable.icon_roman, "Guardian", R.drawable.icon_guardian, 'M',
                2310, 870, 65, 79, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.6, 0.95); //HP5, MP5, Attack Speed

        God terra = new God(getString(R.string.terra), getString(R.string.terra_title), "terra", R.drawable.terra,
                "Roman", R.drawable.icon_roman, "Guardian", R.drawable.icon_guardian, 'M',
                2400, 900, 69, 84, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.6, 1.15); //HP5, MP5, Attack Speed

        God thanatos = new God(getString(R.string.thanatos), getString(R.string.thanatos_title), "thanatos", R.drawable.thanatos,
                "Greek", R.drawable.icon_greek, "Assassin", R.drawable.icon_assassin, 'P',
                1890, 1000, 85, 72, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.4, 12.0, 1.34); //HP5, MP5, Attack Speed

        God theMorrigan = new God(getString(R.string.the_morrigan), getString(R.string.the_morrigan_title), "the_morrigan", R.drawable.the_morrigan,
                "Celtic", R.drawable.icon_celtic, "Mage", R.drawable.icon_mage, 'M',
                1900, 1010, 82, 72, 30, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                24.0, 12.5, 1.04); //HP5, MP5, Attack Speed

        God thor = new God(getString(R.string.thor), getString(R.string.thor_title), "thor", R.drawable.thor,
                "Norse", R.drawable.icon_norse, "Assassin", R.drawable.icon_assassin, 'P',
                1995, 1000, 87, 72, 48, 370, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.8, 10.2, 1.29); //HP5, MP5, Attack Speed

        God thoth = new God(getString(R.string.thoth), getString(R.string.thoth_title), "thoth", R.drawable.thoth,
                "Egyptian", R.drawable.icon_egyptian, "Mage", R.drawable.icon_mage, 'M',
                1865, 1225, 62, 61, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 13.4, 1.24); //HP5, MP5, Attack Speed

        God tyr = new God(getString(R.string.tyr), getString(R.string.tyr_title), "tyr", R.drawable.tyr,
                "Norse", R.drawable.icon_norse, "Warrior", R.drawable.icon_warrior, 'P',
                2075, 1030, 79, 75, 48, 375, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.4, 10.2, 1.18); //HP5, MP5, Attack Speed

        God ullr = new God(getString(R.string.ullr), getString(R.string.ullr_title), "ullr", R.drawable.ullr,
                "Norse", R.drawable.icon_norse, "Hunter", R.drawable.icon_hunter, 'P',
                2080, 1030, 86, 73, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                22.2, 12.0, 1.23); //HP5, MP5, Attack Speed

        God vamana = new God(getString(R.string.vamana), getString(R.string.vamana_title), "vamana", R.drawable.vamana,
                "Hindu", R.drawable.icon_hindu, "Warrior", R.drawable.icon_warrior, 'P',
                2180, 980, 92, 76, 48, 380, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                18.0, 12.9, 1.15); //HP5, MP5, Attack Speed

        God vulcan = new God(getString(R.string.vulcan), getString(R.string.vulcan_title), "vulcan", R.drawable.vulcan,
                "Roman", R.drawable.icon_roman, "Mage", R.drawable.icon_mage, 'M',
                1800, 1045, 64, 73, 30, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                16.6, 13.8, 1.10); //HP5, MP5, Attack Speed

        God xbalanque = new God(getString(R.string.xbalanque), getString(R.string.xbalanque_title), "xbalanque", R.drawable.xbalanque,
                "Mayan", R.drawable.icon_mayan, "Hunter", R.drawable.icon_hunter, 'P',
                1955, 960, 87, 70, 48, 365, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                21.6, 12.4, 1.14); //HP5, MP5, Attack Speed

        God xingTian = new God(getString(R.string.xing_tian), getString(R.string.xing_tian_title), "xing_tian", R.drawable.xing_tian,
                "Chinese", R.drawable.icon_chinese, "Guardian", R.drawable.icon_guardian, 'M',
                2295, 1000, 66, 89, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.8, 13.5, 1.12); //HP5, MP5, Attack Speed

        God ymir = new God(getString(R.string.ymir), getString(R.string.ymir_title), "ymir", R.drawable.ymir,
                "Norse", R.drawable.icon_norse, "Guardian", R.drawable.icon_guardian, 'M',
                2590, 840, 69, 89, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                26.0, 12.5, 1.05); //HP5, MP5, Attack Speed

        God zeus = new God(getString(R.string.zeus), getString(R.string.zeus_title), "zeus", R.drawable.zeus,
                "Greek", R.drawable.icon_greek, "Mage", R.drawable.icon_mage, 'M',
                1800, 1125, 65, 62, 30, 355, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                15.0, 13.6, 1.04); //HP5, MP5, Attack Speed

        God zhongKui = new God(getString(R.string.zhong_kui), getString(R.string.zhong_kui_title), "zhong_kui", R.drawable.zhong_kui,
                "Chinese", R.drawable.icon_chinese, "Mage", R.drawable.icon_mage, 'M',
                2150, 1190, 63, 60, 48, 360, //Health, Mana, Damage, Physical Protections, Magical Protections, Speed
                14.8, 13.8, 1.03); //HP5, MP5, Attack Speed

        ArrayList<God> gods = new ArrayList<God>();
        gods.add(agni);
        gods.add(ahMuzenCab);
        gods.add(ahPuch);
        gods.add(amaterasu);
        gods.add(anhur);
        gods.add(anubis);
        gods.add(aoKuang);
        gods.add(aphrodite);
        gods.add(apollo);
        gods.add(arachne);
        gods.add(ares);
        gods.add(artemis);
        gods.add(athena);
        gods.add(awilix);
        gods.add(bacchus);
        gods.add(bakasura);
        gods.add(bastet);
        gods.add(bellona);
        gods.add(cabrakan);
        gods.add(camazotz);
        gods.add(cernunnos);
        gods.add(chaac);
        gods.add(change);
        gods.add(chiron);
        gods.add(chronos);
        gods.add(cupid);
        gods.add(erlangShen);
        gods.add(fafnir);
        gods.add(fenrir);
        gods.add(freya);
        gods.add(geb);
        gods.add(guanYu);
        gods.add(hades);
        gods.add(heBo);
        gods.add(hel);
        gods.add(hercules);
        gods.add(houYi);
        gods.add(hunBatz);
        gods.add(isis);
        gods.add(izanami);
        gods.add(janus);
        gods.add(jingWei);
        gods.add(kali);
        gods.add(khepri);
        gods.add(kukulkan);
        gods.add(kumbhakarna);
        gods.add(kuzenbo);
        gods.add(loki);
        gods.add(medusa);
        gods.add(mercury);
        gods.add(neZha);
        gods.add(neith);
        gods.add(nemesis);
        gods.add(nike);
        gods.add(nox);
        gods.add(nuWa);
        gods.add(odin);
        gods.add(osiris);
        gods.add(poseidon);
        gods.add(ra);
        gods.add(raijin);
        gods.add(rama);
        gods.add(ratatoskr);
        gods.add(ravana);
        gods.add(scylla);
        gods.add(serqet);
        gods.add(skadi);
        gods.add(sobek);
        gods.add(sol);
        gods.add(sunWukong);
        gods.add(susano);
        gods.add(sylvanus);
        gods.add(terra);
        gods.add(thanatos);
        gods.add(theMorrigan);
        gods.add(thor);
        gods.add(thoth);
        gods.add(tyr);
        gods.add(ullr);
        gods.add(vamana);
        gods.add(vulcan);
        gods.add(xbalanque);
        gods.add(xingTian);
        gods.add(ymir);
        gods.add(zeus);
        gods.add(zhongKui);

        this.gods = gods;
    }

    public void createItems() {

        //Common starters
        Item noStarter = new Item("No Starter", R.drawable.no_starter, 0, 'C', 'S',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                null);
        Item bumbasMask = new Item("Bumba's Mask", R.drawable.bumbas_mask, 500, 'C', 'S',
                50, 50, 0.0, 0.0, 0, 0, 0,       //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Your Basic Attacks deal +15 True Damage and your Abilities +15% Damage versus Jungle Camps. When a jungle monster is killed: only the closest ally god in assist range with Bumba's Mask will be healed for 15% of the monster's health, restored 25 Mana, and given and additional 4 gold.");
        Item rangdasMask = new Item("Rangda's Mask", R.drawable.rangdas_mask, 500, 'C', 'S',
                0, 0, 0.0, 5.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Each time you get an assist you gain a stack, or 2 for a kill. At 6 stacks this item provides 7% Movement Speed and 10% Cooldown Reduction. At 16 stacks this item provides 15 Penetration, 10% Movement Speed, and 15% Cooldown Reduction.");
        Item markOfTheVanguard = new Item("Mark of the Vanguard", R.drawable.mark_of_the_vanguard, 800, 'C', 'S',
                100, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                10, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "All damage taken is reduced by 5");
        Item swiftWing = new Item("Swift Wing", R.drawable.swift_wing, 800, 'C', 'S',
                100, 0, 10.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 5,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Whenever you leave the fountain, you gain 40% movespeed for 15s. You will lose this speed early if you enter combat.");
        Item watchersGift = new Item("Watcher's Gift", R.drawable.watchers_gift, 800, 'C', 'S',
                100, 0, 0.0, 5.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                5, 5, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Being within assist range of a minion or jungle camp monster death without dealing the killing blow awards 5 bonus gold, and also restores +12 Health and +10 Mana.");

        //Physical starters
        Item bluestonePendant = new Item("Bluestone Pendant", R.drawable.bluestone_pendant, 800, 'P', 'S',
                0, 100, 0.0, 5.0, 15, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemies hit by your damaging Abilities take an additional 30 Physical Damage over 2s. (Max 2 Stacks)");
        Item deathsToll = new Item("Death's Toll", R.drawable.deaths_toll, 800, 'P', 'S',
                100, 0, 0.0, 0.0, 10, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Hitting an enemy with a Basic Attack restores 8 Health and 3 Mana.");
        Item warFlag = new Item("War Flag", R.drawable.war_flag, 800, 'P', 'S',
                100, 0, 0.0, 5.0, 10, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Being in range of minion or jungle camp death without dealing the killing the blow restores 5 Health and 5 Mana to all allies within 55 units and also provides allies with a stacking self buff of 1% Movement Speed and 1% Attack Speed. Lasts 6s and stacks up to 10 times.");

        //Magical Starters
        Item sandsOfTime = new Item("Sands of Time", R.drawable.sands_of_time, 800, 'M', 'S',
                0, 0, 0.0, 5.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "You gain 2 MP5 per 10% of your missing Mana");
        Item soulStone = new Item("Soul Stone", R.drawable.soul_stone, 800, 'M', 'S',
                0, 100, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Gain 1 stack every time you hit an enemy with a basic attack. If you have 5 stacks, the next time you deal damage with an ability the stacks are consumed and you gain 40 mana, and that ability and any abilities used in the next 3s will deal bonus damage equal to having +40 Magical Power for those abilities.");
        Item vampiricShroud = new Item("Vampiric Shroud", R.drawable.vampiric_shroud, 800, 'M', 'S',
                100, 0, 0.0, 0.0, 20, 4, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Killing an enemy restores 10 Health and 8 Mana.");

        //Common Items
        Item noItem = new Item("", R.drawable.no_item, 0, 'C', 'I',
                0, 0 ,0.0, 0.0, 0 ,0 ,0,
                0 ,0 ,0.0 ,0,
                0 ,0 ,0,
                null);
        Item relicDagger = new Item("Relic Dagger", R.drawable.relic_dagger, 1850, 'C', 'I',
                200, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.1, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "Your relics receive 20% Cooldown Reduction.");
        Item wingedBlade = new Item("Winged Blade", R.drawable.winged_blade, 1850, 'C', 'I',
                300, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.1, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "When hit by a Slow, you are immune to Slows and your movement speed is increased by 20% for 4s. Only occurs once every 30 seconds.");
        Item oniHuntersGarb = new Item("Oni Hunter's Garb", R.drawable.oni_hunters_garb, 1900, 'C', 'I',
                0, 0, 0.0, 20.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 60, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "When you deal damage to an enemy god, if at least 2 other enemy gods are within 55 units of you, you gain 15% damage mitigation for 5s. Can only occur every 90s.");
        Item emperorsArmor = new Item("Emperor's Armor", R.drawable.emperors_armor, 2000, 'C', 'I',
                250, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                30, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Damageable enemy structures within 55 units have their Attack Speed decreased by 30%.\n" +
                        "Damageable allied structures within 55 units have their Attack Speed increased by 30%.");
        Item stoneOfGaia = new Item("Stone of Gaia", R.drawable.stone_of_gaia, 2000, 'C', 'I',
                400, 0, 25.0, 15.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "If you are hit by a Knockup, Knockback, Pull, or Grab you are instead enveloped by the Earth, becoming CC immune for 1s. Can only occur once every 90s.\n" +
                        "Regenerates 2% of your max. Health every 5 seconds.");
        Item magisBlessing = new Item("Magi's Blessing", R.drawable.magis_blessing, 2050, 'C', 'I',
                350, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                15, 15, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Absorb a single hard Crowd Control effect or Root once every 70 seconds. When this occurs, you also receive 1s of Crowd Control immunity.");
        Item witchblade = new Item("Witchblade", R.drawable.witchblade, 2050, 'C', 'I',
                200, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.15, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemies hit by your basic attacks are cursed, receiving 15% Reduced healing, stacking up to 3 times and lasting 5s.\n" +
                        "Enemy gods within 55 units have their Attack Speed reduced by 20%.");
        Item heartwardAmulet = new Item("Heartward Amulet", R.drawable.heartward_amulet, 2100, 'C', 'I',
                200, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 45, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Allied gods within 70 units have their Magical Protections increased by 20 and their MP5 increased by 20.");
        Item shieldOfRegrowth = new Item("Shield of Regrowth", R.drawable.shield_of_regrowth, 2100, 'C', 'I',
                200, 0, 10.0, 10.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 20, 0,                        //Crit Chance, CDR, CCR
                "After healing yourself from an ability, you gain +40% movement speed for 4 seconds. This cannot occur more than once every 10 seconds.");
        Item sovereignty = new Item("Sovereignty", R.drawable.sovereignty, 2100, 'C', 'I',
                200, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                30, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Allied gods within 70 units have their Physical Protections increased by 30 and their HP5 increased by 25.");
        Item spectralArmor = new Item("Spectral Armor", R.drawable.spectral_armor, 2100, 'C', 'I',
                0, 300, 0.0, 10.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                70, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "Anytime you receive Physical damage from a god, enemies within 30 units of you become feared for 1s. This effect cannot happen more than once every 90s.");
        Item gauntletOfThebes = new Item("Gauntlet of Thebes", R.drawable.gauntlet_of_thebes, 2150, 'C', 'I',
                400, 0, 15.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Allied gods within 75 units have their Magical and Physical Protections increased by 20.");
        Item pestilence = new Item("Pestilence", R.drawable.pestilence, 2150, 'C', 'I',
                200, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 80, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemy gods within 55 units have their healing reduced by 25%.");
        Item genjisGuard = new Item("Genji's Guard", R.drawable.genjis_guard, 2200, 'C', 'I',
                0, 0, 0.0, 20.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 70, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "When you take Magical Damage from Abilities your cooldowns are reduced by 2s. This can only occur once every 30s.");
        Item hideOfTheNemeanLion = new Item("Hide of the Nemean Lion", R.drawable.hide_of_the_nemean_lion, 2200, 'C', 'I',
                0, 200, 0.0, 20.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                80, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Reflects 25% of all Basic Attack damage back to the attacker as Physical Damage.");
        Item mailOfRenewal = new Item("Mail of Renewal", R.drawable.mail_of_renewal, 2250, 'C', 'I',
                400, 0, 10.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "You gain 15% of your maximum Health and Mana over the next 5 seconds when you get a kill or assist against an enemy god or Objective.");
        Item midgardianMail = new Item("Midgardian Mail", R.drawable.midgardian_mail, 2250, 'C', 'I',
                350, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                30, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "When hit by a Basic Attack, there is a 30% chance to slow your enemy's Movement Speed and Attack Speeds by 30% for 2 seconds.");
        Item breastplateOfValor = new Item("Breastplate of Valor", R.drawable.breastplate_of_valor, 2300, 'C', 'I',
                0, 300, 0.0, 10.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                65, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 20, 0,                        //Crit Chance, CDR, CCR
                null);
        Item hastenedFatalis = new Item("Hastened Fatalis", R.drawable.hastened_fatalis, 2300, 'C', 'I',
                0, 0, 0.0, 0.0, 0, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.2, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "When a Basic Attack hits a target, the attacking movement speed Debuff is removed from you for 1s.");
        Item hideOfTheUrchin = new Item("Hide of the Urchin", R.drawable.hide_of_the_urchin, 2350, 'C', 'I',
                250, 250, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                35, 35, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain +3 Magical Protection and +3 Physical Protection for each god kill or assist (max. 10 Stacks).");
        Item shogunsKusari = new Item("Shogun's Kusari", R.drawable.shoguns_kusari, 2400, 'C', 'I',
                0, 0, 0.0, 20.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 80, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 20,                        //Crit Chance, CDR, CCR
                "Allied gods within 70 units have their Attack Speed increased by 15%.");
        Item spiritRobe = new Item("Spirit Robe", R.drawable.spirit_robe, 2500, 'C', 'I',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                40, 40, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 20,                        //Crit Chance, CDR, CCR
                "You gain an additional 15% Damage Mitigation for 3s whenever you are hit with a hard Crowd Control Effect. This can only occur once every 15 seconds.");
        Item bulwarkOfHope = new Item("Bulwark of Hope", R.drawable.bulwark_of_hope, 2550, 'C', 'I',
                200, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 60, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "When you take damage and are below 30% Health, you gain a Shield with health equal to 150 +10 Per Player Level for 20s. Can only occur once every 60s.");
        Item mysticalMail = new Item("Mystical Mail", R.drawable.mystical_mail, 2700, 'C', 'I',
                300, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                40, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "All enemies within 25 units are dealt 40 Magical Damage per second.");
        Item mantleOfDiscord = new Item("Mantle of Discord", R.drawable.mantle_of_discord, 2900, 'C', 'I',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                60, 60, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "If you take damage below 30% health you unleash a shockwave that stuns all enemies within a range of 20 units for 1s and gain CC immunity for 1s. This effect cannot trigger more than once every 90s.");

        //Physical Items
        Item reinforcedGreaves = new Item("Reinforced Greaves", R.drawable.reinforced_greaves, 1400, 'P', 'I',
                75, 0, 0.0, 0.0, 10, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "Every time you are damaged by a god you gain a stack that provides 3 Physical and Magical Protections. Stacks up to 6 times, Lasts 6s.");
        Item talariaBoots = new Item("Talaria Boots", R.drawable.talaria_boots, 1400, 'P', 'I',
                0, 0, 0.0, 0.0, 15, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain +14% additional Movement Speed and +25 HP5 while out of combat. Each time you damage an enemy god you earn +30 Gold. This cannot occur on the same god more than once every 90s.");
        Item ninjaTabi = new Item("Ninja Tabi", R.drawable.ninja_tabi, 1500, 'P', 'I',
                0, 100, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.2, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                null);
        Item warriorTabi = new Item("Warrior Tabi", R.drawable.warrior_tabi, 1550, 'P', 'I',
                0, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                null);
        Item ancile = new Item("Ancile", R.drawable.ancile, 2000, 'P', 'I',
                0, 0, 0.0, 0.0, 25, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 60, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "Whenever you take Magical Damage from an enemy ability you unleash a shockwave that Silences all enemies within a range of 30 units for 1s. This effect cannot trigger more than once every 30s.");
        Item runeforgedHammer = new Item("Runeforged Hammer", R.drawable.runeforged_hammer, 2000, 'P', 'I',
                200, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemies take 10% Bonus damage from you if they are affected by Crowd Control. Does not include Knockbacks, Blinds, or Grabs.");
        Item devourersGauntlet = new Item("Devourer's Gauntlet", R.drawable.devourers_gauntlet, 2050, 'P', 'I',
                0, 0, 0.0, 0.0, 25, 10, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You permanently gain +.4 Physical Power and +.20% Physical Lifesteal per Stack, and receive 5 Stacks per god kill and 1 Stack per minion kill. (Max. 75 Stacks).");
        Item odysseusBow = new Item("Odysseus' Bow", R.drawable.odysseus_bow, 2100, 'P', 'I',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.4, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Every fourth Basic Attack triggers a chain lightning, damaging the target and up to 4 nearby enemies for 30 damage +50% of your total Basic Attack Power.");
        Item hydrasLament = new Item("Hydra's Lament", R.drawable.hydras_lament, 2150, 'P', 'I',
                0, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "For 8s after using an ability, your next Basic Attack will deal an additional 30% damage.\n" +
                        "This item grants 2.5 MP5 per 10% of your missing Mana.");
        Item runicShield = new Item("Runic Shield", R.drawable.runic_shield, 2150, 'P', 'I',
                0, 0, 0.0, 0.0, 35, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 50, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemy gods within 55 units have their Magical Power reduced by 50.");
        Item brawlersBeatStick = new Item("Brawler's Beat Stick", R.drawable.brawlers_beat_stick, 2200, 'P', 'I',
                0, 0, 0.0, 0.0, 40, 0, 15,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemies hit by your Abilities have 40% reduced healing and regeneration for 8 seconds.");
        Item rage = new Item("Rage", R.drawable.rage, 2200, 'P', 'I',
                0, 0, 0.0, 0.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                20, 0, 0,                        //Crit Chance, CDR, CCR
                "Earning a kill or assist fills you with rage, increasing your Critical Strike Chance by 20%. This buff can stack up to 3 times and lasts 8s.");
        Item soulEater = new Item("Soul Eater", R.drawable.soul_eater, 2200, 'P', 'I',
                0, 200, 0.0, 0.0, 0, 20, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "Successfully hitting an Enemy god with a Basic Attack restores 2% of your maximum health per hit.");
        Item theExecutioner = new Item("The Executioner", R.drawable.the_executioner, 2250, 'P', 'I',
                0, 0, 0.0, 0.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.25, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Basic Attacks against an enemy reduce your target's Physical Protection by 12% for 3 seconds (max. 3 Stacks).");
        Item blackthornHammer = new Item("Blackthorn Hammer", R.drawable.blackthorn_hammer, 2300, 'P', 'I',
                200, 200, 0.0, 0.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "If you are reduced to below 30% HP then 3s are substracted from all abilities currently on cooldown and all of your abilities cost 0 Mana to cast for the next 5s. This effect can only be activated once every 60s.");
        Item frostboundHammer = new Item("Frostbound Hammer", R.drawable.frostbound_hammer, 2300, 'P', 'I',
                325, 0, 0.0, 0.0, 25, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemies hit by your Basic Attacks have their Movement Speed reduced by 30% and have their Attack Speed reduced 15% for 1.25 seconds.");
        Item theCrusher = new Item("The Crusher", R.drawable.the_crusher, 2300, 'P', 'I',
                0, 0, 0.0, 0.0, 30, 0, 15,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.15, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Successfully hitting an enemy god with a basic attack will subtract 1s from all your abilities currently on cooldown. This effect can only occur once every 5s.");
        Item titansBane = new Item("Titan's Bane", R.drawable.titans_bane, 2300, 'P', 'I',
                0, 0, 0.0, 0.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain +33% Physical Penetration.");
        Item heartseeker = new Item("Heartseeker", R.drawable.heartseeker, 2400, 'P', 'I',
                0, 0, 0.0, 0.0, 25, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Every successful basic attack gives you 1 stack. At 5 stacks, your next ability deals bonus damage equal to 100% of your physical power to the first enemy god hit.");
        Item poisonedStar = new Item("Poisoned Star", R.drawable.poisoned_star, 2400, 'P', 'I',
                0, 0, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.15, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                15, 0, 0,                        //Crit Chance, CDR, CCR
                "Critical hits on enemy gods afflict them with poison for 2s. This poison slows them by 20% and reduces their damage output by 20%.");
        Item shiftersShield = new Item("Shifter's Shield", R.drawable.shifters_shield, 2400, 'P', 'I',
                0, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                20, 20, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "While over 50% Health, you gain +20 Physical Power. While under 50% Health, you gain +20 Protections.");
        Item jotunnsWrath = new Item("Jotunn's Wrath", R.drawable.jotunns_wrath, 2450, 'P', 'I',
                0, 150, 0.0, 0.0, 40, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 20, 0,                        //Crit Chance, CDR, CCR
                null);
        Item masamune = new Item("Masamune", R.drawable.masamune, 2500, 'P', 'I',
                100, 0, 0.0, 0.0, 50, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "For each enemy god within 55 units of you, you gain a stacking buff that provides 7 Magical Protection and 7 Physical Protection. Stacks up to 5 times.");
        Item stoneCuttingSword = new Item("Stone Cutting Sword", R.drawable.stone_cutting_sword, 2600, 'P', 'I',
                0, 0, 0.0, 0.0, 50, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Melee Basic Attacks decreases enemy Physical protections by 10, and increase your physical protection by 10 for 3s (max. 3 Stacks).");
        Item transcendence = new Item("Transcendence", R.drawable.transcendence, 2600, 'P', 'I',
                0, 300, 0.0, 6.0, 35, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You permanently gain 15 Mana per Stack, and receive 5 Stacks for a god kill, and 1 Stack for a minion kill (max. 50 stacks). Additionally, 3% of your Mana is converted to Physical Power.");
        Item qinsSais = new Item("Qin's Sais", R.drawable.qins_sais, 2700, 'P', 'I',
                0, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.15, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "On Basic Attack hits, deal Physical Damage equal to 4% of the target's maximum Health. This only affects gods.");
        Item voidShield = new Item("Void Shield", R.drawable.void_shield, 2700, 'P', 'I',
                0, 0, 0.0, 0.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                40, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemy gods within 55 units have their Physical Protection reduced by 20.");
        Item windDemon = new Item("Wind Demon", R.drawable.wind_demon, 2800, 'P', 'I',
                0, 0, 0.0, 0.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.1, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                20, 0, 0,                        //Crit Chance, CDR, CCR
                "Your Critical Hits increase your Attack Speed and Movement Speed by 20% for 5s.");
        Item bloodforge = new Item("Bloodforge", R.drawable.bloodforge, 2850, 'P', 'I',
                0, 0, 0.0, 0.0, 75, 15, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Killing an enemy god forges a shield from their blood with Health equal to 200 + 10 per Player Level for 20s. While the Blood Shield is active you gain +10% movement speed.");
        Item malice = new Item("Malice", R.drawable.malice, 3000, 'P', 'I',
                0, 0, 0.0, 0.0, 50, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                20, 0, 0,                        //Crit Chance, CDR, CCR
                "When you deal a Critical Strike, you deal an additional +75% of your total Physical Power as Physical Damage over the next 3s. Additional crits refresh this effect.");
        Item deathbringer = new Item("Deathbringer", R.drawable.deathbringer, 3200, 'P', 'I',
                0, 0, 0.0, 0.0, 50, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                20, 0, 0,                        //Crit Chance, CDR, CCR
                "Critical Strike damage is increased by 40%.");
        Item gladiatorsShield = new Item("Gladiator's Shield", R.drawable.gladiators_shield, 1700, 'P', 'I',
                0, 0, 0.0, 0.0, 15, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                40, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "Anytime you hit an Enemy god with an ability you are healed for 2% of your maximum Health and Mana. This can only trigger once per ability.");
        Item ichaival = new Item("Ichaival", R.drawable.ichaival, 1700, 'P', 'I',
                0, 0, 0.0, 0.0, 0, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.3, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Every successful Basic Attack increases your Physical Power by 10 and reduces your target's Physical Power from items by 10, for 3s. (Max. 3 Stacks)");
        Item silverbranchBow = new Item("Silverbranch Bow", R.drawable.silverbranch_bow, 1700, 'P', 'I',
                0, 0, 0.0, 0.0, 0, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.3, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Every successful Basic Attack increases your Physical Power by 10 and reduces your target's Magical Power from items by 15, for 3s. (Max 3 Stacks)");
        Item asi = new Item("Asi", R.drawable.asi, 1750, 'P', 'I',
                0, 0, 0.0, 0.0, 0, 15, 15,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.2, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "If you drop below 35% Health, you gain an additional 25% Physical Lifesteal for 5 seconds. Can only occur once every 15 seconds.");

        //Magical Items
        Item dynastyPlateHelm = new Item("Dynasty Plate Helm", R.drawable.dynasty_plate_helm, 1700, 'M', 'I',
                0, 0, 0.0, 0.0, 45, 0, 15,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                30, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                null);
        Item stoneOfBinding = new Item("Stone of Binding", R.drawable.stone_of_binding, 1700, 'M', 'I',
                0, 0, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                30, 30, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Successfully hitting an enemy god with hard Crowd Control will place a buff on all allies within 70 units of you. The buff provides 10 Penetration for 5s.");
        Item doomOrb = new Item("Doom Orb", R.drawable.doom_orb, 2050, 'M', 'I',
                0, 200, 0.0, 7.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain +2 Magical Power per stack, and receive 5 stacks per god kill and 1 stack per minion kill. Half of your stacks are lost on death. (Max 50 stacks).");
        Item reinforcedShoes = new Item("Reinforced Shoes", R.drawable.reinforced_shoes, 1400, 'M', 'I',
                75, 0, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "Every time you are damaged by a god you gain a stack that provides 3 Physical and Magical Protections. Stacks up to 6 times, Lasts 6s.");
        Item travelersShoes = new Item("Travelers Shoes", R.drawable.travelers_shoes, 1400, 'M', 'I',
                0, 0, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain +14% additional Movement Speed and +25 HP5 while out of combat. Each time you damage an enemy god you earn +30 Gold. This cannot occur on the same god more than once every 90s.");
        Item shoesOfFocus = new Item("Shoes of Focus", R.drawable.shoes_of_focus, 1500, 'M', 'I',
                0, 250, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                null);
        Item shoesOfTheMagi = new Item("Shoes of the Magi", R.drawable.shoes_of_the_magi, 1600, 'M', 'I',
                0, 0, 0.0, 0.0, 45, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 18,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                null);
        Item celestialLegionHelm = new Item("Celestian Legion Helm", R.drawable.celestial_legion_helm, 2050, 'M', 'I',
                0, 0, 0.0, 20.0, 60, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                30, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Any god affected by your ability heals gains 20 Increased Physical and Magical Power for 5 seconds.");
        Item lotusCrown = new Item("Lotus Crown", R.drawable.lotus_crown, 2050, 'M', 'I',
                0, 0, 0.0, 20.0, 30, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                60, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Any god affected by your ability heals gains 20 increased Physical and Magical Protection for 5 seconds. Cannot activate on the same target again for 10s.");
        Item jadeEmperorsCrown = new Item("Jade Emperor's Crown", R.drawable.jade_emperors_crown, 2150, 'M', 'I',
                100, 0, 0.0, 0.0, 20, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                60, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemy gods within 55 units have their Physical Power reduced by 30.");
        Item spearOfTheMagus = new Item("Spear of the Magus", R.drawable.spear_of_the_magus, 2150, 'M', 'I',
                0, 0, 0.0, 0.0, 50, 0, 15,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Your abilities reduce your target's Magical Protection by 10 for 5 seconds (max. 5 Stacks).");
        Item voidStone = new Item("Void Stone", R.drawable.void_stone, 2150, 'M', 'I',
                0, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 70, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemy gods within 55 units have their Magical Protection reduced by 20.");
        Item bancroftsTalon = new Item("Bancroft's Talon", R.drawable.bancrofts_talon, 2300, 'M', 'I',
                0, 0, 0.0, 0.0, 100, 20, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain additional Magical Power and Lifesteal scaled from missing Health. This caps at 100 power and 15% Lifesteal at 25% Health.");
        Item demonicGrip = new Item("Demonic Grip", R.drawable.demonic_grip, 2300, 'M', 'I',
                0, 0, 0.0, 0.0, 60, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.2, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Your Basic Attacks reduce your target's Magical Protection by 12% for 3s (max 3 Stacks).");
        Item obsidianShard = new Item("Obsidian Shard", R.drawable.obsidian_shard, 2300, 'M', 'I',
                0, 0, 0.0, 0.0, 60, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You gain +33% Magical Penetration.");
        Item polynomicon = new Item("Polynomicon", R.drawable.polynomicon, 2300, 'M', 'I',
                0, 300, 0.0, 0.0, 75, 12, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using an ability gives your next Basic Attack within the next 8 seconds +75% of your Magical Power as additional Magical Damage. The effect can only apply once every 3 seconds.");
        Item pythagoremsPiece = new Item("Pythagorem's Piece", R.drawable.pythagorems_piece, 2300, 'M', 'I',
                0, 200, 0.0, 0.0, 40, 12, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "Allied gods within 70 units have their Magical Lifesteal increased by 12% and their Magical Power increased by 30 or their Physical Lifesteal increased by 10% and their Physical Power increased by 20.");
        Item divineRuin = new Item("Divine Ruin", R.drawable.divine_ruin, 2400, 'M', 'I',
                0, 0, 0.0, 0.0, 80, 0, 10,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Enemies hit by your abilities have 40% reduced healing and regeneration for 8 seconds.");
        Item shamansRing = new Item("Shaman's Ring", R.drawable.shamans_ring, 2400, 'M', 'I',
                0, 0, 0.0, 0.0, 40, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.3, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Each basic attack that hits an enemy god heals you for 2% of your maximum Health and Mana per hit.");
        Item rodOfAsclepius = new Item("Rod of Asclepius", R.drawable.rod_of_asclepius, 2600, 'M', 'I',
                250, 0, 0.0, 0.0, 75, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 10,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Allied gods within 70 units have their Healing increased by 10%. If you are in combat, their Healing is increased by an additional 20%");
        Item spearOfDesolation = new Item("Spear of Desolation", R.drawable.spear_of_desolation, 2600, 'M', 'I',
                0, 0, 0.0, 0.0, 80, 0, 20,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "If you receive a kill or assist on an Enemy God all of your cooldowns are reduced by 1 second.");
        Item bookOfThoth = new Item("Book of Thoth", R.drawable.book_of_thoth, 2650, 'M', 'I',
                0, 125, 0.0, 15.0, 100, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You permanently gain 10 Mana per Stack, and receive 5 Stacks for a god kill and 1 Stack for a minion kill (max. 75 Stacks). Additionally, 3% of your Mana is converted to Magical Power.");
        Item warlocksSash = new Item("Warlock's Sash", R.drawable.warlocks_sash, 2650, 'M', 'I',
                300, 400, 0.0, 0.0, 50, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "You permanently gain +3 Health and +.6 Magical Power per Stack, and receive 5 Stacks for a god kill and 1 Stack per minion kill. (Max. 100 Stacks)");
        Item etherealStaff = new Item("Ethereal Staff", R.drawable.ethereal_staff, 2700, 'M', 'I',
                200, 0, 0.0, 0.0, 90, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 20,                        //Crit Chance, CDR, CCR
                "Your abilities deal bonus Magical damage to enemy gods equal to 5% of their max Health. This effect can only happen once every 10s.");
        Item gemOfIsolation = new Item("Gem of Isolation", R.drawable.gem_of_isolation, 2700, 'M', 'I',
                250, 0, 0.0, 0.0, 90, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 10,                        //Crit Chance, CDR, CCR
                "Enemies hit by your damaging abilities will move 25% Slower for 2 seconds.");
        Item bookOfTheDead = new Item("Book of the Dead", R.drawable.book_of_the_dead, 2800, 'M', 'I',
                200, 0, 0.0, 0.0, 100, 20, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Healing from Magical Lifesteal can continue to affect you at max Health and is converted to a Health Shield. This Shield caps at 20% of your current HP. This shield has no duration.");
        Item telkhinesRing = new Item("Telkhines Ring", R.drawable.telkhines_ring, 2800, 'M', 'I',
                0, 0, 0.0, 0.0, 80, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.2, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Successfully hitting enemies or structures with basic attacks gives you a stacking Magical Power buff of 10 per stack. Stacks up to 5 times, Stacks last 5s.");
        Item chronosPendant = new Item("Chronos' Pendant", R.drawable.chronos_pendant, 2900, 'M', 'I',
                0, 0, 0.0, 25.0, 60, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 20, 0,                        //Crit Chance, CDR, CCR
                "Every 10s the Pendant activates, subtracting 1s from all of your abilities currently on Cooldown. The initial countdown will not start until you leave the fountain.");
        Item stoneOfFal = new Item("Stone of Fal", R.drawable.stone_of_fal, 2900, 'M', 'I',
                0, 0, 0.0, 0.0, 70, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 40, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 10, 0,                        //Crit Chance, CDR, CCR
                "Anytime you would be dealt more than 30% of your Max Health by a single Magical ability, that damage is instead reduced to deal exactly 30% of your max Health. This effect can only occur once every 60s.");
        Item soulReaver = new Item("Soul Reaver", R.drawable.soul_reaver, 2950, 'M', 'I',
                0, 300, 0.0, 0.0, 100, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "When a god takes damage from your abilities, they take 10% of their maximum Health in additional True damage. If multiple gods are hit, the damage is applied to the one with the greatest maximum Health. This can only occur once every 40 seconds.");
        Item rodOfTahuti = new Item("Rod of Tahuti", R.drawable.rod_of_tahuti, 3300, 'M', 'I',
                0, 0, 0.0, 30.0, 125, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Increases Magical Power by 25%.");

        //Relics
        Item aegisAmulet = new Item("Aegis Amulet", R.drawable.aegis_amulet, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item makes you invulnerable to damage and healing for 2s, preventing you from taking actions. You may still move. (Cooldown 160s)");
        Item blinkRune = new Item("Blink Rune", R.drawable.blink_rune, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item will allow you to teleport up to 55 units away instantly. You have to be Out of Combat for 3s before you can use this. (Cooldown 120s)");
        Item bracerOfUndoing = new Item("Bracer of Undoing", R.drawable.bracer_of_undoing, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item subtracts 3s from all abilities currently on Cooldown and restores 50% Health and Mana lost within the last 3s. (Cooldown 120s)");
        Item cursedAnkh = new Item("Cursed Ankh", R.drawable.cursed_ankh, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item reduces the Healing received by all enemy gods within 55 units by 50% for 10s. (Cooldown 150s)");
        Item handOfTheGods = new Item("Hand of the Gods", R.drawable.hand_of_the_gods, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item deals 300 + 10 per God Level damage to a single enemy minion, jungle monster or jungle boss within 15 units. The target will be the one with the highest maximum health. The relic's Cooldown will be reduced by 30s if you kill a jungle mob with it. (Cooldown 120s)");
        Item heavenlyWings = new Item("Heavenly Wings", R.drawable.heavenly_wings, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item increases the Movement Speed of allied gods within 55 units by 40% for 5s and cleanses them of Slows. (Cooldown 150s)");
        Item horrificEmblem = new Item("Horrific Emblem", R.drawable.horrific_emblem, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item Slows the Movement Speed of all enemy gods within 35 units by 40% for 5s. Their Attack Speed is also reduced by 25% for the duration. (Cooldown 150s)");
        Item magicShell = new Item("Magic Shell", R.drawable.magic_shell, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item increases the Magical and Physical Protections of allied gods within 35 units by 30 for 5 seconds. Also, all damage taken is reduced by 5%. (Cooldown 140s)");
        Item meditationCloak = new Item("Meditation Cloak", R.drawable.meditation_cloak, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item restores 15% of your maximum Health and 35% of your maximum Mana. Allied gods within 35 units are also restored. (Cooldown 120s)");
        Item phantomVeil = new Item("Phantom Veil", R.drawable.phantom_veil, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item allows you and allied gods within 35 units to pass through players and player made objects for 5s. It also grants 40% Crowd Control and Knockup Immunity for the duration. (Cooldown 180s)");
        Item purificationBeads = new Item("Purification Beads", R.drawable.purification_beads, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item removes Crowd Control Effects and makes you immune to new ones for 2s. (Cooldown 160s)");
        Item shieldOfThorns = new Item("Shield of Thorns", R.drawable.shield_of_thorns, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item reflects 50% of all damage you take, before mitigations, for the next 5s, back to its owner as Magical Damage. (Cooldown 120s)");
        Item sunderingSpear = new Item("Sundering Spear", R.drawable.sundering_spear, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item fires a bolt that travels 70 units, stopping on the first god hit, dealing 40 True Damage + 14 Damage per God level, and increases their damage taken by 15% for 5s. (Cooldown 120s)");
        Item teleportGlyph = new Item("Teleport Glyph", R.drawable.teleport_glyph, 0, 'C', 'R',
                0, 0, 0.0, 0.0, 0, 0, 0,        //Health, Mana, HP5, MP5, Damage, Lifesteal, Penetration
                0, 0, 0.0, 0,                   //Physical Prots, Magical Prots, Attack Speed, Speed
                0, 0, 0,                        //Crit Chance, CDR, CCR
                "Using this item allows you to teleport to any allied tower or ward while Rooted in place. This effect is not interrupted by damage but is interrupted by hard Crowd Control. (Cooldown 120s)");


        ArrayList<Item> starterCommon = new ArrayList<Item>();
        ArrayList<Item> starterPhys = new ArrayList<Item>();
        ArrayList<Item> starterMag = new ArrayList<Item>();

        ArrayList<Item> starterPhysCommon = new ArrayList<Item>();
        ArrayList<Item> starterMagCommon = new ArrayList<Item>();

        ArrayList<Item> itemsCommon = new ArrayList<Item>();
        ArrayList<Item> itemsPhys = new ArrayList<Item>();
        ArrayList<Item> itemsMag = new ArrayList<Item>();

        ArrayList<Item> itemsPhysCommon = new ArrayList<Item>();
        ArrayList<Item> itemsMagCommon = new ArrayList<Item>();

        ArrayList<Item> boots = new ArrayList<Item>();
        ArrayList<Item> shoes = new ArrayList<Item>();

        ArrayList<Item> relics = new ArrayList<Item>();
        ArrayList<Item> itemsSpecial = new ArrayList<Item>();
        ArrayList<Item> itemsAll = new ArrayList<Item>();

        starterCommon.add(bumbasMask);
        starterCommon.add(rangdasMask);
        starterCommon.add(markOfTheVanguard);
        starterCommon.add(swiftWing);
        starterCommon.add(watchersGift);
        starterCommon = sortItemsByName(starterCommon);
        this.starterCommon = starterCommon;

        starterPhys.add(bluestonePendant);
        starterPhys.add(deathsToll);
        starterPhys.add(warFlag);
        starterPhys = sortItemsByName(starterPhys);
        this.starterPhys = starterPhys;

        starterMag.add(sandsOfTime);
        starterMag.add(soulStone);
        starterMag.add(vampiricShroud);
        starterMag = sortItemsByName(starterMag);
        this.starterMag = starterMag;

        boots.add(reinforcedGreaves);
        boots.add(talariaBoots);
        boots.add(ninjaTabi);
        boots.add(warriorTabi);
        boots = sortItemsByName(boots);
        this.boots = boots;

        shoes.add(reinforcedShoes);
        shoes.add(travelersShoes);
        shoes.add(shoesOfFocus);
        shoes.add(shoesOfTheMagi);
        shoes = sortItemsByName(shoes);
        this.shoes = shoes;

        itemsCommon.add(relicDagger);
        itemsCommon.add(wingedBlade);
        itemsCommon.add(oniHuntersGarb);
        itemsCommon.add(emperorsArmor);
        itemsCommon.add(stoneOfGaia);
        itemsCommon.add(magisBlessing);
        itemsCommon.add(witchblade);
        itemsCommon.add(heartwardAmulet);
        itemsCommon.add(shieldOfRegrowth);
        itemsCommon.add(sovereignty);
        itemsCommon.add(spectralArmor);
        itemsCommon.add(gauntletOfThebes);
        itemsCommon.add(pestilence);
        itemsCommon.add(genjisGuard);
        itemsCommon.add(hideOfTheNemeanLion);
        itemsCommon.add(mailOfRenewal);
        itemsCommon.add(midgardianMail);
        itemsCommon.add(breastplateOfValor);
        itemsCommon.add(hastenedFatalis);
        itemsCommon.add(hideOfTheUrchin);
        itemsCommon.add(shogunsKusari);
        itemsCommon.add(spiritRobe);
        itemsCommon.add(bulwarkOfHope);
        itemsCommon.add(mysticalMail);
        itemsCommon.add(mantleOfDiscord);
        itemsCommon = sortItemsByName(itemsCommon);
        this.itemsCommon = itemsCommon;

        itemsPhys.add(gladiatorsShield);
        itemsPhys.add(ichaival);
        itemsPhys.add(silverbranchBow);
        itemsPhys.add(asi);
        itemsPhys.add(ancile);
        itemsPhys.add(runeforgedHammer);
        itemsPhys.add(devourersGauntlet);
        itemsPhys.add(hydrasLament);
        itemsPhys.add(runicShield);
        itemsPhys.add(brawlersBeatStick);
        itemsPhys.add(rage);
        itemsPhys.add(soulEater);
        itemsPhys.add(theExecutioner);
        itemsPhys.add(blackthornHammer);
        itemsPhys.add(frostboundHammer);
        itemsPhys.add(theCrusher);
        itemsPhys.add(titansBane);
        itemsPhys.add(heartseeker);
        itemsPhys.add(poisonedStar);
        itemsPhys.add(jotunnsWrath);
        itemsPhys.add(shiftersShield);
        itemsPhys.add(masamune);
        itemsPhys.add(stoneCuttingSword);
        itemsPhys.add(transcendence);
        itemsPhys.add(qinsSais);
        itemsPhys.add(voidShield);
        itemsPhys.add(windDemon);
        itemsPhys.add(bloodforge);
        itemsPhys.add(malice);
        itemsPhys.add(deathbringer);
        itemsPhys = sortItemsByName(itemsPhys);
        this.itemsPhys = itemsPhys;

        itemsMag.add(dynastyPlateHelm);
        itemsMag.add(stoneOfBinding);
        itemsMag.add(doomOrb);
        itemsMag.add(celestialLegionHelm);
        itemsMag.add(lotusCrown);
        itemsMag.add(jadeEmperorsCrown);
        itemsMag.add(spearOfTheMagus);
        itemsMag.add(voidStone);
        itemsMag.add(bancroftsTalon);
        itemsMag.add(demonicGrip);
        itemsMag.add(obsidianShard);
        itemsMag.add(polynomicon);
        itemsMag.add(pythagoremsPiece);
        itemsMag.add(divineRuin);
        itemsMag.add(shamansRing);
        itemsMag.add(rodOfAsclepius);
        itemsMag.add(spearOfDesolation);
        itemsMag.add(bookOfThoth);
        itemsMag.add(gemOfIsolation);
        itemsMag.add(etherealStaff);
        itemsMag.add(warlocksSash);
        itemsMag.add(bookOfTheDead);
        itemsMag.add(telkhinesRing);
        itemsMag.add(chronosPendant);
        itemsMag.add(stoneOfFal);
        itemsMag.add(soulReaver);
        itemsMag.add(rodOfTahuti);
        itemsMag = sortItemsByName(itemsMag);
        this.itemsMag = itemsMag;

        starterPhysCommon.addAll(starterPhys);
        starterPhysCommon.addAll(starterCommon);
        starterPhysCommon = sortItemsByName(starterPhysCommon);
        this.starterPhysCommon = starterPhysCommon;

        starterMagCommon.addAll(starterMag);
        starterMagCommon.addAll(starterCommon);
        starterMagCommon = sortItemsByName(starterMagCommon);
        this.starterMagCommon = starterMagCommon;

        itemsPhysCommon.addAll(itemsPhys);
        itemsPhysCommon.addAll(itemsCommon);
        itemsPhysCommon = sortItemsByName(itemsPhysCommon);
        this.itemsPhysCommon = itemsPhysCommon;

        itemsMagCommon.addAll(itemsMag);
        itemsMagCommon.addAll(itemsCommon);
        itemsMagCommon = sortItemsByName(itemsMagCommon);
        this.itemsMagCommon = itemsMagCommon;

        relics.add(aegisAmulet);
        relics.add(blinkRune);
        relics.add(bracerOfUndoing);
        relics.add(cursedAnkh);
        relics.add(handOfTheGods);
        relics.add(heavenlyWings);
        relics.add(horrificEmblem);
        relics.add(magicShell);
        relics.add(meditationCloak);
        relics.add(phantomVeil);
        relics.add(purificationBeads);
        relics.add(shieldOfThorns);
        relics.add(sunderingSpear);
        relics.add(teleportGlyph);
        relics = sortItemsByName(relics);
        this.relics = relics;

        itemsSpecial.add(noItem);
        this.itemsSpecial = itemsSpecial;

        itemsAll.addAll(boots);
        itemsAll.addAll(shoes);
        itemsAll.addAll(itemsCommon);
        itemsAll.addAll(itemsMag);
        itemsAll.addAll(itemsPhys);
        itemsAll.addAll(starterMag);
        itemsAll.addAll(starterPhys);
        itemsAll.addAll(starterCommon);
        itemsAll.addAll(relics);
        itemsAll.addAll(itemsSpecial);
        itemsAll = sortItemsByName(itemsAll);
        this.itemsAll = itemsAll;

    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void replaceFragment(Fragment myFragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.containerView, myFragment);
        transaction.commit();
    }

    public Bundle createGodBundle(God god) {
        Bundle args = new Bundle();

        args.putString("infoGodName", god.getName());
        args.putString("infoGodTitle", god.getTitle());

        args.putString("infoGodNameString", god.getNameString());
        args.putInt("infoGodImage", god.getImage());
        args.putString("infoPantheon", god.getPantheon());
        args.putInt("infoPantheonIcon", god.getPantheonIcon());
        args.putString("infoClass", god.getClassName());
        args.putInt("infoClassIcon", god.getClassIcon());
        args.putChar("infoType", god.getType());

        args.putInt("infoHealth", god.getHealth());
        args.putInt("infoMana", god.getMana());
        args.putInt("infoDamage", god.getDamage());
        args.putInt("infoProtPhys", god.getProtPhys());
        args.putInt("infoProtMag", god.getProtMag());
        args.putDouble("infoSpeed", god.getSpeed());

        args.putDouble("infoHp5", god.getHp5());
        args.putDouble("infoMp5", god.getMp5());
        args.putDouble("infoAttackSpeed", god.getAttackSpeed());

        return args;
    }

    public static ArrayList<God> getGods() {
        return gods;
    }

    public ArrayList<Item> sortItemsByName(ArrayList<Item> list)
    {
        Collections.sort(list, new Comparator<Item>() {
            public int compare(final Item object1, final Item object2) {
                return object1.getName().compareTo(object2.getName());
            }
        });

        return list;
    }

}

