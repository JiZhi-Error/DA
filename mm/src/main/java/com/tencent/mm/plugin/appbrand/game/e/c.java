package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.luggage.game.d.b;
import com.tencent.luggage.game.d.b.d;
import com.tencent.luggage.game.d.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.appbrand.jsapi.p.ai;
import com.tencent.mm.plugin.appbrand.jsapi.p.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Map;

public final class c {
    private static final String[] lsA = {t.NAME, ah.NAME, e.NAME, ai.NAME, f.NAME};

    public static Map<String, p> bDi() {
        AppMethodBeat.i(45135);
        Map<String, p> bEk = com.tencent.mm.plugin.appbrand.jsapi.t.bEk();
        bEk.putAll(com.tencent.mm.plugin.appbrand.jsapi.t.bEl());
        HashSet<p> hashSet = new HashSet();
        hashSet.add(new com.tencent.luggage.game.d.b.e());
        hashSet.add(new com.tencent.luggage.game.d.b.f());
        hashSet.add(new d());
        hashSet.add(new b());
        hashSet.add(new b());
        hashSet.add(new com.tencent.luggage.game.d.c());
        hashSet.add(new com.tencent.luggage.game.d.d());
        hashSet.add(new com.tencent.luggage.game.d.e());
        hashSet.add(new a());
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.e.a.e());
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.e.a.d());
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.e.a.f());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.e(bd.bty()));
        hashSet.add(new a());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.o.e(com.tencent.mm.plugin.appbrand.jsapi.o.e.mgh, bd.btw()));
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.e.b.c());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.o.b.b(com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgg, bd.btx()));
        for (p pVar : hashSet) {
            if (pVar != null && !Util.isNullOrNil(pVar.getName())) {
                bEk.put(pVar.getName(), pVar);
            }
        }
        for (String str : lsA) {
            bEk.remove(str);
        }
        AppMethodBeat.o(45135);
        return bEk;
    }
}
