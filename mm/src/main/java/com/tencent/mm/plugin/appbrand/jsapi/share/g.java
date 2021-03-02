package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g extends e {
    public static final int CTRL_INDEX = 552;
    public static final String NAME = "shareAppMessageToSpecificContactDirectly";

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final JsApiShareAppMessageBase.d a(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(174916);
        JsApiShareAppMessageBase.d a2 = super.a(cVar, jSONObject);
        if (!Util.isNullOrNil(a2.mrs) || !Util.isNullOrNil(a2.mrt)) {
            AppMethodBeat.o(174916);
            return a2;
        }
        Log.i("MicroMsg.JsApiShareAppMessageToSpecificContactDirectly", "openid and chatroom is null");
        JsApiShareAppMessageBase.c cVar2 = new JsApiShareAppMessageBase.c("openid and chatroom is null");
        AppMethodBeat.o(174916);
        throw cVar2;
    }
}
