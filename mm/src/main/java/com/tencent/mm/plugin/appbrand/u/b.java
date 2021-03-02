package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.a.a;
import com.tencent.mm.plugin.appbrand.u.c.c;
import com.tencent.mm.plugin.appbrand.u.c.d;
import com.tencent.mm.plugin.appbrand.u.c.e;
import com.tencent.mm.plugin.appbrand.u.c.f;
import com.tencent.mm.plugin.appbrand.u.c.g;
import com.tencent.mm.plugin.appbrand.u.c.h;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<Integer, a> njS = new HashMap();

    static {
        AppMethodBeat.i(147368);
        a(new com.tencent.mm.plugin.appbrand.u.c.a());
        a(new d());
        a(new f());
        a(new h());
        a(new g());
        a(new c());
        a(new com.tencent.mm.plugin.appbrand.u.c.b());
        a(new e());
        AppMethodBeat.o(147368);
    }

    public static a yF(int i2) {
        AppMethodBeat.i(147366);
        a aVar = njS.get(Integer.valueOf(i2));
        AppMethodBeat.o(147366);
        return aVar;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(147367);
        njS.put(Integer.valueOf(aVar.bPT()), aVar);
        AppMethodBeat.o(147367);
    }
}
