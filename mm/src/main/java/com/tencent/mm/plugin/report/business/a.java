package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.am;

public final class a {
    public static void a(long j2, long j3, long j4, String str) {
        AppMethodBeat.i(224152);
        am amVar = new am();
        amVar.eoH = j2;
        amVar.eoI = j3;
        amVar.eoJ = j4;
        amVar.eoK = amVar.x("UserName", str, true);
        amVar.bfK();
        AppMethodBeat.o(224152);
    }
}
