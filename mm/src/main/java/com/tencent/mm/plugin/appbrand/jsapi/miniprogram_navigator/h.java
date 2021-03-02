package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class h extends a {
    public static final int CTRL_INDEX = 251;
    public static final String NAME = "navigateToMiniProgram";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147184);
        d dVar2 = dVar;
        String optString = jSONObject.optString("appId", null);
        if (Util.isNullOrNil(optString)) {
            dVar2.i(i2, h("fail:appID is empty", null));
            AppMethodBeat.o(147184);
        } else if (optString.equals(dVar2.getAppId())) {
            dVar2.i(i2, h("fail:target appId is the same as the caller appId", null));
            AppMethodBeat.o(147184);
        } else {
            String optString2 = jSONObject.optString("path", null);
            l OT = dVar2.getRuntime().OT();
            if (OT == null) {
                Log.e("Luggage.JsApiNavigateToMiniProgram", "invoke appId:%s, navigateToAppId:%s, NULL sysConfig", dVar2.getAppId(), optString);
                dVar2.i(i2, h("fail:internal error", null));
                AppMethodBeat.o(147184);
                return;
            }
            int i3 = OT.leE.kNW;
            int i4 = b.a(jSONObject.optString("envVersion"), b.RELEASE).iOo;
            if (!(i3 == 1 || i3 == 2)) {
                i4 = 0;
            }
            int optInt = jSONObject.optInt("sourcetype", 0);
            String optString3 = jSONObject.optString("agentId");
            c.a aVar = new c.a();
            aVar.scene = jSONObject.optInt("scene", 0);
            aVar.dCw = jSONObject.optString("sceneNote");
            aVar.ecU = jSONObject.optInt("preScene", 0);
            aVar.ecV = jSONObject.optString("preSceneNote");
            aVar.sourceType = optInt;
            aVar.leq = optString3;
            aVar.meP = jSONObject.optString("adInfo");
            bGm().a(dVar2, optString, i4, optString2, aVar, jSONObject, b(dVar2, jSONObject, i2));
            AppMethodBeat.o(147184);
        }
    }

    /* access modifiers changed from: protected */
    public c.AbstractC0681c b(final d dVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(229904);
        AnonymousClass1 r0 = new c.AbstractC0681c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.AbstractC0681c
            public final void o(boolean z, String str) {
                String str2;
                AppMethodBeat.i(147183);
                if (z) {
                    str2 = "ok";
                } else {
                    str2 = "fail" + (TextUtils.isEmpty(str) ? "" : " ".concat(String.valueOf(str)));
                }
                dVar.i(i2, h.this.h(str2, null));
                AppMethodBeat.o(147183);
            }
        };
        AppMethodBeat.o(229904);
        return r0;
    }
}
