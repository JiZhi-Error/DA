package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.luggage.sdk.b.a.c.j;
import com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import com.tencent.mm.sdk.platformtools.Log;

public class b extends c {
    static /* synthetic */ void a(b bVar, a.c cVar) {
        AppMethodBeat.i(146683);
        super.a(cVar);
        AppMethodBeat.o(146683);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.sdk.c, com.tencent.luggage.bridge.a.a.b
    public void a(final a.c cVar) {
        AppMethodBeat.i(146681);
        c.a("NanoSdkLuggageInitDelegate", new Runnable() {
            /* class com.tencent.luggage.sdk.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(146679);
                b.a(b.this, cVar);
                AppMethodBeat.o(146679);
            }
        });
        c.a("FullSdkLuggageInitDelegate", new Runnable() {
            /* class com.tencent.luggage.sdk.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(146680);
                cVar.a(ag.class, new FullSdkExternalToolsHelper());
                cVar.a(p.a.class, new com.tencent.luggage.sdk.a.a());
                cVar.a(bf.a.class, new al.a());
                b.this.Nu();
                AppMethodBeat.o(146680);
            }
        });
        AppMethodBeat.o(146681);
    }

    /* access modifiers changed from: protected */
    public void Nu() {
        AppMethodBeat.i(146682);
        Log.i("Luggage.FullSdkLuggageInitDelegate", "hy: trigger registerServiceLogicImp");
        e.Oy().a(new c.a(), com.tencent.luggage.sdk.b.a.c.c.class);
        e.Oy().a(j.cBs, j.class);
        AppMethodBeat.o(146682);
    }
}
