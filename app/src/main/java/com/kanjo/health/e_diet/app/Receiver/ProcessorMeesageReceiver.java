package com.kanjo.health.e_diet.app.Receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.kanjo.health.e_diet.app.KanjoAPI.APIClient;
import com.kanjo.health.e_diet.app.PagerMainActivity;
import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.core.ICommunicatorAPI;

/**
 * Created by JARP on 6/4/14.
 */
public class ProcessorMeesageReceiver implements IProcessorMessage {

    //TODO we need to do more things than just send notifications
    Context mContext ;
    Intent mIntent;
    @Override
    public void processMessage(Intent intent, Context context) {
        mContext = context;
        mIntent= intent;
        if(intent!=null)
            postNotification();


    }

    private void postNotification()
    {

        //TODO :  need a better implementation this is awful!!
        String message ="There was an error with your message";
        if (mIntent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) {
            Bundle extras = mIntent.getExtras();
            if (extras != null) {


                if (extras.getString("messageType") != null && extras.getString("messageType").equals("pop")) {
                        postNotification(extras.getString("message"));
                } else if (extras.getString("default") != null) {
                    message = extras.getString("default");
                    postNotification(message);

                } else if (extras.getString("messageType") != null && extras.getString("messageType").equals("KanjoAPICall")) {
                    getTaskAPI(extras.getString("APIRequest"));//
                }

            }
        }

    }

    private void postNotification(String message)
    {
        final NotificationManager mNotificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent mIntent = new Intent(mContext, PagerMainActivity.class);

        final PendingIntent mPendingIntent =
                PendingIntent.getActivity(mContext,0,mIntent, Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL);


        Notification mNotification = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("e-diet deliver a new message!")
                .setContentText(message)
                .setContentIntent(mPendingIntent)
                .setAutoCancel(true)
                .build();

        //TODO:An identifier for this notification unique within your application.
        mNotificationManager.notify(1,mNotification);
    }


    private void getTaskAPI(String requestAPI)
    {
        ICommunicatorAPI api = new APIClient();
        api.getJSON(mContext,requestAPI);
    }
}
