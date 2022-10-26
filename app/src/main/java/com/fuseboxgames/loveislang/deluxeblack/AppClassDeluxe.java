package com.fuseboxgames.loveislang.deluxeblack;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;
import com.orhanobut.hawk.Hawk;

public class AppClassDeluxe extends Application {
    public static final String KDOSDLFLFDLSLFD = "funcId";
    private static final String YUDSIDIIFJJFDJSFJ = "d8af799a-6f50-4698-b90b-a8b225929784";

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        OneSignal.initWithContext(this);
        OneSignal.setAppId(YUDSIDIIFJJFDJSFJ);
        Hawk.init(this).build();
        gltask.execute();

    }

    @SuppressLint("StaticFieldLeak")
    AsyncTask<Void, Void, String> gltask = new AsyncTask<Void, Void, String>() {
        @Override
        protected String doInBackground(Void... params) {
            AdvertisingIdClient.Info kdosdldlflfkd = null;
            try {
                kdosdldlflfkd = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String odisisfjdfjjsdf = null;
            try {
                odisisfjdfjjsdf = kdosdldlflfkd.getId();
                Hawk.put(KDOSDLFLFDLSLFD, odisisfjdfjjsdf);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return odisisfjdfjjsdf;
        }

        @Override
        protected void onPostExecute(String advertId) {
        }
    };
}
