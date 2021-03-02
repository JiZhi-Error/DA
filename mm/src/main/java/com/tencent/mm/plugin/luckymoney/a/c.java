package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public static String haD;
    public static String iNV;
    public static String openId;
    public static String yOW;
    public static int yOX;
    public static int yOY;

    public static void a(String str, String str2, String str3, String str4, int i2, int i3) {
        openId = str;
        haD = str3;
        yOW = str4;
        yOX = i2;
        yOY = i3;
        iNV = str2;
    }

    public static void bC(int i2, String str) {
        AppMethodBeat.i(168790);
        if (Util.isNullOrNil(openId)) {
            AppMethodBeat.o(168790);
            return;
        }
        h.INSTANCE.a(16598, Integer.valueOf(i2), iNV, str, haD, yOW, 0, openId, Integer.valueOf(yOX), Integer.valueOf(yOY));
        AppMethodBeat.o(168790);
    }
}
