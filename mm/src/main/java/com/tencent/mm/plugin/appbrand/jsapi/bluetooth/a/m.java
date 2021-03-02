package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class m extends d {
    private static final int CTRL_INDEX = 185;
    private static final String NAME = "readBLECharacteristicValue";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144517);
        c.pl(41);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            fVar.i(i2, n("fail:invalid data", hashMap));
            c.dY(43, 44);
            AppMethodBeat.o(144517);
            return;
        }
        Log.i("MicroMsg.JsApiReadBLECharacteristicValue", "appId:%s readBLECharacteristicValue data %s", fVar.getAppId(), jSONObject.toString());
        b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap2));
            c.dY(43, 46);
            AppMethodBeat.o(144517);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap3));
            c.dY(43, 48);
            AppMethodBeat.o(144517);
        } else {
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", false);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            g gVar = new g(optString2, optString3);
            gVar.aXs = optBoolean;
            gVar.lMh = optBoolean2;
            gVar.lMj = optBoolean3;
            ZC.a(optString, gVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
                public final void a(j jVar) {
                    AppMethodBeat.i(144516);
                    switch (jVar.errCode) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("errCode", 0);
                            fVar.i(i2, m.this.n("ok", hashMap));
                            c.pl(42);
                            AppMethodBeat.o(144516);
                            return;
                        default:
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errCode", Integer.valueOf(jVar.errCode));
                            fVar.i(i2, m.this.n(jVar.errMsg, hashMap2));
                            c.pl(43);
                            AppMethodBeat.o(144516);
                            return;
                    }
                }
            });
            AppMethodBeat.o(144517);
        }
    }
}
