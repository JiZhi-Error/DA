package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class a extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        int i2 = 1;
        AppMethodBeat.i(198836);
        String optString = jSONObject.optString("targetAppId");
        String optString2 = jSONObject.optString("currentUrl");
        String optString3 = jSONObject.optString("preVerifyAppId");
        if (Util.isNullOrNil(optString3)) {
            optString3 = jSONObject.optString("referrerAppId");
        }
        if (Util.isNullOrNil(optString)) {
            this.yEn.aCS("invalid_targetAppId");
            AppMethodBeat.o(198836);
        } else if (Util.isNullOrNil(optString3)) {
            this.yEn.aCS("invalid_referrerAppId");
            AppMethodBeat.o(198836);
        } else {
            String nullAsNil = Util.nullAsNil(jSONObject.optString("envVersion"));
            char c2 = 65535;
            switch (nullAsNil.hashCode()) {
                case 110628630:
                    if (nullAsNil.equals("trial")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (nullAsNil.equals("develop")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    break;
                case 1:
                    i2 = 2;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            ((r) g.af(r.class)).b(MMApplicationContext.getContext(), optString2, optString3, optString, i2, jSONObject.optString("path"), 0);
            this.yEn.ecz();
            AppMethodBeat.o(198836);
        }
    }
}
