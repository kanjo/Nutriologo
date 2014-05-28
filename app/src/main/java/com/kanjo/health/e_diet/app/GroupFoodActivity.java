package com.kanjo.health.e_diet.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.kanjo.health.e_diet.app.UI.Fragments.HorarioGroupAlimentosFragment;
import com.kanjo.health.e_diet.app.domain.Horario;
import com.kanjo.health.e_diet.app.profile.DietProfileManager;

public class GroupFoodActivity extends SingleFragmentActivity {


    DietProfileManager dietProfileManager  = new DietProfileManager();

    @Override
    protected Fragment createFragment() {

        Intent intentParams = getIntent();

        Bundle mBundleParams ;

        if(intentParams!=null && (mBundleParams=intentParams.getExtras())!=null)
        {
            Horario  mHorario =
                    (Horario)mBundleParams.get(PagerMainActivity.KEY_HORARIO);

            if(mHorario!=null)
                return HorarioGroupAlimentosFragment.newInstance("",mHorario);
        }
        String test = intentParams.getStringExtra("testParam");
        return
                HorarioGroupAlimentosFragment.newInstance("",dietProfileManager.getHorario(0));
    }

}
