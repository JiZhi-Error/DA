package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static String zFN = "afterLogin";
    public static String zFO = "afterSleep";
    public static String zFP = "getMore";
    public static int zFQ = 0;
    public static int zFR = 1644429312;
    public static int zFS = 302122240;
    public static int zFT = 50;
    public static int zFU = 20;
    public static int zFV = 100;
    public static int zFW = 3;
    public static int zFX = 1;
    public static int zFY = 1;
    public static int zFZ = 1000;

    public static void elt() {
        AppMethodBeat.i(26514);
        c Fu = d.aXu().Fu("100224");
        if (Fu.isValid()) {
            Map<String, String> gzz = Fu.gzz();
            zFQ = Util.getInt(gzz.get("SyncOpen"), 0);
            zFR = Util.getInt(gzz.get("WindowsVersion"), 1644429312);
            zFS = Util.getInt(gzz.get("MacVersion"), 302122240);
            zFT = Util.getInt(gzz.get("MsgSyncSessionCount"), 50);
            zFU = Util.getInt(gzz.get("MsgSyncMsgCount"), 20);
            zFV = Util.getInt(gzz.get("MsgSyncSessionListCount"), 100);
            zFW = Util.getInt(gzz.get("MsgSyncTimeLimit"), 3);
            zFX = Util.getInt(gzz.get("MsgSyncAfterSleepSwitch"), 1);
            zFY = Util.getInt(gzz.get("MsgSyncGetMoreSwitch"), 1);
            zFZ = Util.getInt(gzz.get("MsgSyncGetMoreMaxMsgCount"), 1000);
        }
        Log.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", Integer.valueOf(zFQ), Integer.valueOf(zFR), Integer.valueOf(zFS), Integer.valueOf(zFT), Integer.valueOf(zFU), Integer.valueOf(zFV), Integer.valueOf(zFW), Integer.valueOf(zFX), Integer.valueOf(zFY), Integer.valueOf(zFZ));
        AppMethodBeat.o(26514);
    }

    public static void a(long j2, long j3, long j4, long j5, int i2, int i3, String str) {
        AppMethodBeat.i(26515);
        int i4 = 0;
        if (str.equals(zFN)) {
            i4 = 1;
        } else if (str.equals(zFO)) {
            i4 = 2;
        } else if (str.equals(zFP)) {
            i4 = 3;
        }
        h.INSTANCE.a(14108, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(26515);
    }

    public static void l(long j2, int i2, int i3) {
        AppMethodBeat.i(26516);
        h.INSTANCE.a(14108, 0L, Long.valueOf(j2), 0L, 0L, 0, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(26516);
    }
}
