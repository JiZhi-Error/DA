package com.tencent.mm.plugin.sns.waid;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import org.json.JSONObject;

public final class b {
    public static String aRy(String str) {
        AppMethodBeat.i(204037);
        if (TextUtils.isEmpty(str)) {
            Log.d("ad.waid.WaidHelper", "getAppWaid, pkg is empty");
            AppMethodBeat.o(204037);
            return "";
        } else if (!flt()) {
            Log.w("ad.waid.WaidHelper", "getAppWaid, isInnerExptWaidEnable==false");
            AppMethodBeat.o(204037);
            return "";
        } else {
            String aRz = aRz(str);
            AppMethodBeat.o(204037);
            return aRz;
        }
    }

    public static synchronized String aRz(String str) {
        String str2;
        synchronized (b.class) {
            AppMethodBeat.i(204038);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = kT(str, flp());
                Log.i("ad.waid.WaidHelper", "doGetAppWaid pkg=" + str + ", appWaid=" + str2 + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(204038);
            } catch (Throwable th) {
                Log.e("ad.waid.WaidHelper", "doGetAppWaid exp=" + th.toString());
                str2 = "";
                AppMethodBeat.o(204038);
            }
        }
        return str2;
    }

    private static String aRA(String str) {
        AppMethodBeat.i(204040);
        String replace = Util.nullAsNil(str).replace(" ", "_");
        AppMethodBeat.o(204040);
        return replace;
    }

    private static String kT(String str, String str2) {
        AppMethodBeat.i(204041);
        String trim = Util.nullAsNil(str).trim();
        if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(204041);
            return "";
        }
        try {
            String messageDigest = g.getMessageDigest((trim.toLowerCase() + "_" + str2).getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            if (!TextUtils.isEmpty(messageDigest)) {
                String concat = "waid".concat(String.valueOf(messageDigest));
                AppMethodBeat.o(204041);
                return concat;
            }
        } catch (Throwable th) {
            Log.e("ad.waid.WaidHelper", "getAppWaid, exp=" + th.toString());
        }
        AppMethodBeat.o(204041);
        return "";
    }

