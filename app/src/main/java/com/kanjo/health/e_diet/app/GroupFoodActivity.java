package com.kanjo.health.e_diet.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.kanjo.health.e_diet.app.UI.Fragments.HorarioGroupAlimentosFragment;
import com.kanjo.health.e_diet.app.profile.DietProfileManager;

public class GroupFoodActivity extends SingleFragmentActivity {


    DietProfileManager dietProfileManager;

    private void initProfile ()
    {
        dietProfileManager= new DietProfileManager();
        //TODO : implement profile to construct the schedule
        dietProfileManager.createDietHorarios();
    }



    @Override
    protected Fragment createFragment() {

        Intent intentParams = getIntent();
        //TODO: GET the Horario from the activity
        String test = intentParams.getStringExtra("testParam");

        initProfile();
        return
                HorarioGroupAlimentosFragment.newInstance("",dietProfileManager.mHorarioList.get(0));
    }

}
