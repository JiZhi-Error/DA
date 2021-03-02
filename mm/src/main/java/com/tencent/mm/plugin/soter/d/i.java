package com.tencent.mm.plugin.soter.d;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class i {
    public static void aB(String str, int i2, int i3) {
        AppMethodBeat.i(145968);
        ((b) e.N(b.class)).a(13711, 0, str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(145968);
    }

    public static void jb(int i2, int i3) {
        int i4;
        AppMethodBeat.i(145969);
        switch (i3) {
            case 4:
                i4 = 1;
                break;
            case 6:
                i4 = 3;
                break;
            case 1001:
                i4 = 5;
                break;
            case 1003:
                i4 = 2;
                break;
            case 1004:
                i4 = 4;
                break;
            case TXLiteAVCode.EVT_CAMERA_REMOVED:
                if (i2 != 3) {
                    i4 = -1;
                    break;
                } else {
                    i4 = 0;
                    break;
                }
            default:
                i4 = -1;
                break;
        }
        if (i4 != -1) {
            Log.i("SoterLuggageReportManager", "luggage soter idkey report id: %d, key: %d, value: %d", 672, Integer.valueOf(i4), 1L);
            ((a) e.N(a.class)).idkeyStat(672, (long) i4, 1, false);
        }
        AppMethodBeat.o(145969);
    }
}
