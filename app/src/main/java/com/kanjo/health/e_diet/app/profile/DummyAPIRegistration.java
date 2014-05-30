package com.kanjo.health.e_diet.app.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;

import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.core.IRegisterProfileKanjo;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by JARP on 5/29/14.
 * This class has to be deleted because the
 * the id need to be keep in DB
 */
public class DummyAPIRegistration implements IRegisterProfileKanjo {

    String mFilName;

    private SharedPreferences mSharedPreferences;

    private Context mContext;

    public DummyAPIRegistration(Context context) {
        if(context == null)
            throw  new IllegalArgumentException("Context can not be null");
        mContext = context;
        mFilName = context.getString(R.string.preference_file);
        mSharedPreferences = mContext.getSharedPreferences(mFilName,context.MODE_PRIVATE);
        if(Build.VERSION.SDK_INT>9)
            mSharedPreferences= mContext.getSharedPreferences(mFilName,context.MODE_MULTI_PROCESS);

        mSharedPreferences=PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    @Override
    public boolean isRegisteredInKanjo() {
        return mSharedPreferences.getBoolean(mContext.getString(R.string.is_register_in_kanjo),false);
    }

    @Override
    public void registerInKanjo(String token) {
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(mContext.getString(R.string.is_register_in_kanjo),true);
        mEditor.commit();
        //TODO: Need to send the real User
        Calendar g = GregorianCalendar.getInstance();
        String User = "Kanjo_" +
                                String.valueOf( g.get(Calendar.YEAR))+"_"+
                                String.valueOf( g.get(Calendar.MONTH))+"_"+
                                String.valueOf( g.get(Calendar.DAY_OF_MONTH));
        registerInKanjoAPI(token,User);
    }

    @SuppressWarnings("all")
    private void registerInKanjoAPI(final String token , final String user)
    {
        new AsyncTask()
        {

            @Override
            protected Object doInBackground(Object[] objects) {

                HttpClient client = new DefaultHttpClient();

                //http://api.kanjo.com.mx/regdevice/e-diet/gcm/post?token=numero_token&user=usuario

                HttpPost mPost = new HttpPost("http://api.kanjo.com.mx/regdevice/e-diet/gcm/");

                List<NameValuePair> params= new ArrayList<NameValuePair>();

                params.add(new BasicNameValuePair("token",token));
                params.add(new BasicNameValuePair("user",user));

                try {
                    mPost.setEntity(new UrlEncodedFormEntity(params));

                    HttpResponse response = client.execute(mPost);
                }
                catch (ClientProtocolException cpEX)
                {

                }
                catch (IOException ioEx)
                {

                }
                return true;
            }
        }.execute(null);

    }






}
