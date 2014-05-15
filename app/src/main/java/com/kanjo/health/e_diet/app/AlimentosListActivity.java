package com.kanjo.health.e_diet.app;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kanjo.health.e_diet.app.UI.Fragments.AlimentosListFragment;
import com.kanjo.health.e_diet.app.profile.DietProfileManager;


public class AlimentosListActivity extends SingleFragmentActivity {

    DietProfileManager dietProfileManager;

    private void initProfile ()
    {
        dietProfileManager= new DietProfileManager();
        //TODO : implement profile to construct the schedule
        dietProfileManager.createDietHorarios();
    }

    @Override
    protected Fragment createFragment() {
        initProfile();

        return AlimentosListFragment.newInstance("","",dietProfileManager.mHorarioList.get(0).ListGroupAlimentos.get(0));
    }
}
