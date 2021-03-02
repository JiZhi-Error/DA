package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class q extends d {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(144527);
        c.pl(56);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            fVar.i(i2, h("fail:invalid data", null));
            c.dY(58, 59);
            AppMethodBeat.o(144527);
            return;
        }
        Log.i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", fVar.getAppId(), jSONObject.toString());
        b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap));
            c.dY(58, 61);
            AppMethodBeat.o(144527);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap2));
            c.dY(58, 63);
            AppMethodBeat.o(144527);
        } else {
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString("value");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", false);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            i iVar = new i(optString2, optString3, optString4);
            iVar.aXs = optBoolean;
            iVar.lMh = optBoolean2;
            iVar.lMj = optBoolean3;
            ZC.a(optString, iVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.q.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b
                public final void a(j jVar) {
                    AppMethodBeat.i(144526);
                    switch (jVar.errCode) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("errCode", 0);
                            fVar.i(i2, q.this.n("ok", hashMap));
                            c.pl(58);
                            AppMethodBeat.o(144526);
                            return;
                        default:
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errCode", Integer.valueOf(jVar.errCode));
                            fVar.i(i2, q.this.n(jVar.errMsg, hashMap2));
                            c.pl(58);
                            AppMethodBeat.o(144526);
                            return;
                    }
                }
            });
            AppMethodBeat.o(144527);
        }
    }
}
