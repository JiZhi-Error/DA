package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends d<k> {
    public static final int CTRL_INDEX = 593;
    public static final String NAME = "navigateBackH5";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46282);
        k kVar2 = kVar;
        String str = p.Um(kVar2.getRuntime().mAppId).kCY;
        Log.i("MicroMsg.JsApiNavigateBackH5", "navigate back H5, businessType:%s", str);
        if (!Util.isNullOrNil(str)) {
            OpenBusinessViewUtil.B(str, jSONObject.optString("extraData"), 0);
            p.Un(kVar2.getAppId()).kDa = true;
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 0);
            kVar2.i(i2, n("ok", hashMap));
            kVar2.getRuntime().finish();
            AppMethodBeat.o(46282);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", -1);
        Log.i("MicroMsg.JsApiNavigateBackH5", "fail system error");
        kVar2.i(i2, n("fail system error", hashMap2));
        AppMethodBeat.o(46282);
    }
}
