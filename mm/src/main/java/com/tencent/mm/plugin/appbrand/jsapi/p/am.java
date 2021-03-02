package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class am extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(134889);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        final String optString = jSONObject.optString("url");
        if (!dVar2.getRuntime().getAppConfig().bzG().WX(optString)) {
            dVar2.i(i2, h("fail:can not switch to non-TabBar page", null));
            AppMethodBeat.o(134889);
            return;
        }
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.am.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(134888);
                dVar2.getRuntime().brh().adE(optString);
                dVar2.i(i2, am.this.h("ok", null));
                AppMethodBeat.o(134888);
            }
        };
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            r1.run();
            AppMethodBeat.o(134889);
            return;
        }
        dVar2.getRuntime().O(r1);
        AppMethodBeat.o(134889);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
