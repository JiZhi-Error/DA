package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class z {
    private static Boolean ReJ = null;
    private static Boolean ReK = null;
    private static Boolean ReL = null;
    private static Boolean ReM = null;
    private static Boolean ReN = null;

    public static void bUV() {
        AppMethodBeat.i(182929);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("VFSStrategy");
        long j2 = mmkv.getLong("VFSSwitchReportTime", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 <= 0 || currentTimeMillis - j2 >= 259200000) {
            mmkv.encode("VFSSwitchReportTime", currentTimeMillis);
            e.INSTANCE.idkeyStat(1317, 0, 1, true);
            if (heY()) {
                e.INSTANCE.idkeyStat(1317, 1, 1, true);
            }
            e.INSTANCE.idkeyStat(1317, 3, 1, true);
            e.INSTANCE.idkeyStat(1317, 5, 1, true);
            e.INSTANCE.idkeyStat(1317, 7, 1, true);
            e.INSTANCE.idkeyStat(1317, 9, 1, true);
        }
        AppMethodBeat.o(182929);
    }

    public static synchronized boolean heY() {
        boolean booleanValue;
        synchronized (z.class) {
            AppMethodBeat.i(182930);
            if (ReN == null) {
                ReN = Boolean.valueOf(b.gwY());
            }
            booleanValue = ReN.booleanValue();
            AppMethodBeat.o(182930);
        }
        return booleanValue;
    }
}
