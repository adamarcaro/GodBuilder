package com.example.adamtrudeauarcaro.godbuilder;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class GodDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemIconTintList(null);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAgni()).commit();

        drawer.openDrawer(Gravity.LEFT);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_agni) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAgni()).commit();
        } else if (id == R.id.nav_ah_muzen_cab) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAhMuzenCab()).commit();
        } else if (id == R.id.nav_ah_puch) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAhPuch()).commit();
        } else if (id == R.id.nav_amaterasu) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAmaterasu()).commit();
        } else if (id == R.id.nav_anhur) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAnhur()).commit();
        } else if (id == R.id.nav_anubis) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAnubis()).commit();
        } else if (id == R.id.nav_ao_kuang) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAoKuang()).commit();
        } else if (id == R.id.nav_aphrodite) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAphrodite()).commit();
        } else if (id == R.id.nav_apollo) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentApollo()).commit();
        } else if (id == R.id.nav_arachne) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentArachne()).commit();
        } else if (id == R.id.nav_ares) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAres()).commit();
        } else if (id == R.id.nav_artemis) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentArtemis()).commit();
        } else if (id == R.id.nav_athena) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAthena()).commit();
        } else if (id == R.id.nav_awilix) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAwilix()).commit();
        } else if (id == R.id.nav_bacchus) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentBacchus()).commit();
        } else if (id == R.id.nav_bakasura) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentBakasura()).commit();
        } else if (id == R.id.nav_bastet) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentBastet()).commit();
        } else if (id == R.id.nav_bellona) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentBellona()).commit();
        } else if (id == R.id.nav_cabrakan) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentCabrakan()).commit();
        } else if (id == R.id.nav_camazotz) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentCamazotz()).commit();
        } else if (id == R.id.nav_chaac) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChaac()).commit();
        } else if (id == R.id.nav_change) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChange()).commit();
        } else if (id == R.id.nav_chiron) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChiron()).commit();
        } else if (id == R.id.nav_chronos) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChronos()).commit();
        } else if (id == R.id.nav_cupid) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentCupid()).commit();
        } else if (id == R.id.nav_erlang_shen) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentErlangShen()).commit();
        } else if (id == R.id.nav_fafnir) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentFafnir()).commit();
        } else if (id == R.id.nav_fenrir) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentFenrir()).commit();
        } else if (id == R.id.nav_freya) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentFreya()).commit();
        } else if (id == R.id.nav_geb) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentGeb()).commit();
        } else if (id == R.id.nav_guan_yu) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentGuanYu()).commit();
        } else if (id == R.id.nav_hades) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentHades()).commit();
        } else if (id == R.id.nav_he_bo) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentHeBo()).commit();
        } else if (id == R.id.nav_hel) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentHel()).commit();
        } else if (id == R.id.nav_hercules) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentHercules()).commit();
        } else if (id == R.id.nav_hou_yi) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentHouYi()).commit();
        } else if (id == R.id.nav_hun_batz) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentHunBatz()).commit();
        } else if (id == R.id.nav_isis) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentIsis()).commit();
        } else if (id == R.id.nav_izanami) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentIzanami()).commit();
        } else if (id == R.id.nav_janus) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentJanus()).commit();
        } else if (id == R.id.nav_jing_wei) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentJingWei()).commit();
        } else if (id == R.id.nav_kali) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentKali()).commit();
        } else if (id == R.id.nav_khepri) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentKhepri()).commit();
        } else if (id == R.id.nav_kukulkan) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentKukulkan()).commit();
        } else if (id == R.id.nav_kumbhakarna) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentKumbhakarna()).commit();
        } else if (id == R.id.nav_loki) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentLoki()).commit();
        } else if (id == R.id.nav_medusa) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentMedusa()).commit();
        } else if (id == R.id.nav_mercury) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentMercury()).commit();
        } else if (id == R.id.nav_ne_zha) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentNeZha()).commit();
        } else if (id == R.id.nav_neith) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentNeith()).commit();
        } else if (id == R.id.nav_nemesis) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentNemesis()).commit();
        } else if (id == R.id.nav_nox) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentNox()).commit();
        } else if (id == R.id.nav_nu_wa) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentNuWa()).commit();
        } else if (id == R.id.nav_odin) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentOdin()).commit();
        } else if (id == R.id.nav_osiris) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentOsiris()).commit();
        } else if (id == R.id.nav_poseidon) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentPoseidon()).commit();
        } else if (id == R.id.nav_ra) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentRa()).commit();
        } else if (id == R.id.nav_raijin) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentRaijin()).commit();
        } else if (id == R.id.nav_rama) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentRama()).commit();
        } else if (id == R.id.nav_ratatoskr) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentRatatoskr()).commit();
        } else if (id == R.id.nav_ravana) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentRavana()).commit();
        } else if (id == R.id.nav_scylla) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentScylla()).commit();
        } else if (id == R.id.nav_serqet) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSerqet()).commit();
        } else if (id == R.id.nav_skadi) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSkadi()).commit();
        } else if (id == R.id.nav_sobek) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSobek()).commit();
        } else if (id == R.id.nav_sol) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSol()).commit();
        } else if (id == R.id.nav_sun_wukong) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSunWukong()).commit();
        } else if (id == R.id.nav_susano) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSusano()).commit();
        } else if (id == R.id.nav_sylvanus) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentSylvanus()).commit();
        } else if (id == R.id.nav_terra) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentTerra()).commit();
        } else if (id == R.id.nav_thanatos) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentThanatos()).commit();
        } else if (id == R.id.nav_thor) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentThor()).commit();
        } else if (id == R.id.nav_tyr) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentTyr()).commit();
        } else if (id == R.id.nav_ullr) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentUllr()).commit();
        } else if (id == R.id.nav_vamana) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentVamana()).commit();
        } else if (id == R.id.nav_vulcan) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentVulcan()).commit();
        } else if (id == R.id.nav_xbalanque) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentXbalanque()).commit();
        } else if (id == R.id.nav_xing_tian) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentXingTian()).commit();
        } else if (id == R.id.nav_ymir) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentYmir()).commit();
        } else if (id == R.id.nav_zeus) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentZeus()).commit();
        } else if (id == R.id.nav_zhong_kui) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentZhongKui()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
