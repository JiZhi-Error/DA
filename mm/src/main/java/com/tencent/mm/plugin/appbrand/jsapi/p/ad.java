package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class ad extends d<s> {
    private static final int CTRL_INDEX = 197;
    private static final String NAME = "setStatusBarStyle";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138237);
        final s sVar2 = sVar;
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.ad.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138236);
                String optString = jSONObject.optString("color", "");
                ac pageView = sVar2.getRuntime().brh().getPageView();
                if (pageView == null) {
                    sVar2.i(i2, ad.this.h("fail:page don't exist", null));
                    AppMethodBeat.o(138236);
                    return;
                }
                if (optString.equals("white") || optString.equals("black")) {
                    pageView.YP(optString);
                }
                sVar2.i(i2, ad.this.h("ok", null));
                AppMethodBeat.o(138236);
            }
        };
        if (!sVar2.getRuntime().bry()) {
            r0.run();
            AppMethodBeat.o(138237);
            return;
        }
        sVar2.getRuntime().O(r0);
        AppMethodBeat.o(138237);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
