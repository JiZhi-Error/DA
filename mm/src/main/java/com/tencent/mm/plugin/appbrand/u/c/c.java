package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.u.a.d;
import java.util.HashMap;

public final class c extends d {
    @Override // com.tencent.mm.plugin.appbrand.u.a.d
    public final String b(i iVar, com.tencent.mm.plugin.appbrand.u.a.c cVar) {
        AppMethodBeat.i(147394);
        HashMap hashMap = new HashMap();
        hashMap.put("isLANIp", Boolean.valueOf(j.adf(j.adc(iVar.optString("url")).get("host")) == 2));
        String Y = cVar.Y(hashMap);
        AppMethodBeat.o(147394);
        return Y;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 6;
    }
}
