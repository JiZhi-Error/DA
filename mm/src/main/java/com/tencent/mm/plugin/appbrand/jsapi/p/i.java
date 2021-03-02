package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.w;
import org.json.JSONObject;

public final class i extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(138222);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        dVar2.P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138221);
                w brh = dVar2.getRuntime().brh();
                if (brh.getPageCount() <= 1) {
                    dVar2.i(i2, i.this.h("fail cannot navigate back at first page", null));
                    AppMethodBeat.o(138221);
                    return;
                }
                brh.a(jSONObject.optInt("delta", 1), "scene_jsapi_navigate_back", new f() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.p.i.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.page.b.f
                    public final void hL(boolean z) {
                        AppMethodBeat.i(240898);
                        if (z) {
                            dVar2.i(i2, i.this.h("fail:navigateBack intercepted", null));
                            AppMethodBeat.o(240898);
                            return;
                        }
                        dVar2.i(i2, i.this.h("ok", null));
                        AppMethodBeat.o(240898);
                    }
                });
                AppMethodBeat.o(138221);
            }
        });
        AppMethodBeat.o(138222);
    }
}
