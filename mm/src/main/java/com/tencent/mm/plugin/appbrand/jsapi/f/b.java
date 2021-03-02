package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends d<c> {
    public static final int CTRL_INDEX = 910;
    public static final String NAME = "checkHandoffEnabled";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226845);
        c cVar2 = cVar;
        Log.i("MicroMsg.JsApiCheckHandoffEnabled", "invoke JsApiCheckHandoffEnabled");
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("showToast", true));
        int l = a.l("MicroMsg.JsApiCheckHandoffEnabled", cVar2.getAppId(), cVar2.getRuntime().NA());
        if (l != 0) {
            if (valueOf.booleanValue() && l < a.lWg.length && l > 1) {
                a.ad(cVar2.getContext(), cVar2.getContext().getString(a.lWg[l]));
            }
            hashMap.put("errCode", Integer.valueOf(l));
            hashMap.put("isEnabled", Boolean.FALSE);
        } else {
            hashMap.put("isEnabled", Boolean.TRUE);
        }
        cVar2.i(i2, n("ok", hashMap));
        AppMethodBeat.o(226845);
    }
}
