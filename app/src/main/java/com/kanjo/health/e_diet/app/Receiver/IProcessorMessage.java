package com.kanjo.health.e_diet.app.Receiver;

import android.content.Context;
import android.content.Intent;

/**
 * Created by JARP on 6/4/14.
 */
public interface IProcessorMessage {

    void processMessage(Intent intent, Context context);

}
