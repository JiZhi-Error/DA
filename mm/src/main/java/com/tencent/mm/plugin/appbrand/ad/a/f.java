package com.tencent.mm.plugin.appbrand.ad.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.Random;

public final class f extends s {
    private static final int CTRL_INDEX = 750;
    public static final String NAME = "shouldShowSplashAd";
    public String source = "launch";

    public final void a(com.tencent.mm.plugin.appbrand.s sVar, Context context) {
        int[] f2;
        AppMethodBeat.i(44050);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", sVar.getAppId());
        hashMap.put("appName", sVar.getRuntime().OU().brandName);
        hashMap.put("appIcon", sVar.getRuntime().OU().iconUrl);
        if (sVar.getRuntime() instanceof q) {
            hashMap.put("scene", Integer.valueOf(((q) sVar.getRuntime()).ON().cyA.scene));
        }
        hashMap.put("source", Util.nullAs(this.source, "launch"));
        boolean isDarkMode = ao.isDarkMode();
        hashMap.put("isDarkMode", Boolean.valueOf(isDarkMode));
        boolean z = false;
        if (sVar.getRuntime() instanceof q) {
            z = ((q) sVar.getRuntime()).NA();
        }
        hashMap.put("isGame", Boolean.valueOf(z));
        int bsL = b.bsL();
        hashMap.put("timeThreshold", Integer.valueOf(bsL));
        String UE = UE(String.format("%s_%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(10000))));
        hashMap.put("instanceId", UE);
        hashMap.put("weixinVersion", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
        hashMap.put("osType", 2);
        hashMap.put("osVersion", "Android " + Build.VERSION.RELEASE);
        hashMap.put("model", Build.MODEL);
        f.c dS = com.tencent.mm.plugin.appbrand.jsapi.z.f.dS(context == null ? MMApplicationContext.getContext() : context);
        hashMap.put("networkType", dS.value);
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f2 = new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        } else {
            f2 = ai.f(sVar);
        }
        int i2 = f2[0];
        int i3 = f2[1];
        int zB = g.zB(i2);
        int zB2 = g.zB(i3);
        hashMap.put("screenWidth", Integer.valueOf(zB));
        hashMap.put("screenHeight", Integer.valueOf(zB2));
        hashMap.put("pixelRatio", Float.valueOf(g.bZk()));
        Log.i("MicroMsg.JsApiEventShouldShowSplashAd[AppBrandSplashAd]", "dispatch, instanceId:%s, timeThreshold:%s, screenSize[%s, %s], pixelRatio:%s, isDarkMode:%s, isGame:%s, networkType:%s", UE, Integer.valueOf(bsL), Integer.valueOf(zB), Integer.valueOf(zB2), Float.valueOf(g.bZk()), Boolean.valueOf(isDarkMode), Boolean.valueOf(z), dS);
        p.Un(sVar.getAppId()).kCO.kGs = Util.nowMilliSecond();
        L(hashMap).g(sVar).bEo();
        AppMethodBeat.o(44050);
    }

    private static String UE(String str) {
        AppMethodBeat.i(226279);
        int azs = a.azs();
        if (azs != 0) {
            String str2 = (((long) azs) & Util.MAX_32BIT_VALUE) + "_" + str;
            AppMethodBeat.o(226279);
            return str2;
        }
        AppMethodBeat.o(226279);
        return str;
    }
}
