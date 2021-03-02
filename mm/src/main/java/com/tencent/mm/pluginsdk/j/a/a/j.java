package com.tencent.mm.pluginsdk.j.a.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class j {
    private static final int JZo = i.b.DoCache.cSx;
    private static final int JZp = i.b.DoDelete.cSx;
    private static final int JZq = i.b.DoDecrypt.cSx;

    public static void F(long j2, long j3) {
        AppMethodBeat.i(151981);
        if (j2 > 0 && 197 != j2) {
            h.INSTANCE.idkeyStat(j2, j3, 1, false);
        }
        h.INSTANCE.idkeyStat(197, j3, 1, false);
        AppMethodBeat.o(151981);
    }

    public static void Mr(long j2) {
        AppMethodBeat.i(151982);
        F(j2, 2);
        AppMethodBeat.o(151982);
    }

    public static void a(int i2, int i3, String str, int i4, a aVar, boolean z, boolean z2, boolean z3, String str2) {
        AppMethodBeat.i(151983);
        a(i2, i3, str, i4, JZo, z2 ? 0 : 1, aVar.ordinal(), z3 ? 0 : 1, 1, z ? 0 : 1, str2);
        AppMethodBeat.o(151983);
    }

    public static void a(int i2, int i3, int i4, boolean z, String str) {
        AppMethodBeat.i(151984);
        a(i2, i3, "", i4, JZp, z ? 0 : 1, a.FAIL.ordinal(), 1, 1, 1, str);
        AppMethodBeat.o(151984);
    }

    public static void a(int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        AppMethodBeat.i(151985);
        a(i2, i3, "", i4, JZq, z ? 0 : 1, a.FAIL.ordinal(), z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
        AppMethodBeat.o(151985);
    }

    private static void a(int i2, int i3, String str, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str2) {
        AppMethodBeat.i(151986);
        h.INSTANCE.a(11906, Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
        if (!Util.isNullOrNil(str2) && !str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            h.INSTANCE.a(11907, Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), str2);
        }
        AppMethodBeat.o(151986);
    }

    public static void m(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(223825);
        hj hjVar = new hj();
        String str = "none";
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                str = "wifi";
            } else {
                str = "4g";
            }
        }
        hjVar.eLN = hjVar.x("Network", str, true);
        hjVar.eLK = (long) i2;
        hjVar.eLL = (long) i3;
        hjVar.eLM = (long) i4;
        hjVar.eLO = (long) i5;
        hjVar.eLP = (long) i6;
        hjVar.bfK();
        Log.i("MicroMsg.ConstantsCheckResUpdate", "kvStatDownload: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6));
        AppMethodBeat.o(223825);
    }

    public enum a {
        SUCC,
        FAIL,
        RETRY_SUCC,
        FILE_LATEST,
        FILE_EXPIRED,
        DEVICE_NOT_MATCH;

        public static a valueOf(String str) {
            AppMethodBeat.i(151979);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(151979);
            return aVar;
        }

        static {
            AppMethodBeat.i(151980);
            AppMethodBeat.o(151980);
        }
    }
}
