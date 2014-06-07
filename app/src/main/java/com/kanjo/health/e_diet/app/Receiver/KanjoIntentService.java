package com.kanjo.health.e_diet.app.Receiver;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class KanjoIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.kanjo.health.e_diet.app.Receiver.action.FOO";
    private static final String ACTION_BAZ = "com.kanjo.health.e_diet.app.Receiver.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.kanjo.health.e_diet.app.Receiver.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.kanjo.health.e_diet.app.Receiver.extra.PARAM2";

    private final static String TAG ="e-diet";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, KanjoIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, KanjoIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public KanjoIntentService() {
        super("KanjoIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {

            Bundle extras =intent.getExtras();

            if(intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) {

                GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
                // The getMessageType() intent parameter must be the intent you received
                // in your BroadcastReceiver.
                String messageType = gcm.getMessageType(intent);

                IProcessorMessage processorMessage = new ProcessorReceiver();


                if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM will be
             * extended in the future with new message types, just ignore any message types you're
             * not interested in, or that you don't recognize.
             */
                    if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                        processorMessage.processMessage(intent, getApplicationContext());
                    } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {
                        processorMessage.processMessage(intent, getApplicationContext());
                        // If it's a regular GCM message, do some work.
                    } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                        processorMessage.processMessage(intent, getApplicationContext());
                        Log.i(TAG, "Received: " + extras.toString());
                    }
                }
                // Release the wake lock provided by the WakefulBroadcastReceiver.
                DietBroacastReceiver2.completeWakefulIntent(intent);
            }

        }

            /*
            final String action = intent.getAction();



            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }*/

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
