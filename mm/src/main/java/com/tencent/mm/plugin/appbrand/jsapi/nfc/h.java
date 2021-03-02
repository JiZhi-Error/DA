package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(136119);
        a(new JsApiAppBrandNFCBase.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.h.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a
            public final void A(int i2, String str) {
                AppMethodBeat.i(136118);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i2));
                if (i2 == 0) {
                    h hVar = h.this;
                    f fVar = fVar;
                    int i3 = i2;
                    HCEEventLogic.aav(fVar.getAppId());
                    HCEEventLogic.a(fVar.getAppId(), 13, null);
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("errCode", 0);
                    h.a(fVar, i3, hVar.n("ok", hashMap2));
                    AppMethodBeat.o(136118);
                    return;
                }
                h.a(fVar, i2, h.this.n("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(136118);
            }
        });
        AppMethodBeat.o(136119);
    }

    static void a(f fVar, int i2, String str) {
        AppMethodBeat.i(136120);
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", str);
        if (fVar != null) {
            fVar.i(i2, str);
        }
        AppMethodBeat.o(136120);
    }
}
