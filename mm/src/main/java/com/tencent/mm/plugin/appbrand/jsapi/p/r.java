package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class r extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(134887);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        final String optString = jSONObject.optString("url");
        if (dVar2.getRuntime().getAppConfig().bzG().WX(optString)) {
            dVar2.i(i2, h("fail:can not redirect to a tab bar page", null));
            AppMethodBeat.o(134887);
            return;
        }
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.r.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(134886);
                dVar2.getRuntime().brh().adD(optString);
                dVar2.i(i2, r.this.h("ok", null));
                AppMethodBeat.o(134886);
            }
        };
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            r1.run();
            AppMethodBeat.o(134887);
            return;
        }
        dVar2.getRuntime().O(r1);
        AppMethodBeat.o(134887);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
