package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class a extends d {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144494);
        c.pl(91);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            fVar.i(i2, n("fail:invalid data", hashMap));
            c.dY(93, 94);
            AppMethodBeat.o(144494);
            return;
        }
        Log.i("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", fVar.getAppId(), jSONObject.toString());
        b ZC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap2));
            c.dY(93, 96);
            AppMethodBeat.o(144494);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap3));
            c.dY(93, 98);
            AppMethodBeat.o(144494);
        } else {
            String optString = jSONObject.optString("deviceId");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a();
            aVar.aXs = optBoolean;
            aVar.lMh = optBoolean2;
            aVar.lMj = optBoolean3;
            ZC.a(optString, aVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
                public final void a(j jVar) {
                    AppMethodBeat.i(144493);
                    switch (jVar.errCode) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("errCode", 0);
                            fVar.i(i2, a.this.n("ok", hashMap));
                            c.pl(92);
                            AppMethodBeat.o(144493);
                            return;
                        default:
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errCode", Integer.valueOf(jVar.errCode));
                            fVar.i(i2, a.this.n(jVar.errMsg, hashMap2));
                            c.pl(93);
                            AppMethodBeat.o(144493);
                            return;
                    }
                }
            });
            AppMethodBeat.o(144494);
        }
    }
}
