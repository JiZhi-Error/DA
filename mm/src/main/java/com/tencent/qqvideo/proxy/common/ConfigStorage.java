package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigStorage {
    private static String Config_Version = "";
    private static final long GET_CONFIG_INTERVAL = 600000;
    private static long LastGetConfigTime = 0;
    private static final String PREFERENCE = "_httpproxy_preferences";
    public static final String PREF_DOWNPROXY_CONFIG = "DOWNPROXY_CONFIG";
    public static final String PREF_DOWNPROXY_CONFIG_VERSION = "DOWNPROXY_GUID_CONFIG_VERSION";
    private static String TAG = "TV_Httpproxy";
    private static final String TVHttpProxy_Version = "V1.0.186.0011";
    private static final String TVHttpProxy_Version_Code = "101860011";
    private static final String TVHttpProxy_channel_id = "186";
    private static final int[] connectTimeOut = {5000, 5000, 10000};
    private static String guid = "123";
    private static final String httpsCrtFileName = "videosdkcrt/sec.video.qq.com.crt";
    private static final String ipflag = "1";
    private static final String otype = "json";
    private static final String platform = "aphone";
    private static final int[] readTimeOut = {10000, 10000, 15000};
    private static final int[] retryTimes = {3, 2};
    private static String sharedPreferencesName = null;
    private static final String url = "https://sec.video.qq.com/p/wxconf/getmfomat";
    private Thread thread = null;

    public static SharedPreferences getSharedPreferences(Context context, String str, int i2) {
        AppMethodBeat.i(89731);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i2);
        AppMethodBeat.o(89731);
        return sharedPreferences;
    }

    public static SharedPreferences getAppSharedPreferences(Context context) {
        AppMethodBeat.i(89732);
        if (sharedPreferencesName == null) {
            sharedPreferencesName = String.valueOf(context.getPackageName()) + PREFERENCE;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(context, sharedPreferencesName, 0);
        AppMethodBeat.o(89732);
        return sharedPreferences;
    }

    public static String getDownProxyConfig(Context context) {
        AppMethodBeat.i(89733);
        if (context == null) {
            AppMethodBeat.o(89733);
            return "";
        }
        Config_Version = getConfigVersionFromSharedPreference(context);
        String string = getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG, "");
        AppMethodBeat.o(89733);
        return string;
    }

    public static void setDownProxyConfig(Context context, String str) {
        AppMethodBeat.i(89734);
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG, str).commit();
        AppMethodBeat.o(89734);
    }

    public static String getHttpProxyVersion() {
        return TVHttpProxy_Version;
    }

    public static String getHttpProxyVersionCode() {
        return TVHttpProxy_Version_Code;
    }

    public static String getConfigVersion() {
        return Config_Version;
    }

    private static String getConfigVersionFromSharedPreference(Context context) {
        AppMethodBeat.i(89735);
        if (context == null) {
            AppMethodBeat.o(89735);
            return "";
        }
        String string = getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG_VERSION, "");
        AppMethodBeat.o(89735);
        return string;
    }

    private static void setConfigVersionToSharedPreference(Context context, String str) {
        AppMethodBeat.i(89736);
        if (context == null || str == null) {
            AppMethodBeat.o(89736);
            return;
        }
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG_VERSION, str).commit();
        AppMethodBeat.o(89736);
    }

    public void synGetServerConfig(final Context context) {
        AppMethodBeat.i(89737);
        if (context == null) {
            HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
            AppMethodBeat.o(89737);
            return;
        }
        try {
            this.thread = new Thread(new Runnable() {
                /* class com.tencent.qqvideo.proxy.common.ConfigStorage.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(89730);
                    ConfigStorage.access$0(ConfigStorage.this, context);
                    AppMethodBeat.o(89730);
                }
            });
            if (this.thread == null) {
                HttpproxyFacade.print(6, TAG, "thread create failed");
                AppMethodBeat.o(89737);
                return;
            }
            this.thread.start();
            AppMethodBeat.o(89737);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
            AppMethodBeat.o(89737);
        }
    }

    public void stopGetServerConfig() {
        AppMethodBeat.i(89738);
        try {
            if (this.thread != null) {
                this.thread.interrupt();
                AppMethodBeat.o(89738);
                return;
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
        AppMethodBeat.o(89738);
    }

    private boolean needGetConfig() {
        AppMethodBeat.i(89739);
        if (LastGetConfigTime == 0) {
            LastGetConfigTime = System.currentTimeMillis();
            AppMethodBeat.o(89739);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - LastGetConfigTime > GET_CONFIG_INTERVAL || currentTimeMillis < LastGetConfigTime) {
            LastGetConfigTime = System.currentTimeMillis();
            AppMethodBeat.o(89739);
            return true;
        }
        AppMethodBeat.o(89739);
        return false;
    }

    static /* synthetic */ void access$0(ConfigStorage configStorage, Context context) {
        AppMethodBeat.i(89745);
        configStorage.synGetConfig(context);
        AppMethodBeat.o(89745);
    }

    private void synGetConfig(Context context) {
        AppMethodBeat.i(89740);
        if (!needGetConfig()) {
            HttpproxyFacade.print(4, TAG, "last get config time:" + System.currentTimeMillis() + ",so get config just return");
            AppMethodBeat.o(89740);
            return;
        }
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(fetchTextFromUrl(makeGetServerConfigUrl(context), context));
            if (jSONObject.has("httpproxy_config")) {
                i2 = 0;
                HttpproxyFacade.print(3, TAG, "get httpproxy_config:" + jSONObject.getString("httpproxy_config"));
                setDownProxyConfig(context, jSONObject.getString("httpproxy_config"));
            }
            if (jSONObject.has("config_ver")) {
                setConfigVersionToSharedPreference(context, jSONObject.getString("config_ver"));
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "get config exception");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_code", i2);
            jSONObject2.put("report_type", 90);
            HttpproxyFacade.jsonReport(jSONObject2.toString());
            AppMethodBeat.o(89740);
        } catch (JSONException e2) {
            AppMethodBeat.o(89740);
        }
    }

    private String makeGetServerConfigUrl(Context context) {
        AppMethodBeat.i(89741);
        String format = String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", url, platform, TVHttpProxy_Version, TVHttpProxy_channel_id, otype, "1", guid);
        AppMethodBeat.o(89741);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0072 A[SYNTHETIC, Splitter:B:15:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A[SYNTHETIC, Splitter:B:21:0x007e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.net.ssl.SSLContext getHttpsSSLContext(android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.common.ConfigStorage.getHttpsSSLContext(android.content.Context):javax.net.ssl.SSLContext");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0120 A[SYNTHETIC, Splitter:B:38:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0125 A[SYNTHETIC, Splitter:B:41:0x0125] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a A[SYNTHETIC, Splitter:B:47:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013f A[SYNTHETIC, Splitter:B:50:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0149 A[SYNTHETIC, Splitter:B:56:0x0149] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014e A[SYNTHETIC, Splitter:B:59:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0128 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0128 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String fetchTextFromUrl(java.lang.String r17, android.content.Context r18) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.common.ConfigStorage.fetchTextFromUrl(java.lang.String, android.content.Context):java.lang.String");
    }

    private String getBkDomain(String str) {
        AppMethodBeat.i(89744);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(89744);
            return "";
        }
        AppMethodBeat.o(89744);
        return str;
    }
}
