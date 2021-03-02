package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kt;
import com.tencent.mm.g.b.a.lk;
import com.tencent.mm.plugin.websearch.api.ar;

public final class b {
    public static void a(int i2, String str, String str2, int i3, String str3, String str4, int i4, long j2) {
        AppMethodBeat.i(198077);
        lk lkVar = new lk();
        lkVar.etp = (long) i2;
        lkVar.eYE = lkVar.x("EnterSceneId", str, true);
        lkVar.eno = lkVar.x("RequestId", str2, true);
        lkVar.enl = (long) i3;
        lkVar.eXp = lkVar.x("QueryKey", str3, true);
        lkVar.eiB = lkVar.x("SessionId", str4, true);
        lkVar.eYF = (long) i4;
        lkVar.eYG = j2;
        lkVar.bfK();
        ar.a(lkVar);
        AppMethodBeat.o(198077);
    }

    public static void a(int i2, int i3, String str, String str2, int i4, String str3, String str4, int i5, String str5, long j2) {
        AppMethodBeat.i(198078);
        kt ktVar = new kt();
        ktVar.eXk = (long) i2;
        ktVar.eXl = (long) i3;
        kt yi = ktVar.yh(str).yi(str2);
        yi.eXn = (long) i4;
        kt yk = yi.yj(str3).yk(str4);
        yk.ejA = (long) i5;
        kt yl = yk.yl(str5);
        yl.eua = j2;
        yl.bfK();
        ar.a(ktVar);
        AppMethodBeat.o(198078);
    }
}
