package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a {
    public static int ecL;
    private static long enterTime;
    public static String gqV;
    public static int scene;
    public static String zbc;
    public static int zbd = 1;

    public static void m(int i2, String str, int i3) {
        AppMethodBeat.i(213350);
        scene = i2;
        gqV = str;
        ecL = i3;
        enterTime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(213350);
    }

    public static void xV(int i2) {
        AppMethodBeat.i(213351);
        if (enterTime > 0) {
            h.INSTANCE.a(20255, Integer.valueOf(scene), gqV, Integer.valueOf(ecL), 0, zbc, Integer.valueOf(zbd), Integer.valueOf(i2), Long.valueOf((SystemClock.elapsedRealtime() - enterTime) / 1000));
        }
        scene = 0;
        enterTime = -1;
        gqV = null;
        ecL = 0;
        zbc = null;
        zbd = 1;
        AppMethodBeat.o(213351);
    }
}
