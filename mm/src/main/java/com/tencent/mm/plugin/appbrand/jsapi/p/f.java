package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class f extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 10;
    public static final String NAME = "hideNavigationBarLoading";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138218);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.f.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138217);
                ac i2 = df.i(dVar2);
                if (i2 == null) {
                    dVar2.i(i2, f.this.h("fail:page don't exist", null));
                    AppMethodBeat.o(138217);
                    return;
                }
                i2.he(false);
                dVar2.i(i2, f.this.h("ok", null));
                AppMethodBeat.o(138217);
            }
        };
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            r0.run();
            AppMethodBeat.o(138218);
            return;
        }
        dVar2.getRuntime().O(r0);
        AppMethodBeat.o(138218);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
