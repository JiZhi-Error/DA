package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 354;
    public static final String NAME = "sendHCEMessage";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(136105);
        a(new JsApiAppBrandNFCBase.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a
            public final void A(int i2, String str) {
                AppMethodBeat.i(136104);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i2));
                if (i2 == 0) {
                    f fVar = f.this;
                    com.tencent.mm.plugin.appbrand.jsapi.f fVar2 = fVar;
                    int i3 = i2;
                    JSONObject jSONObject = jSONObject;
                    HashMap hashMap2 = new HashMap();
                    String optString = jSONObject.optString("data");
                    if (Util.isNullOrNil(optString)) {
                        hashMap2.put("errCode", 13005);
                        f.a(fVar2, i3, fVar.n("fail", hashMap2));
                        AppMethodBeat.o(136104);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("key_apdu_command", optString);
                    HCEEventLogic.a(fVar2.getAppId(), 32, bundle);
                    hashMap2.put("errCode", 0);
                    fVar2.i(i3, fVar.n("ok", hashMap2));
                    AppMethodBeat.o(136104);
                    return;
                }
                f.a(fVar, i2, f.this.n("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(136104);
            }
        });
        AppMethodBeat.o(136105);
    }

    static void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2, String str) {
        AppMethodBeat.i(136106);
        Log.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", str);
        if (fVar != null) {
            fVar.i(i2, str);
        }
        AppMethodBeat.o(136106);
    }
}
