package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144498);
        c.pl(151);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            fVar.i(i2, n("fail:invalid data", hashMap));
            c.dY(153, 154);
            AppMethodBeat.o(144498);
            return;
        }
        Log.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", fVar.getAppId(), jSONObject.toString());
        b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap2));
            c.dY(153, 156);
            AppMethodBeat.o(144498);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap3));
            c.dY(153, 158);
            AppMethodBeat.o(144498);
        } else {
            List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> dn = ZC.dn(jSONObject.optString("deviceId"), jSONObject.optString("serviceId"));
            HashMap hashMap4 = new HashMap();
            if (dn == null || dn.size() <= 0) {
                Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
                hashMap4.put("errCode", 10005);
                fVar.i(i2, n("fail:no characteristic", hashMap4));
                c.dY(153, JsApiGetBackgroundAudioState.CTRL_INDEX);
                AppMethodBeat.o(144498);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c cVar : dn) {
                try {
                    if (cVar.jsonObject == null) {
                        cVar.jsonObject = new JSONObject();
                        cVar.jsonObject.put("uuid", cVar.uuid);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("read", cVar.lNl);
                        jSONObject2.put("write", cVar.lNm || cVar.lNn);
                        jSONObject2.put("notify", cVar.iDl);
                        jSONObject2.put("indicate", cVar.lNo);
                        cVar.jsonObject.put("properties", jSONObject2);
                    }
                    jSONArray.put(cVar.jsonObject);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", e2.getMessage());
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("characteristics", jSONArray);
                jSONObject3.put("errCode", 0);
            } catch (JSONException e3) {
                Log.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", e3, "", new Object[0]);
            }
            Log.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", jSONObject3.toString());
            fVar.i(i2, jSONObject3.toString());
            c.pl(152);
            AppMethodBeat.o(144498);
        }
    }
}
