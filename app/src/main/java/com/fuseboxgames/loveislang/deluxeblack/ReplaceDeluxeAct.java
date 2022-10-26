package com.fuseboxgames.loveislang.deluxeblack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.fuseboxgames.loveislang.R;
import com.orhanobut.hawk.Hawk;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReplaceDeluxeAct extends AppCompatActivity {
    public static final String LDOSFKFDKKDF = "cstR1";
    private static final String RTDSJJDSJJDSJA = "DkUz92ReUG3rBQni5Vvo2W";

    String stMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            String hawkI = Hawk.get(LDOSFKFDKKDF);
            if (hawkI != null) {
                Log.d("TestInUIHawk", hawkI);
                osdpdsksdksakkd();
                executorService.shutdown();
                finish();
            } else {
                Log.d("TestInUIHawk", "Received null");
            }
        }, 0, 2, TimeUnit.SECONDS);


        ttsduusdjsdjsdj();

        SharedPreferences osdiisdjsdjjsd = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (osdiisdjsdjjsd.getBoolean("activity_exec", false)) {
            Intent intent = new Intent(this, FilterDeluxe.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor exec = osdiisdjsdjjsd.edit();
            exec.putBoolean("activity_exec", true);
            exec.apply();
        }
    }



    public void osdpdsksdksakkd() {

        Intent intent = new Intent(ReplaceDeluxeAct.this, FilterDeluxe.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    public void ttsduusdjsdjsdj() {
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {

            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {


                Log.d("TESTING_ZONE", "af stat is " + conversionData.get("af_status"));
                String status = (String) conversionData.get("af_status");
                if (Objects.equals(status, "Organic")) {
                    stMain = "null";
                } else {
                    stMain = (String) conversionData.get("campaign");
                }
                Hawk.put(LDOSFKFDKKDF, stMain);
                Log.d("NAMING TEST", "campaign attributed: " + stMain);
            }


            @Override
            public void onConversionDataFail(String errorMessage) {
                stMain = "null";
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
            }

            @Override
            public void onAttributionFailure(String errorMessage) {
            }

        };

        AppsFlyerLib.getInstance().init(RTDSJJDSJJDSJA, conversionListener, this);
        AppsFlyerLib.getInstance().start(this);
        AppsFlyerLib.getInstance().setDebugLog(true);

    }
}
