package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class co extends d<c> {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "restart";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226683);
        c cVar2 = cVar;
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            cVar2.i(i2, h("fail: empty url", null));
            AppMethodBeat.o(226683);
            return;
        }
        q runtime = cVar2.getRuntime();
        int optInt = jSONObject.optInt("scene", runtime.ON().cyA.scene);
        Log.d("MicroMsg.JsApiRestart", "jsapi restart: url[%s], newScene[%d]", optString, Integer.valueOf(optInt));
        AppBrandInitConfigWC bsC = runtime.bsC();
        g gVar = new g();
        gVar.username = bsC.username;
        gVar.kHw = optString;
        gVar.iOo = bsC.eix;
        gVar.version = bsC.appVersion;
        gVar.launchMode = 0;
        gVar.scene = optInt;
        gVar.dCw = bsC.cym;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(AndroidContextUtil.castActivityOrNull(runtime.mContext), gVar);
        AppMethodBeat.o(226683);
    }
}
