package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class b {
    public static String TAG = "MicroMsg.AppBrandAdABTests[AppBrandSplashAd]";
    private static Set<Integer> kGp;

    static {
        AppMethodBeat.i(226256);
        HashSet hashSet = new HashSet();
        kGp = hashSet;
        hashSet.add(1001);
        kGp.add(1089);
        kGp.add(1104);
        kGp.add(1103);
        AppMethodBeat.o(226256);
    }

    public static void btE() {
        AppMethodBeat.i(44003);
        MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("showad");
        AppMethodBeat.o(44003);
    }

    public static void vJ(int i2) {
        AppMethodBeat.i(44004);
        MultiProcessMMKV.getMMKV("appbrandAd").encode("showad", i2);
        AppMethodBeat.o(44004);
    }

    public static void btG() {
        AppMethodBeat.i(44006);
        MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("allshowad");
        AppMethodBeat.o(44006);
    }

    public static void vK(int i2) {
        AppMethodBeat.i(44007);
        MultiProcessMMKV.getMMKV("appbrandAd").encode("allshowad", i2);
        AppMethodBeat.o(44007);
    }

    public static boolean vL(int i2) {
        boolean contains;
        AppMethodBeat.i(226253);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_ad_scene, "");
        if (!Util.isNullOrNil(a2)) {
            try {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = new JSONArray(a2);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    hashSet.add(Integer.valueOf(jSONArray.optInt(i3)));
                }
                Log.i(TAG, "checkSceneForShowAd, abtest set:%s, scene:%s", hashSet, Integer.valueOf(i2));
                contains = hashSet.contains(Integer.valueOf(i2));
            } catch (Exception e2) {
                Log.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", kGp, Integer.valueOf(i2));
                contains = kGp.contains(Integer.valueOf(i2));
            }
        } else {
            Log.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", kGp, Integer.valueOf(i2));
            contains = kGp.contains(Integer.valueOf(i2));
        }
        AppMethodBeat.o(226253);
        return contains;
    }

    public static int bsL() {
        AppMethodBeat.i(226254);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_ad_code_block_time, 0);
        Log.i(TAG, "getCodeBlockTimeThreshold, timeThreshold:%s", Integer.valueOf(a2));
        AppMethodBeat.o(226254);
        return a2;
    }

    public static int btI() {
        AppMethodBeat.i(226255);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_ad_check_block_time, 0);
        Log.i(TAG, "getCheckBlockTimeThreshold, timeThreshold:%d", Integer.valueOf(a2));
        AppMethodBeat.o(226255);
        return a2;
    }

    public static boolean btF() {
        AppMethodBeat.i(44005);
        int decodeInt = MultiProcessMMKV.getMMKV("appbrandAd").decodeInt("showad", -1);
        if (decodeInt >= 0) {
            Log.i(TAG, "canShowAppBrandAd, command value:%s", Integer.valueOf(decodeInt));
            if (decodeInt == 1) {
                AppMethodBeat.o(44005);
                return true;
            }
            AppMethodBeat.o(44005);
            return false;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_ad, 0);
        Log.i(TAG, "canShowAppBrandAd, experiment value:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            AppMethodBeat.o(44005);
            return true;
        }
        AppMethodBeat.o(44005);
        return false;
    }

    public static boolean btH() {
        AppMethodBeat.i(44008);
        int decodeInt = MultiProcessMMKV.getMMKV("appbrandAd").decodeInt("allshowad", -1);
        if (decodeInt >= 0) {
            Log.i(TAG, "canAllShowAppBrandAd, command value:%s", Integer.valueOf(decodeInt));
            if (decodeInt == 1) {
                AppMethodBeat.o(44008);
                return true;
            }
            AppMethodBeat.o(44008);
            return false;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_all_show_ad, 0);
        Log.i(TAG, "canAllShowAppBrandAd, experiment value:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            AppMethodBeat.o(44008);
            return true;
        }
        AppMethodBeat.o(44008);
        return false;
    }
}
