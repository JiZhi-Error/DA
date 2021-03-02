package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 358;
    public static final String NAME = "getHCEState";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(136103);
        a(new JsApiAppBrandNFCBase.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a
            public final void A(int i2, String str) {
                AppMethodBeat.i(136102);
                Log.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i2));
                if (i2 == 0) {
                    fVar.i(i2, d.this.n("ok", hashMap));
                    AppMethodBeat.o(136102);
                    return;
                }
                fVar.i(i2, d.this.n("fail ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(136102);
            }
        });
        AppMethodBeat.o(136103);
    }
}
