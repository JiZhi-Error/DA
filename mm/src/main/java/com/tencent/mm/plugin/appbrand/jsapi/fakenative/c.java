package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c extends g {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g
    public final /* bridge */ /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46284);
        a(kVar, jSONObject, i2);
        AppMethodBeat.o(46284);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g
    public final void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46283);
        String str = p.Um(kVar.getRuntime().mAppId).kCY;
        Log.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back miniprogram, businessType:%s", str);
        if (!Util.isNullOrNil(str)) {
            String optString = jSONObject.optString("extraData");
            Log.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", str);
            OpenBusinessViewUtil.x(str, f.OK.errCode, optString);
            p.Un(kVar.getAppId()).kDb = true;
        }
        OpenBusinessViewUtil.A((q) kVar.getRuntime());
        super.a(kVar, jSONObject, i2);
        AppMethodBeat.o(46283);
    }
}
