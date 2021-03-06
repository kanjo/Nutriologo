package com.kanjo.health.e_diet.app.profile;

import android.content.Context;
import android.os.AsyncTask;

import com.kanjo.health.e_diet.app.core.IRegisterProfileGCM;
import com.kanjo.health.e_diet.app.core.IRegisterProfileKanjo;
import com.kanjo.health.e_diet.app.core.ListenerOnCompleteToken;

/**
 * Created by JARP on 5/29/14.
 */
public class ProfileRegister {

    private IRegisterProfileKanjo mKanjoRegistration;

    private IRegisterProfileGCM registerProfileGCM;

    private Context mContext;

    private ListenerOnCompleteToken onCompleteToken = new ListenerOnCompleteToken() {
        @Override
        public void onCompleteToken(String token) {
          mKanjoRegistration.registerInKanjo(token);
        }
    };


    @SuppressWarnings("all")
    public void manageRegistration(Context context)
    {

        //TODO: CHECK PLAY SERVICES
        //like http://developer.android.com/google/gcm/client.html

        mContext = context;

        new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                //TODO: Remove this property it's only for testing porpouses
                mKanjoRegistration = new DummyAPIRegistration(mContext,false);

                if(!mKanjoRegistration.isRegisteredInKanjo()) {
                    registerProfileGCM = new GCMConcreteRegistration(mContext, onCompleteToken);
                    registerProfileGCM.registerInGCM();
                }return true;
            }
        }
                .execute(null);





    }

}
