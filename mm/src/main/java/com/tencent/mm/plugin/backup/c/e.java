package com.tencent.mm.plugin.backup.c;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    public static int oKS;
    public static int oKT;
    public static int oKU;
    public static int oKV;
    public static int oKW;
    public static int oKX;
    public static int oKY;
    public static long oKZ;
    public static long oLa;
    public static long oLb;

    public static void reset() {
        AppMethodBeat.i(21271);
        oKS = 0;
        oKT = 0;
        oKU = 0;
        oKV = 0;
        oKW = 0;
        oKX = 0;
        oKY = 0;
        long nowMilliSecond = Util.nowMilliSecond();
        oKZ = nowMilliSecond;
        oLb = nowMilliSecond - oLa;
        AppMethodBeat.o(21271);
    }

    public static void Bd(int i2) {
        switch (i2) {
            case 1:
                oKU++;
                break;
            case 3:
                oKS++;
                break;
            case 34:
                oKW++;
                break;
            case 37:
            case 40:
            case 42:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 66:
            case 10000:
                oKT++;
                break;
            case 43:
                oKV++;
                break;
            case 49:
                oKX++;
                break;
        }
        oKY++;
    }

    public static void cfo() {
        AppMethodBeat.i(21272);
        Log.d("MicroMsg.TestInfo", getInfo());
        AppMethodBeat.o(21272);
    }

    public static void cfp() {
        AppMethodBeat.i(21273);
        Log.d("MicroMsg.TestInfo", "netTime" + (Util.nowMilliSecond() - oLa));
        AppMethodBeat.o(21273);
    }

    private static String getInfo() {
        AppMethodBeat.i(21274);
        String str = "total_count: " + oKY + "text_count: " + oKU + "normal_count : " + oKT + " image_count: " + oKS + " voice_count : " + oKW + " video_count " + oKV + " app_count : " + oKX + " time: " + (Util.nowMilliSecond() - oKZ) + " net: " + oLb;
        AppMethodBeat.o(21274);
        return str;
    }
}
