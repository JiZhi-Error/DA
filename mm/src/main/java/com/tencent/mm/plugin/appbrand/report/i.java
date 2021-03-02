package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.k.ah;
import com.tencent.mm.plugin.appbrand.jsapi.share.aa;
import com.tencent.mm.plugin.appbrand.jsapi.share.z;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class i {
    public static final String nHj = f.c.mtR.value;
    public static final String nHk = f.c.Wifi.value;
    public static final String nHl = f.c.Mobile_2g.value;
    public static final String nHm = f.c.Mobile_3g.value;
    public static final String nHn = f.c.Mobile_4g.value;

    public static String getNetworkType(Context context) {
        AppMethodBeat.i(48047);
        String el = t.el(context);
        AppMethodBeat.o(48047);
        return el;
    }

    public static void a(int i2, String str, String str2, int i3, String str3, String str4) {
        AppMethodBeat.i(48048);
        Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s  sceneNote %s", 13533, Integer.valueOf(i2), Util.nullAsNil(str), 0, str2, Integer.valueOf(i3), str3, str4);
        h.INSTANCE.a(13533, Integer.valueOf(i2), Util.nullAsNil(str), 0, str2, Integer.valueOf(i3), str3, 0, str4);
        AppMethodBeat.o(48048);
    }

    public static void a(String str, int i2, int i3, long j2, boolean z) {
        AppMethodBeat.i(48049);
        String el = t.el(MMApplicationContext.getContext());
        if (Util.isNullOrNil(el)) {
            el = nHj;
        }
        int aeH = aeH(str);
        long nowSecond = Util.nowSecond();
        Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", 13537, 1000, "", "", str, 0, 0, 0, "", el, Integer.valueOf(i2), Integer.valueOf(i3), 0, Long.valueOf(j2), Long.valueOf(nowSecond), Boolean.valueOf(z), Integer.valueOf(aeH));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[16];
        objArr[0] = 1000;
        objArr[1] = "";
        objArr[2] = "";
        objArr[3] = str;
        objArr[4] = 0;
        objArr[5] = 0;
        objArr[6] = 0;
        objArr[7] = "";
        objArr[8] = el;
        objArr[9] = Integer.valueOf(i2);
        objArr[10] = Integer.valueOf(i3);
        objArr[11] = 0;
        objArr[12] = Long.valueOf(j2);
        objArr[13] = Long.valueOf(nowSecond);
        objArr[14] = Integer.valueOf(z ? 1 : 0);
        objArr[15] = Integer.valueOf(aeH);
        hVar.a(13537, objArr);
        AppMethodBeat.o(48049);
    }

    public static void a(String str, String str2, int i2, String str3, long j2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(48050);
        AppBrandStatObject TS = a.TS(str);
        if (TS == null) {
            Log.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            AppMethodBeat.o(48050);
            return;
        }
        String str4 = "";
        if (!Util.isNullOrNil(str2) && str2.contains(".html")) {
            str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
        String str5 = "";
        try {
            str5 = q.encode(Util.nullAsNil(str4), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", str);
            Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
        }
        AppBrandSysConfigWC TR = a.TR(str);
        if (TR == null) {
            i5 = 0;
        } else {
            i5 = TR.leE.pkgVersion;
        }
        int i6 = TR == null ? 0 : TR.leE.kNW + 1;
        String nullAsNil = Util.nullAsNil(str3);
        if (i2 == 18) {
            if (!Util.isNullOrNil(str3) && str3.contains(".html")) {
                nullAsNil = str3.substring(0, str3.lastIndexOf(".html") + 5);
            }
            try {
                nullAsNil = q.encode(Util.nullAsNil(nullAsNil), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e3) {
                Log.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
                Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", e3, "", new Object[0]);
            }
        }
        String nullAsNil2 = Util.nullAsNil(TS.dCw);
        String str6 = null;
        try {
            str6 = Util.nullAsNil(a.TQ(str).bsC().cym);
        } catch (Exception e4) {
            Log.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", str, e4);
        }
        if (TS.scene == 0) {
            TS.scene = 1000;
        }
        int i7 = TS.ecU;
        String str7 = TS.ecV;
        int aeH = aeH(str);
        Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", 13539, Integer.valueOf(TS.scene), nullAsNil2, str6, str, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(TS.nHt), str4, Integer.valueOf(i2), nullAsNil, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i7), str7, Integer.valueOf(aeH));
        h.INSTANCE.a(13539, Integer.valueOf(TS.scene), nullAsNil2, str6, str, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(TS.nHt), str5, Integer.valueOf(i2), nullAsNil, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i7), str7, Integer.valueOf(aeH));
        AppMethodBeat.o(48050);
    }

    public static void a(String str, String str2, int i2, int i3, int i4, String str3, String str4, int i5, String str5, long j2, int i6, int i7, String str6) {
        int i8;
        String str7;
        String str8;
        String str9;
        AppMethodBeat.i(227372);
        int i9 = 3;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(227372);
            return;
        }
        String str10 = "";
        if (!Util.isNullOrNil(str4) && str4.contains(".html")) {
            str10 = str4.substring(0, str4.lastIndexOf(".html") + 5);
        }
        String str11 = "";
        try {
            str11 = q.encode(Util.nullAsNil(str10), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
        }
        String nullAsNil = Util.nullAsNil(str3);
        String nullAsNil2 = Util.nullAsNil(str5);
        String nullAsNil3 = Util.nullAsNil(str2);
        int aeH = aeH(str2);
        if (i3 > 0) {
            int i10 = i3 - 1;
            boolean bm = n.buJ().bm(str, i10);
            if (n.buK().bj(str, i10)) {
                i9 = 1;
            } else if (bm) {
                i9 = 2;
            } else {
                i9 = 3;
            }
        }
        z aaM = aa.aaM(str6);
        if (aaM == null) {
            i8 = 0;
        } else {
            i8 = aaM.msM;
        }
        if (aaM == null) {
            str7 = "";
        } else {
            str7 = aaM.msN;
        }
        String nullAsNil4 = Util.nullAsNil(str7);
        if (aaM == null) {
            str8 = "";
        } else {
            str8 = aaM.msO;
        }
        String encode = q.encode(Util.nullAsNil(str8));
        if (aaM == null) {
            str9 = "";
        } else {
            str9 = aaM.msP;
        }
        String encode2 = q.encode(Util.nullAsNil(str9));
        Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d,shareActionId:%s, shareActionType:%d, shareTitle:%s, sharePath:%s, shareImgUrl:%s", 13540, Integer.valueOf(i4), nullAsNil, nullAsNil3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i9), str10, Integer.valueOf(i5), nullAsNil2, Long.valueOf(j2), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(aeH), str6, Integer.valueOf(i8), nullAsNil4, encode, encode2);
        h.INSTANCE.a(13540, Integer.valueOf(i4), nullAsNil, nullAsNil3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i9), str11, Integer.valueOf(i5), nullAsNil2, Long.valueOf(j2), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(aeH), str6, Integer.valueOf(i8), nullAsNil4, encode, encode2);
        AppMethodBeat.o(227372);
    }

    public static void cf(String str, int i2) {
        AppMethodBeat.i(48052);
        T(str, i2, 0);
        AppMethodBeat.o(48052);
    }

    public static void T(String str, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(48053);
        if ("@LibraryAppId".equals(str)) {
            AppMethodBeat.o(48053);
            return;
        }
        int i7 = 1000;
        String str2 = "";
        int i8 = 0;
        if (!Util.isNullOrNil(str)) {
            AppBrandStatObject TS = a.TS(str);
            if (TS != null) {
                int i9 = TS.scene == 0 ? 1000 : TS.scene;
                str2 = Util.nullAsNil(TS.dCw);
                i6 = TS.nHt;
                i7 = i9;
            } else {
                i6 = 0;
            }
            AppBrandSysConfigWC TR = a.TR(str);
            if (!(TR == null || TR.leE == null)) {
                i8 = TR.leE.pkgVersion;
            }
            if (!(i3 != 0 || TR == null || TR.leE == null)) {
                i3 = TR.leE.kNW + 1;
            }
            i4 = aeH(str);
            i5 = i6;
        } else {
            i4 = 1000;
            i5 = 0;
        }
        Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", 13541, Integer.valueOf(i7), str2, str, Integer.valueOf(i8), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2), 3, Integer.valueOf(i4));
        h.INSTANCE.a(13541, Integer.valueOf(i7), str2, str, Integer.valueOf(i8), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2), 3, "", Integer.valueOf(i4));
        if (!TextUtils.isEmpty(str2) && str2.contains("isWidget=1")) {
            com.tencent.mm.plugin.appbrand.dynamic.f.o(i2, str, str2);
        }
        if ("wxb6d22f922f37b35a".equals(str) && i3 <= 1) {
            h.INSTANCE.dN(1089, i2);
        }
        AppMethodBeat.o(48053);
    }

    public static void as(int i2, String str) {
        AppMethodBeat.i(48054);
        List<LocalUsageInfo> a2 = ((ag) g.af(ag.class)).a(Integer.MAX_VALUE, ag.a.DESC);
        StringBuilder sb = new StringBuilder();
        List G = b.G(a2);
        List subList = G.subList(0, Math.min(20, G.size()));
        for (int i3 = 0; i3 < subList.size(); i3++) {
            sb.append(((LocalUsageInfo) subList.get(i3)).appId);
            if (i3 != subList.size() - 1) {
                sb.append("#");
            }
        }
        Log.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] scene=".concat(String.valueOf(i2)));
        Log.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] appIdStr=".concat(String.valueOf(sb)));
        Log.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] sceneNote=".concat(String.valueOf(str)));
        h.INSTANCE.a(13800, Integer.valueOf(i2), Integer.valueOf(((ag) g.af(ag.class)).getCount()), sb.toString(), Long.valueOf(System.currentTimeMillis()), str);
        AppMethodBeat.o(48054);
    }

    public static void bUt() {
        AppMethodBeat.i(48055);
        as(2, "");
        AppMethodBeat.o(48055);
    }

    public static void a(long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        AppMethodBeat.i(48056);
        if (z2) {
            i2 = 775;
        } else {
            i2 = 367;
        }
        if (j2 <= 2000) {
            i3 = z ? 8 : 1;
        } else if (j2 <= 3000) {
            i3 = z ? 9 : 2;
        } else if (j2 <= 4000) {
            i3 = z ? 10 : 3;
        } else if (j2 <= 5000) {
            i3 = z ? 11 : 4;
        } else if (j2 <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            i3 = z ? 12 : 5;
        } else if (z2) {
            i3 = j2 <= 7000 ? z ? 19 : 14 : j2 <= 8000 ? z ? 20 : 15 : j2 <= 9000 ? z ? 21 : 16 : j2 <= 10000 ? z ? 22 : 17 : z ? 23 : 18;
        } else {
            i3 = z ? 13 : 6;
        }
        h.INSTANCE.idkeyStat((long) i2, (long) i3, 1, false);
        if (z) {
            h.INSTANCE.idkeyStat((long) i2, 7, 1, false);
        } else {
            h.INSTANCE.idkeyStat((long) i2, 0, 1, false);
        }
        Log.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", Long.valueOf(j2), Boolean.valueOf(z));
        AppMethodBeat.o(48056);
    }

    public static void bUu() {
        int i2;
        AppMethodBeat.i(48057);
        int selfMemInMB = Util.getSelfMemInMB(g.aAe().azG().ca);
        Log.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", Integer.valueOf(selfMemInMB));
        if (selfMemInMB <= 90) {
            i2 = 2;
        } else if (selfMemInMB <= 130) {
            i2 = 3;
        } else if (selfMemInMB <= 170) {
            i2 = 4;
        } else if (selfMemInMB <= 210) {
            i2 = 5;
        } else {
            i2 = 6;
        }
        h.INSTANCE.idkeyStat(386, 1, 1, false);
        h.INSTANCE.idkeyStat(386, (long) i2, 1, false);
        AppMethodBeat.o(48057);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void v(boolean z, int i2) {
        AppMethodBeat.i(227373);
        switch (i2) {
            case 5:
                if (z) {
                    h.INSTANCE.idkeyStat(386, 15, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(386, 14, 1, false);
                }
                h.INSTANCE.idkeyStat(386, 9, 1, false);
                break;
            case 10:
                if (z) {
                    h.INSTANCE.idkeyStat(386, 13, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(386, 12, 1, false);
                }
                h.INSTANCE.idkeyStat(386, 8, 1, false);
                AppMethodBeat.o(227373);
                return;
            case 15:
                if (z) {
                    h.INSTANCE.idkeyStat(386, 11, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(386, 10, 1, false);
                }
                h.INSTANCE.idkeyStat(386, 7, 1, false);
                AppMethodBeat.o(227373);
                return;
        }
        AppMethodBeat.o(227373);
    }

    public static void b(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(48060);
        a(str, i2, i3, (long) i4, (long) i5, 1);
        AppMethodBeat.o(48060);
    }

    public static void a(String str, int i2, int i3, long j2, long j3, long j4) {
        AppMethodBeat.i(48061);
        a.nFX.a(14369, str, Integer.valueOf(i2), Integer.valueOf(i3 + 1), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        AppMethodBeat.o(48061);
    }

    public static void at(int i2, String str) {
        AppMethodBeat.i(48062);
        h.INSTANCE.a(15651, Integer.valueOf(i2), Util.nullAsNil(str));
        AppMethodBeat.o(48062);
    }

    public static void zd(int i2) {
        AppMethodBeat.i(48063);
        h.INSTANCE.dN(ah.CTRL_INDEX, i2);
        AppMethodBeat.o(48063);
    }

    public static void E(String str, String str2, int i2) {
        AppMethodBeat.i(48064);
        AppBrandStatObject TS = a.TS(str);
        if (TS == null) {
            Log.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            AppMethodBeat.o(48064);
            return;
        }
        AppBrandSysConfigWC TR = a.TR(str);
        int i3 = TR == null ? 0 : TR.leE.kNW + 1;
        int aeH = aeH(str);
        String nullAsNil = Util.nullAsNil(TS.dCw);
        if (TS.scene == 0) {
            TS.scene = 1000;
        }
        long nowSecond = Util.nowSecond();
        String str3 = "";
        try {
            str3 = q.encode(Util.nullAsNil(str2), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.AppBrandReporterManager", "reportBackHome, encode page path error!, appId = %s", str);
            Log.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
        }
        Log.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, appid : %s, appState : %d, pagePath : %s, actionTime : %s,  appType : %d", 18189, Integer.valueOf(TS.scene), nullAsNil, str, Integer.valueOf(i3), str2, Long.valueOf(nowSecond), Integer.valueOf(aeH));
        h.INSTANCE.a(18189, str, Integer.valueOf(i3), Integer.valueOf(aeH), Long.valueOf(nowSecond), Integer.valueOf(TS.scene), nullAsNil, str3, Integer.valueOf(i2));
        AppMethodBeat.o(48064);
    }

    public static int aeH(String str) {
        AppMethodBeat.i(48065);
        if ("@LibraryAppId".equals(str)) {
            AppMethodBeat.o(48065);
            return 0;
        }
        int aeJ = j.aeJ(str);
        String aeI = aeI(str);
        if (aeJ < 0) {
            if (MMApplicationContext.isMMProcess()) {
                WxaAttributes e2 = n.buC().e(aeI, "appInfo");
                if (e2 != null) {
                    aeJ = e2.bAn().serviceType;
                    j.cg(aeI, aeJ);
                } else {
                    Log.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
                }
            } else {
                com.tencent.mm.plugin.appbrand.q TQ = a.TQ(aeI);
                AppBrandInitConfigWC bsC = TQ == null ? null : TQ.bsC();
                if (bsC != null) {
                    aeJ = bsC.cyo;
                    j.cg(aeI, aeJ);
                } else {
                    Log.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(aeJ));
                }
            }
        }
        int i2 = aeJ + 1000;
        AppMethodBeat.o(48065);
        return i2;
    }

    private static String aeI(String str) {
        AppMethodBeat.i(227374);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(227374);
            return str;
        }
        int indexOf = str.indexOf(36);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            AppMethodBeat.o(227374);
            return substring;
        }
        AppMethodBeat.o(227374);
        return str;
    }
}
