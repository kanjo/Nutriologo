package com.kanjo.health.e_diet.app.profile;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.core.IRegisterProfileGCM;
import com.kanjo.health.e_diet.app.core.ListenerOnCompleteToken;

import java.io.IOException;

/**
 * Created by JARP on 5/29/14.
 */
public class GCMConcreteRegistration implements IRegisterProfileGCM {

    private GoogleCloudMessaging gcm;

    private Context mContext;

    private ListenerOnCompleteToken mListener;


    public GCMConcreteRegistration(Context context, ListenerOnCompleteToken onCompleteToken)
    {
        if(context == null)
            throw  new IllegalArgumentException("Context can not be null");

        this.mContext = context;
        this.mListener = onCompleteToken;
    }

    public String getToken() {
        return token;
    }

    private String token=null;

    @Override
    public String registerInGCM() {
        gcm = GoogleCloudMessaging.getInstance(mContext);
        AsyncRegistration mAsyncRegistration = new AsyncRegistration();
        mAsyncRegistration.doInBackground(null);
        return  null;
    }




    private class AsyncRegistration extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {

                token = gcm.register(mContext.getString(R.string.ProjectGCMID));

                mListener.onCompleteToken(token);

                Log.d("Kanjo","GCM token " + token );
            }
            catch (IOException ioEx)
            {
                Log.d("Kanjo","Error" + ioEx.getMessage());
            }
            return  true;
        }

    }



}
