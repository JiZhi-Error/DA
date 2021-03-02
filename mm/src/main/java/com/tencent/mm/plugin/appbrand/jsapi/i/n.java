package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class n extends o {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.m
    public final /* synthetic */ Bundle g(s sVar, JSONObject jSONObject) {
        AppMethodBeat.i(46384);
        s sVar2 = sVar;
        Bundle g2 = super.g(sVar2, jSONObject);
        String optString = jSONObject.optString("subKey", "");
        String appId = sVar2.getAppId();
        if (!Util.isNullOrNil(optString)) {
            g2.putString("smallAppKey", optString + "#" + appId + ";");
        }
        g2.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        Log.v("MicroMsg.JsApiGetLocation", "getLocation %s", jSONObject);
        AppMethodBeat.o(46384);
        return g2;
    }
}
