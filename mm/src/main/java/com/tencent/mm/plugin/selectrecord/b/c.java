package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ic;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static void a(String str, int i2, int i3, int i4, int i5, int i6, long j2, String str2) {
        AppMethodBeat.i(187920);
        ic icVar = new ic();
        icVar.vL(str);
        icVar.eMQ = (long) i2;
        icVar.eMR = (long) i3;
        icVar.eMS = (long) i4;
        icVar.eMT = (long) i5;
        icVar.eMU = (long) i6;
        icVar.eMP = j2;
        icVar.vM(str2);
        Log.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryRevoke %s", icVar.abW());
        icVar.bfK();
        AppMethodBeat.o(187920);
    }
}
