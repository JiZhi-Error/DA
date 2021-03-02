package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.a;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.util.HashSet;
import java.util.Iterator;

public final class d implements a {
    private static com.tencent.wxa.a.a SxP;
    private static HashSet<a> SxQ = new HashSet<>();
    private final k.c SxR = new k.c() {
        /* class com.tencent.wxa.d.AnonymousClass1 */

        @Override // io.flutter.plugin.a.k.c
        public final void a(j jVar, k.d dVar) {
            boolean z;
            AppMethodBeat.i(206302);
            HashSet hashSet = new HashSet();
            hashSet.addAll(d.SxQ);
            String str = jVar.method;
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (!z2) {
                        a.C2227a a2 = aVar.a(jVar);
                        z = a2.result;
                        if (a2.result) {
                            com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s success ", str);
                            dVar.ba(a2.SxC);
                            AppMethodBeat.o(206302);
                            return;
                        }
                    } else {
                        com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s had been consumed", str);
                        z = z2;
                    }
                    z2 = z;
                }
                if (!z2) {
                    com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "method call %s had no ", str);
                    dVar.dLv();
                }
                hashSet.clear();
            }
            AppMethodBeat.o(206302);
        }
    };

    public d() {
        AppMethodBeat.i(206303);
        AppMethodBeat.o(206303);
    }

    static {
        AppMethodBeat.i(206309);
        AppMethodBeat.o(206309);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(206304);
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onAttachedToEngine", new Object[0]);
        com.tencent.wxa.a.a aVar = new com.tencent.wxa.a.a(bVar.SOH, "com.tencent.wxa/wxa_router");
        SxP = aVar;
        aVar.SxT = this.SxR;
        AppMethodBeat.o(206304);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(206305);
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "onDetachedFromEngine", new Object[0]);
        if (SxP != null) {
            SxP.SxT = null;
        }
        AppMethodBeat.o(206305);
    }

    public static void k(HashSet<a> hashSet) {
        AppMethodBeat.i(206306);
        if (!SxQ.contains(hashSet)) {
            SxQ.addAll(hashSet);
            AppMethodBeat.o(206306);
            return;
        }
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", Integer.valueOf(hashSet.hashCode()));
        AppMethodBeat.o(206306);
    }

    public static void G(String str, Object obj) {
        AppMethodBeat.i(206307);
        SxP.a(str, obj, null);
        AppMethodBeat.o(206307);
    }

    public static void a(String str, k.d dVar) {
        AppMethodBeat.i(206308);
        SxP.a(str, null, dVar);
        AppMethodBeat.o(206308);
    }
}
