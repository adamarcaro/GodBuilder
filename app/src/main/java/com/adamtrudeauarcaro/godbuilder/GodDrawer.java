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

public class GodDrawer extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_drawer);

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
        mFragmentTransaction.replace(R.id.containerView,new TabFragmentAgni()).commit();

        //Setup click events on the Navigation View Items.
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                int id = menuItem.getItemId();

                switch(id) {
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

        mDrawerLayout.openDrawer(Gravity.LEFT);

    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