    private static void kU(String str, String str2) {
        AppMethodBeat.i(204042);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(204042);
            return;
        }
        String nullAsNil = Util.nullAsNil(str2);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
        int flr = flr();
        if (flr >= 10) {
            mmkv.clear().commit();
            Log.e("ad.waid.WaidHelper", "saveKVString, clearKv, kvCOunt=".concat(String.valueOf(flr)));
        }
        mmkv.edit().putString(str, nullAsNil).commit();
        AppMethodBeat.o(204042);
    }

    private static String flq() {
        AppMethodBeat.i(204043);
        JSONObject jSONObject = new JSONObject();
        try {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("ad_id_kv_pref");
            String[] allKeys = mmkv.allKeys();
            if (allKeys != null && allKeys.length > 0) {
                for (String str : allKeys) {
                    jSONObject.put(str, mmkv.getString(str, ""));
                }
            }
        } catch (Throwable th) {
            Log.e("ad.waid.WaidHelper", "dumpKV exp=" + th.toString());
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(204043);
        return jSONObject2;
    }

    private static int flr() {
        int i2 = 0;
        AppMethodBeat.i(204044);
        try {
            String[] allKeys = MultiProcessMMKV.getMMKV("ad_id_kv_pref").allKeys();
            if (allKeys == null) {
                AppMethodBeat.o(204044);
            } else {
                i2 = allKeys.length;
                AppMethodBeat.o(204044);
            }
        } catch (Throwable th) {
            Log.e("ad.waid.WaidHelper", "getKVCount exp=" + th.toString());
            AppMethodBeat.o(204044);
        }
        return i2;
    }

    public static boolean fls() {
        AppMethodBeat.i(204045);
        try {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_waid_switch, 0) > 0) {
                AppMethodBeat.o(204045);
                return true;
            }
            AppMethodBeat.o(204045);
            return false;
        } catch (Throwable th) {
            Log.e("ad.waid.WaidHelper", "isExptWaidEnable, exp=" + th.toString());
            AppMethodBeat.o(204045);
            return false;
        }
    }

    private static boolean flt() {
        AppMethodBeat.i(204046);
        try {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_waid_inner_switch, 1) > 0) {
                AppMethodBeat.o(204046);
                return true;
            }
            AppMethodBeat.o(204046);
            return false;
        } catch (Throwable th) {
            Log.e("ad.waid.WaidHelper", "isInnerExptWaidEnable, exp=" + th.toString());
            AppMethodBeat.o(204046);
            return false;
        }
    }

    private static boolean flu() {
        AppMethodBeat.i(204047);
        try {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_waid_update_switch, 0) > 0) {
                AppMethodBeat.o(204047);
                return true;
            }
            AppMethodBeat.o(204047);
            return false;
        } catch (Throwable th) {
            Log.e("ad.waid.WaidHelper", "isExptWaidNeedUpdate, exp=" + th.toString());
            AppMethodBeat.o(204047);
            return false;
        }
    }

    public static boolean flv() {
        AppMethodBeat.i(204048);
        if (!com.tencent.mm.kernel.g.aAi().hrr || !com.tencent.mm.kernel.g.aAf().azp()) {
            AppMethodBeat.o(204048);
            return false;
        }
        AppMethodBeat.o(204048);
        return true;
    }

    private static String flp() {
        int i2 = 1;
        AppMethodBeat.i(204039);
        try {
            String str = "appWaid_" + aRA(Build.BRAND) + "_" + aRA(Build.MODEL);
            String string = MultiProcessMMKV.getMMKV("ad_id_kv_pref").getString(str, "");
            String exO = d.INSTANCE.exO();
            Log.i("ad.waid.WaidHelper", "getRawWaid, key=" + str + ", wxWaid=" + exO + ", localWaid=" + string);
            if (TextUtils.isEmpty(string) && !TextUtils.isEmpty(exO)) {
                kU(str, exO);
                String flq = flq();
                int flr = flr();
                Log.w("ad.waid.WaidHelper", "device changed, update localWaid, key=" + str + ", kvCount=" + flr);
                if (flr > 1) {
                    if (!flv()) {
                        Log.e("ad.waid.WaidReporter", "reportDeviceChange isWxEnvInitDone==false");
                        string = exO;
                    } else {
                        try {
                            String aRB = c.aRB(flq);
                            Log.i("ad.waid.WaidReporter", "reportDeviceChange data=".concat(String.valueOf(aRB)));
                            h.INSTANCE.a(18666, 2004, aRB);
                            string = exO;
                        } catch (Throwable th) {
                            Log.e("ad.waid.WaidReporter", "reportDeviceChange exp=" + android.util.Log.getStackTraceString(th));
                        }
                    }
                }
                string = exO;
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(exO) && !string.equals(exO)) {
                boolean flu = flu();
                Log.i("ad.waid.WaidHelper", "waid Changed, key=" + str + ", localWaid=" + string + ", wxWaid=" + exO + ", isNeedUpdate=" + flu);
                if (flu) {
                    kU(str, exO);
                    string = exO;
                }
                int flr2 = flr();
                if (!flu) {
                    i2 = 0;
                }
                if (!flv()) {
                    Log.e("ad.waid.WaidReporter", "reportWaidChange isWxEnvInitDone==false");
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("needUpdate", i2);
                        jSONObject.put("kvCount", flr2);
                        String aRB2 = c.aRB(jSONObject.toString());
                        Log.i("ad.waid.WaidReporter", "reportWaidChange data=".concat(String.valueOf(aRB2)));
                        h.INSTANCE.a(18666, 2003, aRB2);
                    } catch (Throwable th2) {
                        Log.e("ad.waid.WaidReporter", "reportWaidChange exp=" + android.util.Log.getStackTraceString(th2));
                    }
                }
            }
            AppMethodBeat.o(204039);
            return string;
        } catch (Throwable th3) {
            Log.e("ad.waid.WaidHelper", "getRawWaid exp=" + android.util.Log.getStackTraceString(th3));
            AppMethodBeat.o(204039);
            return "";
        }
    }
}
