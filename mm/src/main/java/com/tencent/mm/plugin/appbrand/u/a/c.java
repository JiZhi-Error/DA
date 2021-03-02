package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.b;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public final s cAJ;
    private final b.a nkb;
    private final int nkc;

    public c(s sVar) {
        this.cAJ = sVar;
        this.nkc = -1;
        this.nkb = null;
    }

    public c(s sVar, int i2, b.a aVar) {
        this.nkb = aVar;
        this.cAJ = sVar;
        this.nkc = i2;
    }

    public final String Y(Map<String, Object> map) {
        AppMethodBeat.i(147382);
        map.put("ret", 0);
        String adk = adk(Z(map));
        AppMethodBeat.o(147382);
        return adk;
    }

    public final String bPU() {
        AppMethodBeat.i(147383);
        HashMap hashMap = new HashMap();
        hashMap.put("ret", 2);
        String adk = adk(Z(hashMap));
        AppMethodBeat.o(147383);
        return adk;
    }

    private String adk(String str) {
        AppMethodBeat.i(147384);
        if (this.nkb == null) {
            AppMethodBeat.o(147384);
            return str;
        }
        this.nkb.ap(this.nkc, str);
        AppMethodBeat.o(147384);
        return null;
    }

    private static String Z(Map<String, Object> map) {
        AppMethodBeat.i(147385);
        e.m(map);
        String iVar = new i(map).toString();
        AppMethodBeat.o(147385);
        return iVar;
    }
}
