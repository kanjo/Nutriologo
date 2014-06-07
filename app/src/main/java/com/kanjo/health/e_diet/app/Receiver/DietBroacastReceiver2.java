package com.kanjo.health.e_diet.app.Receiver;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by JARP on 6/7/14.
 */
public class DietBroacastReceiver2 extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent!=null)
        {
            ComponentName comp = new ComponentName(context.getPackageName(),
                    KanjoIntentService.class.getName());
            // Start the service, keeping the device awake while it is launching.
            startWakefulService(context, (intent.setComponent(comp)));
            setResultCode(Activity.RESULT_OK);

        }

    }
}
