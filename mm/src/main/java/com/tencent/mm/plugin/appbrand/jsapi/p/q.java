package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class q extends d<com.tencent.mm.plugin.appbrand.d> {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(134885);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        final String optString = jSONObject.optString("url");
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.q.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(134884);
                dVar2.getRuntime().brh().ax(optString, false);
                dVar2.i(i2, q.this.h("ok", null));
                AppMethodBeat.o(134884);
            }
        };
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            r1.run();
            AppMethodBeat.o(134885);
            return;
        }
        dVar2.getRuntime().O(r1);
        AppMethodBeat.o(134885);
    }
}
