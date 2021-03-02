package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class k {
    public static void a(final String str, final String str2, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(46633);
        if (appBrandStatObject == null) {
            AppMethodBeat.o(46633);
            return;
        }
        final String str3 = appBrandStatObject.meP;
        if (Util.isNullOrNil(str3)) {
            AppMethodBeat.o(46633);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        h.a(str, new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void a(h.d dVar) {
                AppMethodBeat.i(46629);
                a(dVar, str, str2, str3);
                AppMethodBeat.o(46629);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(46630);
                a(h.Uc(str), str, str2, str3);
                AppMethodBeat.o(46630);
            }

            private void a(h.d dVar, String str, String str2, String str3) {
                AppMethodBeat.i(46631);
                k.a(dVar, str, str2, str3, Util.nowMilliSecond() - currentTimeMillis);
                appBrandStatObject.meP = null;
                h.b(str, this);
                AppMethodBeat.o(46631);
            }
        });
        AppMethodBeat.o(46633);
    }

    public static void b(String str, String str2, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(46634);
        if (appBrandStatObject == null) {
            AppMethodBeat.o(46634);
        } else if (Util.isNullOrNil(appBrandStatObject.meP)) {
            AppMethodBeat.o(46634);
        } else {
            a(4, str, str2, appBrandStatObject.meP, 0);
            AppMethodBeat.o(46634);
        }
    }

    private static void a(int i2, String str, String str2, String str3, long j2) {
        AppMethodBeat.i(46635);
        Log.v("MicroMsg.MiniProgramNavigatorAdReportHelper", "closeType:%d stayTime:%d", Integer.valueOf(i2), Long.valueOf(j2));
        AdReportCgiHelper.a(16004, str3 + "," + str2 + "," + str + "," + Util.nowMilliSecond() + "," + j2 + "," + i2 + "," + bHy() + "," + NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext()) + "," + NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext()) + ",,", null);
        AppMethodBeat.o(46635);
    }

    private static int bHy() {
        AppMethodBeat.i(46636);
        switch (NetStatusUtil.getNetType(MMApplicationContext.getContext())) {
            case -1:
                AppMethodBeat.o(46636);
                return 255;
            case 0:
                AppMethodBeat.o(46636);
                return 1;
            case 1:
            case 6:
            case 8:
                AppMethodBeat.o(46636);
                return 3;
            case 2:
            case 5:
            case 7:
                AppMethodBeat.o(46636);
                return 2;
            case 3:
            case 4:
                AppMethodBeat.o(46636);
                return 4;
            case 9:
            default:
                AppMethodBeat.o(46636);
                return 6;
            case 10:
                AppMethodBeat.o(46636);
                return 5;
        }
    }

    static /* synthetic */ void a(h.d dVar, String str, String str2, String str3, long j2) {
        AppMethodBeat.i(46637);
        int i2 = 0;
        switch (dVar) {
            case CLOSE:
            case BACK:
                i2 = 1;
                break;
            case HOME_PRESSED:
                i2 = 2;
                break;
            case LAUNCH_MINI_PROGRAM:
                i2 = 3;
                break;
        }
        a(i2, str, str2, str3, j2);
        AppMethodBeat.o(46637);
    }
}
