package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import org.json.JSONObject;

public class g extends d<k> {
    public static final int CTRL_INDEX = 252;
    public static final String NAME = "navigateBackMiniProgram";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public /* bridge */ /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147182);
        a(kVar, jSONObject, i2);
        AppMethodBeat.o(147182);
    }

    public void a(final k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147181);
        final JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        final JSONObject optJSONObject2 = jSONObject.optJSONObject("privateExtraData");
        kVar.P(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(147180);
                kVar.getRuntime().R(MiniProgramNavigationBackResult.a(optJSONObject, optJSONObject2));
                kVar.i(i2, g.this.h("ok", null));
                AppMethodBeat.o(147180);
            }
        });
        AppMethodBeat.o(147181);
    }
}
