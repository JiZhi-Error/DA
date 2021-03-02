package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class aj extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138249);
        final s sVar2 = sVar;
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.aj.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138248);
                t currentPage = sVar2.getRuntime().brh().getCurrentPage();
                if (!(currentPage instanceof m)) {
                    sVar2.i(i2, aj.this.h("fail:not TabBar page", null));
                    AppMethodBeat.o(138248);
                    return;
                }
                ((m) currentPage).getTabBar().aD(jSONObject.optBoolean("animation", true));
                sVar2.i(i2, aj.this.h("ok", null));
                AppMethodBeat.o(138248);
            }
        };
        if (!sVar2.getRuntime().bry()) {
            r0.run();
            AppMethodBeat.o(138249);
            return;
        }
        sVar2.getRuntime().O(r0);
        AppMethodBeat.o(138249);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
