package com.adamtrudeauarcaro.godbuilder;

import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.adamtrudeauarcaro.godbuilder.BuildFragment.passives;

/**
 * Created by adama on 2017-04-16.
 */


public class StatFragment extends DialogFragment {

    private TextView costText;
    private ListView listView, listViewPassives;
    private Button close;

    private int buildCost, buildHealth, buildMana, buildDamage, buildPower, buildLifesteal, buildPenetration, buildProtPhys, buildProtMag, buildCritChance, buildCdr, buildCcr;
    private double buildHp5, buildMp5, buildAttackSpeed, buildSpeed;
    private char infoType;

    private Stat cost, health, mana, hp5, mp5, damage, power, lifesteal, penetration, protPhys, protMag, attackSpeed, speed, critChance, cdr, ccr;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Indicate layout for dialog
        View view = inflater.inflate(R.layout.stats_list, null);

        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        getBuildStatArgs();

        costText = (TextView) view.findViewById(R.id.cost_text);
        listView = (ListView) view.findViewById(R.id.listView);
        listViewPassives = (ListView) view.findViewById(R.id.listViewPassives);
        close = (Button) view.findViewById(R.id.close);

        ArrayList<Stat> stats = new ArrayList<Stat>();
        health = new Stat("Health: ", String.valueOf(buildHealth), false);
        mana = new Stat("Mana: ", String.valueOf(buildMana), false);

        if(buildHp5 > 100) hp5 = new Stat("HP5: ", String.valueOf(buildHp5), true);
        else hp5 = new Stat("HP5: ", String.valueOf(buildHp5), false);
        if(buildMp5 > 100) mp5 = new Stat("MP5: ", String.valueOf(buildMp5), true);
        else mp5 = new Stat("MP5: ", String.valueOf(buildMp5), false);

        damage = new Stat("Basic Attack Damage: ", String.valueOf(buildDamage), false);
        power = new Stat("Power: ", String.valueOf(buildPower), false);

        if(infoType == 'M') {
            if (buildLifesteal > 65) lifesteal = new Stat("Lifesteal: ", String.valueOf(buildLifesteal) + "%", true);
            else lifesteal = new Stat("Lifesteal: ", String.valueOf(buildLifesteal) + "%", false);
        } else {
            if(buildLifesteal > 100) lifesteal = new Stat("Lifesteal: ", String.valueOf(buildLifesteal)+"%", true);
            else lifesteal = new Stat("Lifesteal: ", String.valueOf(buildLifesteal)+"%", false);
        }

        if(buildPenetration > 50) penetration = new Stat("Penetration: ", String.valueOf(buildPenetration), true);
        else penetration = new Stat("Penetration: ", String.valueOf(buildPenetration), false);

        if(buildProtPhys > 325) protPhys = new Stat("Physical Protection: ", String.valueOf(buildProtPhys), true);
        else protPhys = new Stat("Physical Protection: ", String.valueOf(buildProtPhys), false);
        if(buildProtMag > 325) protMag = new Stat("Magical Protection: ", String.valueOf(buildProtMag), true);
        else protMag = new Stat("Magical Protection: ", String.valueOf(buildProtMag), false);

        if(buildAttackSpeed > 2.5) attackSpeed = new Stat("Attack Speed: ", String.valueOf(buildAttackSpeed), true);
        else attackSpeed = new Stat("Attack Speed: ", String.valueOf(buildAttackSpeed), false);

        speed = new Stat("Movement Speed: ", String.valueOf(Math.round(buildSpeed)), false);

        if(buildCritChance > 100) critChance = new Stat("Crit Chance: ", String.valueOf(buildCritChance)+"%", true);
        else critChance = new Stat("Crit Chance: ", String.valueOf(buildCritChance)+"%", false);
        if(buildCdr > 40) cdr = new Stat("Cooldown Reduction: ", String.valueOf(buildCdr)+"%", true);
        else cdr = new Stat("Cooldown Reduction: ", String.valueOf(buildCdr)+"%", false);
        if(buildCcr > 40) ccr = new Stat("CC Reduction: ", String.valueOf(buildCcr)+"%", true);
        else ccr = new Stat("CC Reduction: ", String.valueOf(buildCcr)+"%", false);

        stats.add(health);
        stats.add(mana);
        stats.add(hp5);
        stats.add(mp5);
        stats.add(damage);
        stats.add(power);
        stats.add(lifesteal);
        stats.add(penetration);
        stats.add(protPhys);
        stats.add(protMag);
        stats.add(attackSpeed);
        stats.add(speed);
        stats.add(critChance);
        stats.add(cdr);
        stats.add(ccr);

        costText.setText("Build Cost: " + String.valueOf(buildCost) + " gold");
        StatAdapter statAdapter = new StatAdapter(getActivity(), stats);
        listView.setAdapter(statAdapter);

        PassiveAdapter passiveAdapter = new PassiveAdapter(getActivity(), passives);
        listViewPassives.setAdapter(passiveAdapter);

        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

    public void getBuildStatArgs() {
        infoType = getArguments().getChar("infoType", 'M');

        buildCost = getArguments().getInt("buildCost", 0);

        buildHealth = getArguments().getInt("buildHealth", 0);
        buildMana = getArguments().getInt("buildMana", 0);
        buildDamage = getArguments().getInt("buildDamage", 0);
        buildPower = getArguments().getInt("buildPower", 0);
        buildLifesteal = getArguments().getInt("buildLifesteal", 0);
        buildPenetration = getArguments().getInt("buildPenetration", 0);
        buildProtPhys = getArguments().getInt("buildProtPhys", 0);
        buildProtMag = getArguments().getInt("buildProtMag", 0);
        buildCritChance = getArguments().getInt("buildCritChance", 0);
        buildCdr = getArguments().getInt("buildCdr", 0);
        buildCcr = getArguments().getInt("buildCcr", 0);

        buildHp5 = getArguments().getDouble("buildHp5", 0);
        buildMp5 = getArguments().getDouble("buildMp5", 0);
        buildAttackSpeed = getArguments().getDouble("buildAttackSpeed", 0);
        buildSpeed = getArguments().getDouble("buildSpeed", 0);
    }

}

