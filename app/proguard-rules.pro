# Appsflyer
-dontwarn com.appsflyer.AFKeystoreWrapper

-keepnames class * implements android.os.Parcelable
-keepclassmembers class * implements android.os.Parcelable {
  public static final *** CREATOR;
}
#JSoup
-keep public class org.jsoup.** {
public *;
}

# Onesignal
-dontwarn com.onesignal.**
-keep class com.onesignal.ActivityLifecycleListenerCompat** {*;}

# Facebook
-keep class com.facebook.** {
   *;
}
