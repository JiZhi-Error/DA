package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(134882);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        final String optString = jSONObject.optString("url");
        if (dVar2.getRuntime().getAppConfig().bzG().WX(optString)) {
            dVar2.i(i2, h("fail:can not navigate to a tab bar page", null));
            AppMethodBeat.o(134882);
            return;
        }
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(134881);
                int i2 = dVar2.getRuntime().OT().lex;
                if (dVar2.getRuntime().brh().getPageCount() >= i2) {
                    Log.e("MicroMsg.JsApiNavigateTo", "page limit exceeded: ".concat(String.valueOf(i2)));
                    dVar2.i(i2, j.this.h("fail:page limit exceeded: ".concat(String.valueOf(i2)), null));
                    AppMethodBeat.o(134881);
                    return;
                }
                dVar2.getRuntime().brh().adC(optString);
                dVar2.i(i2, j.this.h("ok", null));
                AppMethodBeat.o(134881);
            }
        };
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            r1.run();
            AppMethodBeat.o(134882);
            return;
        }
        dVar2.getRuntime().O(r1);
        AppMethodBeat.o(134882);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
