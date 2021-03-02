package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class f extends d {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        List<e> list;
        AppMethodBeat.i(144499);
        c.pl(r.CTRL_INDEX);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
            fVar.i(i2, h("fail:invalid data", null));
            c.dY(138, b.CTRL_INDEX);
            AppMethodBeat.o(144499);
            return;
        }
        Log.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", fVar.getAppId(), jSONObject.toString());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b ZC = a.ZC(fVar.getAppId());
        if (ZC == null) {
            Log.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            fVar.i(i2, n("fail:not init", hashMap));
            c.dY(138, 141);
            AppMethodBeat.o(144499);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            Log.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            fVar.i(i2, n("fail:not available", hashMap2));
            c.dY(138, 145);
            AppMethodBeat.o(144499);
        } else {
            String optString = jSONObject.optString("deviceId");
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = ZC.bFg();
            if (bFg != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c cVar = bFg.lMr;
                if (cVar.lMA == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorkers is null", new Object[0]);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar = cVar.lMA.get(optString);
                    if (dVar == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
                    } else {
                        list = dVar.getServices();
                        HashMap hashMap3 = new HashMap();
                        if (list != null || list.size() <= 0) {
                            Log.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
                            hashMap3.put("errCode", Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL));
                            fVar.i(i2, n("fail:no service", hashMap3));
                            c.dY(138, 144);
                            AppMethodBeat.o(144499);
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (e eVar : list) {
                            if (Util.isNullOrNil(eVar.uuid)) {
                                Log.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                            } else {
                                try {
                                    if (eVar.jsonObject == null) {
                                        eVar.jsonObject = new JSONObject();
                                        eVar.jsonObject.put("uuid", eVar.uuid);
                                        eVar.jsonObject.put("isPrimary", eVar.lNt);
                                    }
                                    jSONArray.put(eVar.jsonObject);
                                } catch (JSONException e2) {
                                    Log.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", e2.getMessage());
                                }
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("errMsg", getName() + ":ok");
                            jSONObject2.put("services", jSONArray);
                            jSONObject2.put("errCode", 0);
                        } catch (JSONException e3) {
                            Log.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", e3, "", new Object[0]);
                        }
                        Log.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", jSONObject2.toString());
                        fVar.i(i2, jSONObject2.toString());
                        c.pl(137);
                        AppMethodBeat.o(144499);
                        return;
                    }
                }
            }
            list = null;
            HashMap hashMap32 = new HashMap();
            if (list != null) {
            }
            Log.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
            hashMap32.put("errCode", Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL));
            fVar.i(i2, n("fail:no service", hashMap32));
            c.dY(138, 144);
            AppMethodBeat.o(144499);
        }
    }
}
