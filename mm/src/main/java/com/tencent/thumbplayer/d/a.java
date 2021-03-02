package com.tencent.thumbplayer.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String RYZ = "";
    private static String RZa;
    private static String RZb;
    private static int RZc = -1;
    private static String RZd;
    private static boolean RZe;
    private static String RZf = "";
    private static int RZg = 0;
    private static String RZh = "";
    private static boolean RZi = true;
    private static int RZj = -1;
    public static String RZk = "";
    public static String RZl = "";
    private static String RZm = "";
    private static String RZn = "\\.";
    private static long RZo = -1;
    private static String appVersion = "";
    private static String appVersionName;

    public static void bqy(String str) {
        AppMethodBeat.i(189143);
        if (TextUtils.isEmpty(str)) {
            g.w("TPPlayerConfig", "parseHostConfig, config is null.");
            AppMethodBeat.o(189143);
            return;
        }
        RZm = str;
        g.i("TPPlayerConfig", "parseHostConfig:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(TPPlayerMgr.BEACON_PLYAER_HOST_KEY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(TPPlayerMgr.BEACON_PLYAER_HOST_KEY);
                if (jSONObject2.has(TPPlayerMgr.BEACON_POLICY_HOST_KEY)) {
                    RZk = jSONObject2.getString(TPPlayerMgr.BEACON_POLICY_HOST_KEY);
                }
                if (jSONObject2.has(TPPlayerMgr.BEACON_LOG_HOST_KEY)) {
                    RZl = jSONObject2.getString(TPPlayerMgr.BEACON_LOG_HOST_KEY);
                }
            }
            AppMethodBeat.o(189143);
        } catch (Throwable th) {
            g.w("TPPlayerConfig", "parseHostConfig exception: " + th.toString());
            AppMethodBeat.o(189143);
        }
    }

    public static void setDebugEnable(boolean z) {
        AppMethodBeat.i(189144);
        g.setDebugEnable(z);
        AppMethodBeat.o(189144);
    }

    public static void DT(boolean z) {
        RZi = z;
    }

    public static boolean hnj() {
        return RZi;
    }

    public static String getGuid() {
        return RYZ;
    }

    public static void setGuid(String str) {
        RYZ = str;
    }

    public static String hnk() {
        return RZa;
    }

    public static String hnl() {
        return RZb;
    }

    public static String hnm() {
        AppMethodBeat.i(189145);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(RZm)) {
            try {
                jSONObject.put("host_config", new JSONObject(RZm));
            } catch (JSONException e2) {
                g.e("TPPlayerConfig", e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(189145);
        return jSONObject2;
    }

    public static String hnn() {
        return RZd;
    }

    public static void bqz(String str) {
        RZd = str;
    }

    public static void bqA(String str) {
        RZf = str;
    }

    public static String hno() {
        return RZf;
    }

    public static void arn(int i2) {
        RZg = i2;
    }

    public static int hnp() {
        return RZg;
    }

    public static String hnq() {
        return RZh;
    }

    public static void bqB(String str) {
        RZh = str;
    }

    public static boolean hnr() {
        return RZe;
    }

    public static void DU(boolean z) {
        RZe = z;
    }

    public static void setProxyServiceType(int i2) {
        RZc = i2;
    }

    public static int hns() {
        if (RZc != -1 || RZj == -1) {
            return RZc;
        }
        return RZj;
    }

    public static int getPlatform() {
        return RZj;
    }

    public static void setPlatform(int i2) {
        RZj = i2;
    }

    public static String getAppVersionName(Context context) {
        AppMethodBeat.i(189146);
        if (!TextUtils.isEmpty(appVersionName)) {
            String str = appVersionName;
            AppMethodBeat.o(189146);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(189146);
            return "";
        } else {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                appVersionName = str2;
                if (str2 == null) {
                    str2 = "";
                }
                AppMethodBeat.o(189146);
                return str2;
            } catch (Throwable th) {
                AppMethodBeat.o(189146);
                return "";
            }
        }
    }

    public static long li(Context context) {
        AppMethodBeat.i(189147);
        if (-1 != RZo) {
            long j2 = RZo;
            AppMethodBeat.o(189147);
            return j2;
        }
        try {
            long longVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
            RZo = longVersionCode;
            AppMethodBeat.o(189147);
            return longVersionCode;
        } catch (Throwable th) {
            g.e("TPPlayerConfig", "getLongVersionCode less api 28");
            long j3 = RZo;
            AppMethodBeat.o(189147);
            return j3;
        }
    }
}
