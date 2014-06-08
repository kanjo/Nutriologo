package com.kanjo.health.e_diet.app.KanjoAPI;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.kanjo.health.e_diet.app.core.ICommunicatorAPI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by JARP on 6/7/14.
 */
public class APIClient implements ICommunicatorAPI {


    @Override
    public String getJSON(Context context) {


        getResponse(context);
        return "";


    }

    private void getResponse(final Context context)
    {

        //Toast.makeText(context,"Response" ,Toast.LENGTH_SHORT).show();
        new AsyncTask()
        {

            @Override
            protected Object doInBackground(Object[] objects) {

                HttpClient client = new DefaultHttpClient();


                String url ="http://hmkcode.com/examples/index.php";
                //url="http://api.kanjo.com.mx/json/test";

                HttpGet mGet = new HttpGet(url);

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

                    return builder.toString();

                }
                catch (ClientProtocolException cpEX)
                {

                }
                catch (IOException ioEx)
                {

                }
                return  "Not result";

            }

            @Override
            protected void onPostExecute(Object o) {
                Toast.makeText(context,"Response" + o.toString() ,Toast.LENGTH_SHORT).show();
            }
        }.execute(context);

    }
}
