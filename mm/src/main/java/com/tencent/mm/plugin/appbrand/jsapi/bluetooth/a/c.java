package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends d {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144497);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(25);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            fVar.i(i2, n("fail:invalid data", hashMap));
            AppMethodBeat.o(144497);
            return;
        }
        final String appId = fVar.getAppId();
        Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", appId, jSONObject.toString());
        b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap2));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(27, 30);
            AppMethodBeat.o(144497);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap3));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(27, 32);
            AppMethodBeat.o(144497);
        } else {
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            long optLong = jSONObject.optLong("timeout", 20000);
            boolean optBoolean4 = jSONObject.optBoolean("autoConnect", false);
            String optString = jSONObject.optString("transport", "LE");
            long optLong2 = jSONObject.optLong("discoverDelay", 0);
            String optString2 = jSONObject.optString("connectionPriority", null);
            String optString3 = jSONObject.optString("deviceId");
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(optString3);
            bVar.aXs = optBoolean;
            bVar.lMh = optBoolean2;
            bVar.lMj = optBoolean3;
            bVar.lNf = optLong;
            bVar.lMK = optBoolean4;
            bVar.lML = optString;
            bVar.lMM = optLong2;
            bVar.lMN = optString2;
            ZC.a(optString3, bVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
                public final void a(j jVar) {
                    AppMethodBeat.i(144496);
                    Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", appId, jVar);
                    switch (jVar.errCode) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("errCode", 0);
                            fVar.i(i2, c.this.n("ok", hashMap));
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(26);
                            AppMethodBeat.o(144496);
                            return;
                        default:
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errCode", Integer.valueOf(jVar.errCode));
                            fVar.i(i2, c.this.n(jVar.errMsg, hashMap2));
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(27);
                            AppMethodBeat.o(144496);
                            return;
                    }
                }
            });
            AppMethodBeat.o(144497);
        }
    }
}
