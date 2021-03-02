package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class b {
    public static String openId;
    public static String sessionId;
    public static long startTime;
    public static int vkj;
    public static String yOW;
    public static int zbe;
    public static Set<String> zbf = new HashSet();
    public static int zbg;
    public static int zbh;
    public static int zbi;
    public static int zbj;
    public static int zbk;
    public static int zbl;
    public static int zbm;

    static {
        AppMethodBeat.i(163682);
        AppMethodBeat.o(163682);
    }

    public static void k(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(163680);
        openId = str;
        yOW = str2;
        zbi = i2;
        zbj = i3;
        sessionId = UUID.randomUUID().toString();
        startTime = SystemClock.elapsedRealtime() / 1000;
        AppMethodBeat.o(163680);
    }

    public static void xV(int i2) {
        AppMethodBeat.i(163681);
        if (!Util.isNullOrNil(openId) && !Util.isNullOrNil(sessionId)) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() / 1000) - startTime;
            h.INSTANCE.a(18994, Integer.valueOf(i2), yOW, 0, Integer.valueOf(zbe), Integer.valueOf(zbf.size()), Integer.valueOf(zbg), Integer.valueOf(zbh), Integer.valueOf(zbi), Integer.valueOf(zbj), sessionId, openId, Long.valueOf(elapsedRealtime), Integer.valueOf(vkj), Integer.valueOf(zbk), Integer.valueOf(zbl), Integer.valueOf(zbm));
            yOW = null;
            zbe = 0;
            zbf.clear();
            zbg = 0;
            zbh = 0;
            zbi = 0;
            zbj = 0;
            openId = null;
            startTime = 0;
            vkj = 0;
            zbk = 0;
            zbl = 0;
            zbm = 0;
            sessionId = null;
        }
        AppMethodBeat.o(163681);
    }
}
