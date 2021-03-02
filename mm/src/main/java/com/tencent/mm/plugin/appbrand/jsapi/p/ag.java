package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class ag extends d<s> {
    public static final int CTRL_INDEX = 417;
    public static final String NAME = "setTabBarStyle";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138245);
        final s sVar2 = sVar;
        b.g bzG = sVar2.getRuntime().getAppConfig().bzG();
        final String optString = jSONObject.optString("color", bzG.ixw);
        final String optString2 = jSONObject.optString("selectedColor", bzG.lcn);
        final String optString3 = jSONObject.optString("backgroundColor", bzG.lco);
        final String optString4 = jSONObject.optString("borderStyle", bzG.lcp);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.ag.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138244);
                t currentPage = sVar2.getRuntime().brh().getCurrentPage();
                if (!(currentPage instanceof m)) {
                    sVar2.i(i2, ag.this.h("fail:not TabBar page", null));
                    AppMethodBeat.o(138244);
                    return;
                }
                ((m) currentPage).getTabBar().j(optString, optString2, optString3, optString4);
                sVar2.i(i2, ag.this.h("ok", null));
                AppMethodBeat.o(138244);
            }
        };
        if (!sVar2.getRuntime().bry()) {
            r0.run();
            AppMethodBeat.o(138245);
            return;
        }
        sVar2.getRuntime().O(r0);
        AppMethodBeat.o(138245);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
