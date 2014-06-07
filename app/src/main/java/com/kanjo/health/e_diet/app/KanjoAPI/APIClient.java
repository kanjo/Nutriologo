package com.kanjo.health.e_diet.app.KanjoAPI;

import android.os.AsyncTask;
import android.widget.Toast;

import com.kanjo.health.e_diet.app.core.ICommunicatorAPI;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARP on 6/7/14.
 */
public class APIClient implements ICommunicatorAPI {


    @Override
    public String getJSON() {
        return "";
    }

    private void getJson()
    {
        new AsyncTask()
        {

            @Override
            protected Object doInBackground(Object[] objects) {

                HttpClient client = new DefaultHttpClient();





                HttpGet mGet = new HttpGet("http://api.kanjo.com.mx/json/test");

                try {

                    HttpResponse response = client.execute(mGet);
                    Reader in = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuilder builder= new StringBuilder();
                    char[] buf = new char[1000];
                    int l = 0;
                    while (l >= 0) {
                        builder.append(buf, 0, l);
                        l = in.read(buf);
                    }



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
