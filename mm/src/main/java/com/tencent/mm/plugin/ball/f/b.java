package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Locale;

public final class b {
    public static String bxq(String str) {
        AppMethodBeat.i(127558);
        String mD5String = MD5Util.getMD5String(String.format("%s#%s", Long.valueOf(System.currentTimeMillis()), str));
        AppMethodBeat.o(127558);
        return mD5String;
    }

    public static String cA(String str, int i2) {
        AppMethodBeat.i(188578);
        String format = String.format(Locale.US, "%s#%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(188578);
        return format;
    }

    public static String cB(String str, int i2) {
        AppMethodBeat.i(127559);
        String format = String.format(Locale.US, "%s#%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(127559);
        return format;
    }

    public static String agW(String str) {
        AppMethodBeat.i(127560);
        String mD5String = MD5Util.getMD5String(String.format("%s", str));
        AppMethodBeat.o(127560);
        return mD5String;
    }

    public static String cjf() {
        return "LiveFloatBall";
    }

    public static String dhB() {
        return "FestivalLiveFloatBall";
    }
}
