package com.kanjo.health.e_diet.app.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DietBroadcastReceiver extends BroadcastReceiver {

    IProcessorMessage processorMessage = new ProcessorMeesageReceiver();
    public DietBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent!=null)
        {
            processorMessage.processMessage(intent,context);
        }
    }


}
