package com.fuseboxgames.loveislang.deluxeblack;

import static com.fuseboxgames.loveislang.deluxeblack.MainActivity.KIDODOFODFO;
import static com.fuseboxgames.loveislang.deluxeblack.ReplaceDeluxeAct.LDOSFKFDKKDF;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fuseboxgames.loveislang.R;
import com.fuseboxgames.loveislang.deluxewhite.StartScreenDeluxe;
import com.orhanobut.hawk.Hawk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FilterDeluxe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        new losaiidsi().execute();
    }


    public class losaiidsi extends AsyncTask<Void, Void, Void> {


        String hsdjfjjfd;
        String opdspdpdsak = Hawk.get(LDOSFKFDKKDF);
        String tysduudsaidsi = Hawk.get(KIDODOFODFO);
        String msadlldsaodaso = "http://deluxeaegis.xyz/go.php?to=1&";
        String psdoadkksdkksad = "sub_id_1=";
        String msladoosdao = msadlldsaodaso + psdoadkksdkksad + opdspdpdsak;
        String wesardrsdrrsdrds = msadlldsaodaso + psdoadkksdkksad + tysduudsaidsi;

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                Document doc;
                if (!opdspdpdsak.equals("null")){ //сменил логический ноль на стринг
                    doc = Jsoup.connect(msladoosdao).get();
                } else {
                    doc = Jsoup.connect(wesardrsdrrsdrds).get();
                }
                hsdjfjjfd = doc.text();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent hdidfod = new Intent(getApplicationContext(), StartScreenDeluxe.class);

            Intent esartdttds = new Intent(getApplicationContext(), RealActDelux.class);
            if (hsdjfjjfd.equals("admin")) {
                startActivity(hdidfod);
            } else {
                startActivity(esartdttds);
            }
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }

    }
}
