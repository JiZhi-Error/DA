package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.common.ConfigStorage;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import org.json.JSONObject;

public class HttpproxyFacade {
    private static String TAG = "TV_Httpproxy";
    private static final String dev_type = "2";
    private static Context mContext = null;
    private static HttpproxyFacade mInstance = null;
    private static boolean mbHttpProxyExist = false;
    private IUtils mUtils = null;

    public native String buildPlayURL(int i2);

    public native int cleanStorage();

    public native void deinit();

    public native int getCurrentOffset(int i2);

    public native int getLocalServerPort();

    public native int getTotalOffset(int i2);

    public native String getVersion();

    public native int init(String str, String str2);

    public native int preLoad(int i2, int i3);

    public native void pushEvent(int i2);

    public native void setCookie(String str);

    public native int setMaxStorageSize(long j2);

    public native void setNetWorkState(int i2);

    public native void setPlayerState(int i2);

    public native void setRemainTime(int i2, int i3);

    public native int startPlay(String str, int i2, String str2, long j2, int i3);

    public native void stopPlay(int i2);

    private HttpproxyFacade() {
    }

    public static synchronized HttpproxyFacade instance() {
        HttpproxyFacade httpproxyFacade;
        synchronized (HttpproxyFacade.class) {
            AppMethodBeat.i(89676);
            if (mInstance == null) {
                mInstance = new HttpproxyFacade();
            }
            httpproxyFacade = mInstance;
            AppMethodBeat.o(89676);
        }
        return httpproxyFacade;
    }

    public static boolean isLoadSuccess() {
        return mbHttpProxyExist;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public void setUtils(IUtils iUtils) {
        this.mUtils = iUtils;
    }

    public static synchronized void javaUtilLog(String str) {
        synchronized (HttpproxyFacade.class) {
            AppMethodBeat.i(89677);
            HttpproxyFacade instance = instance();
            if (instance.mUtils != null) {
                instance.mUtils.javaUtilLog(4, TAG, str);
                AppMethodBeat.o(89677);
            } else {
                "IUtils.javaUtilLog not init ".concat(String.valueOf(str));
                AppMethodBeat.o(89677);
            }
        }
    }

    public static void print(int i2, String str, String str2) {
        AppMethodBeat.i(89678);
        HttpproxyFacade instance = instance();
        if (instance.mUtils != null) {
            instance.mUtils.javaUtilLog(i2, str, str2);
            AppMethodBeat.o(89678);
            return;
        }
        "IUtils.javaUtilLog not init ".concat(String.valueOf(str2));
        AppMethodBeat.o(89678);
    }

    public static void jsonReport(String str) {
        String str2;
        AppMethodBeat.i(89679);
        try {
            String deviceID = VcSystemInfo.getDeviceID(mContext);
            String osVersion = VcSystemInfo.getOsVersion();
            int netWorkType = VcSystemInfo.getNetWorkType(mContext);
            WifiInfo connectionInfo = ((WifiManager) mContext.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                str2 = String.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5));
            } else {
                str2 = "";
            }
            String httpProxyVersion = ConfigStorage.getHttpProxyVersion();
            String configVersion = ConfigStorage.getConfigVersion();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("dev_id", deviceID);
            jSONObject.put("dev_type", "2");
            jSONObject.put("os_ver", osVersion);
            jSONObject.put("net_type", netWorkType);
            jSONObject.put("net_stren", str2);
            jSONObject.put("config_ver", configVersion);
            jSONObject.put("proxy_ver", httpProxyVersion);
            String jSONObject2 = jSONObject.toString();
            "IUtils.MTA_Report:".concat(String.valueOf(jSONObject2));
            String replace = jSONObject2.replace(",", ";");
            if (!TextUtils.isEmpty(replace)) {
                HttpproxyFacade instance = instance();
                if (instance.mUtils == null) {
                    "IUtils.MTA_Report:".concat(String.valueOf(replace));
                    AppMethodBeat.o(89679);
                    return;
                } else if (replace.length() <= 1000) {
                    instance.mUtils.httpproxyReport(replace);
                    AppMethodBeat.o(89679);
                    return;
                } else {
                    int length = replace.length();
                    if (length > 2000) {
                        length = 2000;
                    }
                    instance.mUtils.httpproxyReport(replace.substring(0, 1000), replace.substring(1000, length));
                    AppMethodBeat.o(89679);
                    return;
                }
            }
        } catch (Throwable th) {
            print(6, TAG, "reportMTA exception");
        }
        AppMethodBeat.o(89679);
    }

    public static void idKeyReport(String str, String str2, String str3) {
        AppMethodBeat.i(89680);
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HttpproxyFacade instance = instance();
                if (instance.mUtils != null) {
                    new StringBuilder("idKeyReport:id=").append(str).append(",key=").append(str2).append(",value=").append(str3);
                    instance.mUtils.idKeyReport(str, str2, str3);
                    AppMethodBeat.o(89680);
                    return;
                }
            }
        } catch (Throwable th) {
            print(6, TAG, "idKeyReport exception");
        }
        AppMethodBeat.o(89680);
    }

    public static void kvReport(String str) {
        AppMethodBeat.i(89681);
        try {
            String httpProxyVersionCode = ConfigStorage.getHttpProxyVersionCode();
            String configVersion = ConfigStorage.getConfigVersion();
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("DownloadResult");
            String optString2 = jSONObject.optString("OptimalCDN");
            String optString3 = jSONObject.optString("VideoRate");
            String optString4 = jSONObject.optString("VideoTotalFileLength");
            String optString5 = jSONObject.optString("VideoContentLength");
            String optString6 = jSONObject.optString("DownloadTotalFlow");
            String optString7 = jSONObject.optString("DownloadCostTime");
            String optString8 = jSONObject.optString("DownloadAverageSpeed");
            String optString9 = jSONObject.optString("DownloadMaxSpeed");
            String optString10 = jSONObject.optString("DownloadMinSpeed");
            HttpproxyFacade instance = instance();
            if (instance.mUtils != null) {
                instance.mUtils.kvReport(optString, optString2, httpProxyVersionCode, configVersion, optString3, optString4, optString5, optString6, optString7, optString8, optString9, optString10);
                AppMethodBeat.o(89681);
                return;
            }
        } catch (Throwable th) {
            print(6, TAG, "kvReport exception");
        }
        AppMethodBeat.o(89681);
    }
}
