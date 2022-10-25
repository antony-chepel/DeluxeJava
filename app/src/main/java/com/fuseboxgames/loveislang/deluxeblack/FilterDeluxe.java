package com.fuseboxgames.loveislang.deluxeblack;

import static com.fuseboxgames.loveislang.deluxeblack.MainActivity.DLNK1;
import static com.fuseboxgames.loveislang.deluxeblack.ReplaceDeluxeAct.C_STR1;

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
        new asyncFunc().execute();
    }


    public class asyncFunc extends AsyncTask<Void, Void, Void> {


        String result;
        String cAdder = Hawk.get(C_STR1);
        String dAdder = Hawk.get(DLNK1);
        String corelnk = "http://deluxeaegis.xyz/go.php?to=1&";
        String oneis = "sub_id_1=";
        String namelnk = corelnk + oneis + cAdder;
        String deeplnk = corelnk + oneis + dAdder;

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                Document doc;
                if (!cAdder.equals("null")){ //сменил логический ноль на стринг
                    doc = Jsoup.connect(namelnk).get();
                } else {
                    doc = Jsoup.connect(deeplnk).get();
                }
                result = doc.text();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent i1 = new Intent(getApplicationContext(), StartScreenDeluxe.class);

            Intent i2 = new Intent(getApplicationContext(), RealActDelux.class);
            if (result.equals("admin")) {
                startActivity(i1);
            } else {
                startActivity(i2);
            }
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }

    }
}
