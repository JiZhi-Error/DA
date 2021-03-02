package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import org.json.JSONObject;

public final class ae extends d<s> {
    public static final int CTRL_INDEX = 389;
    public static final String NAME = "setTabBarBadge";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138239);
        final s sVar2 = sVar;
        try {
            final int i3 = jSONObject.getInt(FirebaseAnalytics.b.INDEX);
            final String optString = jSONObject.optString("type", "none");
            final String optString2 = jSONObject.optString("badgeValue", "");
            final String optString3 = jSONObject.optString("badgeColor", "");
            final String optString4 = jSONObject.optString("badgeTextColor", "");
            final PBool pBool = new PBool();
            pBool.value = false;
            new c(optString2).a(f.a.MODE_CHINESE_AS_2).aoq(4).CN(true).a(new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.p.ae.AnonymousClass1 */

                @Override // com.tencent.mm.ui.tools.b.c.a
                public final void Tw(String str) {
                }

                @Override // com.tencent.mm.ui.tools.b.c.a
                public final void Tx(String str) {
                }

                @Override // com.tencent.mm.ui.tools.b.c.a
                public final void dv(String str) {
                    pBool.value = true;
                }
            });
            if (pBool.value) {
                optString2 = "…";
            }
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.p.ae.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(138238);
                    t currentPage = sVar2.getRuntime().brh().getCurrentPage();
                    if (!(currentPage instanceof m)) {
                        sVar2.i(i2, ae.this.h("fail:not TabBar page", null));
                        AppMethodBeat.o(138238);
                        return;
                    }
                    ((m) currentPage).getTabBar().d(i3, optString, optString2, optString3, optString4);
                    sVar2.i(i2, ae.this.h("ok", null));
                    AppMethodBeat.o(138238);
                }
            };
            if (!sVar2.getRuntime().bry()) {
                r0.run();
                AppMethodBeat.o(138239);
                return;
            }
            sVar2.getRuntime().O(r0);
            AppMethodBeat.o(138239);
        } catch (Exception e2) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(138239);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
