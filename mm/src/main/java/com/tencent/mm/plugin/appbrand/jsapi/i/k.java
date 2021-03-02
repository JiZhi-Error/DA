package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class k extends l {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.l, com.tencent.mm.plugin.appbrand.jsapi.i.h, com.tencent.mm.plugin.appbrand.jsapi.i.a
    public final /* synthetic */ void d(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46383);
        b(sVar, jSONObject, i2);
        AppMethodBeat.o(46383);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.h
    public final /* synthetic */ Bundle g(s sVar, JSONObject jSONObject) {
        AppMethodBeat.i(46382);
        Bundle bundle = new Bundle();
        String optString = jSONObject.optString("subKey", "");
        String appId = sVar.getAppId();
        if (!Util.isNullOrNil(optString)) {
            bundle.putString("smallAppKey", optString + "#" + appId + ";");
        }
        bundle.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        Log.v("MicroMsg.JsApiEnableLocationUpdateWxImp", "enableLocationUpdate %s", jSONObject);
        AppMethodBeat.o(46382);
        return bundle;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.l
    public final void b(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46381);
        super.b(sVar, jSONObject, i2);
        if (this.lXb != null && !this.lXb.lXu) {
            AppBrandBackgroundRunningMonitor.a(sVar, 2, c.kYp.beL);
        }
        AppMethodBeat.o(46381);
    }
}
