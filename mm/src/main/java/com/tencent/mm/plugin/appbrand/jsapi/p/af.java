package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import org.json.JSONObject;

public final class af extends d<s> {
    public static final int CTRL_INDEX = 418;
    public static final String NAME = "setTabBarItem";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138243);
        final s sVar2 = sVar;
        try {
            final int i3 = jSONObject.getInt(FirebaseAnalytics.b.INDEX);
            final String optString = jSONObject.optString("text", null);
            final String optString2 = jSONObject.optString("iconPath", "");
            final String optString3 = jSONObject.optString("selectedIconPath", "");
            AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.p.af.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(138242);
                    t currentPage = sVar2.getRuntime().brh().getCurrentPage();
                    if (!(currentPage instanceof m)) {
                        sVar2.i(i2, af.this.h("fail:not TabBar page", null));
                        AppMethodBeat.o(138242);
                        return;
                    }
                    final a tabBar = ((m) currentPage).getTabBar();
                    tabBar.a(i3, optString, tabBar.oEB.a(optString2, new c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.p.af.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.c
                        public final void a(String str, com.tencent.mm.plugin.appbrand.widget.tabbar.d dVar) {
                            AppMethodBeat.i(138240);
                            super.a(str, dVar);
                            tabBar.a(i3, optString, (com.tencent.mm.plugin.appbrand.widget.tabbar.d) tabBar.oEH.get(i3).first, null);
                            AppMethodBeat.o(138240);
                        }
                    }, sVar2, i3), tabBar.oEB.a(optString3, new c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.p.af.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.c
                        public final void a(String str, com.tencent.mm.plugin.appbrand.widget.tabbar.d dVar) {
                            AppMethodBeat.i(138241);
                            super.a(str, dVar);
                            tabBar.a(i3, optString, null, (com.tencent.mm.plugin.appbrand.widget.tabbar.d) tabBar.oEH.get(i3).second);
                            AppMethodBeat.o(138241);
                        }
                    }, sVar2, i3));
                    sVar2.i(i2, af.this.h("ok", null));
                    AppMethodBeat.o(138242);
                }
            };
            if (!sVar2.getRuntime().bry()) {
                r0.run();
                AppMethodBeat.o(138243);
                return;
            }
            sVar2.getRuntime().O(r0);
            AppMethodBeat.o(138243);
        } catch (Exception e2) {
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(138243);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
