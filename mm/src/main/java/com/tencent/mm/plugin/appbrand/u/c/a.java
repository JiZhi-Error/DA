package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.u.a.d;
import java.util.HashMap;

public final class a extends d {
    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.d
    public final String b(i iVar, c cVar) {
        AppMethodBeat.i(147392);
        s sVar = cVar.cAJ;
        HashMap hashMap = new HashMap();
        hashMap.put("state", Integer.valueOf(sVar.getRuntime().kAH.kQM.bwY().ordinal()));
        String Y = cVar.Y(hashMap);
        AppMethodBeat.o(147392);
        return Y;
    }
}
