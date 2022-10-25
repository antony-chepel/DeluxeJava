package com.fuseboxgames.loveislang.deluxeblack;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;
import com.orhanobut.hawk.Hawk;

public class AppClassDeluxe extends Application {
    public static final String FUNC_ID = "funcId";
    private static final String ONESIGNAL_APP_ID = "d8af799a-6f50-4698-b90b-a8b225929784";

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        Hawk.init(this).build();
        gltask.execute();

    }

    @SuppressLint("StaticFieldLeak")
    AsyncTask<Void, Void, String> gltask = new AsyncTask<Void, Void, String>() {
        @Override
        protected String doInBackground(Void... params) {
            AdvertisingIdClient.Info idInfo = null;
            try {
                idInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String advertId = null;
            try {
                advertId = idInfo.getId();
                Hawk.put(FUNC_ID, advertId);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return advertId;
        }

        @Override
        protected void onPostExecute(String advertId) {
        }
    };
}
