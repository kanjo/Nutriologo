package com.kanjo.health.e_diet.app.Receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.kanjo.health.e_diet.app.PagerMainActivity;
import com.kanjo.health.e_diet.app.R;

/**
 * Created by JARP on 6/4/14.
 */
public class ProcessorReceiver implements IProcessorMessage {

    //TODO we need to do more things than just send notifications
    Context mContext ;
    @Override
    public void processMessage(Intent intent, Context context) {
        mContext = context;
        if(intent!=null)
            postNotification();
    }

    private void postNotification()
    {
        final NotificationManager mNotificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent mIntent = new Intent(mContext, PagerMainActivity.class);

        final PendingIntent mPendingIntent =
                PendingIntent.getActivity(mContext,0,mIntent, Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL);

        Notification mNotification = new NotificationCompat.Builder(mContext)
                                        .setSmallIcon(R.drawable.ic_launcher)
                                        .setContentText("e-Diet")
                                        .setContentIntent(mPendingIntent)
                                        .setAutoCancel(true)
                                        .build();

        //TODO:An identifier for this notification unique within your application.
        mNotificationManager.notify(1,mNotification);

    }
}