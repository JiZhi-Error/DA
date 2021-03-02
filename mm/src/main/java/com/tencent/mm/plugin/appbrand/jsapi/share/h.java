package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class h extends f {
    public static final int CTRL_INDEX = 773;
    public static final String NAME = "shareAppMessageToSpecificContactForFakeNativeDirectly";

    /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase$d' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.f, com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final /* synthetic */ f.a a(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(174918);
        f.a b2 = b(cVar, jSONObject);
        AppMethodBeat.o(174918);
        return b2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.f
    public final f.a b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(174917);
        f.a b2 = super.b(cVar, jSONObject);
        if (!Util.isNullOrNil(b2.mrs) || !Util.isNullOrNil(b2.mrt)) {
            AppMethodBeat.o(174917);
            return b2;
        }
        Log.i("MicroMsg.JsApiShareAppMessageToSpecificContactForFakeNativeDirectly", "openid and chatroom is null");
        JsApiShareAppMessageBase.c cVar2 = new JsApiShareAppMessageBase.c("openid and chatroom is null");
        AppMethodBeat.o(174917);
        throw cVar2;
    }
}
