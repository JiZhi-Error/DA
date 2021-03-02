package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class g {
    private static String appName;
    private static final a mCB = new a((byte) 0);

    static {
        AppMethodBeat.i(235049);
        AppMethodBeat.o(235049);
    }

    private static String dX(Context context) {
        AppMethodBeat.i(235041);
        if (!Util.isNullOrNil(appName)) {
            String str = appName;
            AppMethodBeat.o(235041);
            return str;
        }
        appName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(appName, 0);
            if (!(packageInfo == null || packageInfo.applicationInfo == null || Util.isNullOrNil(packageInfo.applicationInfo.name))) {
                appName = packageInfo.applicationInfo.name;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayerUtils", e2, "getUserAgent exception", new Object[0]);
        }
        String h2 = x.h(context, appName);
        AppMethodBeat.o(235041);
        return h2;
    }

    public static g.a dY(Context context) {
        AppMethodBeat.i(235042);
        a aVar = mCB;
        n nVar = new n(context, aVar, new p(dX(context), aVar, true));
        AppMethodBeat.o(235042);
        return nVar;
    }

    public static g.a a(Context context, Map<String, String> map) {
        AppMethodBeat.i(235043);
        a aVar = mCB;
        n nVar = new n(context, aVar, a(aVar, dX(context), map));
        AppMethodBeat.o(235043);
        return nVar;
    }

    private static s.b a(a aVar, String str, Map<String, String> map) {
        AppMethodBeat.i(235044);
        p pVar = new p(str, aVar, true);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Log.i("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", entry.getKey(), entry.getValue());
                pVar.setDefaultRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        AppMethodBeat.o(235044);
        return pVar;
    }

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.i(235045);
        boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(context);
        AppMethodBeat.o(235045);
        return isNetworkConnected;
    }

    public static String bKJ() {
        AppMethodBeat.i(235046);
        String xH = xH(10);
        AppMethodBeat.o(235046);
        return xH;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e3 A[SYNTHETIC, Splitter:B:21:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0180 A[SYNTHETIC, Splitter:B:53:0x0180] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String xH(int r18) {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g.xH(int):java.lang.String");
    }

    public static a bKK() {
        return mCB;
    }

    public static String j(Throwable th) {
        AppMethodBeat.i(235048);
        if (th == null) {
            String valueOf = String.valueOf((char[]) null);
            AppMethodBeat.o(235048);
            return valueOf;
        }
        String th2 = th.toString();
        AppMethodBeat.o(235048);
        return th2;
    }
}
