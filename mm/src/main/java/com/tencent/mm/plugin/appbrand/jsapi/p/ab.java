package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class ab extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138235);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (!jSONObject.has("title")) {
            dVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(138235);
            return;
        }
        final String optString = jSONObject.optString("title");
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.ab.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138234);
                ac i2 = df.i(dVar2);
                if (i2 == null) {
                    dVar2.i(i2, ab.this.h("fail", null));
                    AppMethodBeat.o(138234);
                    return;
                }
                i2.YO(optString);
                dVar2.i(i2, ab.this.h("ok", null));
                AppMethodBeat.o(138234);
            }
        };
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            r1.run();
            AppMethodBeat.o(138235);
            return;
        }
        dVar2.getRuntime().O(r1);
        AppMethodBeat.o(138235);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
