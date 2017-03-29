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
import android.view.Gravity;
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
                    case R.id.nav_agni: fragmentTransaction.replace(R.id.containerView,new TabFragmentAgni()).commit(); break;
                    case R.id.nav_ah_muzen_cab: fragmentTransaction.replace(R.id.containerView,new TabFragmentAhMuzenCab()).commit(); break;
                    case R.id.nav_ah_puch: fragmentTransaction.replace(R.id.containerView,new TabFragmentAhPuch()).commit(); break;
                    case R.id.nav_amaterasu: fragmentTransaction.replace(R.id.containerView,new TabFragmentAmaterasu()).commit(); break;
                    case R.id.nav_anhur: fragmentTransaction.replace(R.id.containerView,new TabFragmentAnhur()).commit(); break;
                    case R.id.nav_anubis: fragmentTransaction.replace(R.id.containerView,new TabFragmentAnubis()).commit(); break;
                    case R.id.nav_ao_kuang: fragmentTransaction.replace(R.id.containerView,new TabFragmentAoKuang()).commit(); break;
                    case R.id.nav_aphrodite: fragmentTransaction.replace(R.id.containerView,new TabFragmentAphrodite()).commit(); break;
                    case R.id.nav_apollo: fragmentTransaction.replace(R.id.containerView,new TabFragmentApollo()).commit(); break;
                    case R.id.nav_arachne: fragmentTransaction.replace(R.id.containerView,new TabFragmentArachne()).commit(); break;
                    case R.id.nav_ares: fragmentTransaction.replace(R.id.containerView,new TabFragmentAres()).commit(); break;
                    case R.id.nav_artemis: fragmentTransaction.replace(R.id.containerView,new TabFragmentArtemis()).commit(); break;
                    case R.id.nav_athena: fragmentTransaction.replace(R.id.containerView,new TabFragmentAthena()).commit(); break;
                    case R.id.nav_awilix: fragmentTransaction.replace(R.id.containerView,new TabFragmentAwilix()).commit(); break;
                    case R.id.nav_bacchus: fragmentTransaction.replace(R.id.containerView,new TabFragmentBacchus()).commit(); break;
                    case R.id.nav_bakasura: fragmentTransaction.replace(R.id.containerView,new TabFragmentBakasura()).commit(); break;
                    case R.id.nav_bastet: fragmentTransaction.replace(R.id.containerView,new TabFragmentBastet()).commit(); break;
                    case R.id.nav_bellona: fragmentTransaction.replace(R.id.containerView,new TabFragmentBellona()).commit(); break;
                    case R.id.nav_cabrakan: fragmentTransaction.replace(R.id.containerView,new TabFragmentCabrakan()).commit(); break;
                    case R.id.nav_camazotz: fragmentTransaction.replace(R.id.containerView,new TabFragmentCamazotz()).commit(); break;
                    case R.id.nav_cernunnos: fragmentTransaction.replace(R.id.containerView,new TabFragmentCernunnos()).commit(); break;
                    case R.id.nav_chaac: fragmentTransaction.replace(R.id.containerView,new TabFragmentChaac()).commit(); break;
                    case R.id.nav_change: fragmentTransaction.replace(R.id.containerView,new TabFragmentChange()).commit(); break;
                    case R.id.nav_chiron: fragmentTransaction.replace(R.id.containerView,new TabFragmentChiron()).commit(); break;
                    case R.id.nav_chronos: fragmentTransaction.replace(R.id.containerView,new TabFragmentChronos()).commit(); break;
                    case R.id.nav_cupid: fragmentTransaction.replace(R.id.containerView,new TabFragmentCupid()).commit(); break;
                    case R.id.nav_erlang_shen: fragmentTransaction.replace(R.id.containerView,new TabFragmentErlangShen()).commit(); break;
                    case R.id.nav_fafnir: fragmentTransaction.replace(R.id.containerView,new TabFragmentFafnir()).commit(); break;
                    case R.id.nav_fenrir: fragmentTransaction.replace(R.id.containerView,new TabFragmentFenrir()).commit(); break;
                    case R.id.nav_freya: fragmentTransaction.replace(R.id.containerView,new TabFragmentFreya()).commit(); break;
                    case R.id.nav_geb: fragmentTransaction.replace(R.id.containerView,new TabFragmentGeb()).commit(); break;
                    case R.id.nav_guan_yu: fragmentTransaction.replace(R.id.containerView,new TabFragmentGuanYu()).commit(); break;
                    case R.id.nav_hades: fragmentTransaction.replace(R.id.containerView,new TabFragmentHades()).commit(); break;
                    case R.id.nav_he_bo: fragmentTransaction.replace(R.id.containerView,new TabFragmentHeBo()).commit(); break;
                    case R.id.nav_hel: fragmentTransaction.replace(R.id.containerView,new TabFragmentHel()).commit(); break;
                    case R.id.nav_hercules: fragmentTransaction.replace(R.id.containerView,new TabFragmentHercules()).commit(); break;
                    case R.id.nav_hou_yi: fragmentTransaction.replace(R.id.containerView,new TabFragmentHouYi()).commit(); break;
                    case R.id.nav_hun_batz: fragmentTransaction.replace(R.id.containerView,new TabFragmentHunBatz()).commit(); break;
                    case R.id.nav_isis: fragmentTransaction.replace(R.id.containerView,new TabFragmentIsis()).commit(); break;
                    case R.id.nav_izanami: fragmentTransaction.replace(R.id.containerView,new TabFragmentIzanami()).commit(); break;
                    case R.id.nav_janus: fragmentTransaction.replace(R.id.containerView,new TabFragmentJanus()).commit(); break;
                    case R.id.nav_jing_wei: fragmentTransaction.replace(R.id.containerView,new TabFragmentJingWei()).commit(); break;
                    case R.id.nav_kali: fragmentTransaction.replace(R.id.containerView,new TabFragmentKali()).commit(); break;
                    case R.id.nav_khepri: fragmentTransaction.replace(R.id.containerView,new TabFragmentKhepri()).commit(); break;
                    case R.id.nav_kukulkan: fragmentTransaction.replace(R.id.containerView,new TabFragmentKukulkan()).commit(); break;
                    case R.id.nav_kumbhakarna: fragmentTransaction.replace(R.id.containerView,new TabFragmentKumbhakarna()).commit(); break;
                    case R.id.nav_kuzenbo: fragmentTransaction.replace(R.id.containerView,new TabFragmentKuzenbo()).commit(); break;
                    case R.id.nav_loki: fragmentTransaction.replace(R.id.containerView,new TabFragmentLoki()).commit(); break;
                    case R.id.nav_medusa: fragmentTransaction.replace(R.id.containerView,new TabFragmentMedusa()).commit(); break;
                    case R.id.nav_mercury: fragmentTransaction.replace(R.id.containerView,new TabFragmentMercury()).commit(); break;
                    case R.id.nav_neith: fragmentTransaction.replace(R.id.containerView,new TabFragmentNeith()).commit(); break;
                    case R.id.nav_nemesis: fragmentTransaction.replace(R.id.containerView,new TabFragmentNemesis()).commit(); break;
                    case R.id.nav_ne_zha: fragmentTransaction.replace(R.id.containerView,new TabFragmentNeZha()).commit(); break;
                    case R.id.nav_nike: fragmentTransaction.replace(R.id.containerView,new TabFragmentNike()).commit(); break;
                    case R.id.nav_nox: fragmentTransaction.replace(R.id.containerView,new TabFragmentNox()).commit(); break;
                    case R.id.nav_nu_wa: fragmentTransaction.replace(R.id.containerView,new TabFragmentNuWa()).commit(); break;
                    case R.id.nav_odin: fragmentTransaction.replace(R.id.containerView,new TabFragmentOdin()).commit(); break;
                    case R.id.nav_osiris: fragmentTransaction.replace(R.id.containerView,new TabFragmentOsiris()).commit(); break;
                    case R.id.nav_poseidon: fragmentTransaction.replace(R.id.containerView,new TabFragmentPoseidon()).commit(); break;
                    case R.id.nav_ra: fragmentTransaction.replace(R.id.containerView,new TabFragmentRa()).commit(); break;
                    case R.id.nav_raijin: fragmentTransaction.replace(R.id.containerView,new TabFragmentRaijin()).commit(); break;
                    case R.id.nav_rama: fragmentTransaction.replace(R.id.containerView,new TabFragmentRama()).commit(); break;
                    case R.id.nav_ratatoskr: fragmentTransaction.replace(R.id.containerView,new TabFragmentRatatoskr()).commit(); break;
                    case R.id.nav_ravana: fragmentTransaction.replace(R.id.containerView,new TabFragmentRavana()).commit(); break;
                    case R.id.nav_scylla: fragmentTransaction.replace(R.id.containerView,new TabFragmentScylla()).commit(); break;
                    case R.id.nav_serqet: fragmentTransaction.replace(R.id.containerView,new TabFragmentSerqet()).commit(); break;
                    case R.id.nav_skadi: fragmentTransaction.replace(R.id.containerView,new TabFragmentSkadi()).commit(); break;
                    case R.id.nav_sobek: fragmentTransaction.replace(R.id.containerView,new TabFragmentSobek()).commit(); break;
                    case R.id.nav_sol: fragmentTransaction.replace(R.id.containerView,new TabFragmentSol()).commit(); break;
                    case R.id.nav_sun_wukong: fragmentTransaction.replace(R.id.containerView,new TabFragmentSunWukong()).commit(); break;
                    case R.id.nav_susano: fragmentTransaction.replace(R.id.containerView,new TabFragmentSusano()).commit(); break;
                    case R.id.nav_sylvanus: fragmentTransaction.replace(R.id.containerView,new TabFragmentSylvanus()).commit(); break;
                    case R.id.nav_terra: fragmentTransaction.replace(R.id.containerView,new TabFragmentTerra()).commit(); break;
                    case R.id.nav_thanatos: fragmentTransaction.replace(R.id.containerView,new TabFragmentThanatos()).commit(); break;
                    case R.id.nav_the_morrigan: fragmentTransaction.replace(R.id.containerView,new TabFragmentTheMorrigan()).commit(); break;
                    case R.id.nav_thor: fragmentTransaction.replace(R.id.containerView,new TabFragmentThor()).commit(); break;
                    case R.id.nav_thoth: fragmentTransaction.replace(R.id.containerView,new TabFragmentThoth()).commit(); break;
                    case R.id.nav_tyr: fragmentTransaction.replace(R.id.containerView,new TabFragmentTyr()).commit(); break;
                    case R.id.nav_ullr: fragmentTransaction.replace(R.id.containerView,new TabFragmentUllr()).commit(); break;
                    case R.id.nav_vamana: fragmentTransaction.replace(R.id.containerView,new TabFragmentVamana()).commit(); break;
                    case R.id.nav_vulcan: fragmentTransaction.replace(R.id.containerView,new TabFragmentVulcan()).commit(); break;
                    case R.id.nav_xbalanque: fragmentTransaction.replace(R.id.containerView,new TabFragmentXbalanque()).commit(); break;
                    case R.id.nav_xing_tian: fragmentTransaction.replace(R.id.containerView,new TabFragmentXingTian()).commit(); break;
                    case R.id.nav_ymir: fragmentTransaction.replace(R.id.containerView,new TabFragmentYmir()).commit(); break;
                    case R.id.nav_zeus: fragmentTransaction.replace(R.id.containerView,new TabFragmentZeus()).commit(); break;
                    case R.id.nav_zhong_kui: fragmentTransaction.replace(R.id.containerView,new TabFragmentZhongKui()).commit(); break;
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

