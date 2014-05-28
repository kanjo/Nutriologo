package com.kanjo.health.e_diet.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kanjo.health.e_diet.app.UI.Fragments.AlimentosListFragment;
import com.kanjo.health.e_diet.app.UI.Fragments.HorarioGroupAlimentosFragment;
import com.kanjo.health.e_diet.app.domain.GroupAlimento;
import com.kanjo.health.e_diet.app.profile.DietProfileManager;


public class AlimentosListActivity extends SingleFragmentActivity {

    DietProfileManager dietProfileManager = new DietProfileManager();

    GroupAlimento mGrupoAlimento;


    @Override
    protected Fragment createFragment() {
        Intent intentParams  = getIntent();


        if(intentParams!=null) {

            Bundle mBundle = intentParams.getExtras();
            mGrupoAlimento = (GroupAlimento) mBundle.get(HorarioGroupAlimentosFragment.PARAM_GROUP_ALIMENTO);
            return AlimentosListFragment.newInstance("", "", mGrupoAlimento);
        }

        return AlimentosListFragment.newInstance("","",dietProfileManager.getHorario(0).ListGroupAlimentos.get(0));
    }
}
